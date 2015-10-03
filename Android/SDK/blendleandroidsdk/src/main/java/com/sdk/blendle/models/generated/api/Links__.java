
package com.sdk.blendle.models.generated.api;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Links__ {

    @SerializedName("self")
    @Expose
    private Self__ self;
    @SerializedName("most_recent")
    @Expose
    private MostRecent mostRecent;
    @SerializedName("popular")
    @Expose
    private Popular popular;
    @SerializedName("categories")
    @Expose
    private List<Category> categories = new ArrayList<Category>();

    /**
     * 
     * @return
     *     The self
     */
    public Self__ getSelf() {
        return self;
    }

    /**
     * 
     * @param self
     *     The self
     */
    public void setSelf(Self__ self) {
        this.self = self;
    }

    /**
     * 
     * @return
     *     The mostRecent
     */
    public MostRecent getMostRecent() {
        return mostRecent;
    }

    /**
     * 
     * @param mostRecent
     *     The most_recent
     */
    public void setMostRecent(MostRecent mostRecent) {
        this.mostRecent = mostRecent;
    }

    /**
     * 
     * @return
     *     The popular
     */
    public Popular getPopular() {
        return popular;
    }

    /**
     * 
     * @param popular
     *     The popular
     */
    public void setPopular(Popular popular) {
        this.popular = popular;
    }

    /**
     * 
     * @return
     *     The categories
     */
    public List<Category> getCategories() {
        return categories;
    }

    /**
     * 
     * @param categories
     *     The categories
     */
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(self).append(mostRecent).append(popular).append(categories).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Links__) == false) {
            return false;
        }
        Links__ rhs = ((Links__) other);
        return new EqualsBuilder().append(self, rhs.self).append(mostRecent, rhs.mostRecent).append(popular, rhs.popular).append(categories, rhs.categories).isEquals();
    }

}
