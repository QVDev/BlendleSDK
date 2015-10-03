
package com.sdk.blendle.models.generated.api;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Capabilities {

    @SerializedName("streamers")
    @Expose
    private Boolean streamers;

    /**
     * 
     * @return
     *     The streamers
     */
    public Boolean getStreamers() {
        return streamers;
    }

    /**
     * 
     * @param streamers
     *     The streamers
     */
    public void setStreamers(Boolean streamers) {
        this.streamers = streamers;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(streamers).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Capabilities) == false) {
            return false;
        }
        Capabilities rhs = ((Capabilities) other);
        return new EqualsBuilder().append(streamers, rhs.streamers).isEquals();
    }

}
