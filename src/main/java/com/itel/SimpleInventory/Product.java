package com.itel.SimpleInventory;

import java.math.BigDecimal;

public class Product {

    private final String name;
    private final BigDecimal price;
    private final Long quantity;
    private final Category category;
    private Status status;

    public Product(String name, BigDecimal price, Long quantity, Category category) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
        this.status = displayStatus();
    }

    @Override
    public String toString() {
        return "Product{" + "name='" + name + '\'' + ", price=" + price + ", quantity=" + quantity + ", category=" + category + ", status=" + status + '}';
    }

    private Status displayStatus() {
        if (quantity >= 1) {
            status = Status.AVAILABLE;
        } else {
            status = Status.NOT_AVAILABLE;
        }
        return status;
    }
}


