package com.nimna.possystemlts.service.impl;

import com.nimna.possystemlts.dto.ItemDTO;
import com.nimna.possystemlts.dto.paginated.PaginatedResponseItemDTO;
import com.nimna.possystemlts.dto.request.ItemSaveRequestDTO;
import com.nimna.possystemlts.dto.response.GetItemResponseDTO;
import com.nimna.possystemlts.entity.Item;
import com.nimna.possystemlts.exception.BadRequestException;
import com.nimna.possystemlts.exception.NotFoundException;
import com.nimna.possystemlts.repository.ItemRepo;
import com.nimna.possystemlts.service.ItemService;
import com.nimna.possystemlts.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemMapper itemMapper;


    @Override
    public String save(ItemSaveRequestDTO itemSaveRequestDTO) {
//        Item item = new Item(
//                1,
//                itemSaveRequestDTO.getItemName(),
//                itemSaveRequestDTO.getMeasuringUnitType(),
//                itemSaveRequestDTO.getBalanceQty(),
//                itemSaveRequestDTO.getSellingPrice(),
//                itemSaveRequestDTO.getSupplierPrice(),
//                true
//        );

        // This is how the doing above stuff in one code line using model mapper
        Item item = modelMapper.map(itemSaveRequestDTO, Item.class);
        item.setActiveStatus(true);

        itemRepo.save(item);
        return "Item Created Successfully!";

    }

    @Override
    public ItemDTO GetItemIfActive(String itemName) {
        Item item = itemRepo.findByItemNameAndActiveStatusIsTrue(itemName);
        System.out.println(item);
        ItemDTO itemDTO = modelMapper.map(item, ItemDTO.class);
        return itemDTO;
    }

    @Override
    public List<GetItemResponseDTO> getItemsFromStatus(boolean itemStatus) {

        List<Item> items = itemRepo.findAllByActiveStatus(itemStatus);

        if (items.size() > 0){
            List<GetItemResponseDTO> allItems = modelMapper.map(items, new TypeToken<List<GetItemResponseDTO>>(){}.getType());
            return allItems;
        }else{
            throw new RuntimeException("Not Found");
        }
    }

    @Override
    public List<GetItemResponseDTO> getItemsFromStatusUsingMapStruct(boolean itemStatus) {
        List<Item> items = itemRepo.findAllByActiveStatus(itemStatus);

        if (items.size() > 0){
            List<GetItemResponseDTO> allItems = itemMapper.entityListToDtoList(items);
            return allItems;

        }else{
            throw new RuntimeException("Not Found");
        }
    }

    @Override
    public PaginatedResponseItemDTO getAllItems(int pageNumber, int pageSize) {
        Page<Item>  items = itemRepo.findAll(PageRequest.of(pageNumber, pageSize));

        if(items.getSize() > 0) {
            PaginatedResponseItemDTO paginatedResponseItemDTO = new PaginatedResponseItemDTO(
                    itemMapper.PageItemListToGetItemResponseDTO(items),
                    itemRepo.findAll().size()
            );
            return paginatedResponseItemDTO;
        }else {
            throw new NotFoundException("No Items Found");
        }
    }

    @Override
    public PaginatedResponseItemDTO getAllItemsFromStatus(boolean status, int page, int size) {
        if(size > 10){
            throw new BadRequestException("Page size should not exceed 10");
        }

        Page<Item> items = itemRepo.findAllByActiveStatus(status, PageRequest.of(page, size));

        if(items.getSize() > 1) {
            PaginatedResponseItemDTO paginatedResponseItemDTO = new PaginatedResponseItemDTO(
                    itemMapper.PageItemListToGetItemResponseDTO(items),
                    itemRepo.countAllByActiveStatus(status)
            );

            return  paginatedResponseItemDTO;
        }else{
            throw new NotFoundException("No Items Found");
        }

    }
}
