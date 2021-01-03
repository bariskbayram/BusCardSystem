package com.ab.buscardsystem;

import com.ab.buscardsystem.BusinessLayer.AddingCard;
import com.ab.buscardsystem.DataLayer.AddingCardDB;
import com.ab.buscardsystem.DataLayer.DBFacade;
import com.ab.buscardsystem.DataLayer.SqliteDB;
import com.ab.buscardsystem.DataLayer.TableMapper;
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AddingCardDBTest {

    @InjectMocks
    DBFacade dbFacade = new DBFacade();
    @Mock
    TableMapper tableMapper;

    @Mock
    SqliteDB sqliteDB;

    @InjectMocks
    AddingCardDB addingCardDB = new AddingCardDB(sqliteDB);
    @Mock
    Connection connection;
    @Mock
    PreparedStatement preparedStatement;

    @Test
    @DisplayName("Verify AddingCard Info")
    void putItemTest() throws SQLException {

        //Given
        AddingCard addingCard = new AddingCard();
        addingCard.setCardId(14);
        addingCard.setLocalDate(LocalDate.now());
        addingCard.setLocalTime(LocalTime.now());
        addingCard.setSurname("AbdulAhmet");
        addingCard.setName("Cemalettin");
        addingCard.setType("Normal");
        String query = "INSERT INTO AddingCard (CardId, Date, Time, Name, Surname, Type) VALUES (?,?,?,?,?,?)";

        when(tableMapper.getMapper(AddingCard.class)).thenReturn(addingCardDB);

        doNothing().when(sqliteDB).connectDB();
        when(sqliteDB.getConnection()).thenReturn(connection);
        when(connection.prepareStatement(query)).thenReturn(preparedStatement);
        doNothing().when(preparedStatement).setString(anyInt(), anyString());
        when(preparedStatement.executeUpdate()).thenReturn(1);
        doNothing().when(sqliteDB).closeDB();

        //When
        dbFacade.put(addingCard);

        //Then
        assertEquals(query, addingCardDB.getQuery());
        verify(tableMapper).getMapper(AddingCard.class);
        verify(sqliteDB).connectDB();
        verify(sqliteDB).getConnection();
        verify(connection).prepareStatement(query);
        verify(preparedStatement).executeUpdate();
        verify(sqliteDB).closeDB();
        verify(preparedStatement, times(1)).setString(1, String.valueOf(addingCard.getCardId()));
        verify(preparedStatement, times(1)).setString(2, String.valueOf(addingCard.getLocalDate()));
        verify(preparedStatement, times(1)).setString(3, String.valueOf(addingCard.getLocalTime()));
        verify(preparedStatement, times(1)).setString(4, String.valueOf(addingCard.getName()));
        verify(preparedStatement, times(1)).setString(5, String.valueOf(addingCard.getSurname()));
        verify(preparedStatement, times(1)).setString(6, String.valueOf(addingCard.getType()));
        verify(preparedStatement, times(6)).setString(anyInt(), anyString());
    }

}