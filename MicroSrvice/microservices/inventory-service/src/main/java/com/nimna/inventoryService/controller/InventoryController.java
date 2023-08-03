package com.nimna.inventoryService.controller;

import com.nimna.inventoryService.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
@RequestMapping("api/v1/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;
    @GetMapping(path = "get-status/{sku-code}")
    @ResponseStatus(HttpStatus.OK)
    public boolean  isInStoke(@PathVariable(name = "sku-code") String skuCode){
        return inventoryService.isInStoke(skuCode);
    }
}
