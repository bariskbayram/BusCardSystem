package com.ab.buscardsystem;

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
            PreparedStatement preparedStatement = sqliteDB.connection.prepareStatement(query);
            preparedStatement.setString(1, String.valueOf(id));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int cardId = resultSet.getInt("Id");
                Card card = new Card(cardId);
                card.setName(resultSet.getString("Name"));
                card.setSurname(resultSet.getString("Surname"));
                card.setBalance(resultSet.getDouble("Balance"));
                card.setTip(resultSet.getString("Tip"));
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
    public void putItem(ParentObject object) {
        try {
            sqliteDB.connectDB();
            String queryDelete = "DELETE FROM Card WHERE Id = ?";
            PreparedStatement preparedStatementDelete = sqliteDB.connection.prepareStatement(queryDelete);
            preparedStatementDelete.setString(1,String.valueOf(card.getId()));
            preparedStatementDelete.executeUpdate();
            String query = "INSERT INTO Card (Id, Name, Surname, Balance, Tip) VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = sqliteDB.connection.prepareStatement(query);
            Card card = (Card) object;
            preparedStatement.setString(1, String.valueOf(card.getId()));
            preparedStatement.setString(2, String.valueOf(card.getName()));
            preparedStatement.setString(3, String.valueOf(card.getSurname()));
            preparedStatement.setString(4, String.valueOf(card.getBalance()));
            preparedStatement.setString(5, String.valueOf(card.getTip()));
            preparedStatement.executeUpdate();
            sqliteDB.closeDB();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
