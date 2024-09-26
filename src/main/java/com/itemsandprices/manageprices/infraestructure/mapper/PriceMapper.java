package com.itemsandprices.manageprices.infraestructure.mapper;

import com.itemsandprices.manageprices.api.dto.PriceEntityDTO;
import com.itemsandprices.manageprices.domain.entity.entity.PriceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceMapper extends EntityMapper<PriceEntityDTO, PriceEntity> {
}