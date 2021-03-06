
package com.sdk.blendle.models.generated.login;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class AbTest {

    @SerializedName("group")
    @Expose
    private String group;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("_links")
    @Expose
    private Links_ Links;

    /**
     * 
     * @return
     *     The group
     */
    public String getGroup() {
        return group;
    }

    /**
     * 
     * @param group
     *     The group
     */
    public void setGroup(String group) {
        this.group = group;
    }

    /**
     * 
     * @return
     *     The name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The Links
     */
    public Links_ getLinks() {
        return Links;
    }

    /**
     * 
     * @param Links
     *     The _links
     */
    public void setLinks(Links_ Links) {
        this.Links = Links;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(group).append(name).append(Links).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AbTest) == false) {
            return false;
        }
        AbTest rhs = ((AbTest) other);
        return new EqualsBuilder().append(group, rhs.group).append(name, rhs.name).append(Links, rhs.Links).isEquals();
    }

}
