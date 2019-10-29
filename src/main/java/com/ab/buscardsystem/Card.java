package com.ab.buscardsystem;

public class Card extends ParentObject {

    private String Name;
    private String Surname;
    private int Bakiye;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public int getBakiye() {
        return Bakiye;
    }

    public void setBakiye(int bakiye) {
        Bakiye = bakiye;
    }

    public Card(int id){
        int CardId = id;
        this.setId(CardId);
    }
}
