package com.ab.buscardsystem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TappingCardDB implements IDataBase {

    private SqliteDB sqliteDB;
    private TappingCard tappingCard;

    public TappingCardDB(SqliteDB sqliteDB){
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
                int tappingCardId = resultSet.getInt("Id");
                int busConsoleId = resultSet.getInt("BusConsoleId");
                TappingCard tappingCard = new TappingCard(tappingCardId, busConsoleId);
                this.tappingCard = tappingCard;
            }
            sqliteDB.closeDB();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("TapingCard döndürüldü.");
        return tappingCard;
    }

    @Override
    public void deleteItem(int id) {}

    @Override
    public void updateItem(ParentObject object) {}

    @Override
    public void putItem(ParentObject object) {
        try {
            sqliteDB.connectDB();
            String query = "INSERT INTO TappingCard (Amount, Date, Time, BusConsoleId, CardId) VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = sqliteDB.connection.prepareStatement(query);
            TappingCard tappingCard = (TappingCard) object;
            preparedStatement.setString(1, String.valueOf(tappingCard.getAmount()));
            preparedStatement.setString(2, String.valueOf(tappingCard.getLocalDate()));
            preparedStatement.setString(3, String.valueOf(tappingCard.getLocalTime()));
            preparedStatement.setString(4, String.valueOf(tappingCard.getBusConsoleId()));
            preparedStatement.setString(5, String.valueOf(tappingCard.getCardId()));
            preparedStatement.executeUpdate();
            sqliteDB.closeDB();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setSqliteDB(SqliteDB sqliteDB) {
        this.sqliteDB = sqliteDB;
    }
    public SqliteDB getSqliteDB() {
        return sqliteDB;
    }
}
