package com.ab.buscardsystem;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class CityCardConsole {

    private LocalDate localDate = LocalDate.now();
    private LocalTime localTime = LocalTime.now();
    private AddingMoneyToCenter addingMoneyToCenter;
    private CenterConsole centerConsole;
    private AddingCard addingCard;
    private AddingCenter addingCenter;
    private DBFacade dbFacade;
    private double amount;
    private AddingDriver addingDriver;
    private FactoryInput factoryInput = new FactoryInput();

    public CityCardConsole(DBFacade dbFacade){
        this.dbFacade = dbFacade;
    }

    public void enterCenterId (int centerId, AddingMoneyToCenter addingMoneyToCenter){
        centerConsole =(CenterConsole) dbFacade.get(centerId, CenterConsole.class);
        addingMoneyToCenter.setCenterConsole(centerConsole);
        System.out.println("Please enter amount: ");
        amount = factoryInput.inputDoubleAmount();
        this.addingMoneyToCenter = addingMoneyToCenter;
        enterAmount(amount);
    }

    public void enterAmount (double amount){
        addingMoneyToCenter.setAmount(amount);
        System.out.println("Please enter payment: ");
        double payment = factoryInput.inputDoublePayment();
        addingMoneyToCenter.setPayment(payment);
        addingMoneyToCenter.createCenterReceipt(new CenterReceipt(amount,payment));
        addingMoneyToCenter.getCenterReceipt().setCenterConsoleId(centerConsole.getId());
        centerConsole.setBalance(centerConsole.getBalance()+amount);
        dbFacade.update(centerConsole);
        dbFacade.put(addingMoneyToCenter.getCenterReceipt());
    }

    public void enterCardInfo(AddingCard addingCard){
        Card card = addingCard.setCardInfo(new Card(0));
        if(card == null)
            return;
        dbFacade.put(card);
        this.addingCard = addingCard;
        dbFacade.put(addingCard);
    }

    public void enterCenterInfo(AddingCenter addingCenter){
        dbFacade.put(addingCenter.setCenterInfo(new CenterConsole()));
        this.addingCenter = addingCenter;
        dbFacade.put(addingCenter);
    }

    public void enterDriverInfo(AddingDriver addingDriver){
        dbFacade.put(addingDriver.setDriverInfo(new Driver(0)));
        this.addingDriver = addingDriver;
        dbFacade.put(addingDriver);
    }

    public void deleteDriver(){
        System.out.println("Please enter Driver ID for delete process: ");
        dbFacade.delete(factoryInput.inputIntegerId(), Driver.class);
    }

    public void deleteCenter(){
        System.out.println("Please enter Center ID for delete process: ");
        dbFacade.delete(factoryInput.inputIntegerId(), CenterConsole.class);
    }

    public LocalDate getLocalDate() {
        return localDate;
    }
    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
    public LocalTime getLocalTime() {
        return localTime;
    }
    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }
    public AddingMoneyToCenter getAddingMoneyToCenter() {
        return addingMoneyToCenter;
    }
    public void setAddingMoneyToCenter(AddingMoneyToCenter addingMoneyToCenter) {
        this.addingMoneyToCenter = addingMoneyToCenter;
    }
    public CenterConsole getCenterConsole() {
        return centerConsole;
    }
    public void setCenterConsole(CenterConsole centerConsole) {
        this.centerConsole = centerConsole;
    }
    public AddingCard getAddingCard() {
        return addingCard;
    }
    public void setAddingCard(AddingCard addingCard) {
        this.addingCard = addingCard;
    }
    public DBFacade getDbFacade() {
        return dbFacade;
    }
    public void setDbFacade(DBFacade dbFacade) {
        this.dbFacade = dbFacade;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public AddingCenter getAddingCenter() {
        return addingCenter;
    }
    public void setAddingCenter(AddingCenter addingCenter) {
        this.addingCenter = addingCenter;
    }
    public AddingDriver getAddingDriver() {
        return addingDriver;
    }
    public void setAddingDriver(AddingDriver addingDriver) {
        this.addingDriver = addingDriver;
    }
}
