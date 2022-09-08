package com.example.myspring.model;

import com.example.myspring.enums.MoneyType;
import com.example.myspring.enums.ProductType;
import com.example.myspring.enums.SlotType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Component
public class VendingMachineDto {

    private Long id ;

    @NotEmpty
    private String name;

    @Positive
    private int qtyMoneyLimit;

    @Positive
    private int qtySlotLimit;

    @NotEmpty
    private String address;

    @NotNull
    private List<MoneyType> allowedMoneyTypes;

    @NotNull
    private List<ProductType> allowedProductTypes;

    @NotNull
    private List<SlotType> slots;

    private List<MoneyDto> wallet;

}
