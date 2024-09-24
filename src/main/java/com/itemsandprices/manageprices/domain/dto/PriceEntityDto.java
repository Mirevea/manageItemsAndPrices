package com.itemsandprices.manageprices.domain.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
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
}