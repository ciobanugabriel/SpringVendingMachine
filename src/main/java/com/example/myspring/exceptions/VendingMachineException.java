package com.example.myspring.exceptions;

import com.example.myspring.entities.VendingMachine;

public class VendingMachineException extends Exception{
    public VendingMachineException(){
        super();
    }
    public VendingMachineException(String message){
        super(message);
    }
}
