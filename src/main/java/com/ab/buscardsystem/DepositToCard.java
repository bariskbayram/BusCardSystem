package com.ab.buscardsystem;

public class DepositToCard {

    private int cardId;
    private double amount;
    private Card card;
    private CardDepositReceipt cardDepositReceipt;
    private double payment;

    public void createCardDepositReceipt(double amount, double payment) {
        cardDepositReceipt = new CardDepositReceipt(amount, payment);
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
    public CardDepositReceipt getCardDepositReceipt() {
        return cardDepositReceipt;
    }
    public void setCardDepositReceipt(CardDepositReceipt cardDepositReceipt) {
        this.cardDepositReceipt = cardDepositReceipt;
    }
    public double getPayment() {
        return payment;
    }
    public void setPayment(double payment) {
        this.payment = payment;
    }
}
