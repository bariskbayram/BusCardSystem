package com.ab.buscardsystem;

import java.util.Scanner;

public class WholeSystem {

    private DBFacade dbFacade = new DBFacade();
    private BusConsole busConsole = new BusConsole(dbFacade);
    private CenterConsole centerConsole = new CenterConsole(dbFacade);
    private CityCardConsole cityCardConsole = new CityCardConsole(dbFacade);
    private FactoryInput factoryInput = new FactoryInput();

    public WholeSystem() {
    }

    public void startTappingCard() {

        while (true) {
            System.out.print("Soför LogOut olmak istiyor mu?Devam etmek için 0'a, " +
                    "LogOut olmak için 1'e basınız: ");
            int logOut = factoryInput.inputIntegerId();
            if(logOut == 1)
                return;
            boolean tamBasılmışMı = false;
            System.out.print("Tam kart özelliği aktif edilsin mi?\nAktif etmek için 1 yazınız, " +
                    "aktif etmeden devam etmemek için 0 yazınız: ");
            if(factoryInput.inputIntegerId2() == 1)
                tamBasılmışMı = true;
            System.out.print("Lütfen CardId giriniz: ");
            int cardId = factoryInput.inputIntegerId3();
            if(tamBasılmışMı == true)
                busConsole.enterCardId(cardId, tamBasılmışMı, new TappingCard(0, 3.25));
            else{
                busConsole.enterCardId(cardId, tamBasılmışMı, new TappingCard(0));
            }
        }
    }

    public void startAddingMoneyToCard(){
        System.out.print("CenterId giriniz: ");
        int centerId = factoryInput.inputIntegerId();
        System.out.print("CardId giriniz: ");
        int CardId = factoryInput.inputIntegerId2();
        centerConsole.enterCardId(CardId, centerId, new AddingMoneyToCard());
    }

    public void startAddingMoneyToCenter(){
        System.out.println("Center Id giriniz : ");
        int id = factoryInput.inputIntegerId();
        cityCardConsole.enterCenterId(id, new AddingMoneyToCenter());
    }

    public void startAddingCard(){
        cityCardConsole.enterCardInfo(new AddingCard());
    }
    public void startAddingCenter(){ cityCardConsole.enterCenterInfo(new AddingCenter());}
    public void startAddingDriver(){cityCardConsole.enterDriverInfo(new AddingDriver());}
    public void startRemovingDriver(){
        cityCardConsole.deleteDriver();
    }
    public void startRemovingCenter(){ cityCardConsole.deleteCenter();}
    public void startDriverLogIn(){ busConsole.enterDriverId(new DriverLogIn());}

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
