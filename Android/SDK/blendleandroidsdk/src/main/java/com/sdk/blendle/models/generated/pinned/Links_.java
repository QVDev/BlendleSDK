
package com.sdk.blendle.models.generated.pinned;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Links_ {

    @SerializedName("small")
    @Expose
    private Small small;
    @SerializedName("medium")
    @Expose
    private Medium medium;
    @SerializedName("large")
    @Expose
    private Large large;
    @SerializedName("original")
    @Expose
    private Original original;

    /**
     * 
     * @return
     *     The small
     */
    public Small getSmall() {
        return small;
    }

    /**
     * 
     * @param small
     *     The small
     */
    public void setSmall(Small small) {
        this.small = small;
    }

    /**
     * 
     * @return
     *     The medium
     */
    public Medium getMedium() {
        return medium;
    }

    /**
     * 
     * @param medium
     *     The medium
     */
    public void setMedium(Medium medium) {
        this.medium = medium;
    }

    /**
     * 
     * @return
     *     The large
     */
    public Large getLarge() {
        return large;
    }

    /**
     * 
     * @param large
     *     The large
     */
    public void setLarge(Large large) {
        this.large = large;
    }

    /**
     * 
     * @return
     *     The original
     */
    public Original getOriginal() {
        return original;
    }

    /**
     * 
     * @param original
     *     The original
     */
    public void setOriginal(Original original) {
        this.original = original;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(small).append(medium).append(large).append(original).toHashCode();
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
        return new EqualsBuilder().append(small, rhs.small).append(medium, rhs.medium).append(large, rhs.large).append(original, rhs.original).isEquals();
    }

}
