package com.ab.buscardsystem;

import java.time.LocalDate;
import java.time.LocalTime;

public class DepositToDepositCenterReceipt extends ParentObject {

    private double payment;
    private double amount;
    private double change;
    private LocalTime localTime = LocalTime.now();
    private LocalDate localDate = LocalDate.now();
    private int depositToDepositCenterReceiptId;
    private int depositCenterConsoleId;

    public DepositToDepositCenterReceipt (double amount, double payment){
        this.amount = amount;
        this.payment = payment;
        this.change = (payment - amount);
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public LocalTime getLocalTime() {
        return localTime;
    }

    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public int getDepositToDepositCenterReceiptId() {
        return depositToDepositCenterReceiptId;
    }

    public void setDepositToDepositCenterReceiptId(int depositToDepositCenterReceiptId) {
        this.depositToDepositCenterReceiptId = depositToDepositCenterReceiptId;
    }

    public int getDepositCenterConsoleId() {
        return depositCenterConsoleId;
    }

    public void setDepositCenterConsoleId(int depositCenterConsoleId) {
        this.depositCenterConsoleId = depositCenterConsoleId;
    }
}
