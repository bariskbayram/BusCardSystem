package com.ab.buscardsystem;

import java.sql.PreparedStatement;

public class AddingCenterDB implements IDataBase {

    private SqliteDB sqliteDB;
    private AddingCenter addingCenter;

    public AddingCenterDB(SqliteDB sqliteDB){
        this.sqliteDB = sqliteDB;
    }

    @Override
    public Object getItem(int id) {
        return null;
    }

    @Override
    public void deleteItem(int id) {}

    @Override
    public void updateItem(ParentObject object) {
    }

    @Override
    public void putItem(ParentObject object) {
        try {
            sqliteDB.connectDB();
            String query = "INSERT INTO AddingCenter (Date, Time, Name, Address, CenterId) VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement = sqliteDB.getConnection().prepareStatement(query);
            addingCenter = (AddingCenter) object;
            preparedStatement.setString(1, String.valueOf(addingCenter.getLocalDate()));
            preparedStatement.setString(2, String.valueOf(addingCenter.getLocalTime()));
            preparedStatement.setString(3, String.valueOf(addingCenter.getName()));
            preparedStatement.setString(4, String.valueOf(addingCenter.getAddress()));
            preparedStatement.setString(5, String.valueOf(addingCenter.getCenterConsole().getId()));
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
    public AddingCenter getAddingCenter() {
        return addingCenter;
    }
    public void setAddingCenter(AddingCenter addingCenter) {
        this.addingCenter = addingCenter;
    }
}
