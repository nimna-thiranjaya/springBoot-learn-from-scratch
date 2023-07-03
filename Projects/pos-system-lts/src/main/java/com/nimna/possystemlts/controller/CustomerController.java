package com.nimna.possystemlts.controller;

import com.nimna.possystemlts.dto.CustomerDTO;
import com.nimna.possystemlts.dto.request.CustomerUpdateDTO;
import com.nimna.possystemlts.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class  CustomerController {

    // This is the dependency injection. in here using autowired annotation we can create object from service class tha we annotate using @Service anotation
    // this is same as singleton design pattern
    // This is actually property injection
    @Autowired
    private CustomerService customerService;

    @PostMapping("register")
    public String saveCustomer(@RequestBody CustomerDTO customerDTO) {
//        old method to call service class Currently this method not using because when we use this method over and over it crate object in heap
//        CustomerServiceIMPL customerServiceIMPL = new CustomerServiceIMPL();
//        customerServiceIMPL.saveCustomer(customerDTO);
        String message = customerService.saveCustomer(customerDTO);
        return message;
    }

    @PutMapping("/update")
    public String updateCustomer (@RequestBody CustomerUpdateDTO customerUpdateDTO){
        String message = customerService.updateCustomer(customerUpdateDTO);
        return message;
    }

//    @GetMapping(path = "/get-one-customer")
//    public CustomerDTO getCustomerByID (@RequestParam(name = "id") int id){} we can use this as well for search

    @GetMapping(path = "/get-one-customer", params = "id")
    public CustomerDTO getCustomerByID (@RequestParam(value = "id") int customerId){
//        System.out.println("Print value : " + customerId );
        CustomerDTO customerDTO = customerService.getCustomerByID(customerId);
        return customerDTO;
    }

    @GetMapping("/get-all-customers")
    public List<CustomerDTO> getAllCustomers() {

        List<CustomerDTO> allCustomers = customerService.getAllCustomers();

        return allCustomers;
    }

    @DeleteMapping(path = "delete-customer/{id}")
    public String deleteCustomer(@PathVariable("id") int customer_id) {
        String message = customerService.deleteCustomerById(customer_id);
        return message;
    }

    @GetMapping("get-customers-from-status/{status}")
    public List<CustomerDTO> getCustomersFromStatus (@PathVariable(value = "status") Boolean activeStatus){
        List<CustomerDTO> allCustomers = customerService.getCustomersByStatus(activeStatus);
        return allCustomers;
    }
}