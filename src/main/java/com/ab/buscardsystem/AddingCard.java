package com.ab.buscardsystem;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class AddingCard extends ParentObject {

    private LocalDate localDate = LocalDate.now();
    private LocalTime localTime = LocalTime.now();
    private String name;
    private String surname;
    private String tip;
    private int cardId;
    private Card card;

    public void setIsCorrect(int isCorrect) {
        this.isCorrect = isCorrect;
    }

    private int isCorrect;
    private FactoryInput factoryInput = new FactoryInput();

    public Card setCardInfo(Card card){
        isCorrect = 1;
        takeName();
        if(isCorrect == 0)
            return null;
        takeSurname();
        if(isCorrect == 0)
            return null;
        takeTip();
        if(isCorrect == 0)
            return null;
        takeId();
        if(isCorrect == 0)
            return null;
        card.setId(cardId);
        card.setBalance(0);
        card.setName(name);
        card.setSurname(surname);
        card.setTip(tip);
        this.card = card;
        return card;
    }

    public void takeName(){
        isCorrect = 0;
        for(int i=0; i<3; i++) {
            System.out.print("İsim giriniz: ");
            name = factoryInput.inputStringName();
            if (name.length() < 15) {
                isCorrect = 1;
                break;
            } else {
                System.out.println("Çok uzun isim girdiniz, tekrar deneyin!");
            }
        }
    }

    public void takeSurname(){
        isCorrect = 0;
        for(int i=0; i<3; i++) {
            System.out.print("Soyad giriniz: ");
            surname = factoryInput.inputStringSurname();
            if (surname.length() < 15) {
                isCorrect = 1;
                break;
            } else {
                System.out.println("Çok uzun soyad girdiniz, tekrar deneyin!");
            }
        }
    }

    public void takeTip(){
        isCorrect = 0;
        for(int i=0; i<3; i++) {
            System.out.print("Tip giriniz: ");
            tip = factoryInput.inputStringTip();
            if (tip.toUpperCase().equals("ÖĞRENCİ") || tip.toUpperCase().equals("TAM")) {
                isCorrect = 1;
                break;
            } else {
                System.out.println("Yanlış tip girdiniz, tekrar deneyin!");
            }
        }
    }

    public void takeId(){
        isCorrect = 0;
        for(int i=0; i<3; i++) {
            System.out.print("Id giriniz: ");
            cardId = factoryInput.inputIntegerId();
            if (cardId > 0 && cardId < 10.000 && cardId != 7 && cardId != 18) {
                isCorrect = 1;
                break;
            } else {
                System.out.println("Yanlış tip girdiniz, tekrar deneyin!");
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
    public String getTip() {
        return tip;
    }
    public void setTip(String tip) {
        this.tip = tip;
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
}
