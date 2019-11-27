package com.ab.buscardsystem.DataLayer;

import com.ab.buscardsystem.BusinessLayer.Card;
import com.ab.buscardsystem.BusinessLayer.CardType;
import com.ab.buscardsystem.BusinessLayer.Status;
import com.ab.buscardsystem.ParentObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CardDB implements IDataBase {

    private SqliteDB sqliteDB;
    private Card card;

    public CardDB(SqliteDB sqliteDB) {
        this.sqliteDB = sqliteDB;
    }

    @Override
    public Object getItem(int id) {
        try {
            sqliteDB.connectDB();
            String query = "SELECT * FROM Card WHERE Id = ?";
            PreparedStatement preparedStatement = sqliteDB.getConnection().prepareStatement(query);
            preparedStatement.setString(1, String.valueOf(id));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int cardId = resultSet.getInt("Id");
                if(cardId < 0 || cardId > 10000 || cardId != id)
                    return null;
                Card card = new Card(cardId);
                card.setName(resultSet.getString("Name"));
                card.setSurname(resultSet.getString("Surname"));
                card.setBalance(resultSet.getDouble("Balance"));
                if(resultSet.getString("Type").toUpperCase().equals("STUDENT"))
                    card.setType(CardType.STUDENT);
                else if(resultSet.getString("Type").toUpperCase().equals("YEAR65PLUS"))
                    card.setType(CardType.YEAR65PLUS);
                else if(resultSet.getString("Type").toUpperCase().equals("NORMAL"))
                    card.setType(CardType.NORMAL);
                this.card = card;
            }
            sqliteDB.closeDB();
            }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return card;
    }

    @Override
    public void deleteItem(int id) {}

    @Override
    public void updateItem(ParentObject object) {
        try{
            sqliteDB.connectDB();
            card = (Card) object;
            String query = "UPDATE Card SET Balance = ? WHERE Id = ?";
            PreparedStatement preparedStatement = sqliteDB.getConnection().prepareStatement(query);
            preparedStatement.setString(1, String.valueOf(card.getBalance()));
            preparedStatement.setString(2, String.valueOf(card.getId()));
            preparedStatement.executeUpdate();
            sqliteDB.closeDB();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void putItem(ParentObject object) {
        try {
            sqliteDB.connectDB();
            Card card = (Card) object;
            String queryInsert = "INSERT INTO Card (Id, Name, Surname, Balance, Type) VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatementInsert = sqliteDB.getConnection().prepareStatement(queryInsert);
            preparedStatementInsert.setString(1, String.valueOf(card.getId()));
            preparedStatementInsert.setString(2, String.valueOf(card.getName()));
            preparedStatementInsert.setString(3, String.valueOf(card.getSurname()));
            preparedStatementInsert.setString(4, String.valueOf(card.getBalance()));
            preparedStatementInsert.setString(5, String.valueOf(card.getType()));
            preparedStatementInsert.executeUpdate();
            sqliteDB.closeDB();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
