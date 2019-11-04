package com.ab.buscardsystem;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;

public class BusConsole extends ParentObject {

    private Card card;
    private HashMap<Integer, LocalTime> invalidList = new HashMap<>();
    private TappingCard tappingCard;
    private DriverLogIn driverLogIn;
    private DBFacade dbFacade;
    private Driver driver;
    private LocalDate localDate = LocalDate.now();
    private LocalTime localTime = LocalTime.now();
    private boolean isTappingNormal;
    private FactoryInput factoryInput = new FactoryInput();
    private boolean cardTappingSitutation;
    private boolean balanceSitutation;

    public BusConsole(DBFacade dbFacade){
        this.dbFacade = dbFacade;
    }
    public BusConsole(){}

    public void enterCardId(int cardId, boolean isTappingNormalParameter, TappingCard tappingCard){
        this.isTappingNormal = isTappingNormalParameter;
        if(isTappingNormal == true) {
            tappingCard.setAmount(3.25);
        }else {
            cardTappingSitutation = isCardAlreadyTapped(cardId);
            if(!cardTappingSitutation){
                return;
            }
        }
        tappingCard.setBusConsoleId(getId());
        card = (Card) dbFacade.get(cardId, Card.class);
        if(card == null)
            return;
        tappingCard.set(card);
        balanceSitutation = isCardBalanceEnough(tappingCard);
        if(!balanceSitutation)
            return;
        tappingCard.setCardId(card.getId());
        setId(tappingCard.getBusConsoleId());
        this.tappingCard = tappingCard;
        dbFacade.update(card);
        dbFacade.put(tappingCard);
        invalidList.put(cardId, localTime);
    }

    public void enterDriverId(DriverLogIn driverLogIn){
        System.out.println("Please enter BusConsole ID : ");
        int busConsoleId = factoryInput.inputIntegerId();
        driverLogIn.setBusConsoleId(busConsoleId);
        setId(busConsoleId);
        System.out.println("Please enter Driver ID: ");
        int driverId = factoryInput.inputIntegerId2();
        driver = (Driver) dbFacade.get(driverId, Driver.class);
        driverLogIn.setLogin(driver);
        this.driverLogIn = driverLogIn;
        dbFacade.put(driverLogIn);
    }

    public boolean isCardAlreadyTapped(int cardId) {

        if (invalidList.containsKey(cardId) == true) {
            int time = (localTime.getMinute() - invalidList.get(cardId).getMinute());
            System.out.println(time);
            if (time < 45) {
                System.out.println("Card is already tapped!");
                return false;
            }else {
                return true;
            }
        }else {
            return true;
        }
    }

    public boolean isCardBalanceEnough(TappingCard tappingCard){
        if(tappingCard.getAmount() > tappingCard.getCurrentBalance()) {
            return false;
        }else{
            return true;
        }
    }

   /* public void getAndEquals(){
        BusConsole busConsoleWithDB = BusConsole.this;
        BusConsole busConsoleWithoutDB = dbFacade.get();

    }*/

    public boolean isCardTappingSitutation() {
        return cardTappingSitutation;
    }
    public void setCardTappingSitutation(boolean cardTappingSitutation) {
        this.cardTappingSitutation = cardTappingSitutation;
    }
    public boolean isBalanceSitutation() {
        return balanceSitutation;
    }
    public void setBalanceSitutation(boolean balanceSitutation) {
        this.balanceSitutation = balanceSitutation;
    }
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
    public boolean isTappingNormal() {
        return isTappingNormal;
    }
    public void setTappingNormal(boolean tappingNormal) {
        this.isTappingNormal = tappingNormal;
    }

}