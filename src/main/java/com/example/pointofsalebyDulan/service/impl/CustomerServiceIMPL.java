package com.example.pointofsalebyDulan.service.impl;

import com.example.pointofsalebyDulan.dto.CustomerDTO;
import com.example.pointofsalebyDulan.dto.request.RequestUpdateCustomerDTO;
import com.example.pointofsalebyDulan.entity.Customer;
import com.example.pointofsalebyDulan.repo.CustomerRepo;
import com.example.pointofsalebyDulan.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceIMPL implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Override

    public String saveCustomerInIMPL(CustomerDTO customerDTO) {

        Customer customer = new Customer(
                customerDTO.getName(),
                customerDTO.getNic(),
                customerDTO.getSalary(),
                customerDTO.getAddress(),
                customerDTO.getTp(),
                customerDTO.isActive()
        );
        customerRepo.save(customer);
        return (customerDTO.getName() + " , ID is " + customerDTO.getId() + " is saved");
    }

    @Override
    public String updateCustomerIMPL(RequestUpdateCustomerDTO requestUpdateCustomerDTO) {
        Customer updateCustomer = customerRepo.getById(requestUpdateCustomerDTO.getId());

        updateCustomer.setName(requestUpdateCustomerDTO.getName());
        updateCustomer.setNic(requestUpdateCustomerDTO.getNic());
        updateCustomer.setSalary(requestUpdateCustomerDTO.getSalary());

        customerRepo.save(updateCustomer);

        return requestUpdateCustomerDTO.getName() + " is updated";
    }

    @Override
    public CustomerDTO searchCustomerIMPL(int customerId) {
        Optional<Customer> customerFromDB = customerRepo.findById(customerId);
        if (customerFromDB.isPresent()) {
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

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> entityTypeCustomers = customerRepo.findAll();
        List<CustomerDTO> dtoTypeCustomers = new ArrayList<>();
        for (Customer c : entityTypeCustomers
        ) {
            CustomerDTO custDTO = new CustomerDTO(
                    c.getId(),
                    c.getName(),
                    c.getNic(),
                    c.getSalary(),
                    c.getAddress(),
                    c.getTp(),
                    c.isActive()
            );
            dtoTypeCustomers.add(custDTO);
        }
        return dtoTypeCustomers;
    }

    @Override
    public String deleteCustomerIMPL(int customerId) {
        customerRepo.deleteById(customerId);
        return "deleted";
    }

    @Override
    public CustomerDTO searchCustomerByNicIMPL(String customerNic) {
        Optional<Customer> customerFromDB = customerRepo.findCustomersByNicEquals(customerNic);
        if (customerFromDB.isPresent()) {
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
