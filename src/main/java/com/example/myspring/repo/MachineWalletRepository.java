package com.example.myspring.repo;

import com.example.myspring.entities.MachineWallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MachineWalletRepository extends JpaRepository<MachineWallet,Long> {
//    @Query(value = "select m from VendingMachine vm join vm.money m where vm.id=:vm_id")
//    List<MachineWallet> getMoneyByMachineId(@Param("vm_id") Long vmId);
//     @Modifying
//     @Query(value = "update MachineWallet m set m.quantity = m.quantity-1 " +
//             "where m.id=:id")
//       void updateMoneyStockById(@Param("id") Long id);
//    @Modifying
//    @Query(value = "update MachineWallet m set m.quantity = :stock " +
//            "where m.moneyType=:code")
//    void updateMoneyStockByCode(@Param("code") String code,@Param("stock") int stock);
}
