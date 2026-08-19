package com.dineshmane.bankapp.repository;

import com.dineshmane.bankapp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Spring Data derives the SQL from the method name at startup —
     * "findByEmail" -> "SELECT * FROM users WHERE email = ?"
     * No implementation needed; Spring generates a proxy at runtime.
     */
    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

}
