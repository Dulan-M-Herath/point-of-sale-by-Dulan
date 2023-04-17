package com.example.pointofsalebyDulan.controller;

import com.example.pointofsalebyDulan.dto.CustomerDTO;
import com.example.pointofsalebyDulan.dto.ItemDTO;
import com.example.pointofsalebyDulan.dto.request.RequestItemSaveDTO;
import com.example.pointofsalebyDulan.exception.NotFoundException;
import com.example.pointofsalebyDulan.service.ItemService;
import com.example.pointofsalebyDulan.util.StandardResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/item")
public class Item {

    @Autowired
    private ItemService itemService;


    @PostMapping(path = "/save-item")
    public ResponseEntity<StandardResponse> addItem(@RequestBody RequestItemSaveDTO itemSaveDTO){
        String s = itemService.saveItemInIMPL(itemSaveDTO);
        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success","Item Saved"), HttpStatus.OK);

        return response; // This is the industry Standard.
    }

    @GetMapping(
            path = "get-by-name",
            params = "name"
    )
    private List<ItemDTO> getItemByName(@RequestParam(value = "name") String item_name){

        List<ItemDTO> itemByName = itemService.getAllItemsByName(item_name);
        return itemByName; // This is not the industry standard, ResponseEntity is the way.
    }

    @GetMapping(
            path = "get-by-name-1",
            params = "name"
    )
    private ResponseEntity<StandardResponse> getItemByName1(@RequestParam(value = "name") String item_name) {

        List<ItemDTO> itemByName = itemService.getAllItemsByName(item_name);
        if (itemByName.size() > 0) {
            ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
                    new StandardResponse(200, "Success", itemByName), HttpStatus.OK);

            return response;

        } else {
            throw new NotFoundException("Not Found");
        }

        // Otherwise we can use return(new ResponseEntity<StandardResponse>(
    }    //                new StandardResponse(200,"Success",itemByName), HttpStatus.OK);
}
