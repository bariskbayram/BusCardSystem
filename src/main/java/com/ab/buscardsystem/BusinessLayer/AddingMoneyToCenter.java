package com.ab.buscardsystem.BusinessLayer;

public class AddingMoneyToCenter {

    private int id;
    private double amount;
    private double payment;
    private CenterConsole centerConsole;
    private CenterReceipt centerReceipt;

    public void createCenterReceipt(CenterReceipt centerReceipt) {
        amount = centerReceipt.getAmount();
        payment = centerReceipt.getPayment();
        this.centerReceipt = centerReceipt;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public double getPayment() {
        return payment;
    }
    public void setPayment(double payment) {
        this.payment = payment;
    }
    public void setCenterConsole(CenterConsole centerConsole) {
        this.centerConsole = centerConsole;
    }
    public CenterReceipt getCenterReceipt() {
        return centerReceipt;
    }
}
