package com.ab.buscardsystem;

import java.time.LocalDate;
import java.time.LocalTime;

public class CityCardConsole {

    private LocalDate localDate = LocalDate.now();
    private LocalTime localTime = LocalTime.now();
    private DepositToDepositCenter depositToDepositCenter;
    private DBFacade dbFacade;
    private DepositCenterConsole depositCenterConsole;
    private double amount;

    public CityCardConsole(DBFacade dbFacade){
        this.dbFacade = dbFacade;
    }



}
