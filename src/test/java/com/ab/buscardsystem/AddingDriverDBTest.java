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
class AddingDriverDBTest {

    @InjectMocks
    DBFacade dbFacade = new DBFacade();
    @Mock
    TableMapper tableMapper;

    @Mock
    SqliteDB sqliteDB;

    @InjectMocks
    AddingDriverDB addingDriverDB = new AddingDriverDB(sqliteDB);
    @Mock
    Connection connection;
    @Mock
    PreparedStatement preparedStatement;

    @Test
    @DisplayName("Verify AddingDriver Info")
    void putItemTest() throws SQLException {

        //Given
        AddingDriver addingDriver = new AddingDriver();
        addingDriver.setDriverId(14);
        addingDriver.setLocalDate(LocalDate.now());
        addingDriver.setLocalTime(LocalTime.now());
        addingDriver.setSurname("AbdulAhmet");
        addingDriver.setName("Cemalettin");
        String query = "INSERT INTO AddingDriver (Date, Time, Name, Surname, DriverId) VALUES (?,?,?,?,?)";

        when(tableMapper.getMapper(AddingDriver.class)).thenReturn(addingDriverDB);

        doNothing().when(sqliteDB).connectDB();
        when(sqliteDB.getConnection()).thenReturn(connection);
        when(connection.prepareStatement(query)).thenReturn(preparedStatement);
        doNothing().when(preparedStatement).setString(anyInt(), anyString());
        when(preparedStatement.executeUpdate()).thenReturn(1);
        doNothing().when(sqliteDB).closeDB();

        //When
        dbFacade.put(addingDriver);

        //Then
        assertEquals(query, addingDriverDB.getQuery());
        verify(tableMapper).getMapper(AddingDriver.class);
        verify(sqliteDB).connectDB();
        verify(sqliteDB).getConnection();
        verify(connection).prepareStatement(query);
        verify(preparedStatement).executeUpdate();
        verify(sqliteDB).closeDB();
        verify(preparedStatement, times(1)).setString(1,String.valueOf(addingDriver.getLocalDate()));
        verify(preparedStatement, times(1)).setString(2,String.valueOf(addingDriver.getLocalTime()));
        verify(preparedStatement, times(1)).setString(3,String.valueOf(addingDriver.getName()));
        verify(preparedStatement, times(1)).setString(4,String.valueOf(addingDriver.getSurname()));
        verify(preparedStatement, times(1)).setString(5,String.valueOf(addingDriver.getDriverId()));
        verify(preparedStatement, times(5)).setString(anyInt(),anyString());
    }

}