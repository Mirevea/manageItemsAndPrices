package com.itemsandprices.manageprices.controller;

import com.itemsandprices.manageprices.dto.PriceDto;
import com.itemsandprices.manageprices.dto.PriceEntityDto;
import com.itemsandprices.manageprices.service.PriceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/itemsAndPrices")
@RestController
@Slf4j
public class ItemsAndPricesController {
    private final PriceService priceService;

    public ItemsAndPricesController(PriceService priceService) {
        this.priceService = priceService;
    }

/*    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Validated PriceDto priceDto) {
        priceService.save(priceDto);
        return ResponseEntity.ok().build();
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<PriceEntityDto> findById(@PathVariable("id") String id) {
        PriceEntityDto price = priceService.findById(id);
        return ResponseEntity.ok(price);
    }

/*    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        Optional.ofNullable(priceService.findById(id)).orElseThrow(() -> {
            log.error("Unable to delete non-existent data!");
            return new ResourceNotFoundException();
        });
        priceService.deleteById(id);
        return ResponseEntity.ok().build();
    }*/

    @GetMapping("/page-query")
    public ResponseEntity<Page<PriceEntityDto>> pageQuery(PriceEntityDto priceDto, @PageableDefault(sort = "createAt", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<PriceEntityDto> pricePage = priceService.findByCondition(priceDto, pageable);
        return ResponseEntity.ok(pricePage);
    }

/*    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated PriceDto priceDto, @PathVariable("id") String id) {
        priceService.update(priceDto, id);
        return ResponseEntity.ok().build();
    }*/
}
