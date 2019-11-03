package com.ab.buscardsystem;

public class AddingMoneyToCenter {

    private int id;
    private int centerConsoleId;
    private double amount;
    private double payment;
    private CenterConsole centerConsole;
    private CenterReceipt centerReceipt;

    public void createCenterReceipt(CenterReceipt centerReceipt) {
        amount = centerReceipt.getAmount();
        payment = centerReceipt.getPayment();
        this.centerReceipt = centerReceipt;
        System.out.println("\nPayment : " + payment +"\nAmount : " + amount + "\nChange : " + (payment - amount));
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCenterConsoleId() {
        return centerConsoleId;
    }
    public void setCenterConsoleId(int centerConsoleId) {
        this.centerConsoleId = centerConsoleId;
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
    public CenterConsole getCenterConsole() {
        return centerConsole;
    }
    public void setCenterConsole(CenterConsole centerConsole) {
        this.centerConsole = centerConsole;
    }
    public CenterReceipt getCenterReceipt() {
        return centerReceipt;
    }
    public void setCenterReceipt(CenterReceipt centerReceipt) {
        this.centerReceipt = centerReceipt;
    }

}
