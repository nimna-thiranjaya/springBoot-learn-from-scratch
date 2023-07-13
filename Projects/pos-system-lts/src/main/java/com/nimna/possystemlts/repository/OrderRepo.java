package com.nimna.possystemlts.repository;

import com.nimna.possystemlts.dto.queryInterface.OderDetailsInterface;
import com.nimna.possystemlts.dto.response.ResponseOrderDetailsDTO;
import com.nimna.possystemlts.entity.Order;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface OrderRepo extends JpaRepository<Order, Integer> {

    @Query(value = "SELECT c.customer_name as customerName, c.customer_address as customerAddress, c.contact_numbers as contactNumbers, o.order_date as orderDate, o.total as total FROM customer c, orders o WHERE o.customer_id = c.customer_id", nativeQuery = true)
    List<OderDetailsInterface> getAllOrderDetails(boolean status, Pageable pageable);

    @Query(value = "SELECT COUNT(*) FROM customer c, orders o WHERE o.customer_id = c.customer_id", nativeQuery = true)
    long countAllOrderDetails(boolean status);
}
