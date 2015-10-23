package com.qvdev.apps.readerkid.utils;

import android.os.AsyncTask;

import com.sdk.blendle.models.generated.article.Body;
import com.sdk.blendle.models.generated.newsstand.Issue_;
import com.sdk.blendle.models.generated.newsstand.Newsstand;
import com.sdk.blendle.models.generated.pinned.BTile_;
import com.sdk.blendle.models.generated.pinned.Pinned;
import com.sdk.blendle.models.generated.popular.Item;
import com.sdk.blendle.models.generated.popular.Popular;
import com.sdk.blendle.models.generated.search.Result;
import com.sdk.blendle.models.generated.search.Search;
import com.sdk.blendle.models.generated.userissue.Issue;
import com.sdk.blendle.models.generated.userissue.UserIssue;

import java.util.ArrayList;
import java.util.List;

public class TransformResult extends AsyncTask<Object, Integer, List<ItemWrapper>> {

    private final TransformManifestCallback mCallback;

    public interface TransformManifestCallback {
        void onArticlesReady(List<ItemWrapper> articles);
    }

    public TransformResult(TransformManifestCallback callback) {
        mCallback = callback;
    }

    @Override
    protected List<ItemWrapper> doInBackground(Object... objects) {
        List<ItemWrapper> items = new ArrayList<>();
        Object result = objects.length > 0 ? objects[0] : null;
        Boolean isIssueResult = objects.length > 1 ? (Boolean) objects[1] : false;

        if (result instanceof Search) {
            Search search = (Search) result;
            for (Result item : search.getEmbedded().getResults()) {
                ItemWrapper itemWrapper = new ItemWrapper();
                itemWrapper.setId(item.getEmbedded().getItem().getId());
                itemWrapper.setTitle(item.getSnippet());
                itemWrapper.setSnippet(createSnippet(item.getEmbedded().getItem().getEmbedded().getManifest().getBody()));
                try {
                    itemWrapper.setImageUrl(item.getEmbedded().getItem().getEmbedded().getManifest().getImages().get(0).getLinks().getMedium().getHref());
                } catch (IndexOutOfBoundsException e) {
                    // ;
                }
                items.add(itemWrapper);
            }
        } else if (result instanceof Popular) {
            Popular newsstand = (Popular) result;
            for (Item item : newsstand.getEmbedded().getItems()) {
                ItemWrapper itemWrapper = new ItemWrapper();
                itemWrapper.setId(item.getEmbedded().getManifest().getId());
                itemWrapper.setTitle(item.getEmbedded().getManifest().getBody().get(0).getContent());
                itemWrapper.setSnippet(createSnippet(item.getEmbedded().getManifest().getBody()));
                try {
                    itemWrapper.setImageUrl(item.getEmbedded().getManifest().getImages().get(0).getLinks().getMedium().getHref());
                } catch (IndexOutOfBoundsException e) {
                    // ;
                }
                items.add(itemWrapper);
            }
        } else if (result instanceof Newsstand) {
            Newsstand newsstand = (Newsstand) result;
            for (Issue_ item : newsstand.getEmbedded().getIssues()) {
                ItemWrapper itemWrapper = new ItemWrapper();
                try {
                    if (isIssueResult) {//Such as papers and magazines
                        itemWrapper.setImageUrl(item.getLinks().getPagePreview() == null ? null : item.getLinks().getPagePreview().getHref());
                        itemWrapper.setId(item.getId());
                        itemWrapper.setSubItemsCount(item.getItems().size());
                        itemWrapper.setTitle(item.getProvider().getId());
                    } else {//General newsstand
                        itemWrapper.setId(item.getEmbedded().getManifest().getId());
                        itemWrapper.setImageUrl(item.getEmbedded().getManifest().getImages().get(0).getLinks().getMedium().getHref());
                        itemWrapper.setTitle(item.getEmbedded().getManifest().getBody().get(0).getContent());
                    }
                    itemWrapper.setSnippet(createSnippet(item.getEmbedded().getManifest().getBody()));
                } catch (IndexOutOfBoundsException e) {
                    // ;
                }
                items.add(itemWrapper);
            }
        } else if (result instanceof UserIssue) {
            UserIssue userIssue = (UserIssue) result;
            for (Issue item : userIssue.getEmbedded().getIssues()) {
                ItemWrapper itemWrapper = new ItemWrapper();
                itemWrapper.setImageUrl(item.getEmbedded().getIssue().getLinks().getPagePreview() == null ? null : item.getEmbedded().getIssue().getLinks().getPagePreview().getHref());
                itemWrapper.setId(item.getEmbedded().getIssue().getId());
                itemWrapper.setSubItemsCount(item.getEmbedded().getIssue().getItems().size());
                itemWrapper.setTitle(item.getEmbedded().getIssue().getProvider().getId());
                items.add(itemWrapper);
            }
        } else if (result instanceof Pinned) {
            Pinned pinned = (Pinned) result;
            for (BTile_ item : pinned.getEmbedded().getBTiles()) {
                ItemWrapper itemWrapper = new ItemWrapper();
                itemWrapper.setId(item.getEmbedded().getBItem().getId());
                itemWrapper.setTitle(item.getEmbedded().getBItem().getEmbedded().getManifest().getBody().get(0).getContent());
                itemWrapper.setSnippet(createSnippet(item.getEmbedded().getBItem().getEmbedded().getManifest().getBody()));
                try {
                    itemWrapper.setImageUrl(item.getEmbedded().getBItem().getEmbedded().getManifest().getImages().get(0).getLinks().getMedium().getHref());
                } catch (IndexOutOfBoundsException e) {
                    // ;
                }
                items.add(itemWrapper);
            }
        }

        return items;
    }

    private String createSnippet(List<?> texts) {
        StringBuilder completeArticleText = new StringBuilder();
        //TODO Improve this maybe create json and then parse or change the models?
        for (Object text : texts) {
            if (text instanceof Body) {
                Body body = (Body) text;
                completeArticleText.append(body.getContent());
                completeArticleText.append("<BR><BR>");
            } else if (text instanceof com.sdk.blendle.models.generated.newsstand.Body) {
                com.sdk.blendle.models.generated.newsstand.Body body = (com.sdk.blendle.models.generated.newsstand.Body) text;
                completeArticleText.append(body.getContent());
                completeArticleText.append("<BR><BR>");
            } else if (text instanceof com.sdk.blendle.models.generated.popular.Body) {
                com.sdk.blendle.models.generated.popular.Body body = (com.sdk.blendle.models.generated.popular.Body) text;
                completeArticleText.append(body.getContent());
                completeArticleText.append("<BR><BR>");
            } else if (text instanceof com.sdk.blendle.models.generated.search.Body) {
                com.sdk.blendle.models.generated.search.Body body = (com.sdk.blendle.models.generated.search.Body) text;
                completeArticleText.append(body.getContent());
                completeArticleText.append("<BR><BR>");
            } else if (text instanceof com.sdk.blendle.models.generated.pinned.Body) {
                com.sdk.blendle.models.generated.pinned.Body body = (com.sdk.blendle.models.generated.pinned.Body) text;
                completeArticleText.append(body.getContent());
                completeArticleText.append("<BR><BR>");
            }

        }
        return completeArticleText.toString();
    }

    @Override
    protected void onPostExecute(List<ItemWrapper> manifest) {
        mCallback.onArticlesReady(manifest);
    }
}
