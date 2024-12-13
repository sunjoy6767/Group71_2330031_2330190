package reconditionedcarimporter.group71_2330031_2330190;

import java.io.Serializable;

public class CampaignPerformance implements Serializable {
    private String campaignName, campaignId, Status, performanceSummary;
    private int clicks, conversions;
    private Double returnOnInvestment;

    public CampaignPerformance() {
    }

    public CampaignPerformance(String campaignName, String campaignId, String status, String performanceSummary, int clicks, int conversions, Double returnOnInvestment) {
        this.campaignName = campaignName;
        this.campaignId = campaignId;
        this.Status = status;
        this.performanceSummary = performanceSummary;
        this.clicks = clicks;
        this.conversions = conversions;
        this.returnOnInvestment = returnOnInvestment;
    }

    public CampaignPerformance(String text, String text1, String text2, String text3, int i, int i1, double v, Object o) {
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

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getPerformanceSummary() {
        return performanceSummary;
    }

    public void setPerformanceSummary(String performanceSummary) {
        this.performanceSummary = performanceSummary;
    }

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }

    public int getConversions() {
        return conversions;
    }

    public void setConversions(int conversions) {
        this.conversions = conversions;
    }

    public Double getReturnOnInvestment() {
        return returnOnInvestment;
    }

    public void setReturnOnInvestment(Double returnOnInvestment) {
        this.returnOnInvestment = returnOnInvestment;
    }

    @Override
    public String toString() {
        return "CampaignPerformance{" +
                "campaignName='" + campaignName + '\'' +
                ", campaignId='" + campaignId + '\'' +
                ", Status='" + Status + '\'' +
                ", performanceSummary='" + performanceSummary + '\'' +
                ", clicks=" + clicks +
                ", conversions=" + conversions +
                ", returnOnInvestment=" + returnOnInvestment +
                '}';
    }
}
