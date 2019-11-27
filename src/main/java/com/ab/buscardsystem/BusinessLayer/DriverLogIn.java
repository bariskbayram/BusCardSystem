package com.ab.buscardsystem.BusinessLayer;

import com.ab.buscardsystem.ParentObject;

import java.time.LocalDate;
import java.time.LocalTime;

public class DriverLogIn extends ParentObject {

    private int driverId;
    private LocalDate localDate = LocalDate.now();
    private LocalTime localTime = LocalTime.now();
    private int busConsoleId;

    public void setLogin(Driver driver) {
        driverId = driver.getId();
    }

    public int getDriverId() {
        return driverId;
    }
    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }
    public LocalDate getLocalDate() {
        return localDate;
    }
    public LocalTime getLocalTime() {
        return localTime;
    }
    public int getBusConsoleId() {
        return busConsoleId;
    }
    public void setBusConsoleId(int busConsoleId) {
        this.busConsoleId = busConsoleId;
    }

}
