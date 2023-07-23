package com.example.pointofsalebyDulan.controller;

import com.example.pointofsalebyDulan.dto.request.RequestItemSaveDTO;
import com.example.pointofsalebyDulan.dto.request.RequestOrderSaveDto;
import com.example.pointofsalebyDulan.service.OrderService;
import com.example.pointofsalebyDulan.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(path = "/save-item")
    public ResponseEntity<StandardResponse> addItem(@RequestBody RequestOrderSaveDto requestOrderSaveDto){

        String s = orderService.addOrder(requestOrderSaveDto);

        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success","Item Saved"), HttpStatus.OK);

        return response; // This is the industry Standard.
    }
}
