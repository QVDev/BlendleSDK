
package com.sdk.blendle.models.generated.acquisition;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Acquisition {

    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("acquired")
    @Expose
    private Boolean acquired;
    @SerializedName("acquirable")
    @Expose
    private Boolean acquirable;
    @SerializedName("subscription")
    @Expose
    private Boolean subscription;
    @SerializedName("refundable")
    @Expose
    private Boolean refundable;
    @SerializedName("_links")
    @Expose
    private com.sdk.blendle.models.generated.acquisition.Links Links;

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
     *     The Links
     */
    public com.sdk.blendle.models.generated.acquisition.Links getLinks() {
        return Links;
    }

    /**
     * 
     * @param Links
     *     The _links
     */
    public void setLinks(com.sdk.blendle.models.generated.acquisition.Links Links) {
        this.Links = Links;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(price).append(acquired).append(acquirable).append(subscription).append(refundable).append(Links).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Acquisition) == false) {
            return false;
        }
        Acquisition rhs = ((Acquisition) other);
        return new EqualsBuilder().append(price, rhs.price).append(acquired, rhs.acquired).append(acquirable, rhs.acquirable).append(subscription, rhs.subscription).append(refundable, rhs.refundable).append(Links, rhs.Links).isEquals();
    }

}
