
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
public class Links____ {

    @SerializedName("self")
    @Expose
    private Self____ self;
    @SerializedName("configurations")
    @Expose
    private List<Configuration> configurations = new ArrayList<Configuration>();

    /**
     * 
     * @return
     *     The self
     */
    public Self____ getSelf() {
        return self;
    }

    /**
     * 
     * @param self
     *     The self
     */
    public void setSelf(Self____ self) {
        this.self = self;
    }

    /**
     * 
     * @return
     *     The configurations
     */
    public List<Configuration> getConfigurations() {
        return configurations;
    }

    /**
     * 
     * @param configurations
     *     The configurations
     */
    public void setConfigurations(List<Configuration> configurations) {
        this.configurations = configurations;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(self).append(configurations).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Links____) == false) {
            return false;
        }
        Links____ rhs = ((Links____) other);
        return new EqualsBuilder().append(self, rhs.self).append(configurations, rhs.configurations).isEquals();
    }

}
