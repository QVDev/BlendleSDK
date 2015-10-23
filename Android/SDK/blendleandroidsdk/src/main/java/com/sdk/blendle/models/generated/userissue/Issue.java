
package com.sdk.blendle.models.generated.userissue;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Issue {

    @SerializedName("_links")
    @Expose
    private Links_ Links;
    @SerializedName("_embedded")
    @Expose
    private Embedded_ Embedded;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("acquired")
    @Expose
    private Boolean acquired;
    @SerializedName("price")
    @Expose
    private String price;

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

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The acquired
     */
    public Boolean getAcquired() {
        return acquired;
    }

    /**
     * 
     * @param acquired
     *     The acquired
     */
    public void setAcquired(Boolean acquired) {
        this.acquired = acquired;
    }

    /**
     * 
     * @return
     *     The price
     */
    public String getPrice() {
        return price;
    }

    /**
     * 
     * @param price
     *     The price
     */
    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(Links).append(Embedded).append(id).append(acquired).append(price).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Issue) == false) {
            return false;
        }
        Issue rhs = ((Issue) other);
        return new EqualsBuilder().append(Links, rhs.Links).append(Embedded, rhs.Embedded).append(id, rhs.id).append(acquired, rhs.acquired).append(price, rhs.price).isEquals();
    }

}
