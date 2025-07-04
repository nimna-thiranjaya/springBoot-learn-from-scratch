package com.nimnadev.spring_web_flux.dao;

import com.nimnadev.spring_web_flux.dto.Customer;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDao {

    private static void sleepException(int i)  {
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public List<Customer> getCustomers() {
        return IntStream.rangeClosed(1,50)
                .peek(CustomerDao::sleepException)
                .peek(i-> System.out.println("Processing count :  "+i))
                .mapToObj(i-> new Customer(i,"Customer "+i))
                .collect(Collectors.toList());
    }

    public Flux<Customer> getCustomersStream() {
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i-> System.out.println("Processing count :  "+i))
                .map(i-> new Customer(i,"Customer "+i));
    }
}
