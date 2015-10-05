
package com.sdk.blendle.models.generated.login;

import javax.annotation.Generated;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@Generated("org.jsonschema2pojo")
public class Preferences {

    @SerializedName("did_onboarding")
    @Expose
    private String didOnboarding;
    @SerializedName("hide_tile_explain_kiosk")
    @Expose
    private String hideTileExplainKiosk;
    @SerializedName("hide_acquire_issue_tooltip")
    @Expose
    private String hideAcquireIssueTooltip;
    @SerializedName("hide_tile_explain_following")
    @Expose
    private String hideTileExplainFollowing;

    /**
     * 
     * @return
     *     The didOnboarding
     */
    public String getDidOnboarding() {
        return didOnboarding;
    }

    /**
     * 
     * @param didOnboarding
     *     The did_onboarding
     */
    public void setDidOnboarding(String didOnboarding) {
        this.didOnboarding = didOnboarding;
    }

    /**
     * 
     * @return
     *     The hideTileExplainKiosk
     */
    public String getHideTileExplainKiosk() {
        return hideTileExplainKiosk;
    }

    /**
     * 
     * @param hideTileExplainKiosk
     *     The hide_tile_explain_kiosk
     */
    public void setHideTileExplainKiosk(String hideTileExplainKiosk) {
        this.hideTileExplainKiosk = hideTileExplainKiosk;
    }

    /**
     * 
     * @return
     *     The hideAcquireIssueTooltip
     */
    public String getHideAcquireIssueTooltip() {
        return hideAcquireIssueTooltip;
    }

    /**
     * 
     * @param hideAcquireIssueTooltip
     *     The hide_acquire_issue_tooltip
     */
    public void setHideAcquireIssueTooltip(String hideAcquireIssueTooltip) {
        this.hideAcquireIssueTooltip = hideAcquireIssueTooltip;
    }

    /**
     * 
     * @return
     *     The hideTileExplainFollowing
     */
    public String getHideTileExplainFollowing() {
        return hideTileExplainFollowing;
    }

    /**
     * 
     * @param hideTileExplainFollowing
     *     The hide_tile_explain_following
     */
    public void setHideTileExplainFollowing(String hideTileExplainFollowing) {
        this.hideTileExplainFollowing = hideTileExplainFollowing;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(didOnboarding).append(hideTileExplainKiosk).append(hideAcquireIssueTooltip).append(hideTileExplainFollowing).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Preferences) == false) {
            return false;
        }
        Preferences rhs = ((Preferences) other);
        return new EqualsBuilder().append(didOnboarding, rhs.didOnboarding).append(hideTileExplainKiosk, rhs.hideTileExplainKiosk).append(hideAcquireIssueTooltip, rhs.hideAcquireIssueTooltip).append(hideTileExplainFollowing, rhs.hideTileExplainFollowing).isEquals();
    }

}
