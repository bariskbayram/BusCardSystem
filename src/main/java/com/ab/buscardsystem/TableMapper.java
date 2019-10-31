package com.ab.buscardsystem;

import java.util.HashMap;

public class TableMapper {

    private HashMap<Class<?>, IDataBase> mapper = new HashMap<>();
    private SqliteDB sqliteDB = new SqliteDB();
    private CardDB cardDB = new CardDB(sqliteDB);
    private TappingCardDB tappingCardDB = new TappingCardDB(sqliteDB);
    private CardReceiptDB cardReceiptDB = new CardReceiptDB(sqliteDB);
    private CenterConsoleDB centerConsoleDB = new CenterConsoleDB(sqliteDB);
    private CenterReceiptDB centerReceiptDB = new CenterReceiptDB(sqliteDB);
    private BusConsoleDB busConsoleDB = new BusConsoleDB(sqliteDB);
    private AddingCardDB addingCardDB = new AddingCardDB(sqliteDB);
    private AddingCenterDB addingCenterDB = new AddingCenterDB(sqliteDB);
    private AddingDriverDB addingDriverDB = new AddingDriverDB(sqliteDB);
    private DriverDB driverDB = new DriverDB(sqliteDB);

    public TableMapper() {
        mapper.put(Card.class, cardDB);
        mapper.put(TappingCard.class, tappingCardDB);
        mapper.put(CardReceipt.class, cardReceiptDB);
        mapper.put(CenterConsole.class, centerConsoleDB);
        mapper.put(BusConsole.class,busConsoleDB);
        mapper.put(CenterReceipt.class, centerReceiptDB);
        mapper.put(AddingCard.class, addingCardDB);
        mapper.put(AddingCenter.class, addingCenterDB);
        mapper.put(AddingDriver.class, addingDriverDB);
        mapper.put(Driver.class, driverDB);
    }

    public IDataBase getMapper(Class<?> parameterClass){
        return mapper.get(parameterClass);
    }


    public void setSqliteDB(SqliteDB sqliteDB) {
        this.sqliteDB = sqliteDB;
    }
    public void setMapper(HashMap<Class<?>, IDataBase> mapper) {
        this.mapper = mapper;
    }
    public void setCardDB(CardDB cardDB) {
        this.cardDB = cardDB;
    }
    public void setTappingCardDB(TappingCardDB tappingCardDB) {
        this.tappingCardDB = tappingCardDB;
    }
    public SqliteDB getSqliteDB() {
        return sqliteDB;
    }
    public HashMap<Class<?>, IDataBase> getMapper() {
        return mapper;
    }
    public CardDB getCardDB() {
        return cardDB;
    }
    public TappingCardDB getTappingCardDB() {
        return tappingCardDB;
    }
    public CardReceiptDB getCardReceiptDB() {
        return cardReceiptDB;
    }
    public void setCardReceiptDB(CardReceiptDB cardReceiptDB) {
        this.cardReceiptDB = cardReceiptDB;
    }
    public CenterConsoleDB getCenterConsoleDB() {
        return centerConsoleDB;
    }
    public void setCenterConsoleDB(CenterConsoleDB centerConsoleDB) {
        this.centerConsoleDB = centerConsoleDB;
    }
    public BusConsoleDB getBusConsoleDB() {
        return busConsoleDB;
    }
    public void setBusConsoleDB(BusConsoleDB busConsoleDB) {
        this.busConsoleDB = busConsoleDB;
    }
    public CenterReceiptDB getCenterReceiptDB() {
        return centerReceiptDB;
    }
    public void setCenterReceiptDB(CenterReceiptDB centerReceiptDB) {
        this.centerReceiptDB = centerReceiptDB;
    }
    public AddingCardDB getAddingCardDB() {
        return addingCardDB;
    }
    public void setAddingCardDB(AddingCardDB addingCardDB) {
        this.addingCardDB = addingCardDB;
    }
}