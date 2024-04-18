package com.itel.SimpleInventory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class AppConfig {

    @Bean
    public Map<String, Product> inventory() {

        Map<String, Product> productInventory = new HashMap<>();
//        productInventory.put("IPhone", new Product("PENSHOPPE", BigDecimal.valueOf(10.0), 1L, Category.CLOTHING));
        Product product = new Product("Iphone", BigDecimal.valueOf(11.01), 20L, Category.ELECTRONICS);
        productInventory.put("Iphone", product);
        return productInventory;
    }
}
