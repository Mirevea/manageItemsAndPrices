package com.itemsandprices.manageprices.mapper;

import com.itemsandprices.manageprices.dto.PriceDto;
import com.itemsandprices.manageprices.dto.PriceEntityDto;
import com.itemsandprices.manageprices.entity.PriceEntity;

@Mapper(componentModel = "spring")
public interface PriceMapper extends EntityMapper<PriceEntityDto, PriceEntity> {
}