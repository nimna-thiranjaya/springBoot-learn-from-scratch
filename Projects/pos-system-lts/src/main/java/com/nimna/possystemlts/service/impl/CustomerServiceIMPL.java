package com.nimna.possystemlts.service.impl;


import com.nimna.possystemlts.dto.CustomerDTO;
import com.nimna.possystemlts.dto.request.CustomerUpdateDTO;
import com.nimna.possystemlts.entity.Customer;
import com.nimna.possystemlts.repository.CustomerRepo;
import com.nimna.possystemlts.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public CustomerDTO getCustomerByID(int customerId) {
        if(customerRepo.existsById(customerId)){
            Customer customer = customerRepo.getReferenceById(customerId);
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerID(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.getCustomerSalary(),
                    customer.isActive()
            );
            return customerDTO;
        }else {
            throw new RuntimeException("No Customer Found");
        }
    }

    @Override
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> allCustomers = customerRepo.findAll();
//      System.out.println(allCustomers);

        List<CustomerDTO> customerDTOList = new ArrayList<>();
        // Mapping data using for loop
//        for(int i =0; i<allCustomers.size(); i++) {
//            CustomerDTO customerDTO = new CustomerDTO(
//                    allCustomers.get(i).getCustomerID(),
//                    allCustomers.get(i).getCustomerName(),
//                    allCustomers.get(i).getCustomerAddress(),
//                    allCustomers.get(i).getContactNumber(),
//                    allCustomers.get(i).getNic(),
//                    allCustomers.get(i).getCustomerSalary(),
//                    allCustomers.get(i).isActive()
//            );
//            customerDTOList.add(customerDTO);
//        }
//        System.out.println(customerDTOList);

        // Mapping data using for loopEach

        for (Customer customer : allCustomers) {
            CustomerDTO customerDTO = new CustomerDTO(
                    customer.getCustomerID(),
                    customer.getCustomerName(),
                    customer.getCustomerAddress(),
                    customer.getContactNumber(),
                    customer.getNic(),
                    customer.getCustomerSalary(),
                    customer.isActive()
            );
            customerDTOList.add(customerDTO);
        }
        return customerDTOList;
    }
}
