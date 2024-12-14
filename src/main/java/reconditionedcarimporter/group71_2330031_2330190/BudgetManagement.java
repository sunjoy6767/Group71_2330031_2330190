package reconditionedcarimporter.group71_2330031_2330190;

import java.io.Serializable;
import java.time.LocalDate;

public class BudgetManagement implements Serializable {
    private String campaignId, budgetStatus;
    private double socialMediaBudget,semBudget,emailMarketingBudget,totalBudget,totalSpending;
    private LocalDate startDate,endDate;


    public BudgetManagement() {
    }

    public BudgetManagement(String campaignId, double totalSpending, LocalDate startDate, LocalDate endDate, double socialMediaBudget, double semBudget, double emailMarketingBudget) {
        this.campaignId = campaignId;
        this.totalSpending = totalSpending;
        this.startDate = startDate;
        this.endDate = endDate;
        this.socialMediaBudget = socialMediaBudget;
        this.semBudget = semBudget;
        this.emailMarketingBudget = emailMarketingBudget;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public String getBudgetStatus() {
        return budgetStatus;
    }

    public void setBudgetStatus(String budgetStatus) {
        this.budgetStatus = budgetStatus;
    }

    public double getSocialMediaBudget() {
        return socialMediaBudget;
    }

    public void setSocialMediaBudget(double socialMediaBudget) {
        this.socialMediaBudget = socialMediaBudget;
    }

    public double getSemBudget() {
        return semBudget;
    }

    public void setSemBudget(double semBudget) {
        this.semBudget = semBudget;
    }

    public double getEmailMarketingBudget() {
        return emailMarketingBudget;
    }

    public void setEmailMarketingBudget(double emailMarketingBudget) {
        this.emailMarketingBudget = emailMarketingBudget;
    }

    public double getTotalBudget() {
        return totalBudget;
    }

    public void setTotalBudget(double totalBudget) {
        this.totalBudget = totalBudget;
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

    public double getTotalSpending() {
        return totalSpending;
    }

    public void setTotalSpending(double totalSpending) {
        this.totalSpending = totalSpending;
    }

    @Override
    public String toString() {
        return "BudgetManagement{" +
                "campaignId='" + campaignId + '\'' +
                ", budgetStatus='" + budgetStatus + '\'' +
                ", socialMediaBudget=" + socialMediaBudget +
                ", semBudget=" + semBudget +
                ", emailMarketingBudget=" + emailMarketingBudget +
                ", totalBudget=" + totalBudget +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", totalSpending=" + totalSpending +
                '}';
    }
}
