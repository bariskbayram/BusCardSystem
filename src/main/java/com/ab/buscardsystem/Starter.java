package com.ab.buscardsystem;

public class Starter {

    public static void main(String[] args) {

        WholeSystem start = new WholeSystem();
        System.out.println("Bütün sistem oluşturuldu: " + start);
        start.start();
    }

}
