package com.sdk.blendle.models.custom;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sdk.blendle.models.generated.example.Embedded;
import com.sdk.blendle.models.generated.example.Links;

public class Api {

    @SerializedName("_links")
    @Expose
    private Links links;

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    @SerializedName("_embedded")
    @Expose
    private Embedded embedded;

    public Embedded getEmbedded() {
        return embedded;
    }

    public void setEmbedded(Embedded embedded) {
        this.embedded = embedded;
    }
}
