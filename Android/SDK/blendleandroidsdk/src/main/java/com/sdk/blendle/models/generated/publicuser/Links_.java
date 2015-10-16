
package com.sdk.blendle.models.generated.publicuser;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Links_ {

    @SerializedName("self")
    @Expose
    private Self_ self;
    @SerializedName("avatar")
    @Expose
    private Avatar_ avatar;
    @SerializedName("posts")
    @Expose
    private Posts_ posts;
    @SerializedName("reads")
    @Expose
    private Reads_ reads;
    @SerializedName("followers")
    @Expose
    private Followers_ followers;
    @SerializedName("follows")
    @Expose
    private Follows_ follows;
    @SerializedName("private")
    @Expose
    private Private_ _private;
    @SerializedName("large_avatar")
    @Expose
    private LargeAvatar_ largeAvatar;

    /**
     * 
     * @return
     *     The self
     */
    public Self_ getSelf() {
        return self;
    }

    /**
     * 
     * @param self
     *     The self
     */
    public void setSelf(Self_ self) {
        this.self = self;
    }

    /**
     * 
     * @return
     *     The avatar
     */
    public Avatar_ getAvatar() {
        return avatar;
    }

    /**
     * 
     * @param avatar
     *     The avatar
     */
    public void setAvatar(Avatar_ avatar) {
        this.avatar = avatar;
    }

    /**
     * 
     * @return
     *     The posts
     */
    public Posts_ getPosts() {
        return posts;
    }

    /**
     * 
     * @param posts
     *     The posts
     */
    public void setPosts(Posts_ posts) {
        this.posts = posts;
    }

    /**
     * 
     * @return
     *     The reads
     */
    public Reads_ getReads() {
        return reads;
    }

    /**
     * 
     * @param reads
     *     The reads
     */
    public void setReads(Reads_ reads) {
        this.reads = reads;
    }

    /**
     * 
     * @return
     *     The followers
     */
    public Followers_ getFollowers() {
        return followers;
    }

    /**
     * 
     * @param followers
     *     The followers
     */
    public void setFollowers(Followers_ followers) {
        this.followers = followers;
    }

    /**
     * 
     * @return
     *     The follows
     */
    public Follows_ getFollows() {
        return follows;
    }

    /**
     * 
     * @param follows
     *     The follows
     */
    public void setFollows(Follows_ follows) {
        this.follows = follows;
    }

    /**
     * 
     * @return
     *     The _private
     */
    public Private_ getPrivate() {
        return _private;
    }

    /**
     * 
     * @param _private
     *     The private
     */
    public void setPrivate(Private_ _private) {
        this._private = _private;
    }

    /**
     * 
     * @return
     *     The largeAvatar
     */
    public LargeAvatar_ getLargeAvatar() {
        return largeAvatar;
    }

    /**
     * 
     * @param largeAvatar
     *     The large_avatar
     */
    public void setLargeAvatar(LargeAvatar_ largeAvatar) {
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
        if ((other instanceof Links_) == false) {
            return false;
        }
        Links_ rhs = ((Links_) other);
        return new EqualsBuilder().append(self, rhs.self).append(avatar, rhs.avatar).append(posts, rhs.posts).append(reads, rhs.reads).append(followers, rhs.followers).append(follows, rhs.follows).append(_private, rhs._private).append(largeAvatar, rhs.largeAvatar).isEquals();
    }

}
