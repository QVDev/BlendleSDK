package com.qvdev.apps.readerkid;

public class MagazinesNewsstandFragment extends PapersNewsstandFragment {

    public static MagazinesNewsstandFragment newInstance() {
        MagazinesNewsstandFragment fragment = new MagazinesNewsstandFragment();
        return fragment;
    }

    public MagazinesNewsstandFragment() {
        // Required empty public constructor
    }

    protected void loadCovers() {
        mBlendleApi.getMostRecentMagazinesNewsstand(this);
    }
}
