
package com.sdk.blendle.models.generated.example;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Embedded {

    @SerializedName("validation")
    @Expose
    private Validation validation;
    @SerializedName("publications")
    @Expose
    private Publications_ publications;
    @SerializedName("provider_categories")
    @Expose
    private ProviderCategories providerCategories;
    @SerializedName("provider_configurations")
    @Expose
    private ProviderConfigurations providerConfigurations;

    /**
     * 
     * @return
     *     The validation
     */
    public Validation getValidation() {
        return validation;
    }

    /**
     * 
     * @param validation
     *     The validation
     */
    public void setValidation(Validation validation) {
        this.validation = validation;
    }

    /**
     * 
     * @return
     *     The publications
     */
    public Publications_ getPublications() {
        return publications;
    }

    /**
     * 
     * @param publications
     *     The publications
     */
    public void setPublications(Publications_ publications) {
        this.publications = publications;
    }

    /**
     * 
     * @return
     *     The providerCategories
     */
    public ProviderCategories getProviderCategories() {
        return providerCategories;
    }

    /**
     * 
     * @param providerCategories
     *     The provider_categories
     */
    public void setProviderCategories(ProviderCategories providerCategories) {
        this.providerCategories = providerCategories;
    }

    /**
     * 
     * @return
     *     The providerConfigurations
     */
    public ProviderConfigurations getProviderConfigurations() {
        return providerConfigurations;
    }

    /**
     * 
     * @param providerConfigurations
     *     The provider_configurations
     */
    public void setProviderConfigurations(ProviderConfigurations providerConfigurations) {
        this.providerConfigurations = providerConfigurations;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(validation).append(publications).append(providerCategories).append(providerConfigurations).toHashCode();
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
        return new EqualsBuilder().append(validation, rhs.validation).append(publications, rhs.publications).append(providerCategories, rhs.providerCategories).append(providerConfigurations, rhs.providerConfigurations).isEquals();
    }

}
