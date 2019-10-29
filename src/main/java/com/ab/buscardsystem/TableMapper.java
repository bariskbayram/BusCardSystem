package com.ab.buscardsystem;

import java.util.HashMap;

public class TableMapper {

    private HashMap<Class<?>, IDataBase> mapper = new HashMap<>();
    private SqliteDB sqliteDB = new SqliteDB();
    private CardDB cardDB = new CardDB(sqliteDB);
    private TappingCardDB tappingCardDB = new TappingCardDB(sqliteDB);

    public TableMapper() {
        mapper.put(Card.class, cardDB);
        mapper.put(TappingCard.class, tappingCardDB);
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
}