package com.itemsandprices.manageprices.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "PRICES")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class PriceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RATE_ID")
    private Long rateId;
    @Column(name = "BRAND_ID")
    private Long brandId;
    @Column(name = "START_DATE")
    private String startDate;
    @Column(name = "END_DATE")
    private String endDate;
    @Column(name = "PRICE_LIST")
    private String priceList;
    @Column(name = "PRODUCT_ID")
    private String productId;
    @Column(name = "PRIORITY")
    private String priority;
    @Column(name = "PRICE")
    private String price;
    @Column(name = "CURR")
    private String curr;
}
