package com.ab.buscardsystem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class BusConsoleDB implements IDataBase {

    private SqliteDB sqliteDB;
    private BusConsole busConsole;

    public BusConsoleDB(SqliteDB sqliteDB){
        this.sqliteDB = sqliteDB;
    }

    @Override
    public Object getItem(int id) {
        try {
            sqliteDB.connectDB();
            String query = "SELECT * FROM BusConsole WHERE Id = ?";
            PreparedStatement preparedStatement = sqliteDB.getConnection().prepareStatement(query);
            preparedStatement.setString(1,String.valueOf(id));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                BusConsole busConsole = new BusConsole();
                busConsole.setId(resultSet.getInt("Id"));
                this.busConsole = busConsole;
            }
            sqliteDB.closeDB();
        }catch (Exception e){
            e.printStackTrace();
        }
        return busConsole;
    }

    @Override
    public void deleteItem(int id) {
        //BusConsole silme senaryosu
    }

    @Override
    public void putItem(ParentObject object) {
        //BusConsole ekleme senaryosu
    }

    @Override
    public void updateItem(ParentObject object) {}

    public SqliteDB getSqliteDB() {
        return sqliteDB;
    }
    public void setSqliteDB(SqliteDB sqliteDB) {
        this.sqliteDB = sqliteDB;
    }
    public BusConsole getBusConsole() {
        return busConsole;
    }
    public void setBusConsole(BusConsole busConsole) {
        this.busConsole = busConsole;
    }

}
