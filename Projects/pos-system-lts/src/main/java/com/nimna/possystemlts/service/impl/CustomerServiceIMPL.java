package com.nimna.possystemlts.service.impl;


import com.nimna.possystemlts.dto.CustomerDTO;
import com.nimna.possystemlts.dto.request.CustomerUpdateDTO;
import com.nimna.possystemlts.entity.Customer;
import com.nimna.possystemlts.repository.CustomerRepo;
import com.nimna.possystemlts.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
//        System.out.println("Customer Service Impl Triggered");

        Customer customer = new Customer(
                customerDTO.getCustomerID(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getContactNumber(),
                customerDTO.getNic(),
                customerDTO.getCustomerSalary(),
                customerDTO.isActive()
        );

        // this methos also we can use to set data to entity
        // Customer customerM2 = new Customer();
        // customerM2.setCustomerID(customerDTO.getCustomerID());

        customerRepo.save(customer);
        return "Customer Created Successful!";
    }

    @Override
    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO) {
        if(customerRepo.existsById(customerUpdateDTO.getCustomerID())) {
            Customer customer = customerRepo.getReferenceById(customerUpdateDTO.getCustomerID());

            customer.setCustomerName(customerUpdateDTO.getCustomerName());
            customer.setCustomerAddress(customerUpdateDTO.getCustomerAddress());
            customer.setCustomerSalary(customerUpdateDTO.getCustomerSalary());

            customerRepo.save(customer);

            return  customer.getCustomerName() + " Updated Successful!";
        }else {
            throw new RuntimeException("No Customer Found");
        }
    }
}
