package com.ab.buscardsystem;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
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
    private int time;
    private int busConsoleId;
    private int isCorrect;
    private int driverId;
    boolean isBusConsoleExist;

    public BusConsole(DBFacade dbFacade){
        this.dbFacade = dbFacade;
    }
    public BusConsole(){}

    public void enterCardId(int cardId, boolean isTappingNormalParameter, TappingCard tappingCard){
        if(tappingCard == null)
            throw new NullPointerException("TappingCard is null");
        this.isTappingNormal = isTappingNormalParameter;
        if(isTappingNormal == true) {

        }else {
            cardTappingSitutation = isCardAlreadyTapped(cardId);
            if(!cardTappingSitutation){
                return;
            }
        }
        tappingCard.setBusConsoleId(getId());
        card = (Card) dbFacade.get(cardId, Card.class);
        if(card == null){
            System.out.println("There is no Card for this ID.");
            return;
        }
        tappingCard.set(card);
        tappingCard.setCardId(card.getId());
        setId(tappingCard.getBusConsoleId());
        this.tappingCard = tappingCard;
        dbFacade.update(card);
        dbFacade.put(tappingCard);
        invalidList.put(cardId, localTime);
    }

    public boolean enterDriverId(DriverLogIn driverLogIn){
        if(driverLogIn == null)
            throw new NullPointerException("DriverLogIn is null");
        isCorrect=1;
        takeBusConsoleId();
        if(isCorrect == 0){
            System.out.println("You have entered the wrong 3 times.");
            return false;
        }
        isBusConsoleExist = getAndEquals(busConsoleId);
        if(!isBusConsoleExist){
            return false;
        }
        takeDriverId();
        if(isCorrect == 0){
            System.out.println("You have entered the wrong 3 times.");
            return false;
        }
        driverLogIn.setBusConsoleId(busConsoleId);
        setId(busConsoleId);
        driver = (Driver) dbFacade.get(driverId, Driver.class);
        if(driver == null){
            System.out.println("There is no Driver for this ID");
            return false;
        }
        driverLogIn.setLogin(driver);
        this.driverLogIn = driverLogIn;
        dbFacade.put(driverLogIn);
        return true;
    }

    public void takeBusConsoleId(){
        isCorrect = 0;
        for(int i=0; i<3; i++) {
            System.out.print("Please enter BusConsole ID: ");
            busConsoleId = factoryInput.inputIntegerId();
            if (busConsoleId > 0 && busConsoleId < 10000) {
                isCorrect = 1;
                break;
            } else {
                System.out.println("BusConsole ID is wrong, please try again!");
            }
        }
    }

    public void takeDriverId(){
        isCorrect = 0;
        for(int i=0; i<3; i++) {
            System.out.print("Please enter Driver ID: ");
            driverId = factoryInput.inputIntegerId();
            if (driverId > 0 && driverId < 10000) {
                isCorrect = 1;
                break;
            } else {
                System.out.println("Driver ID is wrong, please try again!");
            }
        }
    }

    public boolean isCardAlreadyTapped(int cardId) {

        if (invalidList.containsKey(cardId) == true) {
            time = (LocalTime.now().get(ChronoField.MINUTE_OF_DAY) - invalidList.get(cardId).get(ChronoField.MINUTE_OF_DAY));
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

    public boolean getAndEquals(int id){
        BusConsole busConsoleConsoleWithoutDB = (BusConsole) dbFacade.get(id, BusConsole.class);
        if(busConsoleConsoleWithoutDB == null){
            System.out.println("There is no BusConsole for this ID");
            return false;
        }
        BusConsole busConsoleWithDB = BusConsole.this;

        busConsoleWithDB.setId(busConsoleConsoleWithoutDB.getId());

        return true;
    }

    public boolean isCardTappingSitutation() {
        return cardTappingSitutation;
    }
    public void setCardTappingSitutation(boolean cardTappingSitutation) {
        this.cardTappingSitutation = cardTappingSitutation;
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
    public int getTime() {
        return time;
    }
    public void setTime(int time) {
        this.time = time;
    }
    public int getBusConsoleId() {
        return busConsoleId;
    }
    public void setBusConsoleId(int busConsoleId) {
        this.busConsoleId = busConsoleId;
    }
    public int getIsCorrect() {
        return isCorrect;
    }
    public void setIsCorrect(int isCorrect) {
        this.isCorrect = isCorrect;
    }
    public int getDriverId() {
        return driverId;
    }
    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }
    public boolean isBusConsoleExist() {
        return isBusConsoleExist;
    }
    public void setBusConsoleExist(boolean busConsoleExist) {
        isBusConsoleExist = busConsoleExist;
    }

}