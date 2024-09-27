package com.itemsandprices.manageprices.infraestructure.mapper;

import java.util.List;
import java.util.Set;

// DTO, Entity, DAO
public interface EntityMapper<D, E, P> {

    D toDto(P entity);

    List<P> toDaoList(List<E> dtoList);

    P toDaoFromEntity(E entity);

    D toDtoFromEntity(E entity);
}
