package com.itemsandprices.manageprices.service.impl;

import com.itemsandprices.manageprices.api.dto.PriceEntityDTO;
import com.itemsandprices.manageprices.infraestructure.mapper.PriceMapper;
import com.itemsandprices.manageprices.domain.repository.PriceRepository;
import com.itemsandprices.manageprices.service.PriceService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class PriceServiceImpl implements PriceService {
    private final PriceRepository repository;
    private final PriceMapper priceMapper;

    public PriceServiceImpl(PriceRepository repository, PriceMapper priceMapper) {
        this.repository = repository;
        this.priceMapper = priceMapper;
    }

    @Override
    public Optional<PriceEntityDTO> findById(String id) {
        return Optional.ofNullable(priceMapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new)));
    }

    @Override
    public List<PriceEntityDTO> findByCondition(String operativeDay, String productId, String brandId) {
        return priceMapper.toDto(repository.findByStartDateAndBrandIdAndProductId(operativeDay, productId, brandId));
    }
}
