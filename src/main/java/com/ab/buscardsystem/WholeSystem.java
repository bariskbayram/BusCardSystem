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
            Scanner scanner = new Scanner(System.in);
            System.out.print("Soför LogOut olmak istiyor mu?Devam etmek için 0'a, " +
                    "LogOut olmak için 1'e basınız: ");
            int logOut = scanner.nextInt();
            if(logOut == 1)
                return;
            boolean tamBasılmışMı = false;
            System.out.print("Tam kart özelliği aktif edilsin mi?\nAktif etmek için 1 yazınız, " +
                    "aktif etmeden devam etmemek için 0 yazınız: ");
            if(scanner.nextInt() == 1)
                tamBasılmışMı = true;
            System.out.print("Lütfen CardId giriniz: ");
            int cardId = scanner.nextInt();
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
        System.out.println("Center Id giriniz : ");
        int id = scanner.nextInt();
        cityCardConsole.enterCenterId(id);
    }

    public void startAddingCard(){
        cityCardConsole.enterCardInfo();
    }
    public void startAddingCenter(){ cityCardConsole.enterCenterInfo();}
    public void startAddingDriver(){cityCardConsole.enterDriverInfo();}
    public void startRemovingDriver(){
        cityCardConsole.deleteDriver();
    }
    public void startRemovingCenter(){ cityCardConsole.deleteCenter();}
    public void startDriverLogIn(){ busConsole.enterDriverId();}

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
