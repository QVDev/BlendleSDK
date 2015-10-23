
package com.sdk.blendle.models.generated.userissue;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Prev {

    @SerializedName("href")
    @Expose
    private Object href;

    /**
     * 
     * @return
     *     The href
     */
    public Object getHref() {
        return href;
    }

    /**
     * 
     * @param href
     *     The href
     */
    public void setHref(Object href) {
        this.href = href;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(href).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Prev) == false) {
            return false;
        }
        Prev rhs = ((Prev) other);
        return new EqualsBuilder().append(href, rhs.href).isEquals();
    }

}
