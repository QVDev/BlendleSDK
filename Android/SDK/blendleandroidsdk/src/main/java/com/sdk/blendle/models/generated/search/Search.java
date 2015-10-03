
package com.sdk.blendle.models.generated.search;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Search {

    @SerializedName("_links")
    @Expose
    private com.sdk.blendle.models.generated.search.Links Links;
    @SerializedName("_embedded")
    @Expose
    private com.sdk.blendle.models.generated.search.Embedded Embedded;
    @SerializedName("results")
    @Expose
    private Integer results;

    /**
     * 
     * @return
     *     The Links
     */
    public com.sdk.blendle.models.generated.search.Links getLinks() {
        return Links;
    }

    /**
     * 
     * @param Links
     *     The _links
     */
    public void setLinks(com.sdk.blendle.models.generated.search.Links Links) {
        this.Links = Links;
    }

    /**
     * 
     * @return
     *     The Embedded
     */
    public com.sdk.blendle.models.generated.search.Embedded getEmbedded() {
        return Embedded;
    }

    /**
     * 
     * @param Embedded
     *     The _embedded
     */
    public void setEmbedded(com.sdk.blendle.models.generated.search.Embedded Embedded) {
        this.Embedded = Embedded;
    }

    /**
     * 
     * @return
     *     The results
     */
    public Integer getResults() {
        return results;
    }

    /**
     * 
     * @param results
     *     The results
     */
    public void setResults(Integer results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(Links).append(Embedded).append(results).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Search) == false) {
            return false;
        }
        Search rhs = ((Search) other);
        return new EqualsBuilder().append(Links, rhs.Links).append(Embedded, rhs.Embedded).append(results, rhs.results).isEquals();
    }

}
