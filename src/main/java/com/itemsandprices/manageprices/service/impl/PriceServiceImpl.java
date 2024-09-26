package com.itemsandprices.manageprices.service.impl;

import com.itemsandprices.manageprices.api.dto.PriceEntityDTO;
import com.itemsandprices.manageprices.infraestructure.dao.PriceEntityDAO;
import com.itemsandprices.manageprices.infraestructure.mapper.PriceMapper;
import com.itemsandprices.manageprices.domain.repository.PriceRepository;
import com.itemsandprices.manageprices.service.PriceService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

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
        List<PriceEntityDAO> prices = priceMapper.toDaoList(repository.findByStartDateAndBrandIdAndProductId(operativeDay, brandId, productId));

        PriceEntityDAO priceEntityDAO = prices.stream()
                .max(Comparator.comparingInt(price -> Integer.parseInt(price.getPriority()))) // Convertir a entero
                .orElseThrow(() -> new ResourceNotFoundException("No price found")
        );

        PriceEntityDTO priceDTO = priceMapper.toDto(priceEntityDAO);
        priceDTO.setFinalPrice(priceEntityDAO.getPrice() + " " + priceEntityDAO.getCurr());
        return priceDTO;

        /*return Optional.ofNullable(priceMapper
                .toDto(priceMapper
                        .toDaoList(repository.findByStartDateAndBrandIdAndProductId(operativeDay, brandId, productId))
                        .stream()
                        .max(Comparator.comparingInt(price -> Integer.parseInt(price.getPriority()))) // Convertir a entero
                        .orElseThrow(() -> new ResourceNotFoundException("No price found"))
                )
        );*/

    }
}
