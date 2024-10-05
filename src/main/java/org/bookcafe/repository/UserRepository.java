package org.bookcafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import org.bookcafe.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    Optional<User> findByEmail(String name);


}
