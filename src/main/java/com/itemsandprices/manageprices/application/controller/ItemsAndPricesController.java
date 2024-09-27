package com.itemsandprices.manageprices.application.controller;

import com.itemsandprices.manageprices.application.dto.PriceEntityDTO;
import com.itemsandprices.manageprices.service.impl.PriceServiceImpl;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
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
/*
    @GetMapping("/{id}")
    public ResponseEntity<PriceEntityDao> findById(@PathVariable("id") String id) {
        Optional<PriceEntityDao> price = priceServiceImpl.findById(id);
        return price.map(priceRecovered -> ResponseEntity.ok().body(priceRecovered)).orElse(ResponseEntity.notFound().build());
    }
*/

    @GetMapping("/getItems")
    public ResponseEntity<PriceEntityDTO> getItems(@Valid @RequestParam String operativeDate, @Valid @RequestParam String productId, @Valid @RequestParam String brandId) {
        /*Optional<PriceEntityDTO> priceDTO = priceServiceImpl.findByCondition(operativeDate, productId, brandId);
        return priceDTO.map(priceRecovered -> ResponseEntity.ok().body(priceRecovered)).orElse(ResponseEntity.notFound().build());*/
        return ResponseEntity.ok().body(priceServiceImpl.findByCondition(operativeDate, productId, brandId));
    }
}
