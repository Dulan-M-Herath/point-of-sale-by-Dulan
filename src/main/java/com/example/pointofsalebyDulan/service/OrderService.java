package com.example.pointofsalebyDulan.service;

import com.example.pointofsalebyDulan.dto.paginated.PaginatedResponseOrderDetails;
import com.example.pointofsalebyDulan.dto.request.RequestOrderSaveDto;

public interface OrderService {
    String addOrder(RequestOrderSaveDto requestOrderSaveDto);

    PaginatedResponseOrderDetails getAllOrderDetails(boolean status, int page, int size);
}
