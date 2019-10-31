package com.ab.buscardsystem;

import java.sql.SQLException;
import java.util.Scanner;

public class Starter {

    public static void main(String[] args){
        startScreen();
    }

    public static void startScreen(){
        while (true){
            System.out.println("1 -> KentKart Konsolu");
            System.out.println("2 -> Dolum Merkezi Konsolu");
            System.out.println("3 -> Otobüs Konsolu");
            System.out.println("0 -> Çıkış");
            System.out.print("Yapmak istediğiniz işlemin numarasını giriniz: ");
            Scanner scanner = new Scanner(System.in);
            int decision = scanner.nextInt();
            switch (decision){
                case 1:
                    System.out.println("KentKart konsolu çalıştı.");
                    startCityCardConsole();
                    System.out.println("\n--------------------------------------\n");
                    break;
                case 2:
                    System.out.println("Dolum Merkezi konsolu çalıştı");
                    startCenterConsoleScreen();
                    System.out.println("\n--------------------------------------\n");
                    break;
                case 3:
                    System.out.println("\nOtobüs konsolu çalıştı.");
                    System.out.println("\n--------------------------------------\n");
                    startBusConsoleScreen();
                    System.out.println("\n--------------------------------------\n");
                    break;
                case 0:
                    System.out.println("\n--------------------------------------\n");
                    System.out.println("Çıkış işlemi gerçekleşti.");
                    return;
                default:
                    System.out.println("Hatalı giriş yaptınız.Tekrar giriniz..");
                    System.out.println("\n--------------------------------------\n");
                    break;
            }
        }
    }

    public static void startBusConsoleScreen() {
            WholeSystem start = new WholeSystem();
            start.startDriverLogIn();
            start.startTappingCard();
    }

    public static void startCenterConsoleScreen() {
        WholeSystem start = new WholeSystem();
        while (true) {
            start.startAddingMoneyToCard();
        }
    }

    public static void startCityCardConsole(){
        WholeSystem start = new WholeSystem();
        while (true) {
            System.out.println("1 -> Yeni Kart ekleme");
            System.out.println("2 -> Dolum Merkezine bakiye yükleme");
            System.out.println("3 -> Yeni Dolum Merkezi ekleme");
            System.out.println("4 -> Mevcut Dolum Merkezi çıkarma");
            System.out.println("5 -> Yeni Sürücü ekleme");
            System.out.println("6 -> Mevcut Sürücü çıkarma");
            System.out.println("0 -> Çıkış");
            System.out.print("Yapmak istediğiniz işlemin numarasını giriniz: ");
            Scanner scanner = new Scanner(System.in);
            int decision = scanner.nextInt();
            switch (decision) {
                case 1:
                    start.startAddingCard();
                    break;
                case 2:
                    start.startAddingMoneyToCenter();
                    break;
                case 3:
                    start.startAddingCenter();
                    break;
                case 4:
                    start.startRemovingCenter();
                    break;
                case 5:
                    start.startAddingDriver();
                    break;
                case 6:
                    start.startRemovingDriver();
                    break;
                case 0:
                    System.out.println("Çıkış işlemi gerçekleştirildi.");
                    return;
                default:
                    System.out.println("Hatalı giriş yaptınız.Tekrar giriniz.");
                    break;
            }
        }
    }

}
