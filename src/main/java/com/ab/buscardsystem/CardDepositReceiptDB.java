package com.ab.buscardsystem;

import java.sql.PreparedStatement;

public class CardDepositReceiptDB implements IDataBase {

    private SqliteDB sqliteDB;
    private CardDepositReceipt cardDepositReceipt;

    public CardDepositReceiptDB(SqliteDB sqliteDB){
        this.sqliteDB = sqliteDB;
    }

    @Override
    public Object getItem(int id) {
       /* try {
            sqliteDB.connectDB();
            String query = "SELECT * FROM Receipt WHERE Id = ?";
            PreparedStatement preparedStatement = sqliteDB.connection.prepareStatement(query);
            preparedStatement.setString(1, String.valueOf(id));
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Receipt receipt = new Receipt();
                receipt.setId(resultSet.getInt("Id"));
                receipt.setCardId(resultSet.getInt("CardId"));
                receipt.setDepositConsoleId(resultSet.getInt("DepositConsoleId"));
                receipt.setLocalDate(resultSet.getString("Date");
                String date = resultSet.getString("Date");
                String time = resultSet.getString("Time");
                int payment = resultSet.getInt("Payment");
                int receiptId = resultSet.getInt("Id");
                int receiptId = resultSet.getInt("Id");
                TappingCard tappingCard = new TappingCard(tappingCardId, busConsoleId);
                this.tappingCard = tappingCard;
            }
            sqliteDB.closeDB();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("TapingCard döndürüldü.");
        return tappingCard;*/
       return cardDepositReceipt;
    }

    @Override
    public void putItem(ParentObject object) {
        try {
            sqliteDB.connectDB();
            String query = "INSERT INTO CardDepositReceipt (CardId, DepositConsoleId, Date, Time, Payment, Change, Amount) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = sqliteDB.connection.prepareStatement(query);
            CardDepositReceipt cardDepositReceipt = (CardDepositReceipt) object;
            preparedStatement.setString(1, String.valueOf(cardDepositReceipt.getCardId()));
            preparedStatement.setString(2, String.valueOf(cardDepositReceipt.getDepositCenterConsoleId()));
            preparedStatement.setString(3, String.valueOf(cardDepositReceipt.getLocalDate()));
            preparedStatement.setString(4, String.valueOf(cardDepositReceipt.getLocalTime()));
            preparedStatement.setString(5, String.valueOf(cardDepositReceipt.getPayment()));
            preparedStatement.setString(6, String.valueOf(cardDepositReceipt.getChange()));
            preparedStatement.setString(7, String.valueOf(cardDepositReceipt.getAmount()));
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
    public CardDepositReceipt getCardDepositReceipt() {
        return cardDepositReceipt;
    }
    public void setCardDepositReceipt(CardDepositReceipt cardDepositReceipt) {
        this.cardDepositReceipt = cardDepositReceipt;
    }
}
