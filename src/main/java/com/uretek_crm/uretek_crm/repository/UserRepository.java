package com.uretek_crm.uretek_crm.repository;

import com.uretek_crm.uretek_crm.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    // Spring Data JPA automatically implements this query: SELECT * FROM crm_user WHERE username = ?
    Optional<User> findByUsername(String username);
}
