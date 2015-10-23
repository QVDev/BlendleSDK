
package com.sdk.blendle.models.generated.userissue;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class UserIssue {

    @SerializedName("_links")
    @Expose
    private com.sdk.blendle.models.generated.userissue.Links Links;
    @SerializedName("_embedded")
    @Expose
    private com.sdk.blendle.models.generated.userissue.Embedded Embedded;

    /**
     * 
     * @return
     *     The Links
     */
    public com.sdk.blendle.models.generated.userissue.Links getLinks() {
        return Links;
    }

    /**
     * 
     * @param Links
     *     The _links
     */
    public void setLinks(com.sdk.blendle.models.generated.userissue.Links Links) {
        this.Links = Links;
    }

    /**
     * 
     * @return
     *     The Embedded
     */
    public com.sdk.blendle.models.generated.userissue.Embedded getEmbedded() {
        return Embedded;
    }

    /**
     * 
     * @param Embedded
     *     The _embedded
     */
    public void setEmbedded(com.sdk.blendle.models.generated.userissue.Embedded Embedded) {
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
        if ((other instanceof UserIssue) == false) {
            return false;
        }
        UserIssue rhs = ((UserIssue) other);
        return new EqualsBuilder().append(Links, rhs.Links).append(Embedded, rhs.Embedded).isEquals();
    }

}
