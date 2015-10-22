
package com.sdk.blendle.models.generated.pinned;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Links____ {

    @SerializedName("self")
    @Expose
    private Self___ self;
    @SerializedName("curies")
    @Expose
    private Curies__ curies;
    @SerializedName("b:posts")
    @Expose
    private BPosts bPosts;
    @SerializedName("b:recent-post")
    @Expose
    private BRecentPost bRecentPost;
    @SerializedName("recent-post")
    @Expose
    private RecentPost recentPost;
    @SerializedName("b:item")
    @Expose
    private BItem_ bItem;

    /**
     * 
     * @return
     *     The self
     */
    public Self___ getSelf() {
        return self;
    }

    /**
     * 
     * @param self
     *     The self
     */
    public void setSelf(Self___ self) {
        this.self = self;
    }

    /**
     * 
     * @return
     *     The curies
     */
    public Curies__ getCuries() {
        return curies;
    }

    /**
     * 
     * @param curies
     *     The curies
     */
    public void setCuries(Curies__ curies) {
        this.curies = curies;
    }

    /**
     * 
     * @return
     *     The bPosts
     */
    public BPosts getBPosts() {
        return bPosts;
    }

    /**
     * 
     * @param bPosts
     *     The b:posts
     */
    public void setBPosts(BPosts bPosts) {
        this.bPosts = bPosts;
    }

    /**
     * 
     * @return
     *     The bRecentPost
     */
    public BRecentPost getBRecentPost() {
        return bRecentPost;
    }

    /**
     * 
     * @param bRecentPost
     *     The b:recent-post
     */
    public void setBRecentPost(BRecentPost bRecentPost) {
        this.bRecentPost = bRecentPost;
    }

    /**
     * 
     * @return
     *     The recentPost
     */
    public RecentPost getRecentPost() {
        return recentPost;
    }

    /**
     * 
     * @param recentPost
     *     The recent-post
     */
    public void setRecentPost(RecentPost recentPost) {
        this.recentPost = recentPost;
    }

    /**
     * 
     * @return
     *     The bItem
     */
    public BItem_ getBItem() {
        return bItem;
    }

    /**
     * 
     * @param bItem
     *     The b:item
     */
    public void setBItem(BItem_ bItem) {
        this.bItem = bItem;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(self).append(curies).append(bPosts).append(bRecentPost).append(recentPost).append(bItem).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Links____) == false) {
            return false;
        }
        Links____ rhs = ((Links____) other);
        return new EqualsBuilder().append(self, rhs.self).append(curies, rhs.curies).append(bPosts, rhs.bPosts).append(bRecentPost, rhs.bRecentPost).append(recentPost, rhs.recentPost).append(bItem, rhs.bItem).isEquals();
    }

}
