package com.itel.SimpleInventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class InventoryService {
    private Map<String, Product> inventory;

    @Autowired
    public InventoryService(Map<String, Product> inventory) {
        this.inventory = inventory;
    }

    public void addItemToInventory (String name, BigDecimal price, Long quantity,
                                    Category category){

        inventory.put(name, new Product(name, price, quantity, category));
    }

    public List<Product> getInventory(){
        return new ArrayList<>(inventory.values());
    }

    public Product showDetails(String productName) {
        return inventory.get(productName);
    }
}
