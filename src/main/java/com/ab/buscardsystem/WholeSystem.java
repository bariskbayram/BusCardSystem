package com.ab.buscardsystem;

import java.util.Scanner;

public class WholeSystem {

    private DBFacade dbFacade = new DBFacade();
    private BusConsole busConsole = new BusConsole(dbFacade);
    private DepositConsole depositConsole = new DepositConsole(dbFacade);

    public WholeSystem() {
    }

    public void startTappingCard() {

        while (true) {
            boolean tamBasılmışMı = false;
            Scanner scannerOne = new Scanner(System.in);
            System.out.print("Tam kart özelliği aktif edilsin mi?\nAktif etmek için 1 yazınız, " +
                    "aktif etmeden devam etmemek için 0 yazınız: ");
            if(scannerOne.nextInt() == 1)
                tamBasılmışMı = true;
            Scanner scannerTwo = new Scanner(System.in);
            System.out.print("Lütfen CardId giriniz: ");
            int cardId = scannerTwo.nextInt();
            busConsole.enterCardId(cardId, tamBasılmışMı);
        }
    }

    public void startDepositToCard(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("CardId giriniz: ");
        int id = scanner.nextInt();
        depositConsole.enterCardId(id);
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
