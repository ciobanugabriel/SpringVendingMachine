package com.example.myspring.repo;

import com.example.myspring.entities.AllowedProductTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AllowedProductsRepository extends JpaRepository<AllowedProductTypes,Long> {

//    @Query(value = "select p from VendingMachine vm join vm.allowedProductTypes p where vm.id=:vm_id")
//    List<AllowedProductTypes> getProductsByMachineId(@Param("vm_id") Long vmId);

   // @Modifying
   // @Query(value = "update Products p set p. = 5 where p.id=:id")
  //  void updateProductStock(@Param("id") Long id);
}
