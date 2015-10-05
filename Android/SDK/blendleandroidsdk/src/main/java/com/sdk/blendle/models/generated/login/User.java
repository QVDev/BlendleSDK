
package com.sdk.blendle.models.generated.login;

import java.util.ArrayList;
import java.util.List;
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
    private com.sdk.blendle.models.generated.login.Links Links;
    @SerializedName("posts")
    @Expose
    private Integer posts;
    @SerializedName("followers")
    @Expose
    private Integer followers;
    @SerializedName("follows")
    @Expose
    private Integer follows;
    @SerializedName("trending_viewed_at")
    @Expose
    private String trendingViewedAt;
    @SerializedName("facebook_id")
    @Expose
    private Object facebookId;
    @SerializedName("twitter_id")
    @Expose
    private Object twitterId;
    @SerializedName("twitter_username")
    @Expose
    private Object twitterUsername;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("languages")
    @Expose
    private List<String> languages = new ArrayList<String>();
    @SerializedName("primary_language")
    @Expose
    private String primaryLanguage;
    @SerializedName("text")
    @Expose
    private String text;
    @SerializedName("digest_opt_out")
    @Expose
    private Boolean digestOptOut;
    @SerializedName("alerts_opt_out")
    @Expose
    private Boolean alertsOptOut;
    @SerializedName("followers_opt_out")
    @Expose
    private Boolean followersOptOut;
    @SerializedName("new_edition_opt_out")
    @Expose
    private Boolean newEditionOptOut;
    @SerializedName("read_later_opt_out")
    @Expose
    private Boolean readLaterOptOut;
    @SerializedName("tips_opt_out")
    @Expose
    private Boolean tipsOptOut;
    @SerializedName("friend_signup_opt_out")
    @Expose
    private Boolean friendSignupOptOut;
    @SerializedName("weekly_digest_opt_out")
    @Expose
    private Boolean weeklyDigestOptOut;
    @SerializedName("magazine_digest_opt_out")
    @Expose
    private Boolean magazineDigestOptOut;
    @SerializedName("mixpanel_opt_out")
    @Expose
    private Boolean mixpanelOptOut;
    @SerializedName("preferences")
    @Expose
    private Preferences preferences;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("reads")
    @Expose
    private Integer reads;
    @SerializedName("has_password")
    @Expose
    private Boolean hasPassword;
    @SerializedName("pins")
    @Expose
    private Integer pins;
    @SerializedName("orders")
    @Expose
    private Integer orders;
    @SerializedName("freeloader")
    @Expose
    private Boolean freeloader;
    @SerializedName("verified")
    @Expose
    private Boolean verified;
    @SerializedName("email_confirmed")
    @Expose
    private Boolean emailConfirmed;
    @SerializedName("unconfirmed_uid")
    @Expose
    private Boolean unconfirmedUid;
    @SerializedName("balance")
    @Expose
    private String balance;
    @SerializedName("providers_opt_in")
    @Expose
    private Boolean providersOptIn;
    @SerializedName("nrc_email_share")
    @Expose
    private Object nrcEmailShare;
    @SerializedName("days_until_parool_gift")
    @Expose
    private Object daysUntilParoolGift;
    @SerializedName("_embedded")
    @Expose
    private Embedded_ Embedded;
    @SerializedName("tracking_uid")
    @Expose
    private String trackingUid;

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
    public com.sdk.blendle.models.generated.login.Links getLinks() {
        return Links;
    }

    /**
     * 
     * @param Links
     *     The _links
     */
    public void setLinks(com.sdk.blendle.models.generated.login.Links Links) {
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
     *     The trendingViewedAt
     */
    public String getTrendingViewedAt() {
        return trendingViewedAt;
    }

    /**
     * 
     * @param trendingViewedAt
     *     The trending_viewed_at
     */
    public void setTrendingViewedAt(String trendingViewedAt) {
        this.trendingViewedAt = trendingViewedAt;
    }

    /**
     * 
     * @return
     *     The facebookId
     */
    public Object getFacebookId() {
        return facebookId;
    }

    /**
     * 
     * @param facebookId
     *     The facebook_id
     */
    public void setFacebookId(Object facebookId) {
        this.facebookId = facebookId;
    }

    /**
     * 
     * @return
     *     The twitterId
     */
    public Object getTwitterId() {
        return twitterId;
    }

    /**
     * 
     * @param twitterId
     *     The twitter_id
     */
    public void setTwitterId(Object twitterId) {
        this.twitterId = twitterId;
    }

    /**
     * 
     * @return
     *     The twitterUsername
     */
    public Object getTwitterUsername() {
        return twitterUsername;
    }

    /**
     * 
     * @param twitterUsername
     *     The twitter_username
     */
    public void setTwitterUsername(Object twitterUsername) {
        this.twitterUsername = twitterUsername;
    }

    /**
     * 
     * @return
     *     The country
     */
    public String getCountry() {
        return country;
    }

    /**
     * 
     * @param country
     *     The country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * 
     * @return
     *     The languages
     */
    public List<String> getLanguages() {
        return languages;
    }

    /**
     * 
     * @param languages
     *     The languages
     */
    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    /**
     * 
     * @return
     *     The primaryLanguage
     */
    public String getPrimaryLanguage() {
        return primaryLanguage;
    }

    /**
     * 
     * @param primaryLanguage
     *     The primary_language
     */
    public void setPrimaryLanguage(String primaryLanguage) {
        this.primaryLanguage = primaryLanguage;
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
     *     The digestOptOut
     */
    public Boolean getDigestOptOut() {
        return digestOptOut;
    }

    /**
     * 
     * @param digestOptOut
     *     The digest_opt_out
     */
    public void setDigestOptOut(Boolean digestOptOut) {
        this.digestOptOut = digestOptOut;
    }

    /**
     * 
     * @return
     *     The alertsOptOut
     */
    public Boolean getAlertsOptOut() {
        return alertsOptOut;
    }

    /**
     * 
     * @param alertsOptOut
     *     The alerts_opt_out
     */
    public void setAlertsOptOut(Boolean alertsOptOut) {
        this.alertsOptOut = alertsOptOut;
    }

    /**
     * 
     * @return
     *     The followersOptOut
     */
    public Boolean getFollowersOptOut() {
        return followersOptOut;
    }

    /**
     * 
     * @param followersOptOut
     *     The followers_opt_out
     */
    public void setFollowersOptOut(Boolean followersOptOut) {
        this.followersOptOut = followersOptOut;
    }

    /**
     * 
     * @return
     *     The newEditionOptOut
     */
    public Boolean getNewEditionOptOut() {
        return newEditionOptOut;
    }

    /**
     * 
     * @param newEditionOptOut
     *     The new_edition_opt_out
     */
    public void setNewEditionOptOut(Boolean newEditionOptOut) {
        this.newEditionOptOut = newEditionOptOut;
    }

    /**
     * 
     * @return
     *     The readLaterOptOut
     */
    public Boolean getReadLaterOptOut() {
        return readLaterOptOut;
    }

    /**
     * 
     * @param readLaterOptOut
     *     The read_later_opt_out
     */
    public void setReadLaterOptOut(Boolean readLaterOptOut) {
        this.readLaterOptOut = readLaterOptOut;
    }

    /**
     * 
     * @return
     *     The tipsOptOut
     */
    public Boolean getTipsOptOut() {
        return tipsOptOut;
    }

    /**
     * 
     * @param tipsOptOut
     *     The tips_opt_out
     */
    public void setTipsOptOut(Boolean tipsOptOut) {
        this.tipsOptOut = tipsOptOut;
    }

    /**
     * 
     * @return
     *     The friendSignupOptOut
     */
    public Boolean getFriendSignupOptOut() {
        return friendSignupOptOut;
    }

    /**
     * 
     * @param friendSignupOptOut
     *     The friend_signup_opt_out
     */
    public void setFriendSignupOptOut(Boolean friendSignupOptOut) {
        this.friendSignupOptOut = friendSignupOptOut;
    }

    /**
     * 
     * @return
     *     The weeklyDigestOptOut
     */
    public Boolean getWeeklyDigestOptOut() {
        return weeklyDigestOptOut;
    }

    /**
     * 
     * @param weeklyDigestOptOut
     *     The weekly_digest_opt_out
     */
    public void setWeeklyDigestOptOut(Boolean weeklyDigestOptOut) {
        this.weeklyDigestOptOut = weeklyDigestOptOut;
    }

    /**
     * 
     * @return
     *     The magazineDigestOptOut
     */
    public Boolean getMagazineDigestOptOut() {
        return magazineDigestOptOut;
    }

    /**
     * 
     * @param magazineDigestOptOut
     *     The magazine_digest_opt_out
     */
    public void setMagazineDigestOptOut(Boolean magazineDigestOptOut) {
        this.magazineDigestOptOut = magazineDigestOptOut;
    }

    /**
     * 
     * @return
     *     The mixpanelOptOut
     */
    public Boolean getMixpanelOptOut() {
        return mixpanelOptOut;
    }

    /**
     * 
     * @param mixpanelOptOut
     *     The mixpanel_opt_out
     */
    public void setMixpanelOptOut(Boolean mixpanelOptOut) {
        this.mixpanelOptOut = mixpanelOptOut;
    }

    /**
     * 
     * @return
     *     The preferences
     */
    public Preferences getPreferences() {
        return preferences;
    }

    /**
     * 
     * @param preferences
     *     The preferences
     */
    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }

    /**
     * 
     * @return
     *     The email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 
     * @param email
     *     The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @return
     *     The reads
     */
    public Integer getReads() {
        return reads;
    }

    /**
     * 
     * @param reads
     *     The reads
     */
    public void setReads(Integer reads) {
        this.reads = reads;
    }

    /**
     * 
     * @return
     *     The hasPassword
     */
    public Boolean getHasPassword() {
        return hasPassword;
    }

    /**
     * 
     * @param hasPassword
     *     The has_password
     */
    public void setHasPassword(Boolean hasPassword) {
        this.hasPassword = hasPassword;
    }

    /**
     * 
     * @return
     *     The pins
     */
    public Integer getPins() {
        return pins;
    }

    /**
     * 
     * @param pins
     *     The pins
     */
    public void setPins(Integer pins) {
        this.pins = pins;
    }

    /**
     * 
     * @return
     *     The orders
     */
    public Integer getOrders() {
        return orders;
    }

    /**
     * 
     * @param orders
     *     The orders
     */
    public void setOrders(Integer orders) {
        this.orders = orders;
    }

    /**
     * 
     * @return
     *     The freeloader
     */
    public Boolean getFreeloader() {
        return freeloader;
    }

    /**
     * 
     * @param freeloader
     *     The freeloader
     */
    public void setFreeloader(Boolean freeloader) {
        this.freeloader = freeloader;
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

    /**
     * 
     * @return
     *     The emailConfirmed
     */
    public Boolean getEmailConfirmed() {
        return emailConfirmed;
    }

    /**
     * 
     * @param emailConfirmed
     *     The email_confirmed
     */
    public void setEmailConfirmed(Boolean emailConfirmed) {
        this.emailConfirmed = emailConfirmed;
    }

    /**
     * 
     * @return
     *     The unconfirmedUid
     */
    public Boolean getUnconfirmedUid() {
        return unconfirmedUid;
    }

    /**
     * 
     * @param unconfirmedUid
     *     The unconfirmed_uid
     */
    public void setUnconfirmedUid(Boolean unconfirmedUid) {
        this.unconfirmedUid = unconfirmedUid;
    }

    /**
     * 
     * @return
     *     The balance
     */
    public String getBalance() {
        return balance;
    }

    /**
     * 
     * @param balance
     *     The balance
     */
    public void setBalance(String balance) {
        this.balance = balance;
    }

    /**
     * 
     * @return
     *     The providersOptIn
     */
    public Boolean getProvidersOptIn() {
        return providersOptIn;
    }

    /**
     * 
     * @param providersOptIn
     *     The providers_opt_in
     */
    public void setProvidersOptIn(Boolean providersOptIn) {
        this.providersOptIn = providersOptIn;
    }

    /**
     * 
     * @return
     *     The nrcEmailShare
     */
    public Object getNrcEmailShare() {
        return nrcEmailShare;
    }

    /**
     * 
     * @param nrcEmailShare
     *     The nrc_email_share
     */
    public void setNrcEmailShare(Object nrcEmailShare) {
        this.nrcEmailShare = nrcEmailShare;
    }

    /**
     * 
     * @return
     *     The daysUntilParoolGift
     */
    public Object getDaysUntilParoolGift() {
        return daysUntilParoolGift;
    }

    /**
     * 
     * @param daysUntilParoolGift
     *     The days_until_parool_gift
     */
    public void setDaysUntilParoolGift(Object daysUntilParoolGift) {
        this.daysUntilParoolGift = daysUntilParoolGift;
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
     *     The trackingUid
     */
    public String getTrackingUid() {
        return trackingUid;
    }

    /**
     * 
     * @param trackingUid
     *     The tracking_uid
     */
    public void setTrackingUid(String trackingUid) {
        this.trackingUid = trackingUid;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(username).append(firstName).append(middleName).append(lastName).append(fullName).append(shortName).append(Links).append(posts).append(followers).append(follows).append(trendingViewedAt).append(facebookId).append(twitterId).append(twitterUsername).append(country).append(languages).append(primaryLanguage).append(text).append(digestOptOut).append(alertsOptOut).append(followersOptOut).append(newEditionOptOut).append(readLaterOptOut).append(tipsOptOut).append(friendSignupOptOut).append(weeklyDigestOptOut).append(magazineDigestOptOut).append(mixpanelOptOut).append(preferences).append(email).append(reads).append(hasPassword).append(pins).append(orders).append(freeloader).append(verified).append(emailConfirmed).append(unconfirmedUid).append(balance).append(providersOptIn).append(nrcEmailShare).append(daysUntilParoolGift).append(Embedded).append(trackingUid).toHashCode();
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
        return new EqualsBuilder().append(id, rhs.id).append(username, rhs.username).append(firstName, rhs.firstName).append(middleName, rhs.middleName).append(lastName, rhs.lastName).append(fullName, rhs.fullName).append(shortName, rhs.shortName).append(Links, rhs.Links).append(posts, rhs.posts).append(followers, rhs.followers).append(follows, rhs.follows).append(trendingViewedAt, rhs.trendingViewedAt).append(facebookId, rhs.facebookId).append(twitterId, rhs.twitterId).append(twitterUsername, rhs.twitterUsername).append(country, rhs.country).append(languages, rhs.languages).append(primaryLanguage, rhs.primaryLanguage).append(text, rhs.text).append(digestOptOut, rhs.digestOptOut).append(alertsOptOut, rhs.alertsOptOut).append(followersOptOut, rhs.followersOptOut).append(newEditionOptOut, rhs.newEditionOptOut).append(readLaterOptOut, rhs.readLaterOptOut).append(tipsOptOut, rhs.tipsOptOut).append(friendSignupOptOut, rhs.friendSignupOptOut).append(weeklyDigestOptOut, rhs.weeklyDigestOptOut).append(magazineDigestOptOut, rhs.magazineDigestOptOut).append(mixpanelOptOut, rhs.mixpanelOptOut).append(preferences, rhs.preferences).append(email, rhs.email).append(reads, rhs.reads).append(hasPassword, rhs.hasPassword).append(pins, rhs.pins).append(orders, rhs.orders).append(freeloader, rhs.freeloader).append(verified, rhs.verified).append(emailConfirmed, rhs.emailConfirmed).append(unconfirmedUid, rhs.unconfirmedUid).append(balance, rhs.balance).append(providersOptIn, rhs.providersOptIn).append(nrcEmailShare, rhs.nrcEmailShare).append(daysUntilParoolGift, rhs.daysUntilParoolGift).append(Embedded, rhs.Embedded).append(trackingUid, rhs.trackingUid).isEquals();
    }

}
