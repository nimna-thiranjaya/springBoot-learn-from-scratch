package com.nimna.usermanagementtest.repository;

import com.nimna.usermanagementtest.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface RoleRepository extends JpaRepository<Role, String> {
}
