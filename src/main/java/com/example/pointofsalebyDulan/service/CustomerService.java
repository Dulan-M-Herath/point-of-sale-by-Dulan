package com.example.pointofsalebyDulan.service;

import com.example.pointofsalebyDulan.dto.CustomerDTO;
import com.example.pointofsalebyDulan.dto.request.RequestUpdateCustomerDTO;

import java.util.List;

public interface CustomerService {
    String saveCustomerInIMPL(CustomerDTO customerDTO);

    String updateCustomerIMPL(RequestUpdateCustomerDTO requestUpdateCustomerDTO);

    CustomerDTO searchCustomerIMPL(int customerId);

    List<CustomerDTO> getAllCustomers();

    String deleteCustomerIMPL(int customerId);

    CustomerDTO searchCustomerByNicIMPL(String customerNic);
}
