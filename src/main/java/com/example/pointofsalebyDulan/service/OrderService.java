package com.example.pointofsalebyDulan.service;

import com.example.pointofsalebyDulan.dto.paginated.PaginatedResponseOrderDetails;
import com.example.pointofsalebyDulan.dto.request.RequestOrderSaveDTO;

public interface OrderService {
    String addOrder(RequestOrderSaveDTO requestOrderSaveDto);

    PaginatedResponseOrderDetails getAllOrderDetails(boolean status, int page, int size);
}
