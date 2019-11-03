package com.ab.buscardsystem;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class CenterConsole extends ParentObject{

    private AddingMoneyToCard addingMoneyToCard;
    private double balance;
    private DBFacade dbFacade;
    private Card card;
    private double amount;
    private String name;
    private String address;
    private LocalDate localDate = LocalDate.now();
    private LocalTime localTime = LocalTime.now();
    private FactoryInput factoryInput = new FactoryInput();

    public CenterConsole(DBFacade dbFacade){
        this.dbFacade = dbFacade;
    }
    public CenterConsole(){}

    public void enterCardId(int cardId, int centerId, AddingMoneyToCard addingMoneyToCard){
        getAndEquals(centerId);
        card = (Card) dbFacade.get(cardId, Card.class);
        if(card == null)
            return;
        addingMoneyToCard.setCard(card);
        System.out.print("Yüklemek istediğiniz tutarı giriniz: ");
        amount = factoryInput.inputDoubleAmount();
        this.addingMoneyToCard = addingMoneyToCard;
        enterAmount(amount);
    }

    public void enterAmount(double amount){
        addingMoneyToCard.setAmount(amount);
        System.out.print("Verilecek tutarı giriniz: ");
        double payment = factoryInput.inputDoublePayment();
        if(balance < amount) {
            System.out.println("Dolum Merkezinin bakiyesi yetersiz.");
            return;
        }
        addingMoneyToCard.setPayment(payment);
        addingMoneyToCard.createCardReceipt(new CardReceipt(amount, payment));
        addingMoneyToCard.getCardReceipt().setCardId(card.getId());
        addingMoneyToCard.getCardReceipt().setCenterConsoleId(getId());
        card.setBalance(card.getBalance() + amount);
        setBalance(getBalance() - amount);
        System.out.println("Önceki Bakiye: " + new DecimalFormat("##.##").format(card.getBalance() - amount));
        System.out.println("Güncel Bakiye: " + new DecimalFormat("##.##").format(card.getBalance()));
        dbFacade.update(card);
        dbFacade.update(CenterConsole.this);
        dbFacade.put(addingMoneyToCard.getCardReceipt());
    }

    public void getAndEquals(int id){
        CenterConsole centerConsoleWithoutDB = (CenterConsole) dbFacade.get(id, CenterConsole.class);
        CenterConsole centerConsoleWithDB = CenterConsole.this;

        centerConsoleWithDB.setId(centerConsoleWithoutDB.getId());
        centerConsoleWithDB.setBalance(centerConsoleWithoutDB.getBalance());
    }

    public AddingMoneyToCard getAddingMoneyToCard() {
        return addingMoneyToCard;
    }
    public void setAddingMoneyToCard(AddingMoneyToCard addingMoneyToCard) {
        this.addingMoneyToCard = addingMoneyToCard;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
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
    public DBFacade getDbFacade() {
        return dbFacade;
    }
    public void setDbFacade(DBFacade dbFacade) {
        this.dbFacade = dbFacade;
    }
    public Card getCard() {
        return card;
    }
    public void setCard(Card card) {
        this.card = card;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
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

}
