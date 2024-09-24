package com.itemsandprices.manageprices.service.impl;

import com.itemsandprices.manageprices.api.mapper.PriceMapper;
import com.itemsandprices.manageprices.domain.dto.PriceEntityDto;
import com.itemsandprices.manageprices.domain.entity.PriceEntity;
import com.itemsandprices.manageprices.domain.repository.PriceRepository;
import com.itemsandprices.manageprices.service.PriceService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public PriceEntityDto findById(String id) {
        return priceMapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    @Override
    public Page<PriceEntityDto> findByCondition(String startDate, Long brandId, String productId, Pageable pageable) {
        Page<PriceEntity> entityPage = repository.findAll(pageable);
        List<PriceEntity> entities = entityPage.getContent();
        return new PageImpl<>(priceMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }
}
