
package com.sdk.blendle.models.generated.example;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Category_ {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("providers")
    @Expose
    private List<String> providers = new ArrayList<String>();

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The providers
     */
    public List<String> getProviders() {
        return providers;
    }

    /**
     * 
     * @param providers
     *     The providers
     */
    public void setProviders(List<String> providers) {
        this.providers = providers;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(name).append(providers).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Category_) == false) {
            return false;
        }
        Category_ rhs = ((Category_) other);
        return new EqualsBuilder().append(name, rhs.name).append(providers, rhs.providers).isEquals();
    }

}
