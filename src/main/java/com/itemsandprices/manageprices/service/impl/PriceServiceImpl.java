package com.itemsandprices.manageprices.service.impl;

import com.itemsandprices.manageprices.api.mapper.PriceMapper;
import com.itemsandprices.manageprices.domain.entity.dao.PriceEntityDao;
import com.itemsandprices.manageprices.domain.entity.PriceEntity;
import com.itemsandprices.manageprices.domain.entity.dto.PriceEntityDto;
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
    public Optional<PriceEntityDao> findById(String id) {
        return Optional.ofNullable(priceMapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new)));
    }

    @Override
    public Page<PriceEntityDao> findByCondition(String startDate, Long brandId, String productId, Pageable pageable) {
        List<PriceEntity> entityList = repository.findByStartDateAndBrandIdAndProductId(startDate, brandId, productId);
        return new PageImpl<>(priceMapper.toDto(entityList));
    }
}
