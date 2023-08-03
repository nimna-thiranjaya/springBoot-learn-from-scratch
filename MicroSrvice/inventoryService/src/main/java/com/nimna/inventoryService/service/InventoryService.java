package com.nimna.inventoryService.service;

import com.nimna.inventoryService.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class InventoryService {
    @Autowired
    private InventoryRepository inventoryRepository;
    public boolean isInStoke(String skuCode){
        return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }
}
