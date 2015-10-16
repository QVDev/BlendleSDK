
package com.sdk.blendle.models.generated.newsstand;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Embedded_ {

    @SerializedName("manifest")
    @Expose
    private Manifest manifest;

    /**
     * 
     * @return
     *     The manifest
     */
    public Manifest getManifest() {
        return manifest;
    }

    /**
     * 
     * @param manifest
     *     The manifest
     */
    public void setManifest(Manifest manifest) {
        this.manifest = manifest;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(manifest).toHashCode();
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
        return new EqualsBuilder().append(manifest, rhs.manifest).isEquals();
    }

}
