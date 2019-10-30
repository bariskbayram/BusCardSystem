package com.ab.buscardsystem;

import java.util.HashMap;

public class TableMapper {

    private HashMap<Class<?>, IDataBase> mapper = new HashMap<>();
    private SqliteDB sqliteDB = new SqliteDB();
    private CardDB cardDB = new CardDB(sqliteDB);
    private TappingCardDB tappingCardDB = new TappingCardDB(sqliteDB);
    private CardDepositReceiptDB cardDepositReceiptDB = new CardDepositReceiptDB(sqliteDB);
    private DepositCenterConsoleDB depositCenterConsoleDB = new DepositCenterConsoleDB(sqliteDB);
    private DepositToDepositCenterReceiptDB depositToDepositCenterReceiptDB = new DepositToDepositCenterReceiptDB(sqliteDB);
    private BusConsoleDB busConsoleDB = new BusConsoleDB(sqliteDB);

    public TableMapper() {
        mapper.put(Card.class, cardDB);
        mapper.put(TappingCard.class, tappingCardDB);
        mapper.put(CardDepositReceipt.class, cardDepositReceiptDB);
        mapper.put(DepositCenterConsole.class, depositCenterConsoleDB);
        mapper.put(BusConsole.class,busConsoleDB);
        mapper.put(DepositToDepositCenterReceipt.class,depositToDepositCenterReceiptDB);
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
    public CardDepositReceiptDB getCardDepositReceiptDB() {
        return cardDepositReceiptDB;
    }

    public void setCardDepositReceiptDB(CardDepositReceiptDB cardDepositReceiptDB) {
        this.cardDepositReceiptDB = cardDepositReceiptDB;
    }

    public DepositCenterConsoleDB getDepositCenterConsoleDB() {
        return depositCenterConsoleDB;
    }

    public void setDepositCenterConsoleDB(DepositCenterConsoleDB depositCenterConsoleDB) {
        this.depositCenterConsoleDB = depositCenterConsoleDB;
    }

    public BusConsoleDB getBusConsoleDB() {
        return busConsoleDB;
    }

    public void setBusConsoleDB(BusConsoleDB busConsoleDB) {
        this.busConsoleDB = busConsoleDB;
    }
}