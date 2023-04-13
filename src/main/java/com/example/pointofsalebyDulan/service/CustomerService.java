package com.example.pointofsalebyDulan.service;

import com.example.pointofsalebyDulan.dto.CustomerDTO;
import com.example.pointofsalebyDulan.dto.request.RequestCustomerDTO;

import java.util.List;

public interface CustomerService {
    String saveCustomerInIMPL(CustomerDTO customerDTO);

    String updateCustomerIMPL(RequestCustomerDTO requestCustomerDTO);

    CustomerDTO searchCustomerIMPL(int customerId);

    List<CustomerDTO> getAllCustomers();

    String deleteCustomerIMPL(int customerId);
}
