
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
public class ProviderCategories {

    @SerializedName("_links")
    @Expose
    private Links___ Links;
    @SerializedName("categories")
    @Expose
    private List<Category_> categories = new ArrayList<Category_>();

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

    /**
     * 
     * @return
     *     The categories
     */
    public List<Category_> getCategories() {
        return categories;
    }

    /**
     * 
     * @param categories
     *     The categories
     */
    public void setCategories(List<Category_> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(Links).append(categories).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ProviderCategories) == false) {
            return false;
        }
        ProviderCategories rhs = ((ProviderCategories) other);
        return new EqualsBuilder().append(Links, rhs.Links).append(categories, rhs.categories).isEquals();
    }

}
