package com.ab.buscardsystem;

import java.util.Scanner;

public class DepositToCard {

    private int cardId;
    private double amount;
    private Card card;
    private Receipt receipt;
    private double payment;

    public void createReceipt(double amount, double payment) {
        receipt = new Receipt(amount, payment);
        System.out.println("Verilen tutar: " + payment + " Yüklenecek tutar: " + amount + " Para üstü: " + (payment-amount));
    }

    public int getCardId() {
        return cardId;
    }
    public void setCardId(int cardId) {
        this.cardId = cardId;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public Card getCard() {
        return card;
    }
    public void setCard(Card card) {
        this.card = card;
    }
    public Receipt getReceipt() {
        return receipt;
    }
    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }
    public double getPayment() {
        return payment;
    }
    public void setPayment(double payment) {
        this.payment = payment;
    }
}
