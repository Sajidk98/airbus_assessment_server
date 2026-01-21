package com.example.shopping_demo.controllers;

import com.example.shopping_demo.Modal.Inventory;
import com.example.shopping_demo.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/shop")
public class ShopController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping()
    public ResponseEntity<List<Inventory>> getItemList(){
        return ResponseEntity.ok(inventoryService.getItem());
    }
}
