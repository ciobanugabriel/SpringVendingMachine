package com.example.myspring.repo;

import com.example.myspring.entities.VendingMachine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface VendingMachineRepository extends JpaRepository<VendingMachine, Long>{

}
