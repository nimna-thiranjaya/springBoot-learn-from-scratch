package com.nimna.possystemlts.controller;

import com.nimna.possystemlts.dto.ItemDTO;
import com.nimna.possystemlts.dto.request.ItemSaveRequestDTO;
import com.nimna.possystemlts.dto.response.GetItemResponseDTO;
import com.nimna.possystemlts.entity.Item;
import com.nimna.possystemlts.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/item")
@CrossOrigin
public class ItemController {
    @Autowired
    private ItemService itemService;

    @PostMapping("/save-item")
    public String saveItem(ItemSaveRequestDTO itemSaveRequestDTO) {
        String message = itemService.save(itemSaveRequestDTO);

        return message;
    }

    @GetMapping(
            path = "/get-item-if-active",
            params = "item_name"
    )
    public ItemDTO getItemIfActive(@RequestParam(value = "item_name") String itemName) {
        ItemDTO itemDTO = itemService.GetItemIfActive(itemName);
        return itemDTO;
    }

    @GetMapping(path = "/get-active-items", params = "status")
    public List<GetItemResponseDTO> getItemFromStatus(@RequestParam(value = "status") boolean ItemStatus) {

        List<GetItemResponseDTO> items = itemService.getItemsFromStatus(ItemStatus);

        return items;
    }

    @GetMapping(path = "/get-active-items-map-struct", params = "status")
    public List<GetItemResponseDTO> getItemFromStatusUsingMapStruct(@RequestParam(value = "status") boolean ItemStatus) {

        List<GetItemResponseDTO> items = itemService.getItemsFromStatusUsingMapStruct(ItemStatus);

        return items;
    }


}
