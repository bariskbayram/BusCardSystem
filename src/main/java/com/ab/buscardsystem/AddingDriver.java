package com.ab.buscardsystem;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class AddingDriver extends ParentObject {

    private LocalTime localTime = LocalTime.now();
    private LocalDate localDate = LocalDate.now();
    private String name;
    private String surname;
    private int driverId;
    private Driver driver;
    private FactoryInput factoryInput = new FactoryInput();

    public Driver setDriverInfo(Driver driver){
        System.out.print("İsim giriniz: ");
        name = factoryInput.inputStringName();
        System.out.print("Surname giriniz: ");
        surname = factoryInput.inputStringSurname();
        System.out.print("Id giriniz: ");
        driverId = factoryInput.inputIntegerId();
        driver.setId(driverId);
        driver.setName(name);
        driver.setSurname(surname);
        driver.setId(driverId);
        this.driver = driver;
        return driver;
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
}
