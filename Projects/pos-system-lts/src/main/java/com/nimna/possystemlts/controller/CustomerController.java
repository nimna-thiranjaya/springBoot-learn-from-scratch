package com.nimna.possystemlts.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    public String saveCustomer(){
        return  "Customer Created";
    }
}
