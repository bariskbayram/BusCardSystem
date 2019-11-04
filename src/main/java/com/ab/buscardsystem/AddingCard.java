package com.ab.buscardsystem;

import java.time.LocalDate;
import java.time.LocalTime;

public class AddingCard extends ParentObject {

    private LocalDate localDate = LocalDate.now();
    private LocalTime localTime = LocalTime.now();
    private String name;
    private String surname;
    private String type;
    private int cardId;
    private Card card;
    private int isCorrect;
    private FactoryInput factoryInput = new FactoryInput();

    public Card setCardInfo(Card card){
        if(card == null)
            throw new NullPointerException("Card is null");
        isCorrect = 1;
        takeName();
        if(isCorrect == 0){
            System.out.println("You have entered the wrong 3 times.");
            return null;
        }
        takeSurname();
        if(isCorrect == 0){
            System.out.println("You have entered the wrong 3 times.");
            return null;
        }
        takeType();
        if(isCorrect == 0){
            System.out.println("You have entered the wrong 3 times.");
            return null;
        }
        takeId();
        if(isCorrect == 0){
            System.out.println("You have entered the wrong 3 times.");
            return null;
        }
        card.setId(cardId);
        card.setBalance(0);
        card.setName(name);
        card.setSurname(surname);
        card.setType(type);
        this.card = card;
        return card;
    }

    public void takeName(){
        isCorrect = 0;
        for(int i=0; i<3; i++) {
            System.out.print("Please enter name: ");
            name = factoryInput.inputStringName();
            if (name.length() < 15) {
                isCorrect = 1;
                break;
            } else {
                System.out.println("Name is too long, please try again!");
            }
        }
    }

    public void takeSurname(){
        isCorrect = 0;
        for(int i=0; i<3; i++) {
            System.out.print("Please enter surname: ");
            surname = factoryInput.inputStringSurname();
            if (surname.length() < 15) {
                isCorrect = 1;
                break;
            } else {
                System.out.println("Surname is too long, please try again!");
            }
        }
    }

    public void takeType(){
        isCorrect = 0;
        for(int i=0; i<3; i++) {
            System.out.print("Please enter user tpye: ");
            type = factoryInput.inputStringType().toUpperCase();
            if (type.toUpperCase().equals("STUDENT") || type.toUpperCase().equals("NORMAL")) {
                isCorrect = 1;
                break;
            } else {
                System.out.println("Type is wrong, please try again!");
            }
        }
    }

    public void takeId(){
        isCorrect = 0;
        for(int i=0; i<3; i++) {
            System.out.print("Please enter Card ID: ");
            cardId = factoryInput.inputIntegerId();
            if (cardId > 0 && cardId < 10000 && cardId != 7 && cardId != 18) {
                isCorrect = 1;
                break;
            } else {
                System.out.println("Card ID is wrong, please try again!");
            }
        }
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
    public String getType() {
        return type;
    }
    public void setType(String type) {
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
