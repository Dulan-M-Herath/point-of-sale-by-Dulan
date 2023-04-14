package com.example.pointofsalebyDulan.service;

import com.example.pointofsalebyDulan.dto.ItemDTO;
import com.example.pointofsalebyDulan.dto.request.RequestItemSaveDTO;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ItemService {
    String saveItemInIMPL(RequestItemSaveDTO itemSaveDTO);

    List<ItemDTO> getAllItemsByName(String item_name);
}
