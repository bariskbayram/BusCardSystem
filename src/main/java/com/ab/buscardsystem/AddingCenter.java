package com.ab.buscardsystem;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class AddingCenter extends ParentObject {
    private SqliteDB sqliteDB;
    private LocalDate localDate = LocalDate.now();
    private LocalTime localTime = LocalTime.now();
    private String name;
    private String address;
    private CenterConsole centerConsole;
    private int centerId;

    public CenterConsole setCenterInfo(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("İsim giriniz: ");
        name = scanner.nextLine();
        System.out.print("Adres giriniz: ");
        address = scanner.nextLine();
        System.out.print("Id giriniz: ");
        centerId = scanner.nextInt();
        centerConsole = new CenterConsole();
        centerConsole.setName(name);
        centerConsole.setAddress(address);
        centerConsole.setId(centerId);
        return centerConsole;
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
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public CenterConsole getCenterConsole() {
        return centerConsole;
    }
    public void setCenterConsole(CenterConsole centerConsole) {
        this.centerConsole = centerConsole;
    }

}
