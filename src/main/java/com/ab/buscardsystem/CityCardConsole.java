package com.ab.buscardsystem;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class CityCardConsole {

    private LocalDate localDate = LocalDate.now();
    private LocalTime localTime = LocalTime.now();
    private AddingMoneyToCenter addingMoneyToCenter;
    private CenterConsole centerConsole;
    private DBFacade dbFacade;
    private double amount;

    public CityCardConsole(DBFacade dbFacade){
        this.dbFacade = dbFacade;
    }

    public void enterCenterId (int depositCenterId){
        addingMoneyToCenter = new AddingMoneyToCenter();
        centerConsole =(CenterConsole) dbFacade.get(depositCenterId, CenterConsole.class);
        addingMoneyToCenter.setCenterConsole(centerConsole);
        System.out.println("Yuklenecek tutarı giriniz: ");
        Scanner scanner = new Scanner(System.in);
        amount = scanner.nextDouble();
        enterAmount(amount);
    }

    public void enterAmount (double amount){
        addingMoneyToCenter.setAmount(amount);
        System.out.println("Verilen parayı giriniz: ");
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        addingMoneyToCenter.setPayment(payment);
        addingMoneyToCenter.createCenterReceipt(amount,payment);
        addingMoneyToCenter.getCenterReceipt().setCenterConsoleId(centerConsole.getId());
        centerConsole.setBalance(centerConsole.getBalance()+amount);
        dbFacade.put(centerConsole);
        dbFacade.put(addingMoneyToCenter.getCenterReceipt());

    }
}
