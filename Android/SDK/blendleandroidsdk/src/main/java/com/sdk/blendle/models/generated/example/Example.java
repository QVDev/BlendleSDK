
package com.sdk.blendle.models.generated.example;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Example {

    @SerializedName("_links")
    @Expose
    private com.sdk.blendle.models.generated.example.Links Links;
    @SerializedName("_embedded")
    @Expose
    private com.sdk.blendle.models.generated.example.Embedded Embedded;

    /**
     * 
     * @return
     *     The Links
     */
    public com.sdk.blendle.models.generated.example.Links getLinks() {
        return Links;
    }

    /**
     * 
     * @param Links
     *     The _links
     */
    public void setLinks(com.sdk.blendle.models.generated.example.Links Links) {
        this.Links = Links;
    }

    /**
     * 
     * @return
     *     The Embedded
     */
    public com.sdk.blendle.models.generated.example.Embedded getEmbedded() {
        return Embedded;
    }

    /**
     * 
     * @param Embedded
     *     The _embedded
     */
    public void setEmbedded(com.sdk.blendle.models.generated.example.Embedded Embedded) {
        this.Embedded = Embedded;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(Links).append(Embedded).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Example) == false) {
            return false;
        }
        Example rhs = ((Example) other);
        return new EqualsBuilder().append(Links, rhs.Links).append(Embedded, rhs.Embedded).isEquals();
    }

}
