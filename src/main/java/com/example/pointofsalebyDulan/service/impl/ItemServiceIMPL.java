package com.example.pointofsalebyDulan.service.impl;

import com.example.pointofsalebyDulan.dto.ItemDTO;
import com.example.pointofsalebyDulan.dto.paginated.PaginatedResponseItemDto;
import com.example.pointofsalebyDulan.dto.request.RequestItemSaveDTO;
import com.example.pointofsalebyDulan.entity.Item;
import com.example.pointofsalebyDulan.exception.NotFoundException;
import com.example.pointofsalebyDulan.repo.ItemRepo;
import com.example.pointofsalebyDulan.service.ItemService;
import com.example.pointofsalebyDulan.util.mappers.ItemMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceIMPL implements ItemService {


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public String saveItemInIMPL(RequestItemSaveDTO itemSaveDTO) {
        Item addedItem = modelMapper.map(itemSaveDTO, Item.class);
        if (!itemRepo.existsById(addedItem.getId())) {
            itemRepo.save(addedItem);
        }
        return "saved";
    }

    @Override
    public List<ItemDTO> getAllItemsByName(String item_name) {
        List<Item> items = itemRepo.findAllByNameAndActiveStatusIs(item_name, true);
//        List<ItemDTO> item = modelMapper.map(items, new TypeToken<List<ItemDTO>>() {
//        }.getType());
        List<ItemDTO> item = itemMapper.entityToDto(items);
        return item;
    }

    @Override
    public PaginatedResponseItemDto getAllItemsActive(int page, int size, boolean activeState) {
        Page<Item> items = itemRepo.findAllByActiveStatusEquals(activeState, PageRequest.of(page, size));
        if(items.getSize()<1){
            throw new NotFoundException("No data found");
        }
        return new PaginatedResponseItemDto(itemMapper.pageToList(items),itemRepo.countAllByActiveStatusEquals(activeState));
    }
}
