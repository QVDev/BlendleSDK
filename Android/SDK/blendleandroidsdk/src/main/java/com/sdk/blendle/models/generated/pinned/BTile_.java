
package com.sdk.blendle.models.generated.pinned;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class BTile_ {

    @SerializedName("posts")
    @Expose
    private Integer posts;
    @SerializedName("_embedded")
    @Expose
    private Embedded_ Embedded;
    @SerializedName("_links")
    @Expose
    private Links____ Links;

    /**
     * 
     * @return
     *     The posts
     */
    public Integer getPosts() {
        return posts;
    }

    /**
     * 
     * @param posts
     *     The posts
     */
    public void setPosts(Integer posts) {
        this.posts = posts;
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
     *     The Links
     */
    public Links____ getLinks() {
        return Links;
    }

    /**
     * 
     * @param Links
     *     The _links
     */
    public void setLinks(Links____ Links) {
        this.Links = Links;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(posts).append(Embedded).append(Links).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BTile_) == false) {
            return false;
        }
        BTile_ rhs = ((BTile_) other);
        return new EqualsBuilder().append(posts, rhs.posts).append(Embedded, rhs.Embedded).append(Links, rhs.Links).isEquals();
    }

}
