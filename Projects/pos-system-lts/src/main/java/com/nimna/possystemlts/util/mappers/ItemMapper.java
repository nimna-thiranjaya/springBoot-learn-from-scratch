package com.nimna.possystemlts.util.mappers;

import com.nimna.possystemlts.dto.paginated.PaginatedResponseItemDTO;
import com.nimna.possystemlts.dto.response.GetItemResponseDTO;
import com.nimna.possystemlts.entity.Item;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    List<GetItemResponseDTO> entityListToDtoList(List<Item> items);
    List<GetItemResponseDTO> PageItemListToGetItemResponseDTO(Page<Item> items);
}

