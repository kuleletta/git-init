package com.itel.SimpleInventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SimpleInventoryApplication {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SimpleInventoryApplication.class, args);
		InventoryMenuService menuService = context.getBean(InventoryMenuService.class);
		menuService.displayMenu();
	}

}
