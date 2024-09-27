package com.itemsandprices.manageprices.service;

import com.itemsandprices.manageprices.application.dto.PriceEntityDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface PriceService {
    Optional<PriceEntityDTO> findById(String id);

    PriceEntityDTO findByCondition(String operativeDay, String productId, String brandId);
}
