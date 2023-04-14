package com.example.pointofsalebyDulan.controller;

import com.example.pointofsalebyDulan.dto.CustomerDTO;
import com.example.pointofsalebyDulan.dto.request.RequestUpdateCustomerDTO;
import com.example.pointofsalebyDulan.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/customer")
public class Customer {
    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/save")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO){
        String saveCust = customerService.saveCustomerInIMPL(customerDTO);
        return saveCust;
    }

    @PutMapping(path = "/update")
    public String updateCustomer(@RequestBody RequestUpdateCustomerDTO requestUpdateCustomerDTO){
        String updateCust = customerService.updateCustomerIMPL(requestUpdateCustomerDTO);
        return updateCust;
    }

    @GetMapping(
            path = "/search-by-id",
            params = "id"
    )
    public CustomerDTO searchCustomer(@RequestParam (value= "id") int customerId){
        CustomerDTO foundCustomer = customerService.searchCustomerIMPL(customerId);
        return foundCustomer;
    }

    @GetMapping(path = "/get-all-custoemr")
    public List<CustomerDTO> allCustomers(){
        List<CustomerDTO> getCustomer = customerService.getAllCustomers();
        return getCustomer;
    }

    @DeleteMapping(path = "/delete-customer",params = "id")
    public String deleteCustomer(@RequestParam(value = "id") int customerId){
        System.out.println("deleted");
        String deletedCustomer = customerService.deleteCustomerIMPL(customerId);
        return deletedCustomer;
    }

    @GetMapping(
            path = "/search-by-nic",
            params = "nic"
    )
    public CustomerDTO searchCustomer(@RequestParam (value= "nic") String customerNic){
        CustomerDTO foundCustomer = customerService.searchCustomerByNicIMPL(customerNic);
        return foundCustomer;
    }


}
