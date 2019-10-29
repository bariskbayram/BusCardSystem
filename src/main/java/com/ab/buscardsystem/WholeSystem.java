package com.ab.buscardsystem;

import java.util.Scanner;

public class WholeSystem {

    private DBFacade dbFacade = new DBFacade();
    private BusConsole busConsole = new BusConsole(dbFacade);

    public WholeSystem() {
    }

    public void start() {

        while (true) {
            boolean tamBasılmışMı = false;
            Scanner scanner = new Scanner(System.in);
            System.out.println("Tam kart özelliği aktif edilsin mi?Aktif etmek için 1 yazınız.");
            if(scanner.nextInt() == 1)
                tamBasılmışMı = true;
            busConsole.enterCardId(1, tamBasılmışMı);
        }
    }

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
}
