
package com.sdk.blendle.models.generated.userissue;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Image {

    @SerializedName("_links")
    @Expose
    private Links___ Links;
    @SerializedName("credit")
    @Expose
    private String credit;
    @SerializedName("featured")
    @Expose
    private Boolean featured;

    /**
     * 
     * @return
     *     The Links
     */
    public Links___ getLinks() {
        return Links;
    }

    /**
     * 
     * @param Links
     *     The _links
     */
    public void setLinks(Links___ Links) {
        this.Links = Links;
    }

    /**
     * 
     * @return
     *     The credit
     */
    public String getCredit() {
        return credit;
    }

    /**
     * 
     * @param credit
     *     The credit
     */
    public void setCredit(String credit) {
        this.credit = credit;
    }

    /**
     * 
     * @return
     *     The featured
     */
    public Boolean getFeatured() {
        return featured;
    }

    /**
     * 
     * @param featured
     *     The featured
     */
    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(Links).append(credit).append(featured).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Image) == false) {
            return false;
        }
        Image rhs = ((Image) other);
        return new EqualsBuilder().append(Links, rhs.Links).append(credit, rhs.credit).append(featured, rhs.featured).isEquals();
    }

}
