package com.example.myspring.model;

import com.example.myspring.enums.MoneyType;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
@NoArgsConstructor
@Component
public class MoneyDto {

    @NotNull
    private MoneyType moneyType;
    @Positive
    private int quantity;
}
