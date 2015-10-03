
package com.sdk.blendle.models.generated.example;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class CommentText {

    @SerializedName("pattern")
    @Expose
    private String pattern;
    @SerializedName("max_length")
    @Expose
    private Integer maxLength;

    /**
     * 
     * @return
     *     The pattern
     */
    public String getPattern() {
        return pattern;
    }

    /**
     * 
     * @param pattern
     *     The pattern
     */
    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    /**
     * 
     * @return
     *     The maxLength
     */
    public Integer getMaxLength() {
        return maxLength;
    }

    /**
     * 
     * @param maxLength
     *     The max_length
     */
    public void setMaxLength(Integer maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(pattern).append(maxLength).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof CommentText) == false) {
            return false;
        }
        CommentText rhs = ((CommentText) other);
        return new EqualsBuilder().append(pattern, rhs.pattern).append(maxLength, rhs.maxLength).isEquals();
    }

}
