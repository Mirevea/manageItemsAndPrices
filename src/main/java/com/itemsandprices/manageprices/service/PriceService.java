package com.itemsandprices.manageprices.service;

import com.itemsandprices.manageprices.domain.dto.PriceEntityDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface PriceService {
    PriceEntityDto findById(String id);

    Page<PriceEntityDto> findByCondition(String startDate, Long brandId, String productId, Pageable pageable);
}
