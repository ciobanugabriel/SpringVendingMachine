package com.example.myspring.repo;

import com.example.myspring.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<Users, Long> {
}
