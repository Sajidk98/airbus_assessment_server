package com.example.shopping_demo.Modal;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name="inventory")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int stock;
    private BigDecimal price;
}
