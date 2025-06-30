package com.nimnadev.spring_web_flux.controller;

import com.nimnadev.spring_web_flux.dto.Customer;
import com.nimnadev.spring_web_flux.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("/customers")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping("getCustomers")
    private List<Customer> getCustomers() {
        return customerService.loadAllCustomers();
    }

    @GetMapping(value ="getCustomersStream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    private Flux<Customer> getCustomersStream() {
        return customerService.loadAllCustomersStream();
    }
}
