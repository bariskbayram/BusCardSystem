package com.ab.buscardsystem.BusinessLayer;

import com.ab.buscardsystem.DataLayer.DBFacade;

import java.time.LocalDate;
import java.time.LocalTime;

public class CityCardConsole {

    private LocalDate localDate = LocalDate.now();
    private LocalTime localTime = LocalTime.now();
    private AddingMoneyToCenter addingMoneyToCenter;
    private CenterConsole centerConsole;
    private AddingCard addingCard;
    private AddingCenter addingCenter;
    private DBFacade dbFacade;
    private double amount;
    private double payment;
    private AddingDriver addingDriver;

    public CityCardConsole(DBFacade dbFacade){
        this.dbFacade = dbFacade;
    }

    public Status enterCenterId (int centerId, AddingMoneyToCenter addingMoneyToCenter){
        centerConsole =(CenterConsole) dbFacade.get(centerId, CenterConsole.class);
        if(centerConsole == null)
            return Status.CENTERNULL;
        addingMoneyToCenter.setCenterConsole(centerConsole);
        this.addingMoneyToCenter = addingMoneyToCenter;
        enterAmount(amount);
        return Status.TRUE;
    }

    public void enterAmount (double amount){
        addingMoneyToCenter.setAmount(amount);
        addingMoneyToCenter.setPayment(payment);
        addingMoneyToCenter.createCenterReceipt(new CenterReceipt(amount,payment));
        addingMoneyToCenter.getCenterReceipt().setCenterConsoleId(centerConsole.getId());
        centerConsole.setBalance(centerConsole.getBalance()+amount);
        dbFacade.update(centerConsole);
        dbFacade.put(addingMoneyToCenter.getCenterReceipt());
    }

    public Status enterCardInfo(String name, String surname, int cardId, CardType type, AddingCard addingCard){
        addingCard.setName(name);
        addingCard.setSurname(surname);
        addingCard.setCardId(cardId);
        addingCard.setType(type);
        Card card = addingCard.setCardInfo(new Card(0));
        if(card == null)
            return Status.CARDNULL;
        if(dbFacade.get(card.getId(), Card.class) != null) {
            return Status.CARDEXIST;
        }
        dbFacade.put(card);
        this.addingCard = addingCard;
        dbFacade.put(addingCard);
        return Status.TRUE;
    }

    public Status enterCenterInfo(String name, String address, int centerId, AddingCenter addingCenter){
        addingCenter.setName(name);
        addingCenter.setAddress(address);
        addingCenter.setCenterId(centerId);
        CenterConsole centerConsole = addingCenter.setCenterInfo(new CenterConsole());
        if(dbFacade.get(centerConsole.getId(), CenterConsole.class) != null){
            return Status.CENTEREXIST;
        }
        dbFacade.put(centerConsole);
        this.addingCenter = addingCenter;
        dbFacade.put(addingCenter);
        return Status.TRUE;
    }

    public Status enterDriverInfo(String name, String surname, int driverId, AddingDriver addingDriver){
        addingDriver.setName(name);
        addingDriver.setSurname(surname);
        addingDriver.setDriverId(driverId);
        Driver driver = addingDriver.setDriverInfo(new Driver(0));
        if(dbFacade.get(driver.getId(), Driver.class) != null){
            return Status.DRIVEREXIST;
        }
        dbFacade.put(driver);
        this.addingDriver = addingDriver;
        dbFacade.put(addingDriver);
        return Status.TRUE;
    }

    public Status deleteDriver(int driverId){
        if(dbFacade.get(driverId, Driver.class) == null){
            return Status.DRIVERNOTEXIST;
        }
        dbFacade.delete(driverId, Driver.class);
        return Status.TRUE;
    }

    public Status deleteCenter(int centerId) {
        if (dbFacade.get(centerId, CenterConsole.class) == null){
            return Status.CENTERNOTEXIST;
        }
        dbFacade.delete(centerId, CenterConsole.class);
        return Status.TRUE;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }
    public LocalTime getLocalTime() {
        return localTime;
    }
    public CenterConsole getCenterConsole() {
        return centerConsole;
    }
    public double getAmount() {
        return amount;
    }
    public void setAmount(double amount) {
        this.amount = amount;
    }
    public double getPayment() {
        return payment;
    }
    public void setPayment(double payment) {
        this.payment = payment;
    }
}
