package com.itemsandprices.manageprices.controller;

import com.itemsandprices.manageprices.domain.dto.PriceEntityDto;

public class PriceBuilder {

    public static PriceEntityDto getDto() {
        PriceEntityDto dto = new PriceEntityDto();
        dto.setPrice("1");
        dto.setBrandId("1");
        dto.setProductId("1");
        dto.setStartDate("2022-01-01");
        dto.setEndDate("2022-12-31");
        dto.setPriority("1");

        return dto;
    }
}
