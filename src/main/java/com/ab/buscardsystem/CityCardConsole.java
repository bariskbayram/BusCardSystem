package com.ab.buscardsystem;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class CityCardConsole {

    private LocalDate localDate = LocalDate.now();
    private LocalTime localTime = LocalTime.now();
    private DepositToDepositCenter depositToDepositCenter;
    private DepositCenterConsole depositCenterConsole;
    private DBFacade dbFacade;
    private double amount;


    public CityCardConsole(DBFacade dbFacade){
        this.dbFacade = dbFacade;
    }

    public void enterDepositCenterId (int depositCenterId){
        depositToDepositCenter = new DepositToDepositCenter();
        depositCenterConsole =(DepositCenterConsole) dbFacade.get(depositCenterId,DepositCenterConsole.class);
        depositToDepositCenter.setDepositCenterConsole(depositCenterConsole);
        System.out.println("Yuklenecek tutarı giriniz: ");
        Scanner scanner = new Scanner(System.in);
        amount = scanner.nextDouble();
        enterAmount(amount);
    }

    public void enterAmount (double amount){
        depositToDepositCenter.setAmount(amount);
        System.out.println("Verilen parayı giriniz: ");
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        depositToDepositCenter.setPayment(payment);
        depositToDepositCenter.createDepositToDepositCenterReceipt(amount,payment);
        depositToDepositCenter.getDepositToDepositCenterReceipt().setDepositCenterConsoleId(depositCenterConsole.getDepositCenterConsoleId());
        depositCenterConsole.setDepositCenterConsoleBalance(depositCenterConsole.getDepositCenterConsoleBalance()+amount);
        dbFacade.put(depositCenterConsole);
        dbFacade.put(depositToDepositCenter.getDepositToDepositCenterReceipt());

    }
}
