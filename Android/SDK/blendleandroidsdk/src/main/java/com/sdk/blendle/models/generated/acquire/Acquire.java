
package com.sdk.blendle.models.generated.acquire;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Acquire {

    @SerializedName("_links")
    @Expose
    private com.sdk.blendle.models.generated.acquire.Links Links;
    @SerializedName("acquired")
    @Expose
    private Boolean acquired;
    @SerializedName("acquirable")
    @Expose
    private Boolean acquirable;
    @SerializedName("refundable")
    @Expose
    private Boolean refundable;
    @SerializedName("subscription")
    @Expose
    private Boolean subscription;
    @SerializedName("transaction_id")
    @Expose
    private String transactionId;
    @SerializedName("pinned")
    @Expose
    private Boolean pinned;

    /**
     * 
     * @return
     *     The Links
     */
    public com.sdk.blendle.models.generated.acquire.Links getLinks() {
        return Links;
    }

    /**
     * 
     * @param Links
     *     The _links
     */
    public void setLinks(com.sdk.blendle.models.generated.acquire.Links Links) {
        this.Links = Links;
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
     *     The subscription
     */
    public Boolean getSubscription() {
        return subscription;
    }

    /**
     * 
     * @param subscription
     *     The subscription
     */
    public void setSubscription(Boolean subscription) {
        this.subscription = subscription;
    }

    /**
     * 
     * @return
     *     The transactionId
     */
    public String getTransactionId() {
        return transactionId;
    }

    /**
     * 
     * @param transactionId
     *     The transaction_id
     */
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    /**
     * 
     * @return
     *     The pinned
     */
    public Boolean getPinned() {
        return pinned;
    }

    /**
     * 
     * @param pinned
     *     The pinned
     */
    public void setPinned(Boolean pinned) {
        this.pinned = pinned;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(Links).append(acquired).append(acquirable).append(refundable).append(subscription).append(transactionId).append(pinned).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Acquire) == false) {
            return false;
        }
        Acquire rhs = ((Acquire) other);
        return new EqualsBuilder().append(Links, rhs.Links).append(acquired, rhs.acquired).append(acquirable, rhs.acquirable).append(refundable, rhs.refundable).append(subscription, rhs.subscription).append(transactionId, rhs.transactionId).append(pinned, rhs.pinned).isEquals();
    }

}
