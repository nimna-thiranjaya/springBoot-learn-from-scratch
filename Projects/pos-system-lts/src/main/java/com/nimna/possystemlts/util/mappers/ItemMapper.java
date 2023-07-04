package com.nimna.possystemlts.util.mappers;

import com.nimna.possystemlts.dto.response.GetItemResponseDTO;
import com.nimna.possystemlts.entity.Item;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ItemMapper {

    List<GetItemResponseDTO> entityListToDtoList(List<Item> items);
}
