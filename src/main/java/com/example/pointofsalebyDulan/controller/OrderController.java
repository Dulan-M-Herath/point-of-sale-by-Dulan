package com.example.pointofsalebyDulan.controller;

import com.example.pointofsalebyDulan.dto.paginated.PaginatedResponseOrderDetails;
import com.example.pointofsalebyDulan.dto.request.RequestOrderSaveDTO;
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
    public ResponseEntity<StandardResponse> addItem(@RequestBody RequestOrderSaveDTO requestOrderSaveDto){

        String s = orderService.addOrder(requestOrderSaveDto);

        ResponseEntity<StandardResponse> response = new ResponseEntity<StandardResponse>(
                new StandardResponse(200,"Success","Item Saved"), HttpStatus.OK);

        return response; // This is the industry Standard.
    }

    @GetMapping(
            params = {"stateType","page","size"},
            path = {"/get-order-details"}
    )
    public ResponseEntity<StandardResponse> getAllOrderDetails(
            @RequestParam(value = "stateType") String stateType,
            @RequestParam(value = "page") int page,
            @RequestParam(value = "size") int size
    ){
        PaginatedResponseOrderDetails paginatedResponseOrderDetails = null;

        if(stateType.equalsIgnoreCase("active") ||  stateType.equalsIgnoreCase("inactive")){
            boolean status = stateType.equalsIgnoreCase("active") ? true : false;
            paginatedResponseOrderDetails= orderService.getAllOrderDetails(status,page,size);
        }
        return new ResponseEntity<StandardResponse>(new StandardResponse(200,"success",paginatedResponseOrderDetails),HttpStatus.OK);
    }
}
