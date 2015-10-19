
package com.sdk.blendle.models.generated.article;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Links {

    @SerializedName("self")
    @Expose
    private Self self;
    @SerializedName("item_content")
    @Expose
    private ItemContent itemContent;
    @SerializedName("mlt")
    @Expose
    private Mlt mlt;

    /**
     * 
     * @return
     *     The self
     */
    public Self getSelf() {
        return self;
    }

    /**
     * 
     * @param self
     *     The self
     */
    public void setSelf(Self self) {
        this.self = self;
    }

    /**
     * 
     * @return
     *     The itemContent
     */
    public ItemContent getItemContent() {
        return itemContent;
    }

    /**
     * 
     * @param itemContent
     *     The item_content
     */
    public void setItemContent(ItemContent itemContent) {
        this.itemContent = itemContent;
    }

    /**
     * 
     * @return
     *     The mlt
     */
    public Mlt getMlt() {
        return mlt;
    }

    /**
     * 
     * @param mlt
     *     The mlt
     */
    public void setMlt(Mlt mlt) {
        this.mlt = mlt;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(self).append(itemContent).append(mlt).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Links) == false) {
            return false;
        }
        Links rhs = ((Links) other);
        return new EqualsBuilder().append(self, rhs.self).append(itemContent, rhs.itemContent).append(mlt, rhs.mlt).isEquals();
    }

}
