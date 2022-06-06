package com.microservices.myview.inventoryservice.bootstrap;

import com.microservices.myview.inventoryservice.model.Inventory;
import com.microservices.myview.inventoryservice.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final InventoryRepository inventoryRepository;

    public DataLoader(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if(inventoryRepository.findAll().size() == 0){
            loadData();
        }
    }

    private void loadData() {
        Inventory inventory = new Inventory();
        inventory.setStock(100);
        inventory.setSkuCode("IPHONE_12_RED");
        inventoryRepository.save(inventory);
        Inventory inventory1 = new Inventory();
        inventory1.setStock(0);
        inventory1.setSkuCode("IPHONE_12_GREY");
        inventoryRepository.save(inventory1);
        System.out.println("Saved Inventories");
    }
}
