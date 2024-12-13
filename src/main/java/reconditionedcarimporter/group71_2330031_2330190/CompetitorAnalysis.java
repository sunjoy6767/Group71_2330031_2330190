package reconditionedcarimporter.group71_2330031_2330190;

import java.io.Serializable;
import java.time.LocalDate;

public class CompetitorAnalysis implements Serializable {
    private String competitorName, competitorCampaignName,
            competitorAdvertisingChannels, competitorKeyInsights;
    private LocalDate competitorStartDate, competitorEndDate;
    private int reach, impression, engagement;

    public CompetitorAnalysis(String competitorName, String competitorCampaignName, String competitorAdvertisingChannels, String competitorKeyInsights, LocalDate competitorStartDate, LocalDate competitorEndDate) {
        this.competitorName = competitorName;
        this.competitorCampaignName = competitorCampaignName;
        this.competitorAdvertisingChannels = competitorAdvertisingChannels;
        this.competitorKeyInsights = competitorKeyInsights;
        this.competitorStartDate = competitorStartDate;
        this.competitorEndDate = competitorEndDate;
    }

    public CompetitorAnalysis(String competitorName, String competitorCampaignName, String competitorAdvertisingChannels, String competitorKeyInsights, LocalDate competitorStartDate, LocalDate competitorEndDate, int reach, int impression, int engagement) {
        this.competitorName = competitorName;
        this.competitorCampaignName = competitorCampaignName;
        this.competitorAdvertisingChannels = competitorAdvertisingChannels;
        this.competitorKeyInsights = competitorKeyInsights;
        this.competitorStartDate = competitorStartDate;
        this.competitorEndDate = competitorEndDate;
        this.reach = reach;
        this.impression = impression;
        this.engagement = engagement;
    }

    public String getCompetitorName() {
        return competitorName;
    }

    public void setCompetitorName(String competitorName) {
        this.competitorName = competitorName;
    }

    public String getCompetitorCampaignName() {
        return competitorCampaignName;
    }

    public void setCompetitorCampaignName(String competitorCampaignName) {
        this.competitorCampaignName = competitorCampaignName;
    }

    public String getCompetitorAdvertisingChannels() {
        return competitorAdvertisingChannels;
    }

    public void setCompetitorAdvertisingChannels(String competitorAdvertisingChannels) {
        this.competitorAdvertisingChannels = competitorAdvertisingChannels;
    }

    public String getCompetitorKeyInsights() {
        return competitorKeyInsights;
    }

    public void setCompetitorKeyInsights(String competitorKeyInsights) {
        this.competitorKeyInsights = competitorKeyInsights;
    }

    public LocalDate getCompetitorStartDate() {
        return competitorStartDate;
    }

    public void setCompetitorStartDate(LocalDate competitorStartDate) {
        this.competitorStartDate = competitorStartDate;
    }

    public LocalDate getCompetitorEndDate() {
        return competitorEndDate;
    }

    public void setCompetitorEndDate(LocalDate competitorEndDate) {
        this.competitorEndDate = competitorEndDate;
    }

    public int getReach() {
        return reach;
    }

    public void setReach(int reach) {
        this.reach = reach;
    }

    public int getImpression() {
        return impression;
    }

    public void setImpression(int impression) {
        this.impression = impression;
    }

    public int getEngagement() {
        return engagement;
    }

    public void setEngagement(int engagement) {
        this.engagement = engagement;
    }

    @Override
    public String toString() {
        return "CompetitorAnalysis{" +
                "competitorName='" + competitorName + '\'' +
                ", competitorCampaignName='" + competitorCampaignName + '\'' +
                ", competitorAdvertisingChannels='" + competitorAdvertisingChannels + '\'' +
                ", competitorKeyInsights='" + competitorKeyInsights + '\'' +
                ", competitorStartDate=" + competitorStartDate +
                ", competitorEndDate=" + competitorEndDate +
                ", reach=" + reach +
                ", impression=" + impression +
                ", engagement=" + engagement +
                '}';
    }
}
