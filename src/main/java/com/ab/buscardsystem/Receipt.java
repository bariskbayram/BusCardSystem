package com.ab.buscardsystem;

import java.time.LocalDate;
import java.time.LocalTime;

public class Receipt extends ParentObject {

    private int receiptId;
    private int cardId;
    private LocalDate localDate = LocalDate.now();
    private LocalTime localTime = LocalTime.now();
    private double payment;
    private double change;
    private double amount;
    private int depositConsoleId;

    public Receipt(double amount, double payment){
        this.amount = amount;
        this.payment = payment;
        this.change = (payment - amount);
    }

    public int getDepositConsoleId() {
        return depositConsoleId;
    }
    public void setDepositConsoleId(int depositConsoleId) {
        this.depositConsoleId = depositConsoleId;
    }
    public int getReceiptId() {
        return receiptId;
    }
    public void setReceiptId(int receiptId) {
        this.receiptId = receiptId;
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
    public void setChange(double change) {
        this.change = change;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }

}
