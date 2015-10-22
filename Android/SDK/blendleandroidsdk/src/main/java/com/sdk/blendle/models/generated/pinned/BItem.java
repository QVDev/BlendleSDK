
package com.sdk.blendle.models.generated.pinned;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class BItem {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("_embedded")
    @Expose
    private Embedded__ Embedded;
    @SerializedName("_links")
    @Expose
    private Links___ Links;

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The Embedded
     */
    public Embedded__ getEmbedded() {
        return Embedded;
    }

    /**
     * 
     * @param Embedded
     *     The _embedded
     */
    public void setEmbedded(Embedded__ Embedded) {
        this.Embedded = Embedded;
    }

    /**
     * 
     * @return
     *     The Links
     */
    public Links___ getLinks() {
        return Links;
    }

    /**
     * 
     * @param Links
     *     The _links
     */
    public void setLinks(Links___ Links) {
        this.Links = Links;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(Embedded).append(Links).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof BItem) == false) {
            return false;
        }
        BItem rhs = ((BItem) other);
        return new EqualsBuilder().append(id, rhs.id).append(Embedded, rhs.Embedded).append(Links, rhs.Links).isEquals();
    }

}
