
package com.sdk.blendle.models.generated.pinned;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Links___ {

    @SerializedName("self")
    @Expose
    private Self__ self;
    @SerializedName("curies")
    @Expose
    private Curies_ curies;
    @SerializedName("b:acquisition")
    @Expose
    private BAcquisition bAcquisition;
    @SerializedName("b:pin")
    @Expose
    private BPin bPin;
    @SerializedName("manifest")
    @Expose
    private Manifest_ manifest;
    @SerializedName("item_content")
    @Expose
    private ItemContent itemContent;

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
     *     The curies
     */
    public Curies_ getCuries() {
        return curies;
    }

    /**
     * 
     * @param curies
     *     The curies
     */
    public void setCuries(Curies_ curies) {
        this.curies = curies;
    }

    /**
     * 
     * @return
     *     The bAcquisition
     */
    public BAcquisition getBAcquisition() {
        return bAcquisition;
    }

    /**
     * 
     * @param bAcquisition
     *     The b:acquisition
     */
    public void setBAcquisition(BAcquisition bAcquisition) {
        this.bAcquisition = bAcquisition;
    }

    /**
     * 
     * @return
     *     The bPin
     */
    public BPin getBPin() {
        return bPin;
    }

    /**
     * 
     * @param bPin
     *     The b:pin
     */
    public void setBPin(BPin bPin) {
        this.bPin = bPin;
    }

    /**
     * 
     * @return
     *     The manifest
     */
    public Manifest_ getManifest() {
        return manifest;
    }

    /**
     * 
     * @param manifest
     *     The manifest
     */
    public void setManifest(Manifest_ manifest) {
        this.manifest = manifest;
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

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(self).append(curies).append(bAcquisition).append(bPin).append(manifest).append(itemContent).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Links___) == false) {
            return false;
        }
        Links___ rhs = ((Links___) other);
        return new EqualsBuilder().append(self, rhs.self).append(curies, rhs.curies).append(bAcquisition, rhs.bAcquisition).append(bPin, rhs.bPin).append(manifest, rhs.manifest).append(itemContent, rhs.itemContent).isEquals();
    }

}
