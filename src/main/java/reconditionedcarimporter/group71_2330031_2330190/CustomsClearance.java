package reconditionedcarimporter.group71_2330031_2330190;

import java.io.Serializable;
import java.time.LocalDate;

public class CustomsClearance implements Serializable {
    private String clearanceId, customsAgentName, clearanceStatus, customsDutyPaidStatus;
    private double customsDutyAmount;
    private LocalDate clearanceDate;

    public CustomsClearance() {
    }

    public CustomsClearance(String clearanceId, String customsAgentName, String clearanceStatus, String customsDutyPaidStatus, double customsDutyAmount, LocalDate clearanceDate) {
        this.clearanceId = clearanceId;
        this.customsAgentName = customsAgentName;
        this.clearanceStatus = clearanceStatus;
        this.customsDutyPaidStatus = customsDutyPaidStatus;
        this.customsDutyAmount = customsDutyAmount;
        this.clearanceDate = clearanceDate;
    }

    public String getClearanceId() {
        return clearanceId;
    }

    public void setClearanceId(String clearanceId) {
        this.clearanceId = clearanceId;
    }

    public String getCustomsAgentName() {
        return customsAgentName;
    }

    public void setCustomsAgentName(String customsAgentName) {
        this.customsAgentName = customsAgentName;
    }

    public String getClearanceStatus() {
        return clearanceStatus;
    }

    public void setClearanceStatus(String clearanceStatus) {
        this.clearanceStatus = clearanceStatus;
    }

    public String getCustomsDutyPaidStatus() {
        return customsDutyPaidStatus;
    }

    public void setCustomsDutyPaidStatus(String customsDutyPaidStatus) {
        this.customsDutyPaidStatus = customsDutyPaidStatus;
    }

    public double getCustomsDutyAmount() {
        return customsDutyAmount;
    }

    public void setCustomsDutyAmount(double customsDutyAmount) {
        this.customsDutyAmount = customsDutyAmount;
    }

    public LocalDate getClearanceDate() {
        return clearanceDate;
    }

    public void setClearanceDate(LocalDate clearanceDate) {
        this.clearanceDate = clearanceDate;
    }

    @Override
    public String toString() {
        return "CustomsClearance{" +
                "clearanceId='" + clearanceId + '\'' +
                ", customsAgentName='" + customsAgentName + '\'' +
                ", clearanceStatus='" + clearanceStatus + '\'' +
                ", customsDutyPaidStatus='" + customsDutyPaidStatus + '\'' +
                ", customsDutyAmount=" + customsDutyAmount +
                ", clearanceDate=" + clearanceDate +
                '}';
    }
}
