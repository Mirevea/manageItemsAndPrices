package com.itemsandprices.manageprices.api.mapper;

import com.itemsandprices.manageprices.domain.entity.dao.PriceEntityDao;
import com.itemsandprices.manageprices.domain.entity.PriceEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PriceMapper extends EntityMapper<PriceEntityDao, PriceEntity> {
}