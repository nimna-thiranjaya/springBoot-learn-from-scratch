package com.nimna.inventoryService.repository;

import com.nimna.inventoryService.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long > {
    Optional<Inventory> findBySkuCode(String skuCode);
}
