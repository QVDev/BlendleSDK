package com.qvdev.apps.readerkid;

public class InternationalNewsstandFragment extends PapersNewsstandFragment {

    public static InternationalNewsstandFragment newInstance() {
        InternationalNewsstandFragment fragment = new InternationalNewsstandFragment();
        return fragment;
    }

    public InternationalNewsstandFragment() {
        // Required empty public constructor
    }

    protected void loadCovers() {
        mBlendleApi.getInternational(this);
    }
}
