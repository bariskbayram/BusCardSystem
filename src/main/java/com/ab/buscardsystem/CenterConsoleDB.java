package com.ab.buscardsystem;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CenterConsoleDB implements IDataBase {

    private SqliteDB sqliteDB;
    private CenterConsole centerConsole;

    public CenterConsoleDB(SqliteDB sqliteDB){
        this.sqliteDB = sqliteDB;
    }

    @Override
    public Object getItem(int id) {
        try {
            sqliteDB.connectDB();
            String query = "SELECT * FROM CenterConsole WHERE Id = ?";
            PreparedStatement preparedStatement = sqliteDB.connection.prepareStatement(query);
            preparedStatement.setString(1,String.valueOf(id));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                CenterConsole centerConsole = new CenterConsole();
                centerConsole.setId(resultSet.getInt("Id"));
                centerConsole.setBalance(resultSet.getDouble("Balance"));
                this.centerConsole = centerConsole;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return centerConsole;
    }

    @Override
    public void putItem(ParentObject object) {
        try {
            sqliteDB.connectDB();
            CenterConsole centerConsole = (CenterConsole) object;
            String queryDelete = "DELETE FROM CenterConsole WHERE Id = ?"; //Eğer olmayan kart ekleme senaryosu çalışırsa delete sorun çıkarabilir.
            PreparedStatement preparedStatementDelete = sqliteDB.connection.prepareStatement(queryDelete);
            preparedStatementDelete.setString(1,String.valueOf(centerConsole.getId()));
            preparedStatementDelete.executeUpdate();
            String query = "INSERT INTO CenterConsole (Id, Balance) VALUES (?,?)";
            PreparedStatement preparedStatement = sqliteDB.connection.prepareStatement(query);
            preparedStatement.setString(1, String.valueOf(centerConsole.getId()));
            preparedStatement.setString(2, String.valueOf(centerConsole.getBalance()));
            preparedStatement.executeUpdate();
            sqliteDB.closeDB();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
