package reconditionedcarimporter.group71_2330031_2330190;

import java.io.Serializable;
import java.time.LocalDate;

public class Campaign implements Serializable {
    private String campaignName, campaignId, targetAudience;
    private int budget;
    private LocalDate startDate, endDate;

    public Campaign(String campaignName, String campaignId, String targetAudience, int budget, LocalDate startDate, LocalDate endDate) {
        this.campaignName = campaignName;
        this.campaignId = campaignId;
        this.targetAudience = targetAudience;
        this.budget = budget;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Campaign{campaignName='%s', campaignId='%s', targetAudience='%s', budget=%d, startDate=%s, endDate=%s}".formatted(campaignName, campaignId, targetAudience, budget, startDate, endDate);
    }
}