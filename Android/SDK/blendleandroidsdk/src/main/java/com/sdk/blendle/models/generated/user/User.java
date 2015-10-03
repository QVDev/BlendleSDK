
package com.sdk.blendle.models.generated.user;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class User {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("middle_name")
    @Expose
    private Object middleName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("full_name")
    @Expose
    private String fullName;
    @SerializedName("short_name")
    @Expose
    private String shortName;
    @SerializedName("_links")
    @Expose
    private com.sdk.blendle.models.generated.user.Links Links;
    @SerializedName("posts")
    @Expose
    private Integer posts;
    @SerializedName("followers")
    @Expose
    private Integer followers;
    @SerializedName("follows")
    @Expose
    private Integer follows;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("verified")
    @Expose
    private Boolean verified;

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
     *     The username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 
     * @param username
     *     The username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 
     * @return
     *     The firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * 
     * @param firstName
     *     The first_name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * 
     * @return
     *     The middleName
     */
    public Object getMiddleName() {
        return middleName;
    }

    /**
     * 
     * @param middleName
     *     The middle_name
     */
    public void setMiddleName(Object middleName) {
        this.middleName = middleName;
    }

    /**
     * 
     * @return
     *     The lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * 
     * @param lastName
     *     The last_name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * 
     * @return
     *     The fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * 
     * @param fullName
     *     The full_name
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * 
     * @return
     *     The shortName
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * 
     * @param shortName
     *     The short_name
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * 
     * @return
     *     The Links
     */
    public com.sdk.blendle.models.generated.user.Links getLinks() {
        return Links;
    }

    /**
     * 
     * @param Links
     *     The _links
     */
    public void setLinks(com.sdk.blendle.models.generated.user.Links Links) {
        this.Links = Links;
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
     *     The followers
     */
    public Integer getFollowers() {
        return followers;
    }

    /**
     * 
     * @param followers
     *     The followers
     */
    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

    /**
     * 
     * @return
     *     The follows
     */
    public Integer getFollows() {
        return follows;
    }

    /**
     * 
     * @param follows
     *     The follows
     */
    public void setFollows(Integer follows) {
        this.follows = follows;
    }

    /**
     * 
     * @return
     *     The text
     */
    public String getText() {
        return text;
    }

    /**
     * 
     * @param text
     *     The text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * 
     * @return
     *     The verified
     */
    public Boolean getVerified() {
        return verified;
    }

    /**
     * 
     * @param verified
     *     The verified
     */
    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(username).append(firstName).append(middleName).append(lastName).append(fullName).append(shortName).append(Links).append(posts).append(followers).append(follows).append(text).append(verified).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof User) == false) {
            return false;
        }
        User rhs = ((User) other);
        return new EqualsBuilder().append(id, rhs.id).append(username, rhs.username).append(firstName, rhs.firstName).append(middleName, rhs.middleName).append(lastName, rhs.lastName).append(fullName, rhs.fullName).append(shortName, rhs.shortName).append(Links, rhs.Links).append(posts, rhs.posts).append(followers, rhs.followers).append(follows, rhs.follows).append(text, rhs.text).append(verified, rhs.verified).isEquals();
    }

}
