package com.ab.buscardsystem.DataLayer;

import com.ab.buscardsystem.BusinessLayer.AddingCard;
import com.ab.buscardsystem.ParentObject;

import java.sql.PreparedStatement;

public class AddingCardDB implements IDataBase {

    private SqliteDB sqliteDB;
    private AddingCard addingCard;
    private String query;

    public AddingCardDB(SqliteDB sqliteDB){
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
            query = "INSERT INTO AddingCard (CardId, Date, Time, Name, Surname, Type) VALUES (?,?,?,?,?,?)";
            PreparedStatement preparedStatement = sqliteDB.getConnection().prepareStatement(query);
            addingCard = (AddingCard) object;
            preparedStatement.setString(1, String.valueOf(addingCard.getCardId()));
            preparedStatement.setString(2, String.valueOf(addingCard.getLocalDate()));
            preparedStatement.setString(3, String.valueOf(addingCard.getLocalTime()));
            preparedStatement.setString(4, String.valueOf(addingCard.getName()));
            preparedStatement.setString(5, String.valueOf(addingCard.getSurname()));
            preparedStatement.setString(6, String.valueOf(addingCard.getType()));
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
    public AddingCard getAddingCard() {
        return addingCard;
    }
    public void setAddingCard(AddingCard addingCard) {
        this.addingCard = addingCard;
    }
    public String getQuery() {
        return query;
    }
    public void setQuery(String query) {
        this.query = query;
    }

}
