package com.itemsandprices.manageprices.service;

import com.itemsandprices.manageprices.api.dto.PriceEntityDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public interface PriceService {
    Optional<PriceEntityDTO> findById(String id);

    List<PriceEntityDTO> findByCondition(String operativeDay, String productId, String brandId);
}
