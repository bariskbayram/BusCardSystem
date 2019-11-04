package com.ab.buscardsystem;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;

public class TappingCard extends ParentObject {

    private double amount;
    private LocalDate localDate = LocalDate.now();
    private LocalTime localTime = LocalTime.now();
    private int busConsoleId;
    private int cardId;
    private int constructorTip = 0;
    private double cardDefaultPrice;
    private double currentBalance;

    public TappingCard(int busConsoleId){
        this.busConsoleId = busConsoleId;
        this.amount = 0;
    }
    public TappingCard(int busConsoleId, double amount){
        this.busConsoleId = busConsoleId;
        this.amount = amount;
        this.constructorTip = 1;
    }

    public void set(Card card){
        currentBalance = card.getBalance();
        if(card.getType().equals("STUDENT")){
            cardDefaultPrice = 2.10;
        }else{
            cardDefaultPrice = 3.25;
        }
        if(constructorTip == 0){
            this.amount = cardDefaultPrice;
        }
        if(amount > card.getBalance()){
            System.out.println("Card's balance is not enough.");
            return;
        }else{
            card.setBalance(card.getBalance() - amount);
            System.out.println("Previous Balance: " + new DecimalFormat("##.##").format(currentBalance));
            System.out.println("Current Balance: " + new DecimalFormat("##.##").format(card.getBalance()));
        }
    }

    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
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
    public int getCardId() {
        return cardId;
    }
    public void setCardId(int cardId) {
        this.cardId = cardId;
    }
    public void setConstructorTip(int constructorTip) {
        this.constructorTip = constructorTip;
    }
    public void setCardDefaultPrice(double cardDefaultPrice) {
        this.cardDefaultPrice = cardDefaultPrice;
    }
    public int getConstructorTip() {
        return constructorTip;
    }
    public double getCardDefaultPrice() {
        return cardDefaultPrice;
    }
    public double getCurrentBalance() {
        return currentBalance;
    }
    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }
    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

}
