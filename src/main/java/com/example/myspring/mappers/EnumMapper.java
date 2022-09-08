package com.example.myspring.mappers;

import com.example.myspring.entities.AllowedMoneyTypes;
import com.example.myspring.entities.AllowedProductTypes;
import com.example.myspring.entities.Slot;
import com.example.myspring.enums.MoneyType;
import com.example.myspring.enums.ProductType;
import com.example.myspring.enums.SlotType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface EnumMapper {

    List<AllowedMoneyTypes> moneyTypesToAllowedMoneyTypes(List<MoneyType>moneyTypes);
    @Mapping(source = "moneyType" , target = "moneyType")
    AllowedMoneyTypes moneyTypeToAllowedMoneyTypes(MoneyType moneyType);

    List<AllowedProductTypes> productTypesToAllowedProductTypes(List<ProductType> productTypes);
    @Mapping(source = "productType", target = "productType")
    AllowedProductTypes productTypeToAllowedProductTypes(ProductType productType);

    List<Slot> slotTypesToSlots(List<SlotType> slotTypes);
    @Mapping(source = "slotType", target = "slot")
    Slot slotTypeToSlot(SlotType slotType);

    default MoneyType allowedMoneyTypesToMoneyType(AllowedMoneyTypes moneyTypes){
        return moneyTypes.getMoneyType();
    }
    List<MoneyType> allowedMoneyTypesToMoneyTypes(List<AllowedMoneyTypes> allowedMoneyTypes);

    default ProductType allowedProductTypesToProductType(AllowedProductTypes allowedProductTypes){
        return allowedProductTypes.getProductType();
    }
    List<ProductType> allowedProductTypesToProductTypes(List<AllowedProductTypes> allowedProductTypes);

    default SlotType slotToSlotType(Slot slot){
        return slot.getSlot();
    }
    List<SlotType> slotsToSlotTypes(List<Slot> slots);

}
