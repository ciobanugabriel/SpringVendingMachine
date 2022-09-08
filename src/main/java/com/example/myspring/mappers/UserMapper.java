package com.example.myspring.mappers;

import com.example.myspring.entities.Users;
import com.example.myspring.model.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(componentModel = "spring", uses = {MoneyMapper.class})
public interface UserMapper {


    List<UserDto> usersToUserDtos(List<Users> users);
    UserDto usersToUserDto(Users users);

    default int mapIsAdmin(boolean isAdmin){
        if(isAdmin){
            return 1;
        }else{
            return 0;
        }
    }

    @Mapping(source = "password", target = "password")
    @Mapping(source = "isAdmin" , target = "isAdmin")
    Users userDtoToUsers(UserDto userDto , boolean isAdmin, String password);




}
