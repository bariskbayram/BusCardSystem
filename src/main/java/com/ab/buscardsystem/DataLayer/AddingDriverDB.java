package com.ab.buscardsystem.DataLayer;

import com.ab.buscardsystem.BusinessLayer.AddingDriver;
import com.ab.buscardsystem.ParentObject;

import java.sql.PreparedStatement;

public class AddingDriverDB implements IDataBase {

    private SqliteDB sqliteDB;
    private AddingDriver addingDriver;
    private String query;

    public AddingDriverDB(SqliteDB sqliteDB){
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
            query = "INSERT INTO AddingDriver (Date, Time, Name, Surname, DriverId) VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = sqliteDB.getConnection().prepareStatement(query);
            addingDriver = (AddingDriver) object;
            preparedStatement.setString(1, String.valueOf(addingDriver.getLocalDate()));
            preparedStatement.setString(2, String.valueOf(addingDriver.getLocalTime()));
            preparedStatement.setString(3, String.valueOf(addingDriver.getName()));
            preparedStatement.setString(4, String.valueOf(addingDriver.getSurname()));
            preparedStatement.setString(5, String.valueOf(addingDriver.getDriverId()));
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
    public AddingDriver getAddingDriver() {
        return addingDriver;
    }
    public void setAddingDriver(AddingDriver addingDriver) {
        this.addingDriver = addingDriver;
    }
    public String getQuery() {
        return query;
    }
    public void setQuery(String query) {
        this.query = query;
    }
}
