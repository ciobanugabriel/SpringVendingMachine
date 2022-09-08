package com.example.myspring.mappers;

import com.example.myspring.entities.MachineWallet;
import com.example.myspring.entities.UserWallet;
import com.example.myspring.model.MoneyDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring")
public interface MoneyMapper {

    List<UserWallet> moneyDtosToUserWallets(List<MoneyDto> moneyDtos);
    UserWallet moneyDtoToUserWallet(MoneyDto moneyDto);

    List<MachineWallet> moneyDtosToMachineWallets(List<MoneyDto> moneyDtos);
    MachineWallet moneyDtoToMachineWallet(MoneyDto moneyDto);

    List<MoneyDto> userWalletsToMoneyDtos(List<UserWallet> userWallets);
    MoneyDto userWalletToMoneyDto(UserWallet userWallet);

    List<MoneyDto> machineWalletsToMoneyDtos(List<MachineWallet> machineWallets);
    MoneyDto machineWalletToMoneyDto(MachineWallet machineWallet);
}
