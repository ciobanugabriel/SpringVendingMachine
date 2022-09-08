package com.example.myspring.mappers;

import com.example.myspring.entities.*;
import com.example.myspring.enums.MoneyType;
import com.example.myspring.enums.SlotType;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface EnumMapMapper {

    default EnumMap<SlotType,Integer> slotsToEnumMapSlots(List<Slot> slots){
        EnumMap<SlotType,Integer> enumMapSlots = new EnumMap<>(SlotType.class);
        for(Slot slot : slots){
            enumMapSlots.put(slot.getSlot(), slot.getStock());
        }
        return  enumMapSlots;
    }

    default  EnumMap<SlotType,Integer> shoppingListToEnumMapShoppingList(List<ShoppingList> shoppingList){
        EnumMap<SlotType,Integer> enumMapShoppingList = new EnumMap<SlotType, Integer>(SlotType.class);
        for(ShoppingList item : shoppingList){
            enumMapShoppingList.put(item.getSlot(), item.getQuantity());
        }
        return enumMapShoppingList;
    }
    default List<ShoppingList> enumMapShoppingListToShoppingList(EnumMap<SlotType, Integer> enumMapShoppingList){
        List<ShoppingList> shoppingList = new ArrayList<>();
        for(SlotType slotType : enumMapShoppingList.keySet()){
            ShoppingList item = new ShoppingList();
            item.setSlot(slotType);
            item.setQuantity(enumMapShoppingList.get(slotType));
            shoppingList.add(item);
        }
        return shoppingList;
    }



    default EnumMap<MoneyType,Integer> userWalletToEnumMap(List<UserWallet> userWallet){
        EnumMap<MoneyType, Integer> enumWallet = new EnumMap<>(MoneyType.class);
        for(UserWallet moneyType : userWallet){
            enumWallet.put(moneyType.getMoneyType(),moneyType.getQuantity());
        }
        return enumWallet;
    }

    default List<UserWallet> enumMapUserWalletToUserWallet(EnumMap<MoneyType,Integer> enumMapUserWallet){
        List<UserWallet> userWalletList = new ArrayList<>();
        for(MoneyType moneyType : enumMapUserWallet.keySet()){
            UserWallet userWallet = new UserWallet();
            userWallet.setMoneyType(moneyType);
            userWallet.setQuantity(enumMapUserWallet.get(moneyType));
            userWalletList.add(userWallet);
        }
        return userWalletList;
    }
    default List<MoneyLoaded> enumMapMoneyLoadedToList(EnumMap<MoneyType,Integer> enumMapMoneyLoaded){
        List<MoneyLoaded> moneyLoadedList = new ArrayList<>();

        for(MoneyType moneyType : enumMapMoneyLoaded.keySet()){
            MoneyLoaded moneyLoaded = new MoneyLoaded();
            moneyLoaded.setMoneyType(moneyType);
            moneyLoaded.setQuantity(enumMapMoneyLoaded.get(moneyType));
            moneyLoadedList.add(moneyLoaded);
        }

        return moneyLoadedList;
    }

    default EnumMap<MoneyType,Integer> moneyLoadedToEnumMap(List<MoneyLoaded> wallet){
        EnumMap<MoneyType, Integer> enumWallet = new EnumMap<>(MoneyType.class);
        for(MoneyLoaded moneyType : wallet){
            enumWallet.put(moneyType.getMoneyType(),moneyType.getQuantity());
        }
        return enumWallet;
    }
    default EnumMap<MoneyType,Integer> machineWalletToEnumMap(List<MachineWallet> machineWallet){
        EnumMap<MoneyType, Integer> enumWallet = new EnumMap<>(MoneyType.class);
        for(MachineWallet moneyType : machineWallet){
            enumWallet.put(moneyType.getMoneyType(),moneyType.getQuantity());
        }
        return enumWallet;
    }
}
