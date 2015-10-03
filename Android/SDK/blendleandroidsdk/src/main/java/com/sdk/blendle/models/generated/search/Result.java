
package com.sdk.blendle.models.generated.search;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Result {

    @SerializedName("_links")
    @Expose
    private Links_ Links;
    @SerializedName("first_hit")
    @Expose
    private String firstHit;
    @SerializedName("snippet")
    @Expose
    private String snippet;
    @SerializedName("_embedded")
    @Expose
    private Embedded_ Embedded;

    /**
     * 
     * @return
     *     The Links
     */
    public Links_ getLinks() {
        return Links;
    }

    /**
     * 
     * @param Links
     *     The _links
     */
    public void setLinks(Links_ Links) {
        this.Links = Links;
    }

    /**
     * 
     * @return
     *     The firstHit
     */
    public String getFirstHit() {
        return firstHit;
    }

    /**
     * 
     * @param firstHit
     *     The first_hit
     */
    public void setFirstHit(String firstHit) {
        this.firstHit = firstHit;
    }

    /**
     * 
     * @return
     *     The snippet
     */
    public String getSnippet() {
        return snippet;
    }

    /**
     * 
     * @param snippet
     *     The snippet
     */
    public void setSnippet(String snippet) {
        this.snippet = snippet;
    }

    /**
     * 
     * @return
     *     The Embedded
     */
    public Embedded_ getEmbedded() {
        return Embedded;
    }

    /**
     * 
     * @param Embedded
     *     The _embedded
     */
    public void setEmbedded(Embedded_ Embedded) {
        this.Embedded = Embedded;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(Links).append(firstHit).append(snippet).append(Embedded).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Result) == false) {
            return false;
        }
        Result rhs = ((Result) other);
        return new EqualsBuilder().append(Links, rhs.Links).append(firstHit, rhs.firstHit).append(snippet, rhs.snippet).append(Embedded, rhs.Embedded).isEquals();
    }

}
