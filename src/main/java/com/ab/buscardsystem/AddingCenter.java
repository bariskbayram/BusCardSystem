package com.ab.buscardsystem;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class AddingCenter extends ParentObject {
    private LocalDate localDate = LocalDate.now();
    private LocalTime localTime = LocalTime.now();
    private String name;
    private String address;
    private CenterConsole centerConsole;
    private int centerId;
    private FactoryInput factoryInput = new FactoryInput();

    public CenterConsole setCenterInfo(CenterConsole centerConsole){
        System.out.print("Please enter name: ");
        name = factoryInput.inputStringName().toUpperCase();
        System.out.print("Please enter address: ");
        address = factoryInput.inputStringAddress().toUpperCase();
        System.out.print("Please enter center ID: ");
        centerId = factoryInput.inputIntegerId();
        centerConsole.setId(centerId);
        centerConsole.setName(name);
        centerConsole.setAddress(address);
        centerConsole.setId(centerId);
        this.centerConsole = centerConsole;
        return centerConsole;
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

}
