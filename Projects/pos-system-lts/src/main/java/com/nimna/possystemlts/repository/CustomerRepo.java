package com.nimna.possystemlts.repository;

import com.nimna.possystemlts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
// JpaRepository<Customer,Integer>  <Entity class name, Entity Id data type>. ID data type going as generic
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    List<Customer> findAllByActiveEquals(Boolean activeStatus);
}
