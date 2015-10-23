package com.qvdev.apps.readerkid;

import com.qvdev.apps.readerkid.utils.ItemWrapper;
import com.sdk.blendle.models.generated.popular.Popular;

import java.util.List;

import retrofit.Response;

public class ArchiveFragment extends PapersNewsstandFragment {

    public static ArchiveFragment newInstance() {
        ArchiveFragment fragment = new ArchiveFragment();
        return fragment;
    }

    public ArchiveFragment() {
        // Required empty public constructor
    }

    protected void loadCovers() {
        mBlendleApi.getUserIssues(this, mBlendleApi.getUserId());
    }

    @Override
    protected void processResponse(Response<?> response) {
        super.processResponse(response);

        if (response.body() instanceof Popular) {
            Popular popularResponse = (Popular) response.body();
            mNextItems = popularResponse.getLinks().getNext().getHref();
        }
    }

    protected boolean fromArchive() {
        return true;
    }

    protected void loadNonStandardIssues() {
        mBlendleApi.getUserItems(this, mBlendleApi.getUserId());
    }

    @Override
    public void onArticlesReady(List<ItemWrapper> items) {
        if (mCovers.isEmpty()) {
            ItemWrapper itemWrapper = new ItemWrapper();
            itemWrapper.setId(ItemWrapper.OWNED_ITEMS_ID);
            itemWrapper.setTitle(getString(R.string.menu_archive));
            itemWrapper.setImageUrl("https://static.blendle.nl/images/default/avatar/default.jpg");
            items.add(0, itemWrapper);
        }
        super.onArticlesReady(items);
    }
}
