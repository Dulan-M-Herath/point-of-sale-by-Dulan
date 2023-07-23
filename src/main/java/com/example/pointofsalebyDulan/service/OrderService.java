package com.example.pointofsalebyDulan.service;

import com.example.pointofsalebyDulan.dto.request.RequestOrderSaveDto;

public interface OrderService {
    String addOrder(RequestOrderSaveDto requestOrderSaveDto);
}
