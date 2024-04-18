package com.itel.SimpleInventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

@Service
public class InventoryMenuService {

    private final InventoryService inventoryService;
    private final Scanner scanner;

    @Autowired
    public InventoryMenuService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
        this.scanner = new Scanner(System.in);
    }


    public void displayMenu() {

        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Item");
            System.out.println("2. Display Inventory");
            System.out.println("3. Display Product");
            System.out.println("4. Exit");

            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        addItem();
                        break;
                    case 2:
                        inventoryService.getInventory().forEach(System.out::println);
                        break;
                    case 3:
                        System.out.print("Enter product name: ");
                        String productName = scanner.nextLine();
                        Product product = inventoryService.showDetails(productName);
                        if (product != null) {
                            System.out.println(product);
                        } else {
                            System.out.println("Product does not exist.");
                        }
                        break;
                    case 4:
                        System.out.print("Exiting program...");
                        System.exit(0);
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Try again");
                scanner.nextLine();
            }
        }
    }

    private void addItem() {
        System.out.print("Enter product name: ");
        String name = scanner.nextLine();

        System.out.print("Enter product price: ");
        BigDecimal price = scanner.nextBigDecimal();

        System.out.print("Enter product quantity: ");
        long quantity = scanner.nextLong();

        Category category;
        do {
            System.out.print("Enter product category (");
            for (Category category1 : Category.values()) {
                if(category1 != Category.valueOf("TOYS")){
                    System.out.print(category1 + ", ");
                }else {
                    System.out.print(category1);
                }
            }
            System.out.print("): ");
            String userInput = scanner.next().toUpperCase();
            try {
                category = Category.valueOf(userInput);
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid category. Try again");
                continue;
            }
            break;
        } while (true);

        inventoryService.addItemToInventory(name, price, quantity, category);
    }
}