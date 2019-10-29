package com.ab.buscardsystem;

import java.util.Scanner;

public class WholeSystem {

    private DBFacade dbFacade  = new DBFacade();
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

    public void start(){

        int cardId = 32;

        busConsole.enterCardId(cardId);
    }

}
