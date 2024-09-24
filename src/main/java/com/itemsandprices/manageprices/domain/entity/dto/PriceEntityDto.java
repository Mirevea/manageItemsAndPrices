package com.itemsandprices.manageprices.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Data
public class PriceEntityDto {
    private String brandId;
    private String startDate;
    private String endDate;
    private String priceList;
    private String productId;
    private String priority;
    private String price;
    private String curr;
}