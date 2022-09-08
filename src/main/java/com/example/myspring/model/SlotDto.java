package com.example.myspring.model;

import com.example.myspring.enums.ProductType;
import com.example.myspring.enums.SlotType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
@Data
@NoArgsConstructor
@Component
public class SlotDto {

    @NotNull
    private ProductType productTypeCode;

    @NotNull
    private SlotType slot;

    @Positive
    private int quantity;

    @Positive
    private int price;
}
