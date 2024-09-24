package com.itemsandprices.manageprices.api.controller;

import com.itemsandprices.manageprices.domain.dto.PriceEntityDto;
import com.itemsandprices.manageprices.service.impl.PriceServiceImpl;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/itemsAndPrices")
@RestController
@Slf4j
public class ItemsAndPricesController {
    private final PriceServiceImpl priceServiceImpl;

    public ItemsAndPricesController(PriceServiceImpl priceServiceImpl) {
        this.priceServiceImpl = priceServiceImpl;
    }


    @GetMapping("/{id}")
    public ResponseEntity<PriceEntityDto> findById(@PathVariable("id") String id) {
        PriceEntityDto price = priceServiceImpl.findById(id);
        return ResponseEntity.ok(price);
    }

    @GetMapping("/page-query")
    public ResponseEntity<Page<PriceEntityDto>> pageQuery(@Valid @RequestBody PriceEntityDto priceDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {

        Page<PriceEntityDto> pricePage = priceServiceImpl.findByCondition(null, null, null, pageable);
        return ResponseEntity.ok(pricePage);
    }
}
