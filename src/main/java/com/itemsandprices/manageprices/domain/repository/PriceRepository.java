package com.itemsandprices.manageprices.domain.repository;

import com.itemsandprices.manageprices.domain.entity.entity.PriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<PriceEntity, String> {

    List<PriceEntity> findByStartDateAndBrandIdAndProductId(String operativeDay, String productId, String brandId);

}