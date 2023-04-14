package com.example.pointofsalebyDulan.controller;

import com.example.pointofsalebyDulan.dto.CustomerDTO;
import com.example.pointofsalebyDulan.dto.ItemDTO;
import com.example.pointofsalebyDulan.dto.request.RequestItemSaveDTO;
import com.example.pointofsalebyDulan.service.ItemService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/item")
public class Item {

    @Autowired
    private ItemService itemService;


    @PostMapping(path = "/save-item")
    public String addItem(@RequestBody RequestItemSaveDTO itemSaveDTO){
        itemService.saveItemInIMPL(itemSaveDTO);
        return "Saved Item";
    }

    @GetMapping(
            path = "get-by-name",
            params = "name"
    )
    private List<ItemDTO> getItemByName(@RequestParam(value = "name") String item_name){

        List<ItemDTO> itemByName = itemService.getAllItemsByName(item_name);
        return itemByName;
    }
}
