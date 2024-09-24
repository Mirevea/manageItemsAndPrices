package com.itemsandprices.manageprices.mapper;

import com.itemsandprices.manageprices.domain.dto.PriceEntityDto;
import com.itemsandprices.manageprices.domain.entity.PriceEntity;

@Mapper(componentModel = "spring")
public interface PriceMapper extends EntityMapper<PriceEntityDto, PriceEntity> {
}