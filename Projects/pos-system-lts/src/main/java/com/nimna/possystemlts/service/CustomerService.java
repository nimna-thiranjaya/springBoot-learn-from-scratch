package com.nimna.possystemlts.service;

import com.nimna.possystemlts.dto.CustomerDTO;
import com.nimna.possystemlts.dto.request.CustomerUpdateDTO;

import java.util.List;

public interface CustomerService {
    public String saveCustomer(CustomerDTO customerDTO);

    public String updateCustomer(CustomerUpdateDTO customerUpdateDTO);

    public CustomerDTO getCustomerByID(int customerId);

    public List<CustomerDTO> getAllCustomers();
}
