package com.nimnadev.spring_web_flux.service;

import com.nimnadev.spring_web_flux.dao.CustomerDao;
import com.nimnadev.spring_web_flux.dto.Customer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerDao customerDao;

    public List<Customer> loadAllCustomers() {
        long start = System.currentTimeMillis();
        List<Customer> customers = customerDao.getCustomers();
        long end = System.currentTimeMillis();
        System.out.println("Total Execution : "+ (end-start));
        return customers;
    }

    public Flux<Customer> loadAllCustomersStream() {
        long start = System.currentTimeMillis();
        Flux<Customer> customers = customerDao.getCustomersStream();
        long end = System.currentTimeMillis();
        System.out.println("Total Execution : "+ (end-start));

        return customers;
    }
}
