
package com.sdk.blendle.models.generated.example;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Validation {

    @SerializedName("_links")
    @Expose
    private Links_ Links;
    @SerializedName("constraints")
    @Expose
    private Constraints constraints;

    /**
     * 
     * @return
     *     The Links
     */
    public Links_ getLinks() {
        return Links;
    }

    /**
     * 
     * @param Links
     *     The _links
     */
    public void setLinks(Links_ Links) {
        this.Links = Links;
    }

    /**
     * 
     * @return
     *     The constraints
     */
    public Constraints getConstraints() {
        return constraints;
    }

    /**
     * 
     * @param constraints
     *     The constraints
     */
    public void setConstraints(Constraints constraints) {
        this.constraints = constraints;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(Links).append(constraints).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Validation) == false) {
            return false;
        }
        Validation rhs = ((Validation) other);
        return new EqualsBuilder().append(Links, rhs.Links).append(constraints, rhs.constraints).isEquals();
    }

}
