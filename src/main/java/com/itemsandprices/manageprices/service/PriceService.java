package com.itemsandprices.manageprices.service;

import com.itemsandprices.manageprices.domain.entity.dao.PriceEntityDao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface PriceService {
    Optional<PriceEntityDao> findById(String id);

    Page<PriceEntityDao> findByCondition(String startDate, Long brandId, String productId, Pageable pageable);
}
