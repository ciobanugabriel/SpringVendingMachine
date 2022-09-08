package com.example.myspring.api;

import com.example.myspring.enums.MoneyType;
import com.example.myspring.enums.SlotType;
import com.example.myspring.model.VendingMachineDto;
import com.example.myspring.model.MoneyDto;
import com.example.myspring.model.SlotDto;
import com.example.myspring.service.VendingMachineService;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@ApiModel
@RequestMapping(path = "/api/vending_machines")
public class VendingMachineController {
    @Autowired
    private VendingMachineService vendingMachineService;


    @ApiOperation("Create Vending Machine")
    @PostMapping("/{userId}")
    public String createVendingMachine(@RequestBody VendingMachineDto vendingMachineDto, @PathVariable("userId") Long userId) {
        return vendingMachineService.createVendingMachine(vendingMachineDto, userId);
    }


    @ApiOperation("Log in Vending Machine")
    @PutMapping(path = "/log_in/{vmId}/{userId}")
    public String logIn(@PathVariable("vmId") Long vmId, @PathVariable("userId") Long userId) {

        return vendingMachineService.logIn(vmId, userId);
    }

    @ApiOperation("Log out from Vending Machine")
    @PutMapping(path = "/log_out/{vmId}")
    public String logOut(@PathVariable("vmId") Long vmId) {

        return vendingMachineService.logOut(vmId);
    }


    @ApiOperation("Update Slots For Machine With Id = ?")
    @PutMapping(path = "/update_slots/{vm_id}")
    public String updateVendingMachineSlots(@PathVariable("vm_id") Long vmId, @RequestBody List<SlotDto> productsForSlots) {

       return vendingMachineService.updateSlots(vmId, productsForSlots);
    }

    @ApiOperation("Update Money Inventory For Machine With Id = ?")
    @PutMapping(path = "/update_money/{vm_id}")
    public String updateVendingMachineWallet(@PathVariable("vm_id") Long vmId, @RequestBody List<MoneyDto> moneyDtoList) {

        return vendingMachineService.updateMoneyInventory(vmId, moneyDtoList);
    }

    @ApiOperation("Read Slots For Machine With Id = ?")
    @GetMapping(path = "/read_slots/{vm_id}")
    public List<SlotDto> readSlots(@PathVariable("vm_id") Long vmId) {
        return vendingMachineService.readSlots(vmId);
    }


    @ApiOperation("Read Money Inventory For Machine With Id = ?")
    @GetMapping(path = "/read_money/{vm_id}")
    public List<MoneyDto> readMoneyInventory(@PathVariable("vm_id") Long vmId) {
        return vendingMachineService.readMoneyInventory(vmId);
    }


    @ApiOperation("Read Vending Machines")
    @GetMapping
    public List<VendingMachineDto> readMachines() {
        return vendingMachineService.readMachines();
    }


    @ApiOperation("Read Vending Machine Status By Id")
    @GetMapping(path = "/{id}")
    public VendingMachineDto readMachinesById(@PathVariable Long id) {
        return vendingMachineService.readMachineById(id);
    }

    @ApiOperation("Load Money in Machine With Id =?")
    @PutMapping(path = "{vmId}")
    public String loadMoney(@PathVariable Long vmId, MoneyType moneyType) {
        return vendingMachineService.loadMoney(vmId, moneyType);
    }

    @ApiOperation("Add product in Shopping List at Machine With Id =?")
    @PutMapping(path = "/add_product/{vmId}")
    public String addProductToShoppingList(@PathVariable Long vmId, SlotType slotType) {
        return vendingMachineService.addProductToShoppingList(vmId, slotType);
    }

}
