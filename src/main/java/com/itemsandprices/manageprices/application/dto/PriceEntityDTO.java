package com.itemsandprices.manageprices.application.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;

public class PriceEntityDTO {
    private String brandId;
    private String startDate;
    private String endDate;
    private String productId;
    @JsonIgnore
    private String priority;
    @JsonIgnore
    private String price;
    private String finalPrice;
    @JsonIgnore
    private String curr;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getFinalPrice() {
        return price + " " + curr;
    }

    public void setFinalPrice(String finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}