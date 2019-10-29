package com.ab.buscardsystem;

import java.util.Scanner;

public class WholeSystem {

    private DBFacade dbFacade = new DBFacade();
    private BusConsole busConsole = new BusConsole(dbFacade);

    public void setDbFacade(DBFacade dbFacade) {
        this.dbFacade = dbFacade;
    }

    public void setBusConsole(BusConsole busConsole) {
        this.busConsole = busConsole;
    }

    public DBFacade getDbFacade() {
        return dbFacade;
    }

    public BusConsole getBusConsole() {
        return busConsole;
    }

    public WholeSystem() {
    }

    public void start() {

        int cardId = 1;
        busConsole.enterCardId(cardId);

    }
}
