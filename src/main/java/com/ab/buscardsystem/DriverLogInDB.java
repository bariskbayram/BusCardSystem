package com.ab.buscardsystem;

import java.sql.PreparedStatement;

public class DriverLogInDB implements IDataBase {

    private SqliteDB sqliteDB;
    private DriverLogIn driverLogIn;

    public DriverLogInDB(SqliteDB sqliteDB){
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
            String query = "INSERT INTO DriverLogIn (DriverId, Date, Time, BusConsoleId) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = sqliteDB.getConnection().prepareStatement(query);
            driverLogIn = (DriverLogIn) object;
            preparedStatement.setString(1, String.valueOf(driverLogIn.getDriverId()));
            preparedStatement.setString(2, String.valueOf(driverLogIn.getLocalDate()));
            preparedStatement.setString(3, String.valueOf(driverLogIn.getLocalTime()));
            preparedStatement.setString(4, String.valueOf(driverLogIn.getBusConsoleId()));
            preparedStatement.executeUpdate();
            sqliteDB.closeDB();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
