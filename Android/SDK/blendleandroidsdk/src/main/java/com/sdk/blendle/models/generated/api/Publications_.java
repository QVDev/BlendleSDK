
package com.sdk.blendle.models.generated.api;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Publications_ {

    @SerializedName("_links")
    @Expose
    private Links__ Links;

    /**
     * 
     * @return
     *     The Links
     */
    public Links__ getLinks() {
        return Links;
    }

    /**
     * 
     * @param Links
     *     The _links
     */
    public void setLinks(Links__ Links) {
        this.Links = Links;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(Links).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Publications_) == false) {
            return false;
        }
        Publications_ rhs = ((Publications_) other);
        return new EqualsBuilder().append(Links, rhs.Links).isEquals();
    }

}
