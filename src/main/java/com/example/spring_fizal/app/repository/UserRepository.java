package com.example.spring_fizal.app.repository;

import com.example.spring_fizal.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findByNameIgnoreCaseAndEmailIgnoreCase(String name, String email);
}
