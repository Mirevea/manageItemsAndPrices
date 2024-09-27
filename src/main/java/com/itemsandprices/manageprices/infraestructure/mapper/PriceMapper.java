package com.itemsandprices.manageprices.infraestructure.mapper;

import com.itemsandprices.manageprices.application.dto.PriceEntityDTO;
import com.itemsandprices.manageprices.domain.entity.PriceEntity;
import com.itemsandprices.manageprices.infraestructure.dao.PriceEntityDAO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceMapper extends EntityMapper<PriceEntityDTO, PriceEntity, PriceEntityDAO> {
}