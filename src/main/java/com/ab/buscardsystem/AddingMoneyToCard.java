package com.ab.buscardsystem;

public class AddingMoneyToCard {

    private int cardId;
    private double amount;
    private Card card;
    private CardReceipt cardReceipt;
    private double payment;

    public void createCardReceipt(double amount, double payment) {
        cardReceipt = new CardReceipt(amount, payment);
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
    public CardReceipt getCardReceipt() {
        return cardReceipt;
    }
    public void setCardReceipt(CardReceipt cardReceipt) {
        this.cardReceipt = cardReceipt;
    }
    public double getPayment() {
        return payment;
    }
    public void setPayment(double payment) {
        this.payment = payment;
    }
}
