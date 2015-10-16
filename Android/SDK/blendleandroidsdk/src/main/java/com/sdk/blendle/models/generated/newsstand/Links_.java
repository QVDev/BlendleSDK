
package com.sdk.blendle.models.generated.newsstand;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Links_ {

    @SerializedName("self")
    @Expose
    private Self_ self;
    @SerializedName("cover")
    @Expose
    private Cover cover;
    @SerializedName("month")
    @Expose
    private Month month;
    @SerializedName("year")
    @Expose
    private Year year;
    @SerializedName("years")
    @Expose
    private Years years;
    @SerializedName("pages")
    @Expose
    private Pages pages;
    @SerializedName("page_preview")
    @Expose
    private PagePreview pagePreview;

    /**
     * 
     * @return
     *     The self
     */
    public Self_ getSelf() {
        return self;
    }

    /**
     * 
     * @param self
     *     The self
     */
    public void setSelf(Self_ self) {
        this.self = self;
    }

    /**
     * 
     * @return
     *     The cover
     */
    public Cover getCover() {
        return cover;
    }

    /**
     * 
     * @param cover
     *     The cover
     */
    public void setCover(Cover cover) {
        this.cover = cover;
    }

    /**
     * 
     * @return
     *     The month
     */
    public Month getMonth() {
        return month;
    }

    /**
     * 
     * @param month
     *     The month
     */
    public void setMonth(Month month) {
        this.month = month;
    }

    /**
     * 
     * @return
     *     The year
     */
    public Year getYear() {
        return year;
    }

    /**
     * 
     * @param year
     *     The year
     */
    public void setYear(Year year) {
        this.year = year;
    }

    /**
     * 
     * @return
     *     The years
     */
    public Years getYears() {
        return years;
    }

    /**
     * 
     * @param years
     *     The years
     */
    public void setYears(Years years) {
        this.years = years;
    }

    /**
     * 
     * @return
     *     The pages
     */
    public Pages getPages() {
        return pages;
    }

    /**
     * 
     * @param pages
     *     The pages
     */
    public void setPages(Pages pages) {
        this.pages = pages;
    }

    /**
     * 
     * @return
     *     The pagePreview
     */
    public PagePreview getPagePreview() {
        return pagePreview;
    }

    /**
     * 
     * @param pagePreview
     *     The page_preview
     */
    public void setPagePreview(PagePreview pagePreview) {
        this.pagePreview = pagePreview;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(self).append(cover).append(month).append(year).append(years).append(pages).append(pagePreview).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Links_) == false) {
            return false;
        }
        Links_ rhs = ((Links_) other);
        return new EqualsBuilder().append(self, rhs.self).append(cover, rhs.cover).append(month, rhs.month).append(year, rhs.year).append(years, rhs.years).append(pages, rhs.pages).append(pagePreview, rhs.pagePreview).isEquals();
    }

}
