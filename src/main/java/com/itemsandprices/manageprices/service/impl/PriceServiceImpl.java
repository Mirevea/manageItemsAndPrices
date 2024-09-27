package com.itemsandprices.manageprices.service.impl;

import com.itemsandprices.manageprices.application.dto.PriceEntityDTO;
import com.itemsandprices.manageprices.domain.util.Utilities;
import com.itemsandprices.manageprices.infraestructure.dao.PriceEntityDAO;
import com.itemsandprices.manageprices.infraestructure.mapper.PriceMapper;
import com.itemsandprices.manageprices.domain.repository.PriceRepository;
import com.itemsandprices.manageprices.service.PriceService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        return Optional.ofNullable(priceMapper.toDtoFromEntity(repository.findById(id)
                .orElseThrow(ResourceNotFoundException::new)));
    }

    @Override
    public PriceEntityDTO findByCondition(String operativeDay, String productId, String brandId) {

        LocalDateTime specificTime = LocalDateTime.parse(operativeDay, DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss"));

        List<PriceEntityDAO> prices = priceMapper
                .toDaoList(repository.findByBrandIdAndProductId(Long.parseLong(brandId), productId))
                .stream()
                .filter(daoItem -> Utilities.availablePrice(daoItem, specificTime))
                .toList();

        return priceMapper.toDto(prices
                .stream()
                .max(Comparator.comparingInt(price -> Integer.parseInt(price.getPriority()))) // Convertir a entero
                .orElseThrow(() -> new ResourceNotFoundException("No prices found for product " + productId)));

    }
}
