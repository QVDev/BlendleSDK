
package com.sdk.blendle.models.generated.pinned;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Embedded_ {

    @SerializedName("b:item")
    @Expose
    private BItem bItem;

    /**
     * 
     * @return
     *     The bItem
     */
    public BItem getBItem() {
        return bItem;
    }

    /**
     * 
     * @param bItem
     *     The b:item
     */
    public void setBItem(BItem bItem) {
        this.bItem = bItem;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(bItem).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Embedded_) == false) {
            return false;
        }
        Embedded_ rhs = ((Embedded_) other);
        return new EqualsBuilder().append(bItem, rhs.bItem).isEquals();
    }

}
