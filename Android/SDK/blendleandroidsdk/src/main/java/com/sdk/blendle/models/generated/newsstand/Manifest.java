
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
public class Manifest {

    @SerializedName("format_version")
    @Expose
    private Integer formatVersion;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("provider")
    @Expose
    private Provider_ provider;
    @SerializedName("body")
    @Expose
    private List<Body> body = new ArrayList<Body>();
    @SerializedName("images")
    @Expose
    private List<Image> images = new ArrayList<Image>();
    @SerializedName("length")
    @Expose
    private Length length;
    @SerializedName("item_index")
    @Expose
    private Integer itemIndex;
    @SerializedName("issue")
    @Expose
    private Issue__ issue;
    @SerializedName("_links")
    @Expose
    private Links___ Links;

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
     *     The provider
     */
    public Provider_ getProvider() {
        return provider;
    }

    /**
     * 
     * @param provider
     *     The provider
     */
    public void setProvider(Provider_ provider) {
        this.provider = provider;
    }

    /**
     * 
     * @return
     *     The body
     */
    public List<Body> getBody() {
        return body;
    }

    /**
     * 
     * @param body
     *     The body
     */
    public void setBody(List<Body> body) {
        this.body = body;
    }

    /**
     * 
     * @return
     *     The images
     */
    public List<Image> getImages() {
        return images;
    }

    /**
     * 
     * @param images
     *     The images
     */
    public void setImages(List<Image> images) {
        this.images = images;
    }

    /**
     * 
     * @return
     *     The length
     */
    public Length getLength() {
        return length;
    }

    /**
     * 
     * @param length
     *     The length
     */
    public void setLength(Length length) {
        this.length = length;
    }

    /**
     * 
     * @return
     *     The itemIndex
     */
    public Integer getItemIndex() {
        return itemIndex;
    }

    /**
     * 
     * @param itemIndex
     *     The item_index
     */
    public void setItemIndex(Integer itemIndex) {
        this.itemIndex = itemIndex;
    }

    /**
     * 
     * @return
     *     The issue
     */
    public Issue__ getIssue() {
        return issue;
    }

    /**
     * 
     * @param issue
     *     The issue
     */
    public void setIssue(Issue__ issue) {
        this.issue = issue;
    }

    /**
     * 
     * @return
     *     The Links
     */
    public Links___ getLinks() {
        return Links;
    }

    /**
     * 
     * @param Links
     *     The _links
     */
    public void setLinks(Links___ Links) {
        this.Links = Links;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(formatVersion).append(id).append(date).append(provider).append(body).append(images).append(length).append(itemIndex).append(issue).append(Links).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Manifest) == false) {
            return false;
        }
        Manifest rhs = ((Manifest) other);
        return new EqualsBuilder().append(formatVersion, rhs.formatVersion).append(id, rhs.id).append(date, rhs.date).append(provider, rhs.provider).append(body, rhs.body).append(images, rhs.images).append(length, rhs.length).append(itemIndex, rhs.itemIndex).append(issue, rhs.issue).append(Links, rhs.Links).isEquals();
    }

}
