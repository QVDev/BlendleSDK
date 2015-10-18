
package com.sdk.blendle.models.generated.login;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Login {

    @SerializedName("_embedded")
    @Expose
    private com.sdk.blendle.models.generated.login.Embedded Embedded;
    @SerializedName("refresh_token")
    @Expose
    private String refreshToken;
    @SerializedName("jwt")
    @Expose
    private String jwt;

    /**
     * 
     * @return
     *     The Embedded
     */
    public com.sdk.blendle.models.generated.login.Embedded getEmbedded() {
        return Embedded;
    }

    /**
     * 
     * @param Embedded
     *     The _embedded
     */
    public void setEmbedded(com.sdk.blendle.models.generated.login.Embedded Embedded) {
        this.Embedded = Embedded;
    }

    /**
     * 
     * @return
     *     The refreshToken
     */
    public String getRefreshToken() {
        return refreshToken;
    }

    /**
     * 
     * @param refreshToken
     *     The refresh_token
     */
    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    /**
     * 
     * @return
     *     The jwt
     */
    public String getJwt() {
        return jwt;
    }

    /**
     * 
     * @param jwt
     *     The jwt
     */
    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(Embedded).append(refreshToken).append(jwt).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Login) == false) {
            return false;
        }
        Login rhs = ((Login) other);
        return new EqualsBuilder().append(Embedded, rhs.Embedded).append(refreshToken, rhs.refreshToken).append(jwt, rhs.jwt).isEquals();
    }

}
