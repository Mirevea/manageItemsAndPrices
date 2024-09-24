package com.itemsandprices.manageprices.api.controller;

import com.itemsandprices.manageprices.domain.entity.dao.PriceEntityDao;
import com.itemsandprices.manageprices.service.impl.PriceServiceImpl;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RequestMapping("/api/itemsAndPrices")
@RestController
@Slf4j
public class ItemsAndPricesController {
    private final PriceServiceImpl priceServiceImpl;

    public ItemsAndPricesController(PriceServiceImpl priceServiceImpl) {
        this.priceServiceImpl = priceServiceImpl;
    }


    @GetMapping("/{id}")
    public ResponseEntity<PriceEntityDao> findById(@PathVariable("id") String id) {
        Optional<PriceEntityDao> price = priceServiceImpl.findById(id);
        return price.map(priceRecovered -> ResponseEntity.ok().body(priceRecovered)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/page-query")
    public ResponseEntity<PageImpl<PriceEntityDao>> pageQuery(@Valid @RequestBody PriceEntityDao priceEntityDao, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {

        Page<PriceEntityDao> pricePage = priceServiceImpl.findByCondition(priceEntityDao.getStartDate(), Long.valueOf(priceEntityDao.getBrandId()), priceEntityDao.getProductId(), pageable);
        return ResponseEntity.ok((PageImpl<PriceEntityDao>) pricePage);
    }
}
