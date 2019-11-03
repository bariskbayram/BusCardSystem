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
            System.out.print("İsim giriniz: ");
            name = factoryInput.inputStringName();
            if (name.length() < 15) {
                isCorrect = 1;
                break;
            } else {
                System.out.println("Çok uzun isim girdiniz, tekrar deneyin!");
            }
        }
    }

    public void takeSurname(){
        isCorrect = 0;
        for(int i=0; i<3; i++) {
            System.out.print("Soyad giriniz: ");
            surname = factoryInput.inputStringSurname();
            if (surname.length() < 15) {
                isCorrect = 1;
                break;
            } else {
                System.out.println("Çok uzun soyad girdiniz, tekrar deneyin!");
            }
        }
    }

    public void takeId(){
        isCorrect = 0;
        for(int i=0; i<3; i++) {
            System.out.print("Id giriniz: ");
            driverId = factoryInput.inputIntegerId();
            if (driverId > 0 && driverId < 10.000 && driverId != 7 && driverId != 18) {
                isCorrect = 1;
                break;
            } else {
                System.out.println("Yanlış sürücü Id girdiniz, tekrar deneyin!");
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
