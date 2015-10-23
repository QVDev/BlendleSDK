package com.qvdev.apps.readerkid;

import com.qvdev.apps.readerkid.utils.ItemWrapper;

import java.util.List;

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

    public void onArticlesReady(List<ItemWrapper> items) {
        // Check if this are issues or user items
        if (items.size() > 0 && items.get(0).getSubItemsCount() != 0) {
            ItemWrapper itemWrapper = new ItemWrapper();
            itemWrapper.setId(ItemWrapper.OWNED_ITEMS_ID);
            itemWrapper.setTitle(getString(R.string.menu_archive));
            itemWrapper.setImageUrl("https://static.blendle.nl/images/default/avatar/default.jpg");
            items.add(0, itemWrapper);
        }
        super.onArticlesReady(items);
    }

    protected void loadNonStandardIssues() {
        mBlendleApi.getUserItems(this, mBlendleApi.getUserId());
    }
}
