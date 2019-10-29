package com.ab.buscardsystem;

import java.util.HashMap;

public class TableMapper {

    private SqliteDB sqliteDB = new SqliteDB();
    private HashMap<Class<?>, IDataBase> mapper = new HashMap<>();
    private CardDB cardDB = new CardDB(sqliteDB);
    private TappingCardDB tappingCardDB = new TappingCardDB();

    public void setMapper(HashMap<Class<?>, IDataBase> mapper) {
        this.mapper = mapper;
    }
    public void setSqliteDB(SqliteDB sqliteDB) {
        this.sqliteDB = sqliteDB;
    }
    public void setCardDB(CardDB cardDB) {
        this.cardDB = cardDB;
    }
    public void setTappingCardDB(TappingCardDB tappingCardDB) {
        this.tappingCardDB = tappingCardDB;
    }

    public HashMap<Class<?>, IDataBase> getMapper() {
        return mapper;
    }
    public SqliteDB getSqliteDB() {
        return sqliteDB;
    }
    public CardDB getCardDB() {
        return cardDB;
    }
    public TappingCardDB getTappingCardDB() {
        return tappingCardDB;
    }


    public TableMapper() {

        mapper.put(Card.class, cardDB);
        mapper.put(TappingCard.class, tappingCardDB);

    }

    public IDataBase getMapper(Class<?> parameterClass){
        return mapper.get(parameterClass);
    }
}