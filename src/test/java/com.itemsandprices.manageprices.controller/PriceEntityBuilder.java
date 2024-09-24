package com.itemsandprices.manageprices.controller;

import com.itemsandprices.manageprices.domain.dto.PriceEntityDto;
import com.itemsandprices.manageprices.dto.PriceDto;

import java.util.Collections;
import java.util.List;

public class PriceBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static PriceEntityDto getDto() {
        PriceDto dto = new PriceDto();
        dto.setId("1");
        return dto;
    }
}
