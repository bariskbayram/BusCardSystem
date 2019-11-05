package com.ab.buscardsystem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CardReceiptDBTest {

    @InjectMocks
    DBFacade dbFacade = new DBFacade();
    @Mock
    TableMapper tableMapper;

    @Mock
    SqliteDB sqliteDB;

    @InjectMocks
    CardReceiptDB cardReciptDB = new CardReceiptDB(sqliteDB);
    @Mock
    Connection connection;
    @Mock
    PreparedStatement preparedStatement;

    @Test
    @DisplayName("Verify CardReceiptDB")
    void putItemTest() throws SQLException {

        //Given
        CardReceipt cardReceipt = new CardReceipt(30, 40);
        cardReceipt.setCardId(14);
        cardReceipt.setCenterConsoleId(123);
        cardReceipt.setLocalDate(LocalDate.now());
        cardReceipt.setLocalTime(LocalTime.now());
        cardReceipt.setPayment(40);
        cardReceipt.setAmount(30);
        cardReceipt.setChange(10);
        String query = "INSERT INTO CardReceipt (CardId, CenterConsoleId, Date, Time, Payment, Change, Amount) VALUES (?,?,?,?,?,?,?)";

        when(tableMapper.getMapper(CardReceipt.class)).thenReturn(cardReciptDB);

        doNothing().when(sqliteDB).connectDB();
        when(sqliteDB.getConnection()).thenReturn(connection);
        when(connection.prepareStatement(query)).thenReturn(preparedStatement);
        doNothing().when(preparedStatement).setString(anyInt(), anyString());
        when(preparedStatement.executeUpdate()).thenReturn(1);
        doNothing().when(sqliteDB).closeDB();

        //When
        dbFacade.put(cardReceipt);

        //Then
        assertEquals(query, cardReciptDB.getQuery());
        verify(tableMapper).getMapper(CardReceipt.class);
        verify(sqliteDB).connectDB();
        verify(sqliteDB).getConnection();
        verify(connection).prepareStatement(query);
        verify(preparedStatement).executeUpdate();
        verify(sqliteDB).closeDB();
        verify(preparedStatement, times(1)).setString(1,String.valueOf(cardReceipt.getCardId()));
        verify(preparedStatement, times(1)).setString(2,String.valueOf(cardReceipt.getCenterConsoleId()));
        verify(preparedStatement, times(1)).setString(3,String.valueOf(cardReceipt.getLocalDate()));
        verify(preparedStatement, times(1)).setString(4,String.valueOf(cardReceipt.getLocalTime()));
        verify(preparedStatement, times(1)).setString(5,String.valueOf(cardReceipt.getPayment()));
        verify(preparedStatement, times(1)).setString(6,String.valueOf(cardReceipt.getChange()));
        verify(preparedStatement, times(1)).setString(7,String.valueOf(cardReceipt.getAmount()));
        verify(preparedStatement, times(7)).setString(anyInt(),anyString());
    }
}