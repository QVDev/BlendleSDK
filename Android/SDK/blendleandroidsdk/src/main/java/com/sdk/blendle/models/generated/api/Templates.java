
package com.sdk.blendle.models.generated.api;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Templates {

    @SerializedName("tile")
    @Expose
    private String tile;
    @SerializedName("item_content")
    @Expose
    private String itemContent;

    /**
     * 
     * @return
     *     The tile
     */
    public String getTile() {
        return tile;
    }

    /**
     * 
     * @param tile
     *     The tile
     */
    public void setTile(String tile) {
        this.tile = tile;
    }

    /**
     * 
     * @return
     *     The itemContent
     */
    public String getItemContent() {
        return itemContent;
    }

    /**
     * 
     * @param itemContent
     *     The item_content
     */
    public void setItemContent(String itemContent) {
        this.itemContent = itemContent;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(tile).append(itemContent).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Templates) == false) {
            return false;
        }
        Templates rhs = ((Templates) other);
        return new EqualsBuilder().append(tile, rhs.tile).append(itemContent, rhs.itemContent).isEquals();
    }

}
