package com.example.shopping_demo.controllers;

import com.example.shopping_demo.Modal.Inventory;
import com.example.shopping_demo.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("api/v1/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping()
    public ResponseEntity<List<Inventory>> getItemList(){
        return ResponseEntity.ok(inventoryService.getItem());
    }
}
