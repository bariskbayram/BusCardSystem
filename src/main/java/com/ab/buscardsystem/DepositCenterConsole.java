package com.ab.buscardsystem;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class DepositCenterConsole extends ParentObject{

    private DepositToCard depositToCard;
    private int depositCenterConsoleId;
    private double depositCenterConsoleBalance;
    private DBFacade dbFacade;
    private Card card;
    private double amount;
    private LocalDate localDate = LocalDate.now();
    private LocalTime localTime = LocalTime.now();

    public DepositCenterConsole(DBFacade dbFacade){
        this.dbFacade = dbFacade;
    }
    public DepositCenterConsole(){
    }

    public void enterCardId(int cardId){
        depositToCard = new DepositToCard();
        getAndEquals();
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
        if(depositCenterConsoleBalance < amount) {
            System.out.println("Dolum Merkezinin bakiyesi yetersiz.");
            return;
        }
        depositToCard.setPayment(payment);
        depositToCard.createCardDepositReceipt(amount, payment);
        depositToCard.getCardDepositReceipt().setCardId(card.getId());
        depositToCard.getCardDepositReceipt().setDepositCenterConsoleId(depositCenterConsoleId);
        card.setBalance(card.getBalance() + amount);
        setDepositCenterConsoleBalance(getDepositCenterConsoleBalance() - amount);
        System.out.println("Önceki Bakiye: " + new DecimalFormat("##.##").format(card.getBalance() - amount));
        System.out.println("Güncel Bakiye: " + new DecimalFormat("##.##").format(card.getBalance()));
        dbFacade.put(card);
        dbFacade.put(DepositCenterConsole.this);
        dbFacade.put(depositToCard.getCardDepositReceipt());
    }

    public void getAndEquals(){
        DepositCenterConsole depositCenterConsoleWithoutDB = (DepositCenterConsole) dbFacade.get(1, DepositCenterConsole.class);
        DepositCenterConsole depositCenterConsoleWithDB = DepositCenterConsole.this;

        depositCenterConsoleWithDB.setDepositCenterConsoleId(depositCenterConsoleWithoutDB.getDepositCenterConsoleId());
        depositCenterConsoleWithDB.setDepositCenterConsoleBalance(depositCenterConsoleWithoutDB.getDepositCenterConsoleBalance());
    }

    public DepositToCard getDepositToCard() {
        return depositToCard;
    }
    public void setDepositToCard(DepositToCard depositToCard) {
        this.depositToCard = depositToCard;
    }
    public int getDepositCenterConsoleId() {
        return depositCenterConsoleId;
    }
    public void setDepositCenterConsoleId(int depositCenterConsoleId) {
        this.depositCenterConsoleId = depositCenterConsoleId;
    }
    public double getDepositCenterConsoleBalance() {
        return depositCenterConsoleBalance;
    }
    public void setDepositCenterConsoleBalance(double depositCenterConsoleBalance) {
        this.depositCenterConsoleBalance = depositCenterConsoleBalance;
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
