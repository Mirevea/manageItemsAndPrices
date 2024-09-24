package com.itemsandprices.manageprices.domain.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
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
}