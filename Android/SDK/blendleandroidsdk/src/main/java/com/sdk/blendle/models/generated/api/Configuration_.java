
package com.sdk.blendle.models.generated.api;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Configuration_ {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("external")
    @Expose
    private External external;
    @SerializedName("automatic")
    @Expose
    private Boolean automatic;
    @SerializedName("_links")
    @Expose
    private Links_____ Links;
    @SerializedName("templates")
    @Expose
    private Templates templates;
    @SerializedName("capabilities")
    @Expose
    private Capabilities capabilities;
    @SerializedName("language")
    @Expose
    private String language;
    @SerializedName("locations")
    @Expose
    private List<Location_> locations = new ArrayList<Location_>();
    @SerializedName("tags")
    @Expose
    private List<Tag> tags = new ArrayList<Tag>();

    /**
     * 
     * @return
     *     The id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    public void setId(String id) {
        this.id = id;
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
     *     The external
     */
    public External getExternal() {
        return external;
    }

    /**
     * 
     * @param external
     *     The external
     */
    public void setExternal(External external) {
        this.external = external;
    }

    /**
     * 
     * @return
     *     The automatic
     */
    public Boolean getAutomatic() {
        return automatic;
    }

    /**
     * 
     * @param automatic
     *     The automatic
     */
    public void setAutomatic(Boolean automatic) {
        this.automatic = automatic;
    }

    /**
     * 
     * @return
     *     The Links
     */
    public Links_____ getLinks() {
        return Links;
    }

    /**
     * 
     * @param Links
     *     The _links
     */
    public void setLinks(Links_____ Links) {
        this.Links = Links;
    }

    /**
     * 
     * @return
     *     The templates
     */
    public Templates getTemplates() {
        return templates;
    }

    /**
     * 
     * @param templates
     *     The templates
     */
    public void setTemplates(Templates templates) {
        this.templates = templates;
    }

    /**
     * 
     * @return
     *     The capabilities
     */
    public Capabilities getCapabilities() {
        return capabilities;
    }

    /**
     * 
     * @param capabilities
     *     The capabilities
     */
    public void setCapabilities(Capabilities capabilities) {
        this.capabilities = capabilities;
    }

    /**
     * 
     * @return
     *     The language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * 
     * @param language
     *     The language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * 
     * @return
     *     The locations
     */
    public List<Location_> getLocations() {
        return locations;
    }

    /**
     * 
     * @param locations
     *     The locations
     */
    public void setLocations(List<Location_> locations) {
        this.locations = locations;
    }

    /**
     * 
     * @return
     *     The tags
     */
    public List<Tag> getTags() {
        return tags;
    }

    /**
     * 
     * @param tags
     *     The tags
     */
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(name).append(external).append(automatic).append(Links).append(templates).append(capabilities).append(language).append(locations).append(tags).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Configuration_) == false) {
            return false;
        }
        Configuration_ rhs = ((Configuration_) other);
        return new EqualsBuilder().append(id, rhs.id).append(name, rhs.name).append(external, rhs.external).append(automatic, rhs.automatic).append(Links, rhs.Links).append(templates, rhs.templates).append(capabilities, rhs.capabilities).append(language, rhs.language).append(locations, rhs.locations).append(tags, rhs.tags).isEquals();
    }

}
