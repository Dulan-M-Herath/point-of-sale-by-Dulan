package com.example.pointofsalebyDulan.service;

import com.example.pointofsalebyDulan.dto.CustomerDTO;
import com.example.pointofsalebyDulan.dto.request.RequestCustomerDTO;

public interface CustomerService {
    String saveCustomerInIMPL(CustomerDTO customerDTO);

    String updateCustomerIMPL(RequestCustomerDTO requestCustomerDTO);

    CustomerDTO searchCustomerIMPL(int customerId);
}
