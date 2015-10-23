
package com.sdk.blendle.models.generated.userissue;

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
    @SerializedName("user_issues")
    @Expose
    private UserIssues userIssues;
    @SerializedName("read_later")
    @Expose
    private ReadLater readLater;
    @SerializedName("user_favourites")
    @Expose
    private UserFavourites userFavourites;

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
     *     The userIssues
     */
    public UserIssues getUserIssues() {
        return userIssues;
    }

    /**
     * 
     * @param userIssues
     *     The user_issues
     */
    public void setUserIssues(UserIssues userIssues) {
        this.userIssues = userIssues;
    }

    /**
     * 
     * @return
     *     The readLater
     */
    public ReadLater getReadLater() {
        return readLater;
    }

    /**
     * 
     * @param readLater
     *     The read_later
     */
    public void setReadLater(ReadLater readLater) {
        this.readLater = readLater;
    }

    /**
     * 
     * @return
     *     The userFavourites
     */
    public UserFavourites getUserFavourites() {
        return userFavourites;
    }

    /**
     * 
     * @param userFavourites
     *     The user_favourites
     */
    public void setUserFavourites(UserFavourites userFavourites) {
        this.userFavourites = userFavourites;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(self).append(userIssues).append(readLater).append(userFavourites).toHashCode();
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
        return new EqualsBuilder().append(self, rhs.self).append(userIssues, rhs.userIssues).append(readLater, rhs.readLater).append(userFavourites, rhs.userFavourites).isEquals();
    }

}
