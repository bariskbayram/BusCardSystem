package com.ab.buscardsystem;

public class WholeSystem {

    private DBFacade dbFacade = new DBFacade();
    private BusConsole busConsole = new BusConsole(dbFacade);
    private CenterConsole centerConsole;
    private CityCardConsole cityCardConsole = new CityCardConsole(dbFacade);
    private FactoryInput factoryInput = new FactoryInput();

    public WholeSystem() {
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

    public void startAddingMoneyToCard(){
        System.out.print("Please enter Center ID: ");
        int centerId = factoryInput.inputIntegerId();
        if(centerId < 0 || centerId>10000){
            System.out.println("CenterConsole ID is wrong.");
            return;
        }
        centerConsole = (CenterConsole) dbFacade.get(centerId, CenterConsole.class);
        if(centerConsole == null){
            System.out.println("There is no CenterConsole for this ID.");
            return;
        }else{
            System.out.println("Success!");
        }
        System.out.print("Please enter Card ID: ");
        int CardId = factoryInput.inputIntegerId2();
        centerConsole.enterCardId(CardId, centerId, new AddingMoneyToCard());
    }

    public void startAddingMoneyToCenter(){
        System.out.println("Please enter Center ID: ");
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
    public boolean startDriverLogIn(){

        boolean isCorrect = busConsole.enterDriverId(new DriverLogIn());
        if(!isCorrect)
            return false;
        else
            return true;
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
