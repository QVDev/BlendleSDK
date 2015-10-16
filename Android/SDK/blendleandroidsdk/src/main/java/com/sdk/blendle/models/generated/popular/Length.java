
package com.sdk.blendle.models.generated.popular;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Length {

    @SerializedName("words")
    @Expose
    private Integer words;

    /**
     * 
     * @return
     *     The words
     */
    public Integer getWords() {
        return words;
    }

    /**
     * 
     * @param words
     *     The words
     */
    public void setWords(Integer words) {
        this.words = words;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(words).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Length) == false) {
            return false;
        }
        Length rhs = ((Length) other);
        return new EqualsBuilder().append(words, rhs.words).isEquals();
    }

}
