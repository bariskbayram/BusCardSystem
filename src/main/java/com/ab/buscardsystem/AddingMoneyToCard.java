package com.ab.buscardsystem;

public class AddingMoneyToCard {

    private int cardId;
    private double amount;
    private Card card;
    private CardReceipt cardReceipt;
    private double payment;

    public void createCardReceipt(CardReceipt cardReceipt) {
        amount = cardReceipt.getAmount();
        payment = cardReceipt.getPayment();
        this.cardReceipt = cardReceipt;
        System.out.println("Payment: " + payment + " Amount: " + amount + " Change: " + (payment-amount));
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
