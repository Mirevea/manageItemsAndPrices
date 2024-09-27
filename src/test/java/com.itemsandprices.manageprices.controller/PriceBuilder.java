package com.itemsandprices.manageprices.controller;

import com.itemsandprices.manageprices.application.dto.PriceEntityDTO;

public class PriceBuilder {

    public static PriceEntityDTO getDto() {
        PriceEntityDTO dto = new PriceEntityDTO();
        dto.setFinalPrice("1");
        dto.setBrandId("1");
        dto.setProductId("1");
        dto.setStartDate("2022-01-01");
        //dto.setEndDate("2022-12-31");
        dto.setPriority("1");

        return dto;
    }
}
