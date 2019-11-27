package com.ab.buscardsystem.BusinessLayer;

import com.ab.buscardsystem.FactoryInput;
import com.ab.buscardsystem.ParentObject;

import java.time.LocalDate;
import java.time.LocalTime;

public class AddingCard extends ParentObject {

    private LocalDate localDate = LocalDate.now();
    private LocalTime localTime = LocalTime.now();
    private String name;
    private String surname;
    private CardType type;
    private int cardId;
    private Card card;
    private int isCorrect;
    private FactoryInput factoryInput = new FactoryInput();

    public Card setCardInfo(Card card){
        card.setId(cardId);
        card.setBalance(0);
        card.setName(name);
        card.setSurname(surname);
        card.setType(type);
        this.card = card;
        return card;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }
    public LocalTime getLocalTime() {
        return localTime;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public CardType getType() {
        return type;
    }
    public void setType(CardType type) {
        this.type = type;
    }
    public int getCardId() {
        return cardId;
    }
    public void setCardId(int cardId) {
        this.cardId = cardId;
    }
    public Card getCard() {
        return card;
    }
    public void setCard(Card card) {
        this.card = card;
    }
    public int getIsCorrect() {
        return isCorrect;
    }
    public void setIsCorrect(int isCorrect) {
        this.isCorrect = isCorrect;
    }
    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
    public void setLocalTime(LocalTime localTime) {
        this.localTime = localTime;
    }
    public FactoryInput getFactoryInput() {
        return factoryInput;
    }
    public void setFactoryInput(FactoryInput factoryInput) {
        this.factoryInput = factoryInput;
    }

}
