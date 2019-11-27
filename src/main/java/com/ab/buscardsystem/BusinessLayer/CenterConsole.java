package com.ab.buscardsystem.BusinessLayer;

import com.ab.buscardsystem.DataLayer.DBFacade;
import com.ab.buscardsystem.ParentObject;

import java.time.LocalDate;
import java.time.LocalTime;

public class CenterConsole extends ParentObject {

    private AddingMoneyToCard addingMoneyToCard;
    private double balance;
    private DBFacade dbFacade;
    private Card card;
    private double amount;
    private String name;
    private String address;
    private LocalDate localDate = LocalDate.now();
    private LocalTime localTime = LocalTime.now();
    private boolean isCorrect;

    public CenterConsole(DBFacade dbFacade){
        this.dbFacade = dbFacade;
    }
    public CenterConsole(){}

    public Status enterCardId(int cardId, int centerId, AddingMoneyToCard addingMoneyToCard){
        isCorrect = getAndEquals(centerId);
        if(!isCorrect)
            return Status.GETANDEQUALSFAIL;
        card = (Card) dbFacade.get(cardId, Card.class);
        if(card == null){
            return Status.CARDNULL;
        }
        if(balance < addingMoneyToCard.getAmount()) {
            return Status.NOTENOUGHBALANCE;
        }
        addingMoneyToCard.setCard(card);
        this.addingMoneyToCard = addingMoneyToCard;
        enterAmount(addingMoneyToCard.getAmount());
        return Status.TRUE;
    }

    public void enterAmount(double amount){
        addingMoneyToCard.createCardReceipt(new CardReceipt(amount, addingMoneyToCard.getPayment()));
        addingMoneyToCard.getCardReceipt().setCardId(card.getId());
        addingMoneyToCard.getCardReceipt().setCenterConsoleId(getId());
        card.setBalance(card.getBalance() + amount);
        setBalance(getBalance() - amount);
        dbFacade.update(card);
        dbFacade.update(CenterConsole.this);
        dbFacade.put(addingMoneyToCard.getCardReceipt());
    }

    public boolean getAndEquals(int id){
        CenterConsole centerConsoleWithoutDB = (CenterConsole) dbFacade.get(id, CenterConsole.class);
        if(centerConsoleWithoutDB == null){
            return false;
        }
        CenterConsole centerConsoleWithDB = CenterConsole.this;

        centerConsoleWithDB.setId(centerConsoleWithoutDB.getId());
        centerConsoleWithDB.setBalance(centerConsoleWithoutDB.getBalance());
        return true;
    }

    public AddingMoneyToCard getAddingMoneyToCard() {
        return addingMoneyToCard;
    }
    public void setAddingMoneyToCard(AddingMoneyToCard addingMoneyToCard) {
        this.addingMoneyToCard = addingMoneyToCard;
    }
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
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
    public DBFacade getDbFacade() {
        return dbFacade;
    }
    public void setDbFacade(DBFacade dbFacade) {
        this.dbFacade = dbFacade;
    }
    public Card getCard() {
        return card;
    }
    public void setCard(Card card) {
        this.card = card;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public boolean isCorrect() {
        return isCorrect;
    }
    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }
}
