package com.microservices.myview.inventoryservice.controller;

import com.microservices.myview.inventoryservice.model.Inventory;
import com.microservices.myview.inventoryservice.repository.InventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
@Slf4j
public class InventoryRestController {
    private final InventoryRepository inventoryRepository;
    @GetMapping("/{skuCode}")
    public Boolean isInStock(@PathVariable String skuCode){
        log.info("Checking stock for product with skucode - " + skuCode);
        Inventory inventory = inventoryRepository.findBySkuCode(skuCode)
                .orElseThrow(() -> new RuntimeException("Cannot find product with sku code:- " + skuCode));
        return inventory.getStock() > 0;
    }
}
