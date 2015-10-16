
package com.sdk.blendle.models.generated.publicuser;

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

    @SerializedName("shared_users")
    @Expose
    private List<SharedUser> sharedUsers = new ArrayList<SharedUser>();

    /**
     * 
     * @return
     *     The sharedUsers
     */
    public List<SharedUser> getSharedUsers() {
        return sharedUsers;
    }

    /**
     * 
     * @param sharedUsers
     *     The shared_users
     */
    public void setSharedUsers(List<SharedUser> sharedUsers) {
        this.sharedUsers = sharedUsers;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(sharedUsers).toHashCode();
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
        return new EqualsBuilder().append(sharedUsers, rhs.sharedUsers).isEquals();
    }

}
