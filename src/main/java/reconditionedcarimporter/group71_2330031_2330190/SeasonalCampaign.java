package reconditionedcarimporter.group71_2330031_2330190;

import java.io.Serializable;
import java.time.LocalDate;

public class SeasonalCampaign implements Serializable {
    private String campaignId, campaignTheme,
            targetAudience, historicalDataSummary;
    private LocalDate startDate, endDate;
    private Double forecastedRevenue;

    public SeasonalCampaign(String campaignId, String campaignTheme, String targetAudience, String historicalDataSummary, LocalDate startDate, LocalDate endDate, Double forecastedRevenue) {
        this.campaignId = campaignId;
        this.campaignTheme = campaignTheme;
        this.targetAudience = targetAudience;
        this.historicalDataSummary = historicalDataSummary;
        this.startDate = startDate;
        this.endDate = endDate;
        this.forecastedRevenue = forecastedRevenue;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public String getCampaignTheme() {
        return campaignTheme;
    }

    public void setCampaignTheme(String campaignTheme) {
        this.campaignTheme = campaignTheme;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public String getHistoricalDataSummary() {
        return historicalDataSummary;
    }

    public void setHistoricalDataSummary(String historicalDataSummary) {
        this.historicalDataSummary = historicalDataSummary;
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

    public Double getForecastedRevenue() {
        return forecastedRevenue;
    }

    public void setForecastedRevenue(Double forecastedRevenue) {
        this.forecastedRevenue = forecastedRevenue;
    }

    @Override
    public String toString() {
        return "SeasonalCampaign{" +
                "campaignId='" + campaignId + '\'' +
                ", campaignTheme='" + campaignTheme + '\'' +
                ", targetAudience='" + targetAudience + '\'' +
                ", historicalDataSummary='" + historicalDataSummary + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", forecastedRevenue=" + forecastedRevenue +
                '}';
    }
}
