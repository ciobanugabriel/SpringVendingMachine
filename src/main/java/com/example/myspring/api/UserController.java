package com.example.myspring.api;

import com.example.myspring.model.MoneyDto;
import com.example.myspring.model.UserDto;
import com.example.myspring.service.UserService;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ApiModel
@RequestMapping(path = "/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @ApiOperation("Create User")
    @PostMapping(path="")
    public void createUser(@RequestBody UserDto userDto ,boolean isAdmin , String password){
        userService.addUser(userDto, isAdmin, password);
    }

    @ApiOperation("Read User By Id")
    @GetMapping(path="/{id}")
    public UserDto getUser(@PathVariable("id") Long id){
        return userService.getUser(id);
    }

    @ApiOperation("Read All Users")
    @GetMapping(path="")
    public List<UserDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @ApiOperation("Read Wallet By User Id")
    @GetMapping(path="/wallet/{id}")
    public List<MoneyDto> getUserWallet(@PathVariable("id")Long id){
        return userService.getUserWallet(id);
    }

    @ApiOperation("Update Wallet By User Id")
    @PutMapping(path="/update_wallet/{id}")
    public String getUserWallet(@PathVariable("id")Long id,@RequestBody List<MoneyDto> walletDto){
        return userService.updateUserWallet(id, walletDto);
    }

    @ApiOperation("Delete User By Id")
    @DeleteMapping(path="/{id}")
    public String deleteUser(@PathVariable("id")Long id){
        return userService.deleteUser(id);
    }



}
