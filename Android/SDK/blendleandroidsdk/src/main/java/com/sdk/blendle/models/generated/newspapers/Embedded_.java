
package com.sdk.blendle.models.generated.newspapers;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Embedded_ {

    @SerializedName("permanent_metadata")
    @Expose
    private PermanentMetadata_ permanentMetadata;

    /**
     * 
     * @return
     *     The permanentMetadata
     */
    public PermanentMetadata_ getPermanentMetadata() {
        return permanentMetadata;
    }

    /**
     * 
     * @param permanentMetadata
     *     The permanent_metadata
     */
    public void setPermanentMetadata(PermanentMetadata_ permanentMetadata) {
        this.permanentMetadata = permanentMetadata;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(permanentMetadata).toHashCode();
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
        return new EqualsBuilder().append(permanentMetadata, rhs.permanentMetadata).isEquals();
    }

}
