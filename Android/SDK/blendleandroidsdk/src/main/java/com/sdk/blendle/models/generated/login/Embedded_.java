
package com.sdk.blendle.models.generated.login;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Embedded_ {

    @SerializedName("ab_tests")
    @Expose
    private List<AbTest> abTests = new ArrayList<AbTest>();

    /**
     * 
     * @return
     *     The abTests
     */
    public List<AbTest> getAbTests() {
        return abTests;
    }

    /**
     * 
     * @param abTests
     *     The ab_tests
     */
    public void setAbTests(List<AbTest> abTests) {
        this.abTests = abTests;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(abTests).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Embedded_) == false) {
            return false;
        }
        Embedded_ rhs = ((Embedded_) other);
        return new EqualsBuilder().append(abTests, rhs.abTests).isEquals();
    }

}
