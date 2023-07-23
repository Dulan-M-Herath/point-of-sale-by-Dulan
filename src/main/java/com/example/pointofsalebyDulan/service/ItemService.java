package com.example.pointofsalebyDulan.service;

import com.example.pointofsalebyDulan.dto.ItemDTO;
import com.example.pointofsalebyDulan.dto.paginated.PaginatedResponseItemDto;
import com.example.pointofsalebyDulan.dto.request.RequestItemSaveDTO;

import java.util.List;

public interface ItemService {
    String saveItemInIMPL(RequestItemSaveDTO itemSaveDTO);

    List<ItemDTO> getAllItemsByName(String item_name);

    PaginatedResponseItemDto getAllItemsActive(int page, int size, boolean activeState);
}
