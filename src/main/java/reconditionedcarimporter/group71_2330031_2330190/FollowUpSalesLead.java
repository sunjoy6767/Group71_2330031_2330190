package reconditionedcarimporter.group71_2330031_2330190;

import java.io.Serializable;
import java.time.LocalDate;

public class FollowUpSalesLead implements Serializable {
    private String leadId;
    private String leadName;
    private String leadStatus;
    private String contactInfo;
    private String followUpDetails;
    private LocalDate followUpDate;
    private String followUpOutcome;
    private String contactInfoVerified;

    public FollowUpSalesLead() {
    }

    public FollowUpSalesLead(String leadId, String leadName, String leadStatus, String contactInfo, String followUpDetails, LocalDate followUpDate, String followUpOutcome, String contactInfoVerified) {
        this.leadId = leadId;
        this.leadName = leadName;
        this.leadStatus = leadStatus;
        this.contactInfo = contactInfo;
        this.followUpDetails = followUpDetails;
        this.followUpDate = followUpDate;
        this.followUpOutcome = followUpOutcome;
        this.contactInfoVerified = contactInfoVerified;
    }

    public String getLeadId() {
        return leadId;
    }

    public void setLeadId(String leadId) {
        this.leadId = leadId;
    }

    public String getLeadName() {
        return leadName;
    }

    public void setLeadName(String leadName) {
        this.leadName = leadName;
    }

    public String getLeadStatus() {
        return leadStatus;
    }

    public void setLeadStatus(String leadStatus) {
        this.leadStatus = leadStatus;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getFollowUpDetails() {
        return followUpDetails;
    }

    public void setFollowUpDetails(String followUpDetails) {
        this.followUpDetails = followUpDetails;
    }

    public LocalDate getFollowUpDate() {
        return followUpDate;
    }

    public void setFollowUpDate(LocalDate followUpDate) {
        this.followUpDate = followUpDate;
    }

    public String getFollowUpOutcome() {
        return followUpOutcome;
    }

    public void setFollowUpOutcome(String followUpOutcome) {
        this.followUpOutcome = followUpOutcome;
    }

    public String isContactInfoVerified() {
        return contactInfoVerified;
    }

    public void setContactInfoVerified(String contactInfoVerified) {
        this.contactInfoVerified = contactInfoVerified;
    }

    @Override
    public String toString() {
        return "FollowUpSalesLead{" +
                "leadId='" + leadId + '\'' +
                ", leadName='" + leadName + '\'' +
                ", leadStatus='" + leadStatus + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", followUpDetails='" + followUpDetails + '\'' +
                ", followUpDate=" + followUpDate +
                ", followUpOutcome='" + followUpOutcome + '\'' +
                ", contactInfoVerified=" + contactInfoVerified +
                '}';
    }
}
