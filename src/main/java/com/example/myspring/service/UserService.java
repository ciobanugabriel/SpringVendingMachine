package com.example.myspring.service;

import com.example.myspring.entities.UserWallet;
import com.example.myspring.entities.Users;
import com.example.myspring.exceptions.UserException;
import com.example.myspring.mappers.MoneyMapper;
import com.example.myspring.mappers.UserMapper;
import com.example.myspring.model.MoneyDto;
import com.example.myspring.model.UserDto;
import com.example.myspring.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private MoneyMapper moneyMapper;

    @Transactional
    public void addUser(UserDto userDto,boolean isAdmin, String password){
        userRepository.save(userMapper.userDtoToUsers(userDto , isAdmin, password));
    }

    @Transactional(readOnly = true)
    public List<UserDto> getAllUsers(){
        return userMapper.usersToUserDtos(userRepository.findAll());
    }

    @Transactional(readOnly = true)
    public List<MoneyDto> getUserWallet(Long id){
        try {
            Users user1 = userRepository.findById(id).orElseThrow(UserException::new);
            return moneyMapper.userWalletsToMoneyDtos(user1.getWallet());
        }catch (UserException e){
            return null;
        }
    }


    @Transactional
    public String updateUserWallet(Long id, List<MoneyDto> walletDto){
        try {
            Users user1 = userRepository.findById(id).orElseThrow(UserException::new);
            List<UserWallet> wallet = mergeWallets(user1.getWallet(), moneyMapper.moneyDtosToUserWallets(walletDto));
            user1.setWallet(wallet);
            userRepository.save(user1);
            return "Wallet was updated.";
        }catch (UserException e){
            return "User with " + id + " does not exist.";
        }
    }

    private static List<UserWallet> mergeWallets(List<UserWallet> wallet1,List<UserWallet> wallet2 ){
        List<UserWallet> mergedWallet = new ArrayList<>();
        for(UserWallet money1 : wallet1){

            boolean exist = false;
            UserWallet wallet3 = new UserWallet();
            for(UserWallet money2 : wallet2){
                if(money1.getMoneyType() == money2.getMoneyType()){
                    wallet3.setMoneyType(money1.getMoneyType());
                    wallet3.setQuantity(money1.getQuantity() + money2.getQuantity());
                    mergedWallet.add(wallet3);
                    exist = true;
                }
            }
            if(!exist) {
                wallet3.setMoneyType(money1.getMoneyType());
                wallet3.setQuantity(money1.getQuantity());
                mergedWallet.add(wallet3);
            }
        }
        for(UserWallet money2 : wallet2){
            UserWallet wallet3 = new UserWallet();
            boolean exist = false;
            for(UserWallet money1 : wallet1){
                if (money1.getMoneyType() == money2.getMoneyType()) {
                    exist = true;
                    break;
                }
            }
            if(!exist) {
                wallet3.setMoneyType(money2.getMoneyType());
                wallet3.setQuantity(money2.getQuantity());
                mergedWallet.add(wallet3);
            }
        }
        return mergedWallet;
    }
    @Transactional(readOnly = true)
    public UserDto getUser(Long id){
        try{
            return userMapper.usersToUserDto(userRepository.findById(id).orElseThrow(UserException::new));
        }catch (UserException e){
            return null;
        }
    }
    @Transactional
    public String deleteUser(Long id){
        try {
            userRepository.findById(id).orElseThrow(UserException::new);
            userRepository.deleteById(id);
            return "User with id : " + id + " was deleted.";
        }catch (UserException e){
            return "User with id : " + id + " does not exist in database.";
        }
    }
}
