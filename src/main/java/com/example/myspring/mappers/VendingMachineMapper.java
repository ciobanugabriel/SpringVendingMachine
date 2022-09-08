package com.example.myspring.mappers;

import com.example.myspring.entities.VendingMachine;
import com.example.myspring.model.VendingMachineDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring", uses = {MoneyMapper.class, EnumMapper.class, SlotMapper.class})
public interface VendingMachineMapper {

    List<VendingMachineDto> vendingMachinesToVendingMachineDtos(List<VendingMachine> vendingMachines);
    VendingMachineDto vendingMachineToVendingMachineDto(VendingMachine vendingMachine);


    List<VendingMachine> vendingMachineDtosToVendingMachines(List<VendingMachineDto> vendingMachineDtos);
    VendingMachine vendingMachineDtoToVendingMachine(VendingMachineDto vendingMachineDto);

}
