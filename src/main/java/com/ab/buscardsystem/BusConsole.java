package com.ab.buscardsystem;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Scanner;

public class BusConsole extends ParentObject {

    private Card card;
    private HashMap<Integer, LocalTime> invalidList = new HashMap<>();
    private TappingCard tappingCard;
    private DriverLogIn driverLogIn;
    private DBFacade dbFacade;
    private Driver driver;
    private LocalDate localDate = LocalDate.now();
    private LocalTime localTime = LocalTime.now();
    private boolean tamBasılmışMı;
    private FactoryInput factoryInput = new FactoryInput();

    public BusConsole(DBFacade dbFacade){
        this.dbFacade = dbFacade;
    }
    public BusConsole(){}

    public void enterCardId(int cardId, boolean tamBasılmısMıParameter, TappingCard tappingCard){
        this.tamBasılmışMı = tamBasılmısMıParameter;
        System.out.println(tamBasılmışMı);
        if(tamBasılmışMı == true) {
            tappingCard.setAmount(3.25);
        }else {
            if(invalidList.containsKey(cardId) == true &&
                    (localTime.getMinute() - invalidList.get(cardId).getMinute()) < 90 ){
                System.out.println("Gösterilmiş Kart!");
                return;
            }
        }
        tappingCard.setBusConsoleId(getId());
        card = (Card) dbFacade.get(cardId, Card.class);
        if(card == null)
            return;
        tappingCard.set(card);
        if(tappingCard.getAmount() > tappingCard.getCurrentBalance())
            return;
        tappingCard.setCardId(card.getId());
        setId(tappingCard.getBusConsoleId());
        this.tappingCard = tappingCard;
        dbFacade.update(card);
        dbFacade.put(tappingCard);
        invalidList.put(cardId, localTime);
    }

    public void enterDriverId(DriverLogIn driverLogIn){
        System.out.println("LogIn olacağınız Otobüsün Id'sini giriniz: ");
        int busConsoleId = factoryInput.inputIntegerId();
        driverLogIn.setBusConsoleId(busConsoleId);
        setId(busConsoleId);
        System.out.println("LogIn olmak için ID giriniz: ");
        int driverId = factoryInput.inputIntegerId2();
        driver = (Driver) dbFacade.get(driverId, Driver.class);
        driverLogIn.setLogin(driver);
        this.driverLogIn = driverLogIn;
        dbFacade.put(driverLogIn);
    }

   /* public void getAndEquals(){
        BusConsole busConsoleWithDB = BusConsole.this;
        BusConsole busConsoleWithoutDB = dbFacade.get();

    }*/

    public LocalDate getLocalDate() {
        return localDate;
    }
    public LocalTime getLocalTime() {
        return localTime;
    }
    public void setCard(Card card) {
        this.card = card;
    }
    public void setTappingCard(TappingCard tappingCard) {
        this.tappingCard = tappingCard;
    }
    public void setDbFacade(DBFacade dbFacade) {
        this.dbFacade = dbFacade;
    }
    public Card getCard() {
        return card;
    }
    public TappingCard getTappingCard() {
        return tappingCard;
    }
    public DBFacade getDbFacade() {
        return dbFacade;
    }
    public HashMap<Integer, LocalTime> getInvalidList() {
        return invalidList;
    }
    public void setInvalidList(HashMap<Integer, LocalTime> invalidList) {
        this.invalidList = invalidList;
    }
    public DriverLogIn getDriverLogIn() {
        return driverLogIn;
    }
    public void setDriverLogIn(DriverLogIn driverLogIn) {
        this.driverLogIn = driverLogIn;
    }
    public Driver getDriver() {
        return driver;
    }
    public void setDriver(Driver driver) {
        this.driver = driver;
    }
    public boolean isTamBasılmışMı() {
        return tamBasılmışMı;
    }
    public void setTamBasılmışMı(boolean tamBasılmışMı) {
        this.tamBasılmışMı = tamBasılmışMı;
    }

}
