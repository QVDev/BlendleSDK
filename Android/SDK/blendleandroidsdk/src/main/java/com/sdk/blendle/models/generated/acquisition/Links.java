
package com.sdk.blendle.models.generated.acquisition;

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
    @SerializedName("b:issue-acquisition")
    @Expose
    private BIssueAcquisition bIssueAcquisition;
    @SerializedName("curies")
    @Expose
    private List<Cury> curies = new ArrayList<Cury>();

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
     *     The bIssueAcquisition
     */
    public BIssueAcquisition getBIssueAcquisition() {
        return bIssueAcquisition;
    }

    /**
     * 
     * @param bIssueAcquisition
     *     The b:issue-acquisition
     */
    public void setBIssueAcquisition(BIssueAcquisition bIssueAcquisition) {
        this.bIssueAcquisition = bIssueAcquisition;
    }

    /**
     * 
     * @return
     *     The curies
     */
    public List<Cury> getCuries() {
        return curies;
    }

    /**
     * 
     * @param curies
     *     The curies
     */
    public void setCuries(List<Cury> curies) {
        this.curies = curies;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(self).append(bIssueAcquisition).append(curies).toHashCode();
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
        return new EqualsBuilder().append(self, rhs.self).append(bIssueAcquisition, rhs.bIssueAcquisition).append(curies, rhs.curies).isEquals();
    }

}
