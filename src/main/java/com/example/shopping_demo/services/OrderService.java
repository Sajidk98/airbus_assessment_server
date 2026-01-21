package com.example.shopping_demo.services;

import com.example.shopping_demo.Modal.Inventory;
import com.example.shopping_demo.dto.OrderRequest;
import com.example.shopping_demo.exceptions.ItemNotFoundException;
import com.example.shopping_demo.exceptions.OutOfStockException;
import com.example.shopping_demo.repositories.InventoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Transactional
    public Inventory placeOrder(OrderRequest orderRequest) {
        Inventory inventory = inventoryRepository.findById(orderRequest.id())
                .orElseThrow(() -> new ItemNotFoundException("Product not found"));

        if(inventory.getStock() < 1){
            throw new OutOfStockException("Out of Stock");
        }
        /*
            place order - order table
        */

        inventory.setStock(inventory.getStock() - 1);
        inventoryRepository.save(inventory);

        return inventory;
    }
}
