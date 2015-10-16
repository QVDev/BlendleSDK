
package com.sdk.blendle.models.generated.newsstand;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Issue_ {

    @SerializedName("format_version")
    @Expose
    private Integer formatVersion;
    @SerializedName("representations")
    @Expose
    private List<String> representations = new ArrayList<String>();
    @SerializedName("_links")
    @Expose
    private Links_ Links;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("provider")
    @Expose
    private Provider provider;
    @SerializedName("initial_publication_time")
    @Expose
    private String initialPublicationTime;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("items")
    @Expose
    private List<String> items = new ArrayList<String>();
    @SerializedName("_embedded")
    @Expose
    private Embedded_ Embedded;

    /**
     * 
     * @return
     *     The formatVersion
     */
    public Integer getFormatVersion() {
        return formatVersion;
    }

    /**
     * 
     * @param formatVersion
     *     The format_version
     */
    public void setFormatVersion(Integer formatVersion) {
        this.formatVersion = formatVersion;
    }

    /**
     * 
     * @return
     *     The representations
     */
    public List<String> getRepresentations() {
        return representations;
    }

    /**
     * 
     * @param representations
     *     The representations
     */
    public void setRepresentations(List<String> representations) {
        this.representations = representations;
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
     *     The provider
     */
    public Provider getProvider() {
        return provider;
    }

    /**
     * 
     * @param provider
     *     The provider
     */
    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    /**
     * 
     * @return
     *     The initialPublicationTime
     */
    public String getInitialPublicationTime() {
        return initialPublicationTime;
    }

    /**
     * 
     * @param initialPublicationTime
     *     The initial_publication_time
     */
    public void setInitialPublicationTime(String initialPublicationTime) {
        this.initialPublicationTime = initialPublicationTime;
    }

    /**
     * 
     * @return
     *     The date
     */
    public String getDate() {
        return date;
    }

    /**
     * 
     * @param date
     *     The date
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * 
     * @return
     *     The items
     */
    public List<String> getItems() {
        return items;
    }

    /**
     * 
     * @param items
     *     The items
     */
    public void setItems(List<String> items) {
        this.items = items;
    }

    /**
     * 
     * @return
     *     The Embedded
     */
    public Embedded_ getEmbedded() {
        return Embedded;
    }

    /**
     * 
     * @param Embedded
     *     The _embedded
     */
    public void setEmbedded(Embedded_ Embedded) {
        this.Embedded = Embedded;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(formatVersion).append(representations).append(Links).append(id).append(provider).append(initialPublicationTime).append(date).append(items).append(Embedded).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Issue_) == false) {
            return false;
        }
        Issue_ rhs = ((Issue_) other);
        return new EqualsBuilder().append(formatVersion, rhs.formatVersion).append(representations, rhs.representations).append(Links, rhs.Links).append(id, rhs.id).append(provider, rhs.provider).append(initialPublicationTime, rhs.initialPublicationTime).append(date, rhs.date).append(items, rhs.items).append(Embedded, rhs.Embedded).isEquals();
    }

}
