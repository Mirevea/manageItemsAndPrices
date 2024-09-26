package com.itemsandprices.manageprices.infraestructure.mapper;

import com.itemsandprices.manageprices.api.dto.PriceEntityDTO;
import com.itemsandprices.manageprices.domain.entity.entity.PriceEntity;

import java.util.List;
import java.util.Set;

public interface EntityMapper<D, E> {

    PriceEntity toEntity(PriceEntityDTO dto);

    D toDto(E entity);

    List<E> toEntity(List<D> dtoList);

    List<D> toDto(List<E> entityList);

    Set<D> toDto(Set<E> entityList);
}
