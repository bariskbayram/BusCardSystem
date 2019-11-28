package com.ab.buscardsystem.BusinessLayer;

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

    public CenterConsole setCenterInfo(CenterConsole centerConsole){
        if(centerConsole == null)
            throw new NullPointerException("CenterConsole is null");
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
    public int getCenterId() {
        return centerId;
    }
    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }
}
