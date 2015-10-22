
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
public class Embedded {

    @SerializedName("b:tiles")
    @Expose
    private List<BTile_> bTiles = new ArrayList<BTile_>();

    /**
     * 
     * @return
     *     The bTiles
     */
    public List<BTile_> getBTiles() {
        return bTiles;
    }

    /**
     * 
     * @param bTiles
     *     The b:tiles
     */
    public void setBTiles(List<BTile_> bTiles) {
        this.bTiles = bTiles;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(bTiles).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Embedded) == false) {
            return false;
        }
        Embedded rhs = ((Embedded) other);
        return new EqualsBuilder().append(bTiles, rhs.bTiles).isEquals();
    }

}
