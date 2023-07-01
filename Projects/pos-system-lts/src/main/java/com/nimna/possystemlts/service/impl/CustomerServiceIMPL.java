package com.nimna.possystemlts.service.impl;


import com.nimna.possystemlts.dto.CustomerDTO;
import com.nimna.possystemlts.service.CustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Override
    public String saveCustomer(CustomerDTO customerDTO) {
        System.out.println("Customer Service Impl Triggered");
        System.out.println(customerDTO.getCustomerID());
        System.out.println(customerDTO.getCustomerName());
        return "";
    }
}
