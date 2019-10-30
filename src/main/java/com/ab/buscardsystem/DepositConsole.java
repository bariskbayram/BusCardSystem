package com.ab.buscardsystem;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class DepositConsole extends ParentObject{

    private DepositToCard depositToCard;
    private int depositConsoleId = 1;
    private double depositConsoleBalance = 20;
    private DBFacade dbFacade;
    private Card card;
    private double amount;
    private LocalDate localDate = LocalDate.now();
    private LocalTime localTime = LocalTime.now();

    public DepositConsole(DBFacade dbFacade){
        this.dbFacade = dbFacade;
    }

    public void enterCardId(int cardId){
        depositToCard = new DepositToCard();
        card = (Card) dbFacade.get(cardId, Card.class);
        if(card == null)
            return;
        depositToCard.setCard(card);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Yüklemek istediğiniz tutarı giriniz: ");
        amount = scanner.nextDouble();
        enterAmount(amount);
    }

    public void enterAmount(double amount){
        depositToCard.setAmount(amount);
        Scanner scanner = new Scanner(System.in);
        System.out.print("Verilecek tutarı giriniz: ");
        double payment = scanner.nextDouble();
        if(depositConsoleBalance < amount) {
            System.out.println("Dolum Merkezinin bakiyesi yetersiz.");
            return;
        }
        depositToCard.setPayment(payment);
        depositToCard.createReceipt(amount, payment);
        depositToCard.getReceipt().setCardId(card.getId());
        depositToCard.getReceipt().setDepositConsoleId(depositConsoleId);
        card.setBalance(card.getBalance() + amount);
        setDepositConsoleBalance(getDepositConsoleBalance() - amount);
        System.out.println("Önceki Bakiye: " + new DecimalFormat("##.##").format(card.getBalance() - amount));
        System.out.println("Güncel Bakiye: " + new DecimalFormat("##.##").format(card.getBalance()));
        dbFacade.put(card);
        dbFacade.put(DepositConsole.this);
        dbFacade.put(depositToCard.getReceipt());
    }

    public DepositToCard getDepositToCard() {
        return depositToCard;
    }
    public void setDepositToCard(DepositToCard depositToCard) {
        this.depositToCard = depositToCard;
    }
    public int getDepositConsoleId() {
        return depositConsoleId;
    }
    public void setDepositConsoleId(int depositConsoleId) {
        this.depositConsoleId = depositConsoleId;
    }
    public double getDepositConsoleBalance() {
        return depositConsoleBalance;
    }
    public void setDepositConsoleBalance(double depositConsoleBalance) {
        this.depositConsoleBalance = depositConsoleBalance;
    }
    public LocalDate getLocalDate() {
        return localDate;
    }
    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
    public LocalTime getLocalTime() {
        return localTime;
    }
    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }

}
