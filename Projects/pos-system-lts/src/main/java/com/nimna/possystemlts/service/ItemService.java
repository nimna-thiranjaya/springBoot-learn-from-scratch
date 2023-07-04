package com.nimna.possystemlts.service;

import com.nimna.possystemlts.dto.ItemDTO;
import com.nimna.possystemlts.dto.paginated.PaginatedResponseItemDTO;
import com.nimna.possystemlts.dto.request.ItemSaveRequestDTO;
import com.nimna.possystemlts.dto.response.GetItemResponseDTO;

import java.util.List;

public interface ItemService {
    public String save(ItemSaveRequestDTO itemDTO);

    public ItemDTO GetItemIfActive(String itemName);

    public List<GetItemResponseDTO> getItemsFromStatus(boolean itemStatus);

    public List<GetItemResponseDTO> getItemsFromStatusUsingMapStruct(boolean itemStatus);

    PaginatedResponseItemDTO getAllItems(int pageNumber, int pageSize);

    PaginatedResponseItemDTO getAllItemsFromStatus(boolean status, int page, int size);
}
