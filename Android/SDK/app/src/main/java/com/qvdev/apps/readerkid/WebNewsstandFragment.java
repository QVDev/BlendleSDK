package com.qvdev.apps.readerkid;

public class WebNewsstandFragment extends PapersNewsstandFragment {

    public static WebNewsstandFragment newInstance() {
        WebNewsstandFragment fragment = new WebNewsstandFragment();
        return fragment;
    }

    public WebNewsstandFragment() {
        // Required empty public constructor
    }

    protected void loadCovers() {
        mBlendleApi.getWeb(this);
    }
}
