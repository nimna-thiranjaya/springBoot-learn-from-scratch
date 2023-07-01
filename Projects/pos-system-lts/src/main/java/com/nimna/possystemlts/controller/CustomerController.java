package com.nimna.possystemlts.controller;

import com.nimna.possystemlts.dto.CustomerDTO;
import com.nimna.possystemlts.service.CustomerService;
import com.nimna.possystemlts.service.impl.CustomerServiceIMPL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class  CustomerController {

    // This is the dependency injection. in here using autowired annotation we can create object from service class tha we annotate using @Service anotation
    // this is same as singleton design pattern
    @Autowired
    private CustomerService customerService;

    @PostMapping("register")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO) {
//        old method to call service class Currently this method not using because when we use this method over and over it crate object in heap
//        CustomerServiceIMPL customerServiceIMPL = new CustomerServiceIMPL();
//        customerServiceIMPL.saveCustomer(customerDTO);
        customerService.saveCustomer(customerDTO);
        return "Data Saved Successfully";
    }
}