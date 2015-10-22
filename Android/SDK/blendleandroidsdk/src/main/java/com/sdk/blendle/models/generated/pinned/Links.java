
package com.sdk.blendle.models.generated.pinned;

import java.util.ArrayList;
import java.util.List;
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
    @SerializedName("curies")
    @Expose
    private Curies curies;
    @SerializedName("b:tiles")
    @Expose
    private List<BTile> bTiles = new ArrayList<BTile>();

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
     *     The curies
     */
    public Curies getCuries() {
        return curies;
    }

    /**
     * 
     * @param curies
     *     The curies
     */
    public void setCuries(Curies curies) {
        this.curies = curies;
    }

    /**
     * 
     * @return
     *     The bTiles
     */
    public List<BTile> getBTiles() {
        return bTiles;
    }

    /**
     * 
     * @param bTiles
     *     The b:tiles
     */
    public void setBTiles(List<BTile> bTiles) {
        this.bTiles = bTiles;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(self).append(curies).append(bTiles).toHashCode();
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
        return new EqualsBuilder().append(self, rhs.self).append(curies, rhs.curies).append(bTiles, rhs.bTiles).isEquals();
    }

}
