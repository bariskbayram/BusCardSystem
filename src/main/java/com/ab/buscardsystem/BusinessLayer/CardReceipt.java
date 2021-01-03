package com.ab.buscardsystem.BusinessLayer;

import com.ab.buscardsystem.ParentObject;

import java.time.LocalDate;
import java.time.LocalTime;

public class CardReceipt extends ParentObject {

    private int cardId;
    private LocalDate localDate = LocalDate.now();
    private LocalTime localTime = LocalTime.now();
    private double payment;
    private double change;
    private double amount;
    private int centerConsoleId;

    public CardReceipt(double amount, double payment){
        this.amount = amount;
        this.payment = payment;
        this.change = (payment - amount);
    }

    public int getCenterConsoleId() {
        return centerConsoleId;
    }
    public void setCenterConsoleId(int centerConsoleId) {
        this.centerConsoleId = centerConsoleId;
    }
    public int getCardId() {
        return cardId;
    }
    public void setCardId(int cardId) {
        this.cardId = cardId;
    }
    public LocalDate getLocalDate() {
        return localDate;
    }
    public LocalTime getLocalTime() {
        return localTime;
    }
    public double getPayment() {
        return payment;
    }
    public void setPayment(double payment) {
        this.payment = payment;
    }
    public double getChange() {
        return change;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }

}
