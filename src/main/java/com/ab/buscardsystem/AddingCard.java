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

    public Card setCardInfo(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("İsim giriniz: ");
        name = scanner.nextLine();
        System.out.print("Soyad giriniz: ");
        surname = scanner.nextLine();
        System.out.print("Tip giriniz: ");
        tip = scanner.nextLine();
        System.out.print("Id giriniz: ");
        cardId = scanner.nextInt();
        card = new Card(cardId);
        card.setBalance(0);
        card.setName(name);
        card.setSurname(surname);
        card.setTip(tip);
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
}
