package com.itemsandprices.manageprices.mapper;

import com.itemsandprices.manageprices.domain.dto.PriceEntityDto;
import com.itemsandprices.manageprices.domain.entity.PriceEntity;

import java.util.List;
import java.util.Set;

public interface EntityMapper<D, E> {

    PriceEntity toEntity(PriceEntityDto dto);

    D toDto(E entity);

    List<E> toEntity(List<D> dtoList);

    List<D> toDto(List<E> entityList);

    Set<D> toDto(Set<E> entityList);
}
