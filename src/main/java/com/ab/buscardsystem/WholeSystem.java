package com.ab.buscardsystem;

import java.util.Scanner;

public class WholeSystem {

    private DBFacade dbFacade = new DBFacade();
    private BusConsole busConsole = new BusConsole(dbFacade);
    private CenterConsole centerConsole = new CenterConsole(dbFacade);
    private CityCardConsole cityCardConsole = new CityCardConsole(dbFacade);

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

    public void startAddingMoneyToCard(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("CardId giriniz: ");
        int id = scanner.nextInt();
        centerConsole.enterCardId(id);
    }

    public void startAddingMoneyToCenter(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Deposit Center Id giriniz : ");
        int id = scanner.nextInt();
        cityCardConsole.enterCenterId(id);

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
    public CenterConsole getCenterConsole() {
        return centerConsole;
    }
    public void setCenterConsole(CenterConsole centerConsole) {
        this.centerConsole = centerConsole;
    }
    public CityCardConsole getCityCardConsole() {
        return cityCardConsole;
    }
    public void setCityCardConsole(CityCardConsole cityCardConsole) {
        this.cityCardConsole = cityCardConsole;
    }

}
