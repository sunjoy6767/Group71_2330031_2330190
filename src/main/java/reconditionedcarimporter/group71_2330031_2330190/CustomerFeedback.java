package reconditionedcarimporter.group71_2330031_2330190;

import java.time.LocalDate;

public class CustomerFeedback {
    private String feedbackId, customerId, comment, responseStatus;
    private int rating;
    private LocalDate feedbackDate;

    public CustomerFeedback() {
    }

    public CustomerFeedback(String feedbackId, String customerId, String comment, String responseStatus, int rating, LocalDate feedbackDate) {
        this.feedbackId = feedbackId;
        this.customerId = customerId;
        this.comment = comment;
        this.responseStatus = responseStatus;
        this.rating = rating;
        this.feedbackDate = feedbackDate;
    }

    public String getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(String feedbackId) {
        this.feedbackId = feedbackId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public LocalDate getFeedbackDate() {
        return feedbackDate;
    }

    public void setFeedbackDate(LocalDate feedbackDate) {
        this.feedbackDate = feedbackDate;
    }

    @Override
    public String toString() {
        return "CustomerFeedback{" +
                "feedbackId='" + feedbackId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", comment='" + comment + '\'' +
                ", responseStatus='" + responseStatus + '\'' +
                ", rating=" + rating +
                ", feedbackDate=" + feedbackDate +
                '}';
    }
}
