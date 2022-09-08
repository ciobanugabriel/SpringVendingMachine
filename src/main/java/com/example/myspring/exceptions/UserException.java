package com.example.myspring.exceptions;

import com.example.myspring.model.UserDto;

public class UserException extends Exception{
    public UserException(){
        super();
    }
    public UserException(String message){
        super(message);
    }
}
