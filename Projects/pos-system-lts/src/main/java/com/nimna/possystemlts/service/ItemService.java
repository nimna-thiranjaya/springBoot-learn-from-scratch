package com.nimna.possystemlts.service;

import com.nimna.possystemlts.dto.ItemDTO;
import com.nimna.possystemlts.dto.request.ItemSaveRequestDTO;
import com.nimna.possystemlts.dto.response.GetItemResponseDTO;

import java.util.List;

public interface ItemService {
    public String save(ItemSaveRequestDTO itemDTO);

    public ItemDTO GetItemIfActive(String itemName);

    public List<GetItemResponseDTO> getItemsFromStatus(boolean itemStatus);
}