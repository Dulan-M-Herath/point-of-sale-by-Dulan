package com.example.pointofsalebyDulan.service.impl;

import com.example.pointofsalebyDulan.dto.CustomerDTO;
import com.example.pointofsalebyDulan.dto.request.RequestCustomerDTO;
import com.example.pointofsalebyDulan.entity.Customer;
import com.example.pointofsalebyDulan.repo.CustomerRepo;
import com.example.pointofsalebyDulan.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;
    @Override
    public String saveCustomerInIMPL(CustomerDTO customerDTO) {

        Customer customer = new Customer(
                customerDTO.getId(),
                customerDTO.getName(),
                customerDTO.getNic(),
                customerDTO.getSalary(),
                customerDTO.getAddress(),
                customerDTO.getTp(),
                customerDTO.isActive()
        );
        customerRepo.save(customer);
        return (customerDTO.getName()+" , ID is "+customerDTO.getId()+" is saved");
    }

    @Override
    public String updateCustomerIMPL(RequestCustomerDTO requestCustomerDTO) {
        Customer updateCustomer = customerRepo.getById(requestCustomerDTO.getId());

        updateCustomer.setName(requestCustomerDTO.getName());
        updateCustomer.setNic(requestCustomerDTO.getNic());
        updateCustomer.setSalary(requestCustomerDTO.getSalary());

        customerRepo.save(updateCustomer);

        return requestCustomerDTO.getName()+" is updated";
    }

    @Override
    public CustomerDTO searchCustomerIMPL(int customerId) {
        Optional <Customer> customerFromDB = customerRepo.findById(customerId);
        if(customerFromDB.isPresent()){
            CustomerDTO custDTO = new CustomerDTO(
                customerFromDB.get().getId(),
                    customerFromDB.get().getName(),
                    customerFromDB.get().getNic(),
                    customerFromDB.get().getSalary(),
                    customerFromDB.get().getAddress(),
                    customerFromDB.get().getTp(),
                    customerFromDB.get().isActive()
            );
            return custDTO;
        }
        return null;
    }
}
