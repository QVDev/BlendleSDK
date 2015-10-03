
package com.sdk.blendle.models.generated.api;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Constraints {

    @SerializedName("user_id")
    @Expose
    private UserId userId;
    @SerializedName("user_email")
    @Expose
    private UserEmail userEmail;
    @SerializedName("user_username")
    @Expose
    private UserUsername userUsername;
    @SerializedName("user_text")
    @Expose
    private UserText userText;
    @SerializedName("post_text")
    @Expose
    private PostText postText;
    @SerializedName("comment_text")
    @Expose
    private CommentText commentText;
    @SerializedName("alert_query")
    @Expose
    private AlertQuery alertQuery;

    /**
     * 
     * @return
     *     The userId
     */
    public UserId getUserId() {
        return userId;
    }

    /**
     * 
     * @param userId
     *     The user_id
     */
    public void setUserId(UserId userId) {
        this.userId = userId;
    }

    /**
     * 
     * @return
     *     The userEmail
     */
    public UserEmail getUserEmail() {
        return userEmail;
    }

    /**
     * 
     * @param userEmail
     *     The user_email
     */
    public void setUserEmail(UserEmail userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * 
     * @return
     *     The userUsername
     */
    public UserUsername getUserUsername() {
        return userUsername;
    }

    /**
     * 
     * @param userUsername
     *     The user_username
     */
    public void setUserUsername(UserUsername userUsername) {
        this.userUsername = userUsername;
    }

    /**
     * 
     * @return
     *     The userText
     */
    public UserText getUserText() {
        return userText;
    }

    /**
     * 
     * @param userText
     *     The user_text
     */
    public void setUserText(UserText userText) {
        this.userText = userText;
    }

    /**
     * 
     * @return
     *     The postText
     */
    public PostText getPostText() {
        return postText;
    }

    /**
     * 
     * @param postText
     *     The post_text
     */
    public void setPostText(PostText postText) {
        this.postText = postText;
    }

    /**
     * 
     * @return
     *     The commentText
     */
    public CommentText getCommentText() {
        return commentText;
    }

    /**
     * 
     * @param commentText
     *     The comment_text
     */
    public void setCommentText(CommentText commentText) {
        this.commentText = commentText;
    }

    /**
     * 
     * @return
     *     The alertQuery
     */
    public AlertQuery getAlertQuery() {
        return alertQuery;
    }

    /**
     * 
     * @param alertQuery
     *     The alert_query
     */
    public void setAlertQuery(AlertQuery alertQuery) {
        this.alertQuery = alertQuery;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(userId).append(userEmail).append(userUsername).append(userText).append(postText).append(commentText).append(alertQuery).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Constraints) == false) {
            return false;
        }
        Constraints rhs = ((Constraints) other);
        return new EqualsBuilder().append(userId, rhs.userId).append(userEmail, rhs.userEmail).append(userUsername, rhs.userUsername).append(userText, rhs.userText).append(postText, rhs.postText).append(commentText, rhs.commentText).append(alertQuery, rhs.alertQuery).isEquals();
    }

}
