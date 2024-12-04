package reconditionedcarimporter.group71_2330031_2330190;

import java.time.LocalDate;

public class Campaign {
    private String campaignName, campaignId, targetAudience, status;
    private double budget;
    private LocalDate startDate, endDate;

    public Campaign() {
    }

    public Campaign(String campaignName, String campaignId, String targetAudience, String status, double budget, LocalDate startDate, LocalDate endDate) {
        this.campaignName = campaignName;
        this.campaignId = campaignId;
        this.targetAudience = targetAudience;
        this.status = status;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
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
        return "Campaign{" +
                "campaignName='" + campaignName + '\'' +
                ", campaignId='" + campaignId + '\'' +
                ", targetAudience='" + targetAudience + '\'' +
                ", status='" + status + '\'' +
                ", budget=" + budget +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
