package com.itemsandprices.manageprices.api.mapper;

import com.itemsandprices.manageprices.domain.entity.dao.PriceEntityDao;
import com.itemsandprices.manageprices.domain.entity.PriceEntity;
import com.itemsandprices.manageprices.domain.entity.dto.PriceEntityDto;

import java.util.List;
import java.util.Set;

public interface EntityMapper<D, E> {

    PriceEntity toEntity(PriceEntityDao dto);

    D toDto(E entity);

    List<E> toEntity(List<D> dtoList);

    List<D> toDto(List<E> entityList);

    Set<D> toDto(Set<E> entityList);
}
