package com.example.myspring.repo;


import com.example.myspring.entities.Slot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SlotRepository extends JpaRepository<Slot,Long> {
//    @Query(value = "select s from VendingMachine vm join vm.slots s where vm.id=:vm_id")
//    List<Slot> getSlotsByMachineId(@Param("vm_id") Long vmId);
}


