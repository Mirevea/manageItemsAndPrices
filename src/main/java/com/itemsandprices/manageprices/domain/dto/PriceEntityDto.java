package com.itemsandprices.manageprices.domain.dto;

import jakarta.validation.constraints.NotEmpty;

public class PriceEntityDto {
    @NotEmpty(message = "The ID of the brand is required.")
    private String brandId;
    @NotEmpty(message = "The startDate of the product is required.")
    private String startDate;
    private String endDate;
    private String priceList;
    @NotEmpty(message = "The ID of the product is required.")
    private String productId;
    private String priority;
    private String price;
    private String curr;

    public @NotEmpty(message = "The ID of the brand is required.") String getBrandId() {
        return brandId;
    }

    public @NotEmpty(message = "The startDate of the product is required.") String getStartDate() {
        return startDate;
    }

    public @NotEmpty(message = "The ID of the product is required.") String getProductId() {
        return productId;
    }

    public void setBrandId(@NotEmpty(message = "The ID of the brand is required.") String brandId) {
        this.brandId = brandId;
    }

    public void setStartDate(@NotEmpty(message = "The startDate of the product is required.") String startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setPriceList(String priceList) {
        this.priceList = priceList;
    }

    public void setProductId(@NotEmpty(message = "The ID of the product is required.") String productId) {
        this.productId = productId;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }
}