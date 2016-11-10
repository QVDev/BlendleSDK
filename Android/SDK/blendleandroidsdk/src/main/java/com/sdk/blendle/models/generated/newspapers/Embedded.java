
package com.sdk.blendle.models.generated.newspapers;

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

    @SerializedName("issues")
    @Expose
    private List<Issue_> issues = new ArrayList<Issue_>();

    /**
     * 
     * @return
     *     The issues
     */
    public List<Issue_> getIssues() {
        return issues;
    }

    /**
     * 
     * @param issues
     *     The issues
     */
    public void setIssues(List<Issue_> issues) {
        this.issues = issues;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(issues).toHashCode();
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
        return new EqualsBuilder().append(issues, rhs.issues).isEquals();
    }

}
