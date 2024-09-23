package com.itemsandprices.manageprices.service;

import com.itemsandprices.manageprices.dto.PriceDto;
import com.itemsandprices.manageprices.dto.PriceEntityDto;
import com.itemsandprices.manageprices.entity.PriceEntity;
import com.itemsandprices.manageprices.mapper.PriceMapper;
import com.itemsandprices.manageprices.repository.PriceRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class PriceService {
    private final PriceRepository repository;
    private final PriceMapper priceMapper;

    public PriceService(PriceRepository repository, PriceMapper priceMapper) {
        this.repository = repository;
        this.priceMapper = priceMapper;
    }

    public PriceEntityDto save(PriceEntityDto priceDto) {
        PriceEntity entity = priceMapper.toEntity(priceDto);
        return priceMapper.toDto(repository.save(entity));
    }

    public void deleteById(String id) {
        repository.deleteById(id);
    }

    public PriceEntityDto findById(String id) {
        return priceMapper.toDto(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new));
    }

    public Page<PriceEntityDto> findByCondition(PriceEntityDto priceDto, Pageable pageable) {
        Page<PriceEntity> entityPage = repository.findAll(pageable);
        List<PriceEntity> entities = entityPage.getContent();
        return new PageImpl<>(priceMapper.toDto(entities), pageable, entityPage.getTotalElements());
    }

    public PriceEntityDto update(PriceEntityDto priceDto, String id) {
        PriceEntityDto data = findById(id);
        PriceEntity entity = priceMapper.toEntity(priceDto);
        BeanUtil.copyProperties(data, entity);
        return save(priceMapper.toDto(entity));
    }
}
