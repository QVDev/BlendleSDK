package com.qvdev.apps.readerkid;

import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.ActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.appinvite.AppInviteInvitation;
import com.qvdev.apps.readerkid.utils.BaseBlendleCompatActivity;
import com.qvdev.apps.readerkid.utils.BlendleSharedPreferences;
import com.qvdev.apps.readerkid.utils.CircleTransform;
import com.qvdev.apps.readerkid.utils.DialogBlendleLogin;
import com.sdk.blendle.models.generated.api.SupportedCountries;
import com.sdk.blendle.models.generated.login.Login;
import com.sdk.blendle.models.generated.user.User;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends BaseBlendleCompatActivity implements NavigationView.OnNavigationItemSelectedListener, DialogBlendleLogin.DialogLoginListener, SharedPreferences.OnSharedPreferenceChangeListener {

    private static final String CURRENT_FRAGMENT_TAG = "current_fragment_";
    private static final int REQUEST_INVITE = 0;

    private int mSelectedFragment = -99;
    private ActionProvider mShareActionProvider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blendle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        initDrawer(toolbar, savedInstanceState != null);
        migrateFromLegacyToken();
        startUpCount(savedInstanceState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        restorePossibleFragment(savedInstanceState);
        getMyAccount();
    }

    private void restorePossibleFragment(Bundle savedInstanceState) {
        boolean isRestored = false;
        if (savedInstanceState != null) {
            mSelectedFragment = savedInstanceState.getInt(CURRENT_FRAGMENT_TAG);
            isRestored = didRestoreFragment(mSelectedFragment);
        }

        if (!isRestored) {
            MenuItem defaultMenuItem = ((NavigationView) findViewById(R.id.nav_view)).getMenu().getItem(0);
            onNavigationItemSelected(defaultMenuItem);
        }
    }

    private void startUpCount(Bundle savedInstanceState) {
        mBlendleSharedPreferences.registerBlendlePreferenceChangedListener(this);
        if (savedInstanceState == null) {
            mBlendleSharedPreferences.increaseStartUpCount();
        }
    }

    private boolean didRestoreFragment(int selectedFragment) {
        Fragment fragment;
        fragment = getFragmentManager().findFragmentByTag(CURRENT_FRAGMENT_TAG + selectedFragment);
        if (fragment != null) {
            getFragmentManager().beginTransaction().attach(fragment).commit();
        }
        return fragment != null;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(CURRENT_FRAGMENT_TAG, mSelectedFragment);
    }

    private void initDrawer(final Toolbar toolbar, boolean fromSavedInstance) {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                getMyAccount();
            }
        };
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        if (!fromSavedInstance) {
            MenuItem menuItem = navigationView.getMenu().findItem(R.id.nav_newsstand_locale);
            onNavigationItemSelected(menuItem);
            navigationView.setCheckedItem(menuItem.getItemId());
        }
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        initSearchView(menu);
        return true;
    }

    private void initSearchView(Menu menu) {
        MenuItem searchMenuItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) searchMenuItem.getActionView();
        final int restoreFragmentTag = mSelectedFragment;
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String searchQuery) {
                getFragmentManager().beginTransaction().replace(R.id.blendle_content, SearchArticlesFragment.newInstance(searchQuery), CURRENT_FRAGMENT_TAG + R.id.action_search).commit();
                searchView.clearFocus();
                mSelectedFragment = R.id.action_search;
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        searchView.setOnCloseListener(new SearchView.OnCloseListener() {
            @Override
            public boolean onClose() {
                SearchArticlesFragment searchArticlesFragment = (SearchArticlesFragment) getFragmentManager().findFragmentByTag(CURRENT_FRAGMENT_TAG + R.id.action_search);
                if (searchArticlesFragment != null) {
                    MenuItem restoredMenu = ((NavigationView) findViewById(R.id.nav_view)).getMenu().findItem(restoreFragmentTag);
                    onNavigationItemSelected(restoredMenu);
                }
                return false;
            }
        });
    }

    private void getMyAccount() {
        final String myId = mBlendleSharedPreferences.restoreUserId();
        Login loggedInUser = mBlendleSharedPreferences.restoreStoredUser();

        if (loggedInUser.getRefreshToken() != null && myId != null) {
            mBlendleApi.getMyAccount(new Callback<User>() {
                @Override
                public void onResponse(Response<User> response, Retrofit retrofit) {
                    if (response.isSuccess()) {
                        User userResponse = response.body();
                        setUserData(null, userResponse);
                    }
                }

                @Override
                public void onFailure(Throwable t) {
                    Log.e(getClass().getSimpleName(), t.getMessage());
                }
            }, myId);
        }
    }

    private void migrateFromLegacyToken() {
        final String myId = mBlendleSharedPreferences.restoreUserId();
        final String legacyToken = mBlendleSharedPreferences.restoreToken();
        if (myId != null && legacyToken != null) {
            mBlendleSharedPreferences.storeToken(null);
            mBlendleApi.loginFromLegacyToken(new Callback<Login>() {
                @Override
                public void onResponse(Response<Login> response, Retrofit retrofit) {
                    if (response.isSuccess()) {
                        Login loggedInUser = response.body();
                        mBlendleSharedPreferences.storeLoggedInUser(loggedInUser);
                        mBlendleApi.onUserLoggedIn(loggedInUser);
                        setUserData(loggedInUser, null);
                        getMyAccount();
                    } else {
                        showMigrationLoginOption();
                    }
                }

                @Override
                public void onFailure(Throwable t) {
                    showMigrationLoginOption();
                }
            }, legacyToken);
        } else {
            getMyAccount();
        }
    }

    private void showMigrationLoginOption() {
        showSnackbarWithAction(R.id.blendle_content, R.string.migration_failed, R.string.log_user_in_action, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginClicked(v);
            }
        });
    }

    private void setUserData(Login loggedInUser, User userResponse) {
        String username = userResponse != null ? userResponse.getFullName() : loggedInUser.getEmbedded().getUser().getFullName();
        String balance = String.format(getString(R.string.price_balance), userResponse != null ? userResponse.getBalance() : loggedInUser.getEmbedded().getUser().getBalance());
        String avatarUrl = userResponse != null ? userResponse.getLinks().getLargeAvatar().getHref() : loggedInUser.getEmbedded().getUser().getLinks().getLargeAvatar().getHref();

        TextView userNameText = (TextView) findViewById(R.id.userName);
        if(userNameText != null) {
            userNameText.setText(username);
        }
        TextView balanceText = (TextView) findViewById(R.id.userInfo);
        if(balanceText != null) {
            balanceText.setText(balance);
        }

        ImageView userImage = (ImageView) findViewById(R.id.imageView);
        if(userImage != null) {
            Glide.with(MainActivity.this)
                    .load(avatarUrl)
                    .transform(new CircleTransform(MainActivity.this))
                    .into(userImage);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        if (!didRestoreFragment(item.getItemId())) {
            switch (item.getItemId()) {
                case R.id.nav_newsstand_locale:
                    loadFragment(BaseNewsstandLocaleFragment.newInstance(), item.getItemId());
                    break;
                case R.id.nav_papers_locale:
                    loadFragment(PapersNewsstandFragment.newInstance(), item.getItemId());
                    break;
                case R.id.nav_magazines_locale:
                    loadFragment(MagazinesNewsstandFragment.newInstance(), item.getItemId());
                    break;
                case R.id.nav_pinned:
                    loadFragment(PinnedArticlesFragment.newInstance(), item.getItemId());
                    break;
                case R.id.nav_archive:
                    loadFragment(ArchiveFragment.newInstance(), item.getItemId());
                    break;
                case R.id.nav_international:
                    loadFragment(InternationalNewsstandFragment.newInstance(), item.getItemId());
                    break;
                case R.id.nav_web:
                    loadFragment(WebNewsstandFragment.newInstance(), item.getItemId());
                    break;
                case R.id.nav_popular:
                    loadFragment(PopularArticlesFragment.newInstance(), item.getItemId());
                    break;
                case R.id.nav_share:
                    shareApplication();
                    break;
                case R.id.nav_rate:
                    rateApplication();
                    break;
                case R.id.language_nl:
                    changeCountry(com.sdk.SupportedCountries.NL.toString());
                    break;
                case R.id.language_en:
                    changeCountry(com.sdk.SupportedCountries.US.toString());
                    break;
                case R.id.language_de:
                    changeCountry(com.sdk.SupportedCountries.DE.toString());
                    break;
                default:
                    loadFragment(BaseNewsstandLocaleFragment.newInstance(), item.getItemId());
            }
        }

        closeDrawer();
        return true;
    }

    private void changeCountry(String language) {
        mBlendleSharedPreferences.storeLocale(language);
        showSnackbar(R.id.blendle_content, R.string.country_changed);
    }

    private void rateApplication() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("market://details?id=com.qvdev.apps.readerkid"));
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            Log.d(getClass().getSimpleName(), "No market app found");
        }
    }

    private void shareApplication() {
        Intent intent = new AppInviteInvitation.IntentBuilder(getString(R.string.invitation_title))
                .setMessage(getString(R.string.invitation_message))
                .setCallToActionText(getString(R.string.invitation_cta))
                .build();
        startActivityForResult(intent, REQUEST_INVITE);
    }

    private void loadFragment(Fragment fragment, int tag) {
        if (mSelectedFragment != tag) {
            mSelectedFragment = tag;
            getFragmentManager().beginTransaction().replace(R.id.blendle_content, fragment, CURRENT_FRAGMENT_TAG + tag).commit();
        }
    }

    public void loginClicked(View view) {
        closeDrawer();
        new DialogBlendleLogin(this, this, true);
    }

    private void closeDrawer() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public void finishedWithUser(Login loggedInUser) {
        if (loggedInUser != null) {
            setUserData(loggedInUser, null);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_INVITE) {
            if (resultCode == RESULT_OK) {
                String[] ids = AppInviteInvitation.getInvitationIds(resultCode, data);
                mBlendleSharedPreferences.storeRecommendationShownOk(true);
            } else {
                showSnackbarWithAction(R.id.blendle_content, R.string.invite_send_failed, R.string.action_retry, new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        shareApplication();
                    }
                });
            }
        }
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (key.contentEquals(BlendleSharedPreferences.PREFS_USER_START_COUNT_VALUE)) {
            if (!mBlendleSharedPreferences.restoreRecommendationShownOk()) {
                if (mBlendleSharedPreferences.restoreStartupCount() % 5 == 0) {
                    shareApplication();
                }
            }
        }
    }
}
