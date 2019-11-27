package com.ab.buscardsystem.BusinessLayer;

import com.ab.buscardsystem.FactoryInput;
import com.ab.buscardsystem.ParentObject;

import java.time.LocalDate;
import java.time.LocalTime;

public class AddingCenter extends ParentObject {
    private LocalDate localDate = LocalDate.now();
    private LocalTime localTime = LocalTime.now();
    private String name;
    private String address;
    private CenterConsole centerConsole;
    private int centerId;
    private FactoryInput factoryInput = new FactoryInput();
    private int isCorrect;

    public CenterConsole setCenterInfo(CenterConsole centerConsole){
        if(centerConsole == null)
            throw new NullPointerException("CenterConsole is null");
        isCorrect = 1;
        takeName();
        if(isCorrect == 0){
            System.out.println("You have entered the wrong 3 times.");
            return null;
        }
        takeAddress();
        if(isCorrect == 0){
            System.out.println("You have entered the wrong 3 times.");
            return null;
        }
        takeCenterId();
        if(isCorrect == 0){
            System.out.println("You have entered the wrong 3 times.");
            return null;
        }
        centerConsole.setId(centerId);
        centerConsole.setName(name);
        centerConsole.setAddress(address);
        centerConsole.setId(centerId);
        this.centerConsole = centerConsole;
        return centerConsole;
    }

    public void takeName(){
        isCorrect = 0;
        for(int i=0; i<3; i++) {
            System.out.print("Please enter name: ");
            name = factoryInput.inputStringName();
            if (name.length() < 15 && !name.equals("") && !name.startsWith(" ")) {
                isCorrect = 1;
                break;
            } else {
                System.out.println("Incorrect Name, please try again!");
            }
        }
    }

    public void takeAddress(){
        isCorrect = 0;
        for(int i=0; i<3; i++) {
            System.out.print("Please enter address: ");
            address = factoryInput.inputStringAddress();
            if (address.length() < 100 && !address.equals("") && !address.startsWith(" ")) {
                isCorrect = 1;
                break;
            } else {
                System.out.println("Incorrect address, please try again!");
            }
        }
    }

    public void takeCenterId(){
        isCorrect = 0;
        for(int i=0; i<3; i++) {
            System.out.print("Please enter center Id: ");
            centerId = factoryInput.inputIntegerId();
            if (centerId > 0 && 10000>centerId) {
                isCorrect = 1;
                break;
            } else {
                System.out.println("Center Id is wrong, please try again!");
            }
        }
    }
    public int getIsCorrect() {
        return isCorrect;
    }

    public void setIsCorrect(int isCorrect) {
        this.isCorrect = isCorrect;
    }
    public LocalDate getLocalDate() {
        return localDate;
    }
    public LocalTime getLocalTime() {
        return localTime;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public CenterConsole getCenterConsole() {
        return centerConsole;
    }
    public void setCenterConsole(CenterConsole centerConsole) {
        this.centerConsole = centerConsole;
    }
    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }
    public int getCenterId() {
        return centerId;
    }
    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }
    public FactoryInput getFactoryInput() {
        return factoryInput;
    }
    public void setFactoryInput(FactoryInput factoryInput) {
        this.factoryInput = factoryInput;
    }
}
