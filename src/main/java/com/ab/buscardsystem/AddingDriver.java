package com.ab.buscardsystem;

import java.time.LocalDate;
import java.time.LocalTime;

public class AddingDriver extends ParentObject {

    private LocalTime localTime = LocalTime.now();
    private LocalDate localDate = LocalDate.now();
    private String name;
    private String surname;
    private int driverId;
    private Driver driver;
    private int isCorrect;
    private FactoryInput factoryInput = new FactoryInput();

    public Driver setDriverInfo(Driver driver){
        isCorrect = 1;
        takeName();
        if(isCorrect == 0)
            return null;
        takeSurname();
        if(isCorrect == 0)
            return null;
        takeId();
        if(isCorrect == 0)
            return null;
        driver.setId(driverId);
        driver.setName(name);
        driver.setSurname(surname);
        this.driver = driver;
        return driver;
    }

    public void takeName(){
        isCorrect = 0;
        for(int i=0; i<3; i++) {
            System.out.print("Please enter name: ");
            name = factoryInput.inputStringName().toUpperCase();
            if (name.length() < 15) {
                isCorrect = 1;
                break;
            } else {
                System.out.println("Name is too long, please try again!");
            }
        }
    }

    public void takeSurname(){
        isCorrect = 0;
        for(int i=0; i<3; i++) {
            System.out.print("Please enter surname: ");
            surname = factoryInput.inputStringSurname().toUpperCase();
            if (surname.length() < 15) {
                isCorrect = 1;
                break;
            } else {
                System.out.println("Surname is too long, please try again!");
            }
        }
    }

    public void takeId(){
        isCorrect = 0;
        for(int i=0; i<3; i++) {
            System.out.print("Please enter Driver ID: ");
            driverId = factoryInput.inputIntegerId();
            if (driverId > 0 && driverId < 10.000 && driverId != 7 && driverId != 18) {
                isCorrect = 1;
                break;
            } else {
                System.out.println("Driver ID is wrong, please try again!");
            }
        }
    }

    public LocalTime getLocalTime() {
        return localTime;
    }
    public LocalDate getLocalDate() {
        return localDate;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public int getDriverId() {
        return driverId;
    }
    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }
    public Driver getDriver() {
        return driver;
    }
    public void setDriver(Driver driver) {
        this.driver = driver;
    }
    public int getIsCorrect() {
        return isCorrect;
    }
    public void setIsCorrect(int isCorrect) {
        this.isCorrect = isCorrect;
    }

}
