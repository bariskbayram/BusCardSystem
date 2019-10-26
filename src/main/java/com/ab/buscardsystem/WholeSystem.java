package com.ab.buscardsystem;

import java.util.Scanner;

public class WholeSystem {

    private DBFacade dbFacade;
    private BusConsole busConsole;

    public DBFacade getDbFacade() {
        return dbFacade;
    }

    public BusConsole getBusConsole() {
        return busConsole;
    }

    public WholeSystem() {

        DBFacade dbFacade = new DBFacade();
        this.dbFacade = dbFacade;
        System.out.println("Wholesystem dbfacade nesnesini oluşturdu." + dbFacade);
        BusConsole busConsole = new BusConsole(dbFacade);
        this.busConsole = busConsole;
        System.out.println("Wholesystem busconsole nesnesini oluşturdu." + busConsole);

    }

    public void start(){
        int cardId;
        System.out.print("CardId giriniz: ");
        Scanner deneme = new Scanner(System.in);
        cardId = deneme.nextInt();

        busConsole.enterCardId(cardId);
    }

}
