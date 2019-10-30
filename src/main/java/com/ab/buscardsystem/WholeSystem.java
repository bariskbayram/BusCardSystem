package com.ab.buscardsystem;

import java.util.Scanner;

public class WholeSystem {

    private DBFacade dbFacade = new DBFacade();
    private BusConsole busConsole = new BusConsole(dbFacade);
    private DepositCenterConsole depositCenterConsole = new DepositCenterConsole(dbFacade);
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

    public void startDepositToCard(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("CardId giriniz: ");
        int id = scanner.nextInt();
        depositCenterConsole.enterCardId(id);
    }

    public void startDepositToDepositCenter(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Deposit Center Id giriniz : ");
        int id = scanner.nextInt();
        cityCardConsole.enterDepositCenterId(id);

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
    public DepositCenterConsole getDepositCenterConsole() {
        return depositCenterConsole;
    }

    public void setDepositCenterConsole(DepositCenterConsole depositCenterConsole) {
        this.depositCenterConsole = depositCenterConsole;
    }

    public CityCardConsole getCityCardConsole() {
        return cityCardConsole;
    }

    public void setCityCardConsole(CityCardConsole cityCardConsole) {
        this.cityCardConsole = cityCardConsole;
    }
}
