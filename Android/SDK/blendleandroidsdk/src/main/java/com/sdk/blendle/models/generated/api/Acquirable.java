
package com.sdk.blendle.models.generated.api;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Acquirable {

    @SerializedName("seconds")
    @Expose
    private Integer seconds;

    /**
     * 
     * @return
     *     The seconds
     */
    public Integer getSeconds() {
        return seconds;
    }

    /**
     * 
     * @param seconds
     *     The seconds
     */
    public void setSeconds(Integer seconds) {
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(seconds).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Acquirable) == false) {
            return false;
        }
        Acquirable rhs = ((Acquirable) other);
        return new EqualsBuilder().append(seconds, rhs.seconds).isEquals();
    }

}
