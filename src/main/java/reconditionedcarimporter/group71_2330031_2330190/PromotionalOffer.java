package reconditionedcarimporter.group71_2330031_2330190;

import java.io.Serializable;
import java.time.LocalDate;

public class PromotionalOffer implements Serializable {
    private String offerId, offerName, conditions, status;
    private Double discountPercentage;
    private LocalDate startDate, endDate;

    public PromotionalOffer() {
    }

    public PromotionalOffer(String offerId, String offerName, String conditions, String status, Double discountPercentage, LocalDate startDate, LocalDate endDate) {
        this.offerId = offerId;
        this.offerName = offerName;
        this.conditions = conditions;
        this.status = status;
        this.discountPercentage = discountPercentage;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(Double discountPercentage) {
        this.discountPercentage = discountPercentage;
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
        return "PromotionalOffer{" +
                "offerId='" + offerId + '\'' +
                ", offerName='" + offerName + '\'' +
                ", conditions='" + conditions + '\'' +
                ", status='" + status + '\'' +
                ", discountPercentage=" + discountPercentage +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
