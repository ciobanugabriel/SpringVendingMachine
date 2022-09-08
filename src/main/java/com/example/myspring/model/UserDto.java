package com.example.myspring.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@NoArgsConstructor
@Component
public class UserDto {

    private Long id;

    @NotEmpty
    private String name;

    private int isAdmin;

    @NotNull
    private List<MoneyDto> wallet;

}
