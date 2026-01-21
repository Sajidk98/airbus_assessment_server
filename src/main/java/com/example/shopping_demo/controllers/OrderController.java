package com.example.shopping_demo.controllers;

import com.example.shopping_demo.Modal.Inventory;
import com.example.shopping_demo.dto.OrderRequest;
import com.example.shopping_demo.exceptions.ItemNotFoundException;
import com.example.shopping_demo.exceptions.OutOfStockException;
import com.example.shopping_demo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/buy")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping()
    public ResponseEntity<String> placeOrder(@RequestBody OrderRequest reqBody){
        Inventory inventory = orderService.placeOrder(reqBody);
        return ResponseEntity.status(HttpStatus.CREATED).body("Order placed successfully for: "+inventory.getName()+ "--"+inventory.getId());
    }

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<String> handleItemNotFoundException(ItemNotFoundException ex){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(OutOfStockException.class)
    public ResponseEntity<String> handleItemNotFoundException(OutOfStockException ex){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
    }

}
