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

    public CityCardConsole(DBFacade dbFacade){
        this.dbFacade = dbFacade;
    }

    public void enterCenterId (int centerId){
        addingMoneyToCenter = new AddingMoneyToCenter();
        centerConsole =(CenterConsole) dbFacade.get(centerId, CenterConsole.class);
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
        dbFacade.update(centerConsole);
        dbFacade.put(addingMoneyToCenter.getCenterReceipt());
    }

    public void enterCardInfo(){
        addingCard = new AddingCard();
        dbFacade.put(addingCard.setCardInfo());
        dbFacade.put(addingCard);
    }

    public void enterCenterInfo(){
        addingCenter = new AddingCenter();
        dbFacade.put(addingCenter.setCenterInfo());
        dbFacade.put(addingCenter);
    }

    public void enterDriverInfo(){
        addingDriver = new AddingDriver();
        dbFacade.put(addingDriver.setDriverInfo());
        dbFacade.put(addingDriver);
    }

    public void deleteDriver(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Silinecek sürücünün Id'sini giriniz: ");
        dbFacade.delete(scanner.nextInt(), Driver.class);
    }

    public void deleteCenter(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Silinecek centerId'sini giriniz: ");
        dbFacade.delete(scanner.nextInt(), CenterConsole.class);
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
