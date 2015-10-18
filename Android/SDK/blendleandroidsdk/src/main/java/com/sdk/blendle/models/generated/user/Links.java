
package com.sdk.blendle.models.generated.user;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Links {

    @SerializedName("self")
    @Expose
    private Self self;
    @SerializedName("avatar")
    @Expose
    private Avatar avatar;
    @SerializedName("posts")
    @Expose
    private Posts posts;
    @SerializedName("reads")
    @Expose
    private Reads reads;
    @SerializedName("followers")
    @Expose
    private Followers followers;
    @SerializedName("follows")
    @Expose
    private com.sdk.blendle.models.generated.user.Follows follows;
    @SerializedName("private")
    @Expose
    private Private _private;
    @SerializedName("large_avatar")
    @Expose
    private com.sdk.blendle.models.generated.user.LargeAvatar largeAvatar;

    /**
     * 
     * @return
     *     The self
     */
    public Self getSelf() {
        return self;
    }

    /**
     * 
     * @param self
     *     The self
     */
    public void setSelf(Self self) {
        this.self = self;
    }

    /**
     * 
     * @return
     *     The avatar
     */
    public Avatar getAvatar() {
        return avatar;
    }

    /**
     * 
     * @param avatar
     *     The avatar
     */
    public void setAvatar(Avatar avatar) {
        this.avatar = avatar;
    }

    /**
     * 
     * @return
     *     The posts
     */
    public Posts getPosts() {
        return posts;
    }

    /**
     * 
     * @param posts
     *     The posts
     */
    public void setPosts(Posts posts) {
        this.posts = posts;
    }

    /**
     * 
     * @return
     *     The reads
     */
    public Reads getReads() {
        return reads;
    }

    /**
     * 
     * @param reads
     *     The reads
     */
    public void setReads(Reads reads) {
        this.reads = reads;
    }

    /**
     * 
     * @return
     *     The followers
     */
    public Followers getFollowers() {
        return followers;
    }

    /**
     * 
     * @param followers
     *     The followers
     */
    public void setFollowers(Followers followers) {
        this.followers = followers;
    }

    /**
     * 
     * @return
     *     The follows
     */
    public com.sdk.blendle.models.generated.user.Follows getFollows() {
        return follows;
    }

    /**
     * 
     * @param follows
     *     The follows
     */
    public void setFollows(com.sdk.blendle.models.generated.user.Follows follows) {
        this.follows = follows;
    }

    /**
     * 
     * @return
     *     The _private
     */
    public Private getPrivate() {
        return _private;
    }

    /**
     * 
     * @param _private
     *     The private
     */
    public void setPrivate(Private _private) {
        this._private = _private;
    }

    /**
     * 
     * @return
     *     The largeAvatar
     */
    public com.sdk.blendle.models.generated.user.LargeAvatar getLargeAvatar() {
        return largeAvatar;
    }

    /**
     * 
     * @param largeAvatar
     *     The large_avatar
     */
    public void setLargeAvatar(com.sdk.blendle.models.generated.user.LargeAvatar largeAvatar) {
        this.largeAvatar = largeAvatar;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(self).append(avatar).append(posts).append(reads).append(followers).append(follows).append(_private).append(largeAvatar).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Links) == false) {
            return false;
        }
        Links rhs = ((Links) other);
        return new EqualsBuilder().append(self, rhs.self).append(avatar, rhs.avatar).append(posts, rhs.posts).append(reads, rhs.reads).append(followers, rhs.followers).append(follows, rhs.follows).append(_private, rhs._private).append(largeAvatar, rhs.largeAvatar).isEquals();
    }

}
