package com.ab.buscardsystem;

public class DepositToDepositCenter {

    private int depositToDepositCenterId;
    private int depositCenterConsoleId;
    private double amount;
    private double payment;
    private DepositCenterConsole depositCenterConsole;
    private DepositToDepositCenterReceipt depositToDepositCenterReceipt;

    public int getDepositToDepositCenterId() {
        return depositToDepositCenterId;
    }
    public void setDepositToDepositCenterId(int depositToDepositCenterId) {
        this.depositToDepositCenterId = depositToDepositCenterId;
    }
    public int getDepositCenterConsoleId() {
        return depositCenterConsoleId;
    }
    public void setDepositCenterConsoleId(int depositCenterConsoleId) {
        this.depositCenterConsoleId = depositCenterConsoleId;
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
    public DepositCenterConsole getDepositCenterConsole() {
        return depositCenterConsole;
    }
    public void setDepositCenterConsole(DepositCenterConsole depositCenterConsole) {
        this.depositCenterConsole = depositCenterConsole;
    }
    public DepositToDepositCenterReceipt getDepositToDepositCenterReceipt() {
        return depositToDepositCenterReceipt;
    }
    public void setDepositToDepositCenterReceipt(DepositToDepositCenterReceipt depositToDepositCenterReceipt) {
        this.depositToDepositCenterReceipt = depositToDepositCenterReceipt;
    }

}
