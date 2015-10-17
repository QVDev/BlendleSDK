package com.qvdev.apps.readerkid.utils;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.sdk.blendle.models.generated.search.Manifest;

import java.util.ArrayList;
import java.util.List;

public class TransformManifestResult extends AsyncTask<Object, Integer, List<Manifest>> {

    private final TransformManifestCallback mCallback;

    public interface TransformManifestCallback {
        void onArticlesReady(List<Manifest> articles);
    }

    public TransformManifestResult(TransformManifestCallback callback) {
        mCallback = callback;
    }

    @Override
    protected List<Manifest> doInBackground(Object... objects) {
        List<Manifest> articles = new ArrayList<>();
        Gson gson = new Gson();
        for (Object potentialManifest : objects) {
            String rawJson = gson.toJson(potentialManifest);
            articles.add(gson.fromJson(rawJson, Manifest.class));
        }
        return articles;
    }

    @Override
    protected void onPostExecute(List<Manifest> manifest) {
        mCallback.onArticlesReady(manifest);
    }
}
