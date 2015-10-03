
package com.sdk.blendle.models.generated.api;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Links {

    @SerializedName("self")
    @Expose
    private Self self;
    @SerializedName("style")
    @Expose
    private Style style;
    @SerializedName("publications")
    @Expose
    private Publications publications;
    @SerializedName("account")
    @Expose
    private Account account;
    @SerializedName("signup_code")
    @Expose
    private SignupCode signupCode;
    @SerializedName("users")
    @Expose
    private Users users;
    @SerializedName("channels")
    @Expose
    private Channels channels;
    @SerializedName("all_posts")
    @Expose
    private AllPosts allPosts;
    @SerializedName("users_popular_posts")
    @Expose
    private UsersPopularPosts usersPopularPosts;
    @SerializedName("items_popular")
    @Expose
    private ItemsPopular itemsPopular;
    @SerializedName("login")
    @Expose
    private Login login;
    @SerializedName("logout")
    @Expose
    private Logout logout;
    @SerializedName("request_password_reset_token")
    @Expose
    private RequestPasswordResetToken requestPasswordResetToken;
    @SerializedName("confirm_email")
    @Expose
    private ConfirmEmail confirmEmail;
    @SerializedName("password_reset")
    @Expose
    private PasswordReset passwordReset;
    @SerializedName("credentials")
    @Expose
    private Credentials credentials;
    @SerializedName("user_refresh_token")
    @Expose
    private UserRefreshToken userRefreshToken;
    @SerializedName("user_refresh_tokens")
    @Expose
    private UserRefreshTokens userRefreshTokens;
    @SerializedName("user_email_tokens")
    @Expose
    private UserEmailTokens userEmailTokens;
    @SerializedName("frontend_events")
    @Expose
    private FrontendEvents frontendEvents;
    @SerializedName("default_follows_posts")
    @Expose
    private DefaultFollowsPosts defaultFollowsPosts;
    @SerializedName("i18n")
    @Expose
    private I18n i18n;
    @SerializedName("supported_countries")
    @Expose
    private SupportedCountries supportedCountries;
    @SerializedName("supported_country")
    @Expose
    private SupportedCountry supportedCountry;
    @SerializedName("supported_locales")
    @Expose
    private SupportedLocales supportedLocales;
    @SerializedName("me")
    @Expose
    private Me me;
    @SerializedName("current_location")
    @Expose
    private CurrentLocation currentLocation;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("search_locations")
    @Expose
    private SearchLocations searchLocations;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("user_resend_confirmation_email")
    @Expose
    private UserResendConfirmationEmail userResendConfirmationEmail;
    @SerializedName("user_favourite")
    @Expose
    private UserFavourite userFavourite;
    @SerializedName("user_favourites")
    @Expose
    private UserFavourites userFavourites;
    @SerializedName("user_favourites_category")
    @Expose
    private UserFavouritesCategory userFavouritesCategory;
    @SerializedName("user_timeline")
    @Expose
    private UserTimeline userTimeline;
    @SerializedName("user_posted_tiles")
    @Expose
    private UserPostedTiles userPostedTiles;
    @SerializedName("user_trending_tiles")
    @Expose
    private UserTrendingTiles userTrendingTiles;
    @SerializedName("user_following_tiles")
    @Expose
    private UserFollowingTiles userFollowingTiles;
    @SerializedName("user_pins_timeline")
    @Expose
    private UserPinsTimeline userPinsTimeline;
    @SerializedName("user_pin")
    @Expose
    private UserPin userPin;
    @SerializedName("user_follows_posts")
    @Expose
    private UserFollowsPosts userFollowsPosts;
    @SerializedName("user_follow_suggestions_with_latest_post")
    @Expose
    private UserFollowSuggestionsWithLatestPost userFollowSuggestionsWithLatestPost;
    @SerializedName("user_provider_accounts")
    @Expose
    private UserProviderAccounts userProviderAccounts;
    @SerializedName("user_issues")
    @Expose
    private UserIssues userIssues;
    @SerializedName("recommended_issues")
    @Expose
    private RecommendedIssues recommendedIssues;
    @SerializedName("follows")
    @Expose
    private Follows follows;
    @SerializedName("followers")
    @Expose
    private Followers followers;
    @SerializedName("deposits")
    @Expose
    private Deposits deposits;
    @SerializedName("follow_suggestions")
    @Expose
    private FollowSuggestions followSuggestions;
    @SerializedName("posts")
    @Expose
    private Posts posts;
    @SerializedName("likes")
    @Expose
    private Likes likes;
    @SerializedName("user_items")
    @Expose
    private UserItems userItems;
    @SerializedName("user_items_recommended")
    @Expose
    private UserItemsRecommended userItemsRecommended;
    @SerializedName("alerts")
    @Expose
    private Alerts alerts;
    @SerializedName("read_later")
    @Expose
    private ReadLater readLater;
    @SerializedName("notifications")
    @Expose
    private Notifications notifications;
    @SerializedName("user_notifications")
    @Expose
    private UserNotifications userNotifications;
    @SerializedName("transactions")
    @Expose
    private Transactions transactions;
    @SerializedName("preferences")
    @Expose
    private Preferences preferences;
    @SerializedName("coupons")
    @Expose
    private Coupons coupons;
    @SerializedName("avatars")
    @Expose
    private Avatars avatars;
    @SerializedName("oauth")
    @Expose
    private Oauth oauth;
    @SerializedName("user_payment")
    @Expose
    private UserPayment userPayment;
    @SerializedName("adyen_payment_methods")
    @Expose
    private AdyenPaymentMethods adyenPaymentMethods;
    @SerializedName("adyen_payment_proposal")
    @Expose
    private AdyenPaymentProposal adyenPaymentProposal;
    @SerializedName("adyen_recurring_contracts")
    @Expose
    private AdyenRecurringContracts adyenRecurringContracts;
    @SerializedName("adyen_place_order")
    @Expose
    private AdyenPlaceOrder adyenPlaceOrder;
    @SerializedName("newsstand")
    @Expose
    private Newsstand newsstand;
    @SerializedName("item")
    @Expose
    private Item item;
    @SerializedName("item_posts")
    @Expose
    private ItemPosts itemPosts;
    @SerializedName("item_recommendations")
    @Expose
    private ItemRecommendations itemRecommendations;
    @SerializedName("user_item")
    @Expose
    private UserItem userItem;
    @SerializedName("refund_reason")
    @Expose
    private RefundReason refundReason;
    @SerializedName("issue_metadata")
    @Expose
    private IssueMetadata issueMetadata;
    @SerializedName("issue")
    @Expose
    private Issue issue;
    @SerializedName("issue_pages")
    @Expose
    private IssuePages issuePages;
    @SerializedName("issue_items")
    @Expose
    private IssueItems issueItems;
    @SerializedName("latest_issue")
    @Expose
    private LatestIssue latestIssue;
    @SerializedName("latest_issues")
    @Expose
    private LatestIssues latestIssues;
    @SerializedName("issue_acquisition")
    @Expose
    private IssueAcquisition issueAcquisition;
    @SerializedName("item_acquisition")
    @Expose
    private ItemAcquisition itemAcquisition;
    @SerializedName("nearby_issues")
    @Expose
    private NearbyIssues nearbyIssues;
    @SerializedName("search")
    @Expose
    private Search search;
    @SerializedName("user_search")
    @Expose
    private UserSearch userSearch;
    @SerializedName("advanced_search")
    @Expose
    private AdvancedSearch advancedSearch;
    @SerializedName("suggestions")
    @Expose
    private Suggestions suggestions;
    @SerializedName("provider_statistics")
    @Expose
    private ProviderStatistics providerStatistics;
    @SerializedName("onetimelink")
    @Expose
    private Onetimelink onetimelink;
    @SerializedName("popular_providers_for_user")
    @Expose
    private PopularProvidersForUser popularProvidersForUser;
    @SerializedName("email_share")
    @Expose
    private EmailShare emailShare;
    @SerializedName("ab_test")
    @Expose
    private AbTest abTest;
    @SerializedName("onboarding_newsstand")
    @Expose
    private List<OnboardingNewsstand> onboardingNewsstand = new ArrayList<OnboardingNewsstand>();

    /**
     * 
     * @return
     *     The self
     */
    public Self getSelf() {
        return self;
    }

    /**
     * 
     * @param self
     *     The self
     */
    public void setSelf(Self self) {
        this.self = self;
    }

    /**
     * 
     * @return
     *     The style
     */
    public Style getStyle() {
        return style;
    }

    /**
     * 
     * @param style
     *     The style
     */
    public void setStyle(Style style) {
        this.style = style;
    }

    /**
     * 
     * @return
     *     The publications
     */
    public Publications getPublications() {
        return publications;
    }

    /**
     * 
     * @param publications
     *     The publications
     */
    public void setPublications(Publications publications) {
        this.publications = publications;
    }

    /**
     * 
     * @return
     *     The account
     */
    public Account getAccount() {
        return account;
    }

    /**
     * 
     * @param account
     *     The account
     */
    public void setAccount(Account account) {
        this.account = account;
    }

    /**
     * 
     * @return
     *     The signupCode
     */
    public SignupCode getSignupCode() {
        return signupCode;
    }

    /**
     * 
     * @param signupCode
     *     The signup_code
     */
    public void setSignupCode(SignupCode signupCode) {
        this.signupCode = signupCode;
    }

    /**
     * 
     * @return
     *     The users
     */
    public Users getUsers() {
        return users;
    }

    /**
     * 
     * @param users
     *     The users
     */
    public void setUsers(Users users) {
        this.users = users;
    }

    /**
     * 
     * @return
     *     The channels
     */
    public Channels getChannels() {
        return channels;
    }

    /**
     * 
     * @param channels
     *     The channels
     */
    public void setChannels(Channels channels) {
        this.channels = channels;
    }

    /**
     * 
     * @return
     *     The allPosts
     */
    public AllPosts getAllPosts() {
        return allPosts;
    }

    /**
     * 
     * @param allPosts
     *     The all_posts
     */
    public void setAllPosts(AllPosts allPosts) {
        this.allPosts = allPosts;
    }

    /**
     * 
     * @return
     *     The usersPopularPosts
     */
    public UsersPopularPosts getUsersPopularPosts() {
        return usersPopularPosts;
    }

    /**
     * 
     * @param usersPopularPosts
     *     The users_popular_posts
     */
    public void setUsersPopularPosts(UsersPopularPosts usersPopularPosts) {
        this.usersPopularPosts = usersPopularPosts;
    }

    /**
     * 
     * @return
     *     The itemsPopular
     */
    public ItemsPopular getItemsPopular() {
        return itemsPopular;
    }

    /**
     * 
     * @param itemsPopular
     *     The items_popular
     */
    public void setItemsPopular(ItemsPopular itemsPopular) {
        this.itemsPopular = itemsPopular;
    }

    /**
     * 
     * @return
     *     The login
     */
    public Login getLogin() {
        return login;
    }

    /**
     * 
     * @param login
     *     The login
     */
    public void setLogin(Login login) {
        this.login = login;
    }

    /**
     * 
     * @return
     *     The logout
     */
    public Logout getLogout() {
        return logout;
    }

    /**
     * 
     * @param logout
     *     The logout
     */
    public void setLogout(Logout logout) {
        this.logout = logout;
    }

    /**
     * 
     * @return
     *     The requestPasswordResetToken
     */
    public RequestPasswordResetToken getRequestPasswordResetToken() {
        return requestPasswordResetToken;
    }

    /**
     * 
     * @param requestPasswordResetToken
     *     The request_password_reset_token
     */
    public void setRequestPasswordResetToken(RequestPasswordResetToken requestPasswordResetToken) {
        this.requestPasswordResetToken = requestPasswordResetToken;
    }

    /**
     * 
     * @return
     *     The confirmEmail
     */
    public ConfirmEmail getConfirmEmail() {
        return confirmEmail;
    }

    /**
     * 
     * @param confirmEmail
     *     The confirm_email
     */
    public void setConfirmEmail(ConfirmEmail confirmEmail) {
        this.confirmEmail = confirmEmail;
    }

    /**
     * 
     * @return
     *     The passwordReset
     */
    public PasswordReset getPasswordReset() {
        return passwordReset;
    }

    /**
     * 
     * @param passwordReset
     *     The password_reset
     */
    public void setPasswordReset(PasswordReset passwordReset) {
        this.passwordReset = passwordReset;
    }

    /**
     * 
     * @return
     *     The credentials
     */
    public Credentials getCredentials() {
        return credentials;
    }

    /**
     * 
     * @param credentials
     *     The credentials
     */
    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    /**
     * 
     * @return
     *     The userRefreshToken
     */
    public UserRefreshToken getUserRefreshToken() {
        return userRefreshToken;
    }

    /**
     * 
     * @param userRefreshToken
     *     The user_refresh_token
     */
    public void setUserRefreshToken(UserRefreshToken userRefreshToken) {
        this.userRefreshToken = userRefreshToken;
    }

    /**
     * 
     * @return
     *     The userRefreshTokens
     */
    public UserRefreshTokens getUserRefreshTokens() {
        return userRefreshTokens;
    }

    /**
     * 
     * @param userRefreshTokens
     *     The user_refresh_tokens
     */
    public void setUserRefreshTokens(UserRefreshTokens userRefreshTokens) {
        this.userRefreshTokens = userRefreshTokens;
    }

    /**
     * 
     * @return
     *     The userEmailTokens
     */
    public UserEmailTokens getUserEmailTokens() {
        return userEmailTokens;
    }

    /**
     * 
     * @param userEmailTokens
     *     The user_email_tokens
     */
    public void setUserEmailTokens(UserEmailTokens userEmailTokens) {
        this.userEmailTokens = userEmailTokens;
    }

    /**
     * 
     * @return
     *     The frontendEvents
     */
    public FrontendEvents getFrontendEvents() {
        return frontendEvents;
    }

    /**
     * 
     * @param frontendEvents
     *     The frontend_events
     */
    public void setFrontendEvents(FrontendEvents frontendEvents) {
        this.frontendEvents = frontendEvents;
    }

    /**
     * 
     * @return
     *     The defaultFollowsPosts
     */
    public DefaultFollowsPosts getDefaultFollowsPosts() {
        return defaultFollowsPosts;
    }

    /**
     * 
     * @param defaultFollowsPosts
     *     The default_follows_posts
     */
    public void setDefaultFollowsPosts(DefaultFollowsPosts defaultFollowsPosts) {
        this.defaultFollowsPosts = defaultFollowsPosts;
    }

    /**
     * 
     * @return
     *     The i18n
     */
    public I18n getI18n() {
        return i18n;
    }

    /**
     * 
     * @param i18n
     *     The i18n
     */
    public void setI18n(I18n i18n) {
        this.i18n = i18n;
    }

    /**
     * 
     * @return
     *     The supportedCountries
     */
    public SupportedCountries getSupportedCountries() {
        return supportedCountries;
    }

    /**
     * 
     * @param supportedCountries
     *     The supported_countries
     */
    public void setSupportedCountries(SupportedCountries supportedCountries) {
        this.supportedCountries = supportedCountries;
    }

    /**
     * 
     * @return
     *     The supportedCountry
     */
    public SupportedCountry getSupportedCountry() {
        return supportedCountry;
    }

    /**
     * 
     * @param supportedCountry
     *     The supported_country
     */
    public void setSupportedCountry(SupportedCountry supportedCountry) {
        this.supportedCountry = supportedCountry;
    }

    /**
     * 
     * @return
     *     The supportedLocales
     */
    public SupportedLocales getSupportedLocales() {
        return supportedLocales;
    }

    /**
     * 
     * @param supportedLocales
     *     The supported_locales
     */
    public void setSupportedLocales(SupportedLocales supportedLocales) {
        this.supportedLocales = supportedLocales;
    }

    /**
     * 
     * @return
     *     The me
     */
    public Me getMe() {
        return me;
    }

    /**
     * 
     * @param me
     *     The me
     */
    public void setMe(Me me) {
        this.me = me;
    }

    /**
     * 
     * @return
     *     The currentLocation
     */
    public CurrentLocation getCurrentLocation() {
        return currentLocation;
    }

    /**
     * 
     * @param currentLocation
     *     The current_location
     */
    public void setCurrentLocation(CurrentLocation currentLocation) {
        this.currentLocation = currentLocation;
    }

    /**
     * 
     * @return
     *     The location
     */
    public Location getLocation() {
        return location;
    }

    /**
     * 
     * @param location
     *     The location
     */
    public void setLocation(Location location) {
        this.location = location;
    }

    /**
     * 
     * @return
     *     The searchLocations
     */
    public SearchLocations getSearchLocations() {
        return searchLocations;
    }

    /**
     * 
     * @param searchLocations
     *     The search_locations
     */
    public void setSearchLocations(SearchLocations searchLocations) {
        this.searchLocations = searchLocations;
    }

    /**
     * 
     * @return
     *     The user
     */
    public User getUser() {
        return user;
    }

    /**
     * 
     * @param user
     *     The user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 
     * @return
     *     The userResendConfirmationEmail
     */
    public UserResendConfirmationEmail getUserResendConfirmationEmail() {
        return userResendConfirmationEmail;
    }

    /**
     * 
     * @param userResendConfirmationEmail
     *     The user_resend_confirmation_email
     */
    public void setUserResendConfirmationEmail(UserResendConfirmationEmail userResendConfirmationEmail) {
        this.userResendConfirmationEmail = userResendConfirmationEmail;
    }

    /**
     * 
     * @return
     *     The userFavourite
     */
    public UserFavourite getUserFavourite() {
        return userFavourite;
    }

    /**
     * 
     * @param userFavourite
     *     The user_favourite
     */
    public void setUserFavourite(UserFavourite userFavourite) {
        this.userFavourite = userFavourite;
    }

    /**
     * 
     * @return
     *     The userFavourites
     */
    public UserFavourites getUserFavourites() {
        return userFavourites;
    }

    /**
     * 
     * @param userFavourites
     *     The user_favourites
     */
    public void setUserFavourites(UserFavourites userFavourites) {
        this.userFavourites = userFavourites;
    }

    /**
     * 
     * @return
     *     The userFavouritesCategory
     */
    public UserFavouritesCategory getUserFavouritesCategory() {
        return userFavouritesCategory;
    }

    /**
     * 
     * @param userFavouritesCategory
     *     The user_favourites_category
     */
    public void setUserFavouritesCategory(UserFavouritesCategory userFavouritesCategory) {
        this.userFavouritesCategory = userFavouritesCategory;
    }

    /**
     * 
     * @return
     *     The userTimeline
     */
    public UserTimeline getUserTimeline() {
        return userTimeline;
    }

    /**
     * 
     * @param userTimeline
     *     The user_timeline
     */
    public void setUserTimeline(UserTimeline userTimeline) {
        this.userTimeline = userTimeline;
    }

    /**
     * 
     * @return
     *     The userPostedTiles
     */
    public UserPostedTiles getUserPostedTiles() {
        return userPostedTiles;
    }

    /**
     * 
     * @param userPostedTiles
     *     The user_posted_tiles
     */
    public void setUserPostedTiles(UserPostedTiles userPostedTiles) {
        this.userPostedTiles = userPostedTiles;
    }

    /**
     * 
     * @return
     *     The userTrendingTiles
     */
    public UserTrendingTiles getUserTrendingTiles() {
        return userTrendingTiles;
    }

    /**
     * 
     * @param userTrendingTiles
     *     The user_trending_tiles
     */
    public void setUserTrendingTiles(UserTrendingTiles userTrendingTiles) {
        this.userTrendingTiles = userTrendingTiles;
    }

    /**
     * 
     * @return
     *     The userFollowingTiles
     */
    public UserFollowingTiles getUserFollowingTiles() {
        return userFollowingTiles;
    }

    /**
     * 
     * @param userFollowingTiles
     *     The user_following_tiles
     */
    public void setUserFollowingTiles(UserFollowingTiles userFollowingTiles) {
        this.userFollowingTiles = userFollowingTiles;
    }

    /**
     * 
     * @return
     *     The userPinsTimeline
     */
    public UserPinsTimeline getUserPinsTimeline() {
        return userPinsTimeline;
    }

    /**
     * 
     * @param userPinsTimeline
     *     The user_pins_timeline
     */
    public void setUserPinsTimeline(UserPinsTimeline userPinsTimeline) {
        this.userPinsTimeline = userPinsTimeline;
    }

    /**
     * 
     * @return
     *     The userPin
     */
    public UserPin getUserPin() {
        return userPin;
    }

    /**
     * 
     * @param userPin
     *     The user_pin
     */
    public void setUserPin(UserPin userPin) {
        this.userPin = userPin;
    }

    /**
     * 
     * @return
     *     The userFollowsPosts
     */
    public UserFollowsPosts getUserFollowsPosts() {
        return userFollowsPosts;
    }

    /**
     * 
     * @param userFollowsPosts
     *     The user_follows_posts
     */
    public void setUserFollowsPosts(UserFollowsPosts userFollowsPosts) {
        this.userFollowsPosts = userFollowsPosts;
    }

    /**
     * 
     * @return
     *     The userFollowSuggestionsWithLatestPost
     */
    public UserFollowSuggestionsWithLatestPost getUserFollowSuggestionsWithLatestPost() {
        return userFollowSuggestionsWithLatestPost;
    }

    /**
     * 
     * @param userFollowSuggestionsWithLatestPost
     *     The user_follow_suggestions_with_latest_post
     */
    public void setUserFollowSuggestionsWithLatestPost(UserFollowSuggestionsWithLatestPost userFollowSuggestionsWithLatestPost) {
        this.userFollowSuggestionsWithLatestPost = userFollowSuggestionsWithLatestPost;
    }

    /**
     * 
     * @return
     *     The userProviderAccounts
     */
    public UserProviderAccounts getUserProviderAccounts() {
        return userProviderAccounts;
    }

    /**
     * 
     * @param userProviderAccounts
     *     The user_provider_accounts
     */
    public void setUserProviderAccounts(UserProviderAccounts userProviderAccounts) {
        this.userProviderAccounts = userProviderAccounts;
    }

    /**
     * 
     * @return
     *     The userIssues
     */
    public UserIssues getUserIssues() {
        return userIssues;
    }

    /**
     * 
     * @param userIssues
     *     The user_issues
     */
    public void setUserIssues(UserIssues userIssues) {
        this.userIssues = userIssues;
    }

    /**
     * 
     * @return
     *     The recommendedIssues
     */
    public RecommendedIssues getRecommendedIssues() {
        return recommendedIssues;
    }

    /**
     * 
     * @param recommendedIssues
     *     The recommended_issues
     */
    public void setRecommendedIssues(RecommendedIssues recommendedIssues) {
        this.recommendedIssues = recommendedIssues;
    }

    /**
     * 
     * @return
     *     The follows
     */
    public Follows getFollows() {
        return follows;
    }

    /**
     * 
     * @param follows
     *     The follows
     */
    public void setFollows(Follows follows) {
        this.follows = follows;
    }

    /**
     * 
     * @return
     *     The followers
     */
    public Followers getFollowers() {
        return followers;
    }

    /**
     * 
     * @param followers
     *     The followers
     */
    public void setFollowers(Followers followers) {
        this.followers = followers;
    }

    /**
     * 
     * @return
     *     The deposits
     */
    public Deposits getDeposits() {
        return deposits;
    }

    /**
     * 
     * @param deposits
     *     The deposits
     */
    public void setDeposits(Deposits deposits) {
        this.deposits = deposits;
    }

    /**
     * 
     * @return
     *     The followSuggestions
     */
    public FollowSuggestions getFollowSuggestions() {
        return followSuggestions;
    }

    /**
     * 
     * @param followSuggestions
     *     The follow_suggestions
     */
    public void setFollowSuggestions(FollowSuggestions followSuggestions) {
        this.followSuggestions = followSuggestions;
    }

    /**
     * 
     * @return
     *     The posts
     */
    public Posts getPosts() {
        return posts;
    }

    /**
     * 
     * @param posts
     *     The posts
     */
    public void setPosts(Posts posts) {
        this.posts = posts;
    }

    /**
     * 
     * @return
     *     The likes
     */
    public Likes getLikes() {
        return likes;
    }

    /**
     * 
     * @param likes
     *     The likes
     */
    public void setLikes(Likes likes) {
        this.likes = likes;
    }

    /**
     * 
     * @return
     *     The userItems
     */
    public UserItems getUserItems() {
        return userItems;
    }

    /**
     * 
     * @param userItems
     *     The user_items
     */
    public void setUserItems(UserItems userItems) {
        this.userItems = userItems;
    }

    /**
     * 
     * @return
     *     The userItemsRecommended
     */
    public UserItemsRecommended getUserItemsRecommended() {
        return userItemsRecommended;
    }

    /**
     * 
     * @param userItemsRecommended
     *     The user_items_recommended
     */
    public void setUserItemsRecommended(UserItemsRecommended userItemsRecommended) {
        this.userItemsRecommended = userItemsRecommended;
    }

    /**
     * 
     * @return
     *     The alerts
     */
    public Alerts getAlerts() {
        return alerts;
    }

    /**
     * 
     * @param alerts
     *     The alerts
     */
    public void setAlerts(Alerts alerts) {
        this.alerts = alerts;
    }

    /**
     * 
     * @return
     *     The readLater
     */
    public ReadLater getReadLater() {
        return readLater;
    }

    /**
     * 
     * @param readLater
     *     The read_later
     */
    public void setReadLater(ReadLater readLater) {
        this.readLater = readLater;
    }

    /**
     * 
     * @return
     *     The notifications
     */
    public Notifications getNotifications() {
        return notifications;
    }

    /**
     * 
     * @param notifications
     *     The notifications
     */
    public void setNotifications(Notifications notifications) {
        this.notifications = notifications;
    }

    /**
     * 
     * @return
     *     The userNotifications
     */
    public UserNotifications getUserNotifications() {
        return userNotifications;
    }

    /**
     * 
     * @param userNotifications
     *     The user_notifications
     */
    public void setUserNotifications(UserNotifications userNotifications) {
        this.userNotifications = userNotifications;
    }

    /**
     * 
     * @return
     *     The transactions
     */
    public Transactions getTransactions() {
        return transactions;
    }

    /**
     * 
     * @param transactions
     *     The transactions
     */
    public void setTransactions(Transactions transactions) {
        this.transactions = transactions;
    }

    /**
     * 
     * @return
     *     The preferences
     */
    public Preferences getPreferences() {
        return preferences;
    }

    /**
     * 
     * @param preferences
     *     The preferences
     */
    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }

    /**
     * 
     * @return
     *     The coupons
     */
    public Coupons getCoupons() {
        return coupons;
    }

    /**
     * 
     * @param coupons
     *     The coupons
     */
    public void setCoupons(Coupons coupons) {
        this.coupons = coupons;
    }

    /**
     * 
     * @return
     *     The avatars
     */
    public Avatars getAvatars() {
        return avatars;
    }

    /**
     * 
     * @param avatars
     *     The avatars
     */
    public void setAvatars(Avatars avatars) {
        this.avatars = avatars;
    }

    /**
     * 
     * @return
     *     The oauth
     */
    public Oauth getOauth() {
        return oauth;
    }

    /**
     * 
     * @param oauth
     *     The oauth
     */
    public void setOauth(Oauth oauth) {
        this.oauth = oauth;
    }

    /**
     * 
     * @return
     *     The userPayment
     */
    public UserPayment getUserPayment() {
        return userPayment;
    }

    /**
     * 
     * @param userPayment
     *     The user_payment
     */
    public void setUserPayment(UserPayment userPayment) {
        this.userPayment = userPayment;
    }

    /**
     * 
     * @return
     *     The adyenPaymentMethods
     */
    public AdyenPaymentMethods getAdyenPaymentMethods() {
        return adyenPaymentMethods;
    }

    /**
     * 
     * @param adyenPaymentMethods
     *     The adyen_payment_methods
     */
    public void setAdyenPaymentMethods(AdyenPaymentMethods adyenPaymentMethods) {
        this.adyenPaymentMethods = adyenPaymentMethods;
    }

    /**
     * 
     * @return
     *     The adyenPaymentProposal
     */
    public AdyenPaymentProposal getAdyenPaymentProposal() {
        return adyenPaymentProposal;
    }

    /**
     * 
     * @param adyenPaymentProposal
     *     The adyen_payment_proposal
     */
    public void setAdyenPaymentProposal(AdyenPaymentProposal adyenPaymentProposal) {
        this.adyenPaymentProposal = adyenPaymentProposal;
    }

    /**
     * 
     * @return
     *     The adyenRecurringContracts
     */
    public AdyenRecurringContracts getAdyenRecurringContracts() {
        return adyenRecurringContracts;
    }

    /**
     * 
     * @param adyenRecurringContracts
     *     The adyen_recurring_contracts
     */
    public void setAdyenRecurringContracts(AdyenRecurringContracts adyenRecurringContracts) {
        this.adyenRecurringContracts = adyenRecurringContracts;
    }

    /**
     * 
     * @return
     *     The adyenPlaceOrder
     */
    public AdyenPlaceOrder getAdyenPlaceOrder() {
        return adyenPlaceOrder;
    }

    /**
     * 
     * @param adyenPlaceOrder
     *     The adyen_place_order
     */
    public void setAdyenPlaceOrder(AdyenPlaceOrder adyenPlaceOrder) {
        this.adyenPlaceOrder = adyenPlaceOrder;
    }

    /**
     * 
     * @return
     *     The newsstand
     */
    public Newsstand getNewsstand() {
        return newsstand;
    }

    /**
     * 
     * @param newsstand
     *     The newsstand
     */
    public void setNewsstand(Newsstand newsstand) {
        this.newsstand = newsstand;
    }

    /**
     * 
     * @return
     *     The item
     */
    public Item getItem() {
        return item;
    }

    /**
     * 
     * @param item
     *     The item
     */
    public void setItem(Item item) {
        this.item = item;
    }

    /**
     * 
     * @return
     *     The itemPosts
     */
    public ItemPosts getItemPosts() {
        return itemPosts;
    }

    /**
     * 
     * @param itemPosts
     *     The item_posts
     */
    public void setItemPosts(ItemPosts itemPosts) {
        this.itemPosts = itemPosts;
    }

    /**
     * 
     * @return
     *     The itemRecommendations
     */
    public ItemRecommendations getItemRecommendations() {
        return itemRecommendations;
    }

    /**
     * 
     * @param itemRecommendations
     *     The item_recommendations
     */
    public void setItemRecommendations(ItemRecommendations itemRecommendations) {
        this.itemRecommendations = itemRecommendations;
    }

    /**
     * 
     * @return
     *     The userItem
     */
    public UserItem getUserItem() {
        return userItem;
    }

    /**
     * 
     * @param userItem
     *     The user_item
     */
    public void setUserItem(UserItem userItem) {
        this.userItem = userItem;
    }

    /**
     * 
     * @return
     *     The refundReason
     */
    public RefundReason getRefundReason() {
        return refundReason;
    }

    /**
     * 
     * @param refundReason
     *     The refund_reason
     */
    public void setRefundReason(RefundReason refundReason) {
        this.refundReason = refundReason;
    }

    /**
     * 
     * @return
     *     The issueMetadata
     */
    public IssueMetadata getIssueMetadata() {
        return issueMetadata;
    }

    /**
     * 
     * @param issueMetadata
     *     The issue_metadata
     */
    public void setIssueMetadata(IssueMetadata issueMetadata) {
        this.issueMetadata = issueMetadata;
    }

    /**
     * 
     * @return
     *     The issue
     */
    public Issue getIssue() {
        return issue;
    }

    /**
     * 
     * @param issue
     *     The issue
     */
    public void setIssue(Issue issue) {
        this.issue = issue;
    }

    /**
     * 
     * @return
     *     The issuePages
     */
    public IssuePages getIssuePages() {
        return issuePages;
    }

    /**
     * 
     * @param issuePages
     *     The issue_pages
     */
    public void setIssuePages(IssuePages issuePages) {
        this.issuePages = issuePages;
    }

    /**
     * 
     * @return
     *     The issueItems
     */
    public IssueItems getIssueItems() {
        return issueItems;
    }

    /**
     * 
     * @param issueItems
     *     The issue_items
     */
    public void setIssueItems(IssueItems issueItems) {
        this.issueItems = issueItems;
    }

    /**
     * 
     * @return
     *     The latestIssue
     */
    public LatestIssue getLatestIssue() {
        return latestIssue;
    }

    /**
     * 
     * @param latestIssue
     *     The latest_issue
     */
    public void setLatestIssue(LatestIssue latestIssue) {
        this.latestIssue = latestIssue;
    }

    /**
     * 
     * @return
     *     The latestIssues
     */
    public LatestIssues getLatestIssues() {
        return latestIssues;
    }

    /**
     * 
     * @param latestIssues
     *     The latest_issues
     */
    public void setLatestIssues(LatestIssues latestIssues) {
        this.latestIssues = latestIssues;
    }

    /**
     * 
     * @return
     *     The issueAcquisition
     */
    public IssueAcquisition getIssueAcquisition() {
        return issueAcquisition;
    }

    /**
     * 
     * @param issueAcquisition
     *     The issue_acquisition
     */
    public void setIssueAcquisition(IssueAcquisition issueAcquisition) {
        this.issueAcquisition = issueAcquisition;
    }

    /**
     * 
     * @return
     *     The itemAcquisition
     */
    public ItemAcquisition getItemAcquisition() {
        return itemAcquisition;
    }

    /**
     * 
     * @param itemAcquisition
     *     The item_acquisition
     */
    public void setItemAcquisition(ItemAcquisition itemAcquisition) {
        this.itemAcquisition = itemAcquisition;
    }

    /**
     * 
     * @return
     *     The nearbyIssues
     */
    public NearbyIssues getNearbyIssues() {
        return nearbyIssues;
    }

    /**
     * 
     * @param nearbyIssues
     *     The nearby_issues
     */
    public void setNearbyIssues(NearbyIssues nearbyIssues) {
        this.nearbyIssues = nearbyIssues;
    }

    /**
     * 
     * @return
     *     The search
     */
    public Search getSearch() {
        return search;
    }

    /**
     * 
     * @param search
     *     The search
     */
    public void setSearch(Search search) {
        this.search = search;
    }

    /**
     * 
     * @return
     *     The userSearch
     */
    public UserSearch getUserSearch() {
        return userSearch;
    }

    /**
     * 
     * @param userSearch
     *     The user_search
     */
    public void setUserSearch(UserSearch userSearch) {
        this.userSearch = userSearch;
    }

    /**
     * 
     * @return
     *     The advancedSearch
     */
    public AdvancedSearch getAdvancedSearch() {
        return advancedSearch;
    }

    /**
     * 
     * @param advancedSearch
     *     The advanced_search
     */
    public void setAdvancedSearch(AdvancedSearch advancedSearch) {
        this.advancedSearch = advancedSearch;
    }

    /**
     * 
     * @return
     *     The suggestions
     */
    public Suggestions getSuggestions() {
        return suggestions;
    }

    /**
     * 
     * @param suggestions
     *     The suggestions
     */
    public void setSuggestions(Suggestions suggestions) {
        this.suggestions = suggestions;
    }

    /**
     * 
     * @return
     *     The providerStatistics
     */
    public ProviderStatistics getProviderStatistics() {
        return providerStatistics;
    }

    /**
     * 
     * @param providerStatistics
     *     The provider_statistics
     */
    public void setProviderStatistics(ProviderStatistics providerStatistics) {
        this.providerStatistics = providerStatistics;
    }

    /**
     * 
     * @return
     *     The onetimelink
     */
    public Onetimelink getOnetimelink() {
        return onetimelink;
    }

    /**
     * 
     * @param onetimelink
     *     The onetimelink
     */
    public void setOnetimelink(Onetimelink onetimelink) {
        this.onetimelink = onetimelink;
    }

    /**
     * 
     * @return
     *     The popularProvidersForUser
     */
    public PopularProvidersForUser getPopularProvidersForUser() {
        return popularProvidersForUser;
    }

    /**
     * 
     * @param popularProvidersForUser
     *     The popular_providers_for_user
     */
    public void setPopularProvidersForUser(PopularProvidersForUser popularProvidersForUser) {
        this.popularProvidersForUser = popularProvidersForUser;
    }

    /**
     * 
     * @return
     *     The emailShare
     */
    public EmailShare getEmailShare() {
        return emailShare;
    }

    /**
     * 
     * @param emailShare
     *     The email_share
     */
    public void setEmailShare(EmailShare emailShare) {
        this.emailShare = emailShare;
    }

    /**
     * 
     * @return
     *     The abTest
     */
    public AbTest getAbTest() {
        return abTest;
    }

    /**
     * 
     * @param abTest
     *     The ab_test
     */
    public void setAbTest(AbTest abTest) {
        this.abTest = abTest;
    }

    /**
     * 
     * @return
     *     The onboardingNewsstand
     */
    public List<OnboardingNewsstand> getOnboardingNewsstand() {
        return onboardingNewsstand;
    }

    /**
     * 
     * @param onboardingNewsstand
     *     The onboarding_newsstand
     */
    public void setOnboardingNewsstand(List<OnboardingNewsstand> onboardingNewsstand) {
        this.onboardingNewsstand = onboardingNewsstand;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(self).append(style).append(publications).append(account).append(signupCode).append(users).append(channels).append(allPosts).append(usersPopularPosts).append(itemsPopular).append(login).append(logout).append(requestPasswordResetToken).append(confirmEmail).append(passwordReset).append(credentials).append(userRefreshToken).append(userRefreshTokens).append(userEmailTokens).append(frontendEvents).append(defaultFollowsPosts).append(i18n).append(supportedCountries).append(supportedCountry).append(supportedLocales).append(me).append(currentLocation).append(location).append(searchLocations).append(user).append(userResendConfirmationEmail).append(userFavourite).append(userFavourites).append(userFavouritesCategory).append(userTimeline).append(userPostedTiles).append(userTrendingTiles).append(userFollowingTiles).append(userPinsTimeline).append(userPin).append(userFollowsPosts).append(userFollowSuggestionsWithLatestPost).append(userProviderAccounts).append(userIssues).append(recommendedIssues).append(follows).append(followers).append(deposits).append(followSuggestions).append(posts).append(likes).append(userItems).append(userItemsRecommended).append(alerts).append(readLater).append(notifications).append(userNotifications).append(transactions).append(preferences).append(coupons).append(avatars).append(oauth).append(userPayment).append(adyenPaymentMethods).append(adyenPaymentProposal).append(adyenRecurringContracts).append(adyenPlaceOrder).append(newsstand).append(item).append(itemPosts).append(itemRecommendations).append(userItem).append(refundReason).append(issueMetadata).append(issue).append(issuePages).append(issueItems).append(latestIssue).append(latestIssues).append(issueAcquisition).append(itemAcquisition).append(nearbyIssues).append(search).append(userSearch).append(advancedSearch).append(suggestions).append(providerStatistics).append(onetimelink).append(popularProvidersForUser).append(emailShare).append(abTest).append(onboardingNewsstand).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Links) == false) {
            return false;
        }
        Links rhs = ((Links) other);
        return new EqualsBuilder().append(self, rhs.self).append(style, rhs.style).append(publications, rhs.publications).append(account, rhs.account).append(signupCode, rhs.signupCode).append(users, rhs.users).append(channels, rhs.channels).append(allPosts, rhs.allPosts).append(usersPopularPosts, rhs.usersPopularPosts).append(itemsPopular, rhs.itemsPopular).append(login, rhs.login).append(logout, rhs.logout).append(requestPasswordResetToken, rhs.requestPasswordResetToken).append(confirmEmail, rhs.confirmEmail).append(passwordReset, rhs.passwordReset).append(credentials, rhs.credentials).append(userRefreshToken, rhs.userRefreshToken).append(userRefreshTokens, rhs.userRefreshTokens).append(userEmailTokens, rhs.userEmailTokens).append(frontendEvents, rhs.frontendEvents).append(defaultFollowsPosts, rhs.defaultFollowsPosts).append(i18n, rhs.i18n).append(supportedCountries, rhs.supportedCountries).append(supportedCountry, rhs.supportedCountry).append(supportedLocales, rhs.supportedLocales).append(me, rhs.me).append(currentLocation, rhs.currentLocation).append(location, rhs.location).append(searchLocations, rhs.searchLocations).append(user, rhs.user).append(userResendConfirmationEmail, rhs.userResendConfirmationEmail).append(userFavourite, rhs.userFavourite).append(userFavourites, rhs.userFavourites).append(userFavouritesCategory, rhs.userFavouritesCategory).append(userTimeline, rhs.userTimeline).append(userPostedTiles, rhs.userPostedTiles).append(userTrendingTiles, rhs.userTrendingTiles).append(userFollowingTiles, rhs.userFollowingTiles).append(userPinsTimeline, rhs.userPinsTimeline).append(userPin, rhs.userPin).append(userFollowsPosts, rhs.userFollowsPosts).append(userFollowSuggestionsWithLatestPost, rhs.userFollowSuggestionsWithLatestPost).append(userProviderAccounts, rhs.userProviderAccounts).append(userIssues, rhs.userIssues).append(recommendedIssues, rhs.recommendedIssues).append(follows, rhs.follows).append(followers, rhs.followers).append(deposits, rhs.deposits).append(followSuggestions, rhs.followSuggestions).append(posts, rhs.posts).append(likes, rhs.likes).append(userItems, rhs.userItems).append(userItemsRecommended, rhs.userItemsRecommended).append(alerts, rhs.alerts).append(readLater, rhs.readLater).append(notifications, rhs.notifications).append(userNotifications, rhs.userNotifications).append(transactions, rhs.transactions).append(preferences, rhs.preferences).append(coupons, rhs.coupons).append(avatars, rhs.avatars).append(oauth, rhs.oauth).append(userPayment, rhs.userPayment).append(adyenPaymentMethods, rhs.adyenPaymentMethods).append(adyenPaymentProposal, rhs.adyenPaymentProposal).append(adyenRecurringContracts, rhs.adyenRecurringContracts).append(adyenPlaceOrder, rhs.adyenPlaceOrder).append(newsstand, rhs.newsstand).append(item, rhs.item).append(itemPosts, rhs.itemPosts).append(itemRecommendations, rhs.itemRecommendations).append(userItem, rhs.userItem).append(refundReason, rhs.refundReason).append(issueMetadata, rhs.issueMetadata).append(issue, rhs.issue).append(issuePages, rhs.issuePages).append(issueItems, rhs.issueItems).append(latestIssue, rhs.latestIssue).append(latestIssues, rhs.latestIssues).append(issueAcquisition, rhs.issueAcquisition).append(itemAcquisition, rhs.itemAcquisition).append(nearbyIssues, rhs.nearbyIssues).append(search, rhs.search).append(userSearch, rhs.userSearch).append(advancedSearch, rhs.advancedSearch).append(suggestions, rhs.suggestions).append(providerStatistics, rhs.providerStatistics).append(onetimelink, rhs.onetimelink).append(popularProvidersForUser, rhs.popularProvidersForUser).append(emailShare, rhs.emailShare).append(abTest, rhs.abTest).append(onboardingNewsstand, rhs.onboardingNewsstand).isEquals();
    }

}
