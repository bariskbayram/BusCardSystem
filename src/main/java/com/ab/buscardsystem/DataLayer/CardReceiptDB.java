package com.ab.buscardsystem.DataLayer;

import com.ab.buscardsystem.BusinessLayer.CardReceipt;
import com.ab.buscardsystem.ParentObject;

import java.sql.PreparedStatement;

public class CardReceiptDB implements IDataBase {

    private SqliteDB sqliteDB;
    private CardReceipt cardReceipt;
    private String query;

    public CardReceiptDB(SqliteDB sqliteDB){
        this.sqliteDB = sqliteDB;
    }

    @Override
    public Object getItem(int id) {
       return null;
    }

    @Override
    public void deleteItem(int id) {}

    @Override
    public void updateItem(ParentObject object) {}

    @Override
    public void putItem(ParentObject object) {
        try {
            sqliteDB.connectDB();
            query = "INSERT INTO CardReceipt (CardId, CenterConsoleId, Date, Time, Payment, Change, Amount) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = sqliteDB.getConnection().prepareStatement(query);
            CardReceipt cardReceipt = (CardReceipt) object;
            preparedStatement.setString(1, String.valueOf(cardReceipt.getCardId()));
            preparedStatement.setString(2, String.valueOf(cardReceipt.getCenterConsoleId()));
            preparedStatement.setString(3, String.valueOf(cardReceipt.getLocalDate()));
            preparedStatement.setString(4, String.valueOf(cardReceipt.getLocalTime()));
            preparedStatement.setString(5, String.valueOf(cardReceipt.getPayment()));
            preparedStatement.setString(6, String.valueOf(cardReceipt.getChange()));
            preparedStatement.setString(7, String.valueOf(cardReceipt.getAmount()));
            preparedStatement.executeUpdate();
            sqliteDB.closeDB();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public SqliteDB getSqliteDB() {
        return sqliteDB;
    }
    public void setSqliteDB(SqliteDB sqliteDB) {
        this.sqliteDB = sqliteDB;
    }
    public CardReceipt getCardReceipt() {
        return cardReceipt;
    }
    public void setCardReceipt(CardReceipt cardReceipt) {
        this.cardReceipt = cardReceipt;
    }
    public String getQuery() {
        return query;
    }
    public void setQuery(String query) {
        this.query = query;
    }
}
