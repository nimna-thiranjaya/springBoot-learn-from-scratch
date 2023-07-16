package com.nimna.springsecurity.repository;

import com.nimna.springsecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    boolean existsUserByEmail(String email);

    List<User> getUsersByEmail(String userName);
}
