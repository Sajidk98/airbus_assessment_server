package com.example.shopping_demo.services;

import com.example.shopping_demo.Modal.Inventory;
import com.example.shopping_demo.repositories.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    public List<Inventory> getItem() {
        return inventoryRepository.findAll();
    }
}
