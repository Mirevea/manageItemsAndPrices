package com.itemsandprices.manageprices.controller;

import com.itemsandprices.manageprices.domain.entity.dao.PriceEntityDao;

public class PriceBuilder {

    public static PriceEntityDao getDto() {
        PriceEntityDao dto = new PriceEntityDao();
        dto.setPrice("1");
        dto.setBrandId("1");
        dto.setProductId("1");
        dto.setStartDate("2022-01-01");
        dto.setEndDate("2022-12-31");
        dto.setPriority("1");

        return dto;
    }
}
