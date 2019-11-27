package com.ab.buscardsystem.BusinessLayer;

import com.ab.buscardsystem.DataLayer.DBFacade;
import com.ab.buscardsystem.FactoryInput;

public class WholeSystem {

    private DBFacade dbFacade = new DBFacade();
    private BusConsole busConsole;
    private CenterConsole centerConsole = new CenterConsole(dbFacade);
    private CityCardConsole cityCardConsole = new CityCardConsole(dbFacade);
    private FactoryInput factoryInput = new FactoryInput();
    int centerId;
    int cardId;

    public WholeSystem() {
    }

    public boolean startDriverLogIn(int driverId, int busConsoleId){
        busConsole = new BusConsole(dbFacade);
        busConsole.setDriverId(driverId);
        busConsole.setBusConsoleId(busConsoleId);
        boolean isCorrect = busConsole.enterDriverId(new DriverLogIn());
        if(!isCorrect)
            return false;
        else
            return true;
    }

    public void startTappingCard() {

        while (true) {
            System.out.print("For Driver LogOut please enter 1, for continue without LogOut please enter 0: ");
            int logOut = factoryInput.inputIntegerId();
            if(logOut == 1)
                return;
            boolean isTappingNormal = false;
            System.out.print("For activate the Normal Card Type please enter 1, " +
                    "for continue without activating please enter 0: ");
            if(factoryInput.inputIntegerId2() == 1)
                isTappingNormal = true;
            System.out.print("Please enter Card ID: ");
            int cardId = factoryInput.inputIntegerId3();
            if(isTappingNormal == true)
                busConsole.enterCardId(cardId, isTappingNormal, new TappingCard(0, 3.25));
            else{
                busConsole.enterCardId(cardId, isTappingNormal, new TappingCard(0));
            }
        }
    }

    public boolean startInputCenterConsoleFrame(){
        if(dbFacade.get(centerId, CenterConsole.class) == null){
            return false;
        }
        return true;
    }

    public Status startAddingMoneyToCardFrame(double amount, double payment){
        AddingMoneyToCard addingMoneyToCard = new AddingMoneyToCard();
        if(payment < amount)
            return Status.PAYMENTNOTENOUGH;
        addingMoneyToCard.setAmount(amount);
        addingMoneyToCard.setPayment(payment);
        addingMoneyToCard.setCardId(cardId);
        Status correctless = centerConsole.enterCardId(cardId, centerId, addingMoneyToCard);
        if(correctless == Status.CARDNULL)
            return Status.CARDNULL;
        else if(correctless == Status.NOTENOUGHBALANCE)
            return Status.NOTENOUGHBALANCE;
        return Status.TRUE;
    }

    public Status startAddingMoneyToCenter(int id, double amount, double payment){
        cityCardConsole.setPayment(payment);
        cityCardConsole.setAmount(amount);
        if(amount > payment)
            return Status.PAYMENTNOTENOUGH;
        Status correctness = cityCardConsole.enterCenterId(id, new AddingMoneyToCenter());
        if(correctness == Status.CENTERNULL)
            return Status.CENTERNULL;
        return Status.TRUE;
    }

    public Status startAddingCard(int cardId, String name, String surname, CardType type){
        Status correctness;
        cityCardConsole.getAddingCard().setCardId(cardId);
        cityCardConsole.getAddingCard().setName(name);
        cityCardConsole.getAddingCard().setSurname(surname);
        cityCardConsole.getAddingCard().setType(type);
        return correctness = cityCardConsole.enterCardInfo(new AddingCard());
    }
    public void startAddingCenter(){ cityCardConsole.enterCenterInfo(new AddingCenter());}
    public void startAddingDriver(){cityCardConsole.enterDriverInfo(new AddingDriver());}
    public void startRemovingDriver(){
        cityCardConsole.deleteDriver();
    }
    public void startRemovingCenter(){ cityCardConsole.deleteCenter();}


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
    public int getCenterId() {
        return centerId;
    }
    public int getCardId() {
        return cardId;
    }
    public void setCardId(int cardId) {
        this.cardId = cardId;
    }
    public void setCenterId(int centerId) {
        this.centerId = centerId;
    }

}
