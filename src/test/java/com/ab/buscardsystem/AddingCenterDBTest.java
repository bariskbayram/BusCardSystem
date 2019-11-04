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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AddingCenterDBTest {
    @InjectMocks
    DBFacade dbFacade = new DBFacade();
    @Mock
    TableMapper tableMapper;

    @Mock
    SqliteDB sqliteDB;

    @InjectMocks
    AddingCenterDB addingCenterDB = new AddingCenterDB(sqliteDB);
    @Mock
    Connection connection;
    @Mock
    PreparedStatement preparedStatement;

    @Test
    @DisplayName("Verify AddingCard Info")
    void putItemTest() throws SQLException {

        //Given
        AddingCenter addingCenter = new AddingCenter();
        addingCenter.setCenterId(23);
        addingCenter.setLocalDate(LocalDate.now());
        addingCenter.setLocalTime(LocalTime.now());
        addingCenter.setAddress("Hürriyet Mahallesi Dr.Cemil Bengü Caddesi");
        addingCenter.setName("Ibrahimovic");
        String query = "INSERT INTO AddingCenter (Date, Time, Name, Address, CenterId) VALUES (?,?,?,?,?)";

        when(tableMapper.getMapper(AddingCenter.class)).thenReturn(addingCenterDB);

        doNothing().when(sqliteDB).connectDB();
        when(sqliteDB.getConnection()).thenReturn(connection);
        when(connection.prepareStatement(query)).thenReturn(preparedStatement);
        doNothing().when(preparedStatement).setString(anyInt(), anyString());
        when(preparedStatement.executeUpdate()).thenReturn(1);
        doNothing().when(sqliteDB).closeDB();

        //When
        dbFacade.put(addingCenter);

        //Then
        assertEquals(query, addingCenterDB.getQuery());
        verify(tableMapper).getMapper(AddingCenter.class);
        verify(sqliteDB).connectDB();
        verify(sqliteDB).getConnection();
        verify(connection).prepareStatement(query);
        verify(preparedStatement).executeUpdate();
        verify(sqliteDB).closeDB();
        verify(preparedStatement, times(1)).setString(1,String.valueOf(addingCenter.getLocalDate()));
        verify(preparedStatement, times(1)).setString(2,String.valueOf(addingCenter.getLocalTime()));
        verify(preparedStatement, times(1)).setString(3,String.valueOf(addingCenter.getName()));
        verify(preparedStatement, times(1)).setString(4,String.valueOf(addingCenter.getAddress()));
        verify(preparedStatement, times(1)).setString(5,String.valueOf(addingCenter.getCenterId()));
        verify(preparedStatement, times(5)).setString(anyInt(),anyString());
    }

}