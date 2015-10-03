
package com.sdk.blendle.models.generated.example;

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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(self).toHashCode();
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
        return new EqualsBuilder().append(self, rhs.self).isEquals();
    }

}
