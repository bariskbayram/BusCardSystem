package com.ab.buscardsystem.BusinessLayer;

import com.ab.buscardsystem.ParentObject;

public class Card extends ParentObject {

    private String name;
    private String surname;
    private double balance;
    private CardType type;
    private Boolean situation = true;

    public Card(int id){
        this.setId(id);
    }

    public void setType(CardType type) {
        this.type = type;
    }
    public CardType getType() {
        return type;
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
    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
}
