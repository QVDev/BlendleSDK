
package com.sdk.blendle.models.generated.api;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Embedded_ {

    @SerializedName("configurations")
    @Expose
    private List<Configuration_> configurations = new ArrayList<Configuration_>();

    /**
     * 
     * @return
     *     The configurations
     */
    public List<Configuration_> getConfigurations() {
        return configurations;
    }

    /**
     * 
     * @param configurations
     *     The configurations
     */
    public void setConfigurations(List<Configuration_> configurations) {
        this.configurations = configurations;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(configurations).toHashCode();
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
        return new EqualsBuilder().append(configurations, rhs.configurations).isEquals();
    }

}
