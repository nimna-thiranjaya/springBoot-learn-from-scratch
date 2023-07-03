package com.nimna.possystemlts.repository;

import com.nimna.possystemlts.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@EnableJpaRepositories
public interface ItemRepo extends JpaRepository<Item,Integer> {
    Item findByItemNameAndActiveStatusIsTrue(String itemName);

    List<Item> findAllByActiveStatus(boolean itemStatus);
}
