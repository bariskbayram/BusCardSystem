package com.ab.buscardsystem;

public class Driver extends ParentObject{

    private String name;
    private String surname;
    public Driver(int driverId){
        setId(driverId);
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

}
