package reconditionedcarimporter.group71_2330031_2330190;

import java.io.Serializable;
import java.time.LocalDate;

public class LoyaltyProgram implements Serializable {
    private String programName, programId,
            rewards, eligibilityCriteria, programStatus;
    private LocalDate startDate, endDate;
    private Double minimumSpend;

    public LoyaltyProgram(String programName, String programId, String rewards, String eligibilityCriteria, String programStatus, LocalDate startDate, LocalDate endDate, Double minimumSpend) {
        this.programName = programName;
        this.programId = programId;
        this.rewards = rewards;
        this.eligibilityCriteria = eligibilityCriteria;
        this.programStatus = programStatus;
        this.startDate = startDate;
        this.endDate = endDate;
        this.minimumSpend = minimumSpend;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getProgramId() {
        return programId;
    }

    public void setProgramId(String programId) {
        this.programId = programId;
    }

    public String getRewards() {
        return rewards;
    }

    public void setRewards(String rewards) {
        this.rewards = rewards;
    }

    public String getEligibilityCriteria() {
        return eligibilityCriteria;
    }

    public void setEligibilityCriteria(String eligibilityCriteria) {
        this.eligibilityCriteria = eligibilityCriteria;
    }

    public String getProgramStatus() {
        return programStatus;
    }

    public void setProgramStatus(String programStatus) {
        this.programStatus = programStatus;
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

    public Double getMinimumSpend() {
        return minimumSpend;
    }

    public void setMinimumSpend(Double minimumSpend) {
        this.minimumSpend = minimumSpend;
    }

    @Override
    public String toString() {
        return "LoyaltyProgram{" +
                "programName='" + programName + '\'' +
                ", programId='" + programId + '\'' +
                ", rewards='" + rewards + '\'' +
                ", eligibilityCriteria='" + eligibilityCriteria + '\'' +
                ", programStatus='" + programStatus + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", minimumSpend=" + minimumSpend +
                '}';
    }
}
