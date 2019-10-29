package com.ab.buscardsystem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

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
           PreparedStatement preparedStatement = sqliteDB.connection.prepareStatement(query);
           preparedStatement.setString(1,String.valueOf(id));
           ResultSet resultSet = preparedStatement.executeQuery();

           while(resultSet.next()){
               int cardId = resultSet.getInt("Id");
               Card card = new Card(cardId);
               card.setName(resultSet.getString("Name"));
               card.setSurname(resultSet.getString("Surname"));
               card.setBakiye(resultSet.getInt("Bakiye"));
               this.card = card;
           }
           sqliteDB.closeDB();

       }
       catch (Exception e){
           e.printStackTrace();
       }
        System.out.println("Kart donduruldu  "+ card.getName());
       return card;
    }

    @Override
    public void putItem(ParentObject object) {
        try {
            sqliteDB.connectDB();
            String query = "UPDATE Card SET Balance = ? Where Id = ?";
            PreparedStatement preparedStatement = sqliteDB.connection.prepareStatement(query);
            Card card = (Card) object;
            preparedStatement.setString(1,String.valueOf(card.getBakiye()));
            preparedStatement.setString(2,String.valueOf(card.getId()));
            preparedStatement.executeUpdate();
            sqliteDB.closeDB();

        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
