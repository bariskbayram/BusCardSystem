package com.ab.buscardsystem.DataLayer;

import com.ab.buscardsystem.BusinessLayer.*;

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
    private DriverLogInDB driverLogInDB = new DriverLogInDB(sqliteDB);

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
        mapper.put(DriverLogIn.class, driverLogInDB);
    }

    public IDataBase getMapper(Class<?> parameterClass){
        return mapper.get(parameterClass);
    }


    public void setSqliteDB(SqliteDB sqliteDB) {
        this.sqliteDB = sqliteDB;
    }
    public SqliteDB getSqliteDB() {
        return sqliteDB;
    }
}