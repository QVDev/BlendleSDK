
package com.sdk.blendle.models.generated.article;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Article {

    @SerializedName("_links")
    @Expose
    private com.sdk.blendle.models.generated.article.Links Links;
    @SerializedName("_embedded")
    @Expose
    private com.sdk.blendle.models.generated.article.Embedded Embedded;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("posts")
    @Expose
    private Integer posts;
    @SerializedName("acquired")
    @Expose
    private Boolean acquired;
    @SerializedName("acquirable")
    @Expose
    private Boolean acquirable;
    @SerializedName("refundable")
    @Expose
    private Boolean refundable;
    @SerializedName("price")
    @Expose
    private String price;

    /**
     * 
     * @return
     *     The Links
     */
    public com.sdk.blendle.models.generated.article.Links getLinks() {
        return Links;
    }

    /**
     * 
     * @param Links
     *     The _links
     */
    public void setLinks(com.sdk.blendle.models.generated.article.Links Links) {
        this.Links = Links;
    }

    /**
     * 
     * @return
     *     The Embedded
     */
    public com.sdk.blendle.models.generated.article.Embedded getEmbedded() {
        return Embedded;
    }

    /**
     * 
     * @param Embedded
     *     The _embedded
     */
    public void setEmbedded(com.sdk.blendle.models.generated.article.Embedded Embedded) {
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
     *     The acquirable
     */
    public Boolean getAcquirable() {
        return acquirable;
    }

    /**
     * 
     * @param acquirable
     *     The acquirable
     */
    public void setAcquirable(Boolean acquirable) {
        this.acquirable = acquirable;
    }

    /**
     * 
     * @return
     *     The refundable
     */
    public Boolean getRefundable() {
        return refundable;
    }

    /**
     * 
     * @param refundable
     *     The refundable
     */
    public void setRefundable(Boolean refundable) {
        this.refundable = refundable;
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
        return new HashCodeBuilder().append(Links).append(Embedded).append(id).append(posts).append(acquired).append(acquirable).append(refundable).append(price).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Article) == false) {
            return false;
        }
        Article rhs = ((Article) other);
        return new EqualsBuilder().append(Links, rhs.Links).append(Embedded, rhs.Embedded).append(id, rhs.id).append(posts, rhs.posts).append(acquired, rhs.acquired).append(acquirable, rhs.acquirable).append(refundable, rhs.refundable).append(price, rhs.price).isEquals();
    }

}
