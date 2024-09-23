package com.itemsandprices.manageprices.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PriceEntity {
    @Id
    private String brandId;
    private String startDate;
    private String endDate;
    private String priceList;
    private String productId;
    private String priority;
    private String price;
    private String curr;
}
