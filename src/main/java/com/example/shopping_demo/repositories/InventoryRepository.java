package com.example.shopping_demo.repositories;

import com.example.shopping_demo.Modal.Inventory;
import jakarta.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    Optional<Inventory> findById(Long id);
//    @Query("select i from Inventory i where i.id = :id")
//    Optional<Inventory> findByIdForUpdate(Long id);
}
