package com.itemsandprices.manageprices.api.controller;

import com.itemsandprices.manageprices.api.dto.PriceEntityDTO;
import com.itemsandprices.manageprices.service.impl.PriceServiceImpl;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/api/itemsAndPrices")
@RestController
@Slf4j
public class ItemsAndPricesController {
    private final PriceServiceImpl priceServiceImpl;

    public ItemsAndPricesController(PriceServiceImpl priceServiceImpl) {
        this.priceServiceImpl = priceServiceImpl;
    }
/*
    @GetMapping("/{id}")
    public ResponseEntity<PriceEntityDao> findById(@PathVariable("id") String id) {
        Optional<PriceEntityDao> price = priceServiceImpl.findById(id);
        return price.map(priceRecovered -> ResponseEntity.ok().body(priceRecovered)).orElse(ResponseEntity.notFound().build());
    }
*/

    @GetMapping("/getItems")
    public ResponseEntity<List<PriceEntityDTO>> getitems(@Valid @RequestParam String operativeDate, @Valid @RequestParam String productId, @Valid @RequestParam String brandId) {
        List<PriceEntityDTO> priceList = priceServiceImpl.findByCondition(operativeDate, productId, brandId);
        return ResponseEntity.ok().body(priceList);
    }
}
