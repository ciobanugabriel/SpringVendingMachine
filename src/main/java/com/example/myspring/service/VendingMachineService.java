package com.example.myspring.service;

import com.example.myspring.entities.*;
import com.example.myspring.enums.MoneyType;
import com.example.myspring.enums.SlotType;
import com.example.myspring.exceptions.UserException;
import com.example.myspring.exceptions.VendingMachineException;
import com.example.myspring.mappers.*;
import com.example.myspring.model.VendingMachineDto;
import com.example.myspring.model.MoneyDto;
import com.example.myspring.model.SlotDto;
import com.example.myspring.model.ProductsDto;
import com.example.myspring.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

@Service
public class VendingMachineService {
    @Autowired
    VendingMachineRepository vendingMachineRepository;
    @Autowired
    AllowedProductsRepository productsRepository;
    @Autowired
    SlotRepository slotsRepository;
    @Autowired
    MachineWalletRepository moneyRepository;
    @Autowired
    VendingMachineMapper vendingMachineMapper;
    @Autowired
    UserRepository userRepository;
    @Autowired
    MoneyMapper moneyMapper;
    @Autowired
    SlotMapper slotMapper;
    @Autowired
    EnumMapper enumMapper;
    @Autowired
    EnumMapMapper enumMapMapper;



    @Transactional
    public String createVendingMachine(VendingMachineDto vendingMachineDto, Long userId) {
        try{
            Users users = userRepository.findById(userId).orElseThrow(UserException::new);
            if(users.getIsAdmin() == 1) {
                vendingMachineRepository.save(vendingMachineMapper.vendingMachineDtoToVendingMachine(vendingMachineDto));
                return "Vending Machine " + vendingMachineDto.getName() + " created.";
            }else{
                return "Only admin is allowed to create Vending Machine.";
            }
        }catch (Exception e){
            return "Invalid userId";
        }
    }

    @Transactional
    public String logIn(Long vmId, Long userId){
        try{
            userRepository.findById(userId).orElseThrow(UserException::new);
            VendingMachine vendingMachine = vendingMachineRepository.findById(vmId).orElseThrow(VendingMachineException::new);
            if(vendingMachine.getUserId() != null){
                throw new VendingMachineException(userId + " is still logged.");
            }
            vendingMachine.setUserId(userId);
            vendingMachineRepository.save(vendingMachine);
            return "User with id " + userId + " is logged on " + vendingMachine.getName();
        }catch (UserException e){
            return "Invalid userId";
        }catch (VendingMachineException e){
            if(e.getMessage() == null){
                return "Invalid vmId";
            }else{
                return e.getMessage();
            }
        }
    }

    @Transactional
    public String logOut(Long vmId){
        try{
            VendingMachine vendingMachine = vendingMachineRepository.findById(vmId).orElseThrow(VendingMachineException::new);
            Long userId = vendingMachine.getUserId();
            if(userId == null){
                throw new VendingMachineException("No user is logged in.");
            }
            vendingMachine.setUserId(null);
            return "User with id " + userId + " has logged out from " + vendingMachine.getName();
        }catch (VendingMachineException e){
            if(e.getMessage() == null) {
                return "Invalid vmId";
            }else{
                return  e.getMessage();
            }
        }
    }

    @Transactional(readOnly = true)
    public List<VendingMachineDto> readMachines() {
        return vendingMachineMapper.vendingMachinesToVendingMachineDtos(vendingMachineRepository.findAll());
    }

    @Transactional(readOnly = true)
    public VendingMachineDto readMachineById(Long id) {
        try {
            VendingMachine vendingMachine = vendingMachineRepository.findById(id).orElseThrow(VendingMachineException::new);
            return vendingMachineMapper.vendingMachineToVendingMachineDto(vendingMachine);
        } catch (VendingMachineException e) {
            return null;
        }
    }

    @Transactional
    public String updateSlots(Long vmId, List<SlotDto> productsForSlots) {
        try {
            VendingMachine vendingMachine = vendingMachineRepository.findById(vmId).orElseThrow(VendingMachineException::new);
            List<Slot> slots = vendingMachine.getSlots();
            for (Slot slot : slots) {
                for (SlotDto product : productsForSlots) {
                    if (slot.getSlot().equals(product.getSlot())) {
                        slot.setStock(product.getQuantity());
                        slot.setProductTypeCode(product.getProductTypeCode());
                        slot.setPrice(product.getPrice());
                    }
                }
            }
            vendingMachine.setSlots(slots);
            vendingMachineRepository.save(vendingMachine);

            return "Slots was updated";

        }catch (VendingMachineException e){
            return "Incorrect id";
        }
    }

    @Transactional
    public String buyProducts(Long vmId, List<ProductsDto> productsDto) {
        int totalMoneyCents = 0;
        int moneyLoadedAmount = 0;
        VendingMachine vendingMachine = vendingMachineRepository.findById(vmId).orElseThrow(RuntimeException::new);
        List<Slot> slots = vendingMachine.getSlots();
        for (ProductsDto productDto : productsDto) {
            for (Slot slot : slots) {
                if (slot.getSlot().equals(productDto.getSlot())) {
                    if (productDto.getQuantity() <= slot.getStock()) {
                        totalMoneyCents = totalMoneyCents + slot.getPrice() * productDto.getQuantity();
                    } else {
                        return "You order " + productDto.getQuantity() + " " + slot.getProductTypeCode()+
                                ", but machine have only " + slot.getStock() + " on stock.";
                    }
                }
            }
        }
        List<MoneyLoaded> moneyLoaded = vendingMachine.getMoneyLoaded();
        for(MoneyLoaded moneyType : moneyLoaded){
            moneyLoadedAmount = moneyLoadedAmount + moneyType.getQuantity() * moneyType.getMoneyType().getCurrency();
        }

        int moneyToPay = totalMoneyCents - moneyLoadedAmount;


        return "Need to pay : " + moneyToPay / 100 + " Euro and "
                + moneyToPay % 100 + " Cents.";
    }

    @Transactional
    public String loadMoney(Long vmId, MoneyType moneyType){
        try{
            VendingMachine vendingMachine = vendingMachineRepository.findById(vmId).
                    orElseThrow(()->new VendingMachineException("Invalid vmId"));

            List<MoneyType> allowedMoneyTypes = enumMapper.
                    allowedMoneyTypesToMoneyTypes(vendingMachine.getAllowedMoneyTypes());

            if(vendingMachine.getUserId() == null){
                throw new VendingMachineException("Log in first!");
            }

            if(!allowedMoneyTypes.contains(moneyType)){
                throw new VendingMachineException("Invalid money type for this Vending Machine");
            }

            Users users = userRepository.findById(vendingMachine.getUserId()).
                    orElseThrow(()->new UserException("Invalid User Id"));

            EnumMap<MoneyType,Integer> enumMapUserWallet = enumMapMapper.userWalletToEnumMap(users.getWallet());

            if(!enumMapUserWallet.containsKey(moneyType)){
                throw new UserException("No such money in UserWallet");
            }else if(enumMapUserWallet.get(moneyType) == 0){
                throw new UserException(moneyType + " has 0 stock in UserWallet");
            }else{
                enumMapUserWallet.put(moneyType,enumMapUserWallet.get(moneyType) - 1);
            }
            users.setWallet(enumMapMapper.enumMapUserWalletToUserWallet(enumMapUserWallet));
            userRepository.save(users);

            if(vendingMachine.getMoneyLoaded() == null){
                List<MoneyLoaded> moneyLoadedList = new ArrayList<>();
                MoneyLoaded moneyLoaded = new MoneyLoaded();
                moneyLoaded.setMoneyType(moneyType);
                moneyLoaded.setQuantity(1);
                moneyLoadedList.add(moneyLoaded);
                vendingMachine.setMoneyLoaded(moneyLoadedList);
            }else{
                EnumMap<MoneyType,Integer> enumMapMoneyLoaded =
                        enumMapMapper.moneyLoadedToEnumMap(vendingMachine.getMoneyLoaded());
                if(enumMapMoneyLoaded.containsKey(moneyType)){
                    enumMapMoneyLoaded.put(moneyType,enumMapMoneyLoaded.get(moneyType) + 1);
                }else{
                    enumMapMoneyLoaded.put(moneyType, 1);
                }
                vendingMachine.setMoneyLoaded(enumMapMapper.enumMapMoneyLoadedToList(enumMapMoneyLoaded));
            }
            vendingMachineRepository.save(vendingMachine);
            return moneyType + " was loaded.";

        }catch (VendingMachineException | UserException e){
            return e.getMessage();
        }
    }


    @Transactional
    public String addProductToShoppingList(Long vmId, SlotType slotType){
        try{
            VendingMachine vendingMachine = vendingMachineRepository.findById(vmId).
                    orElseThrow(()->new VendingMachineException("Invalid vmId"));
            EnumMap<SlotType,Integer> enumMapShoppingList ;

            if(vendingMachine.getUserId() == null){
                throw new VendingMachineException("Log in first!");
            }
            EnumMap<SlotType,Integer> enumMapSlots = enumMapMapper.slotsToEnumMapSlots(vendingMachine.getSlots());
            if(! enumMapSlots.containsKey(slotType)){
                throw new VendingMachineException("Invalid Slot Type");
            }else if(enumMapSlots.get(slotType) == 0){
                throw new VendingMachineException(slotType + " has 0 stock.");
            }else{
                List<Slot>slots = vendingMachine.getSlots();
                for(Slot slot : slots){
                    if(slot.getSlot().equals(slotType)){
                        slot.setStock(slot.getStock() -1 );
                    }
                }
                vendingMachine.setSlots(slots);
            }

            if(vendingMachine.getShoppingList() == null){
                List<ShoppingList> shoppingList = new ArrayList<>();
                ShoppingList item = new ShoppingList();
                item.setSlot(slotType);
                item.setQuantity(1);
                shoppingList.add(item);
                vendingMachine.setShoppingList(shoppingList);
            }else{
                enumMapShoppingList = enumMapMapper.
                        shoppingListToEnumMapShoppingList(vendingMachine.getShoppingList());
                if(enumMapShoppingList.containsKey(slotType)){
                        enumMapShoppingList.put(slotType,enumMapShoppingList.get(slotType) + 1);
                }else{
                        enumMapShoppingList.put(slotType, 1);
                }
                vendingMachine.setShoppingList(enumMapMapper.enumMapShoppingListToShoppingList(enumMapShoppingList));

            }
            vendingMachineRepository.save(vendingMachine);
            return "Slot was add.";

        }catch (VendingMachineException e){
            return e.getMessage();
        }
    }

    @Transactional(readOnly = true)
    public List<SlotDto> readSlots(Long vmId){
        try{
            VendingMachine machine = vendingMachineRepository.findById(vmId).orElseThrow(VendingMachineException::new);
            return slotMapper.slotsToSlotDtos(machine.getSlots());
        }catch (Exception e){
            return null;
        }
    }

    @Transactional
    public String updateMoneyInventory(Long vmId,List<MoneyDto> moneyDtoList){

        VendingMachine vendingMachine = vendingMachineRepository.findById(vmId).orElseThrow(RuntimeException::new);
        List<MachineWallet> moneyInventory = vendingMachine.getWallet();
        for (MoneyDto moneyDto : moneyDtoList) {
            for (MachineWallet moneyType : moneyInventory) {
                if(moneyDto.getMoneyType().getCode().equals(moneyType.getMoneyType().toString())){
                    moneyType.setQuantity(moneyDto.getQuantity());
                }
            }
        }
        return null;
    }

    @Transactional(readOnly = true)
    public List<MoneyDto> readMoneyInventory(Long vmId){
        try{
            VendingMachine machine = vendingMachineRepository.findById(vmId).orElseThrow(VendingMachineException::new);
            return moneyMapper.machineWalletsToMoneyDtos(machine.getWallet());
        }catch (Exception e){
            return null;
        }
    }

}
