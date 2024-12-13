package reconditionedcarimporter.group71_2330031_2330190;

import java.io.Serializable;

public class BrandReputation implements Serializable {
    private String campaignId, platform,
            feedbackSummary, improvementAreas;
    private int totalMentions, negativeMentions, positiveMentions;

    public BrandReputation(String campaignId, String platform, String feedbackSummary, String improvementAreas, int totalMentions, int negativeMentions, int positiveMentions) {
        this.campaignId = campaignId;
        this.platform = platform;
        this.feedbackSummary = feedbackSummary;
        this.improvementAreas = improvementAreas;
        this.totalMentions = totalMentions;
        this.negativeMentions = negativeMentions;
        this.positiveMentions = positiveMentions;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getFeedbackSummary() {
        return feedbackSummary;
    }

    public void setFeedbackSummary(String feedbackSummary) {
        this.feedbackSummary = feedbackSummary;
    }

    public String getImprovementAreas() {
        return improvementAreas;
    }

    public void setImprovementAreas(String improvementAreas) {
        this.improvementAreas = improvementAreas;
    }

    public int getTotalMentions() {
        return totalMentions;
    }

    public void setTotalMentions(int totalMentions) {
        this.totalMentions = totalMentions;
    }

    public int getNegativeMentions() {
        return negativeMentions;
    }

    public void setNegativeMentions(int negativeMentions) {
        this.negativeMentions = negativeMentions;
    }

    public int getPositiveMentions() {
        return positiveMentions;
    }

    public void setPositiveMentions(int positiveMentions) {
        this.positiveMentions = positiveMentions;
    }

    @Override
    public String toString() {
        return "BrandReputation{" +
                "campaignId='" + campaignId + '\'' +
                ", platform='" + platform + '\'' +
                ", feedbackSummary='" + feedbackSummary + '\'' +
                ", improvementAreas='" + improvementAreas + '\'' +
                ", totalMentions=" + totalMentions +
                ", negativeMentions=" + negativeMentions +
                ", positiveMentions=" + positiveMentions +
                '}';
    }
}
