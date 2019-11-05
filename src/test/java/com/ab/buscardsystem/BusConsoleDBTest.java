package com.ab.buscardsystem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BusConsoleDBTest {

    @InjectMocks
    DBFacade dbFacade = new DBFacade();
    @Mock
    TableMapper tableMapper;

    @Mock
    SqliteDB sqliteDB;

    @InjectMocks
    BusConsoleDB busConsoleDB = new BusConsoleDB(sqliteDB);
    @Mock
    Connection connection;
    @Mock
    PreparedStatement preparedStatement;
    @Mock
    ResultSet resultSet;

    @Test
    @DisplayName("Verify BusConsoleDB GetItem Process")
    void verifyBusConsoleDBGetItemProcess() throws SQLException {

        //Given
        String query = "SELECT * FROM BusConsole WHERE Id = ?";
        doNothing().when(sqliteDB).connectDB();
        when(sqliteDB.getConnection()).thenReturn(connection);
        when(connection.prepareStatement(query)).thenReturn(preparedStatement);
        doNothing().when(preparedStatement).setString(1, String.valueOf(3));
        when(preparedStatement.executeQuery()).thenReturn(resultSet);
        doNothing().when(sqliteDB).closeDB();
        when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(resultSet.getInt("Id")).thenReturn(3);
        when(tableMapper.getMapper(BusConsole.class)).thenReturn(busConsoleDB);

        //When
        dbFacade.get(3, BusConsole.class);

        //Then
        assertEquals(query, busConsoleDB.getQuery());
        verify(sqliteDB).connectDB();
        verify(sqliteDB).getConnection();
        verify(connection).prepareStatement(query);
        verify(preparedStatement).setString(1, String.valueOf(3));
        verify(preparedStatement).executeQuery();
        verify(sqliteDB).closeDB();
        verify(resultSet, times(2)).next();
        verify(resultSet).getInt("Id");
        verify(tableMapper).getMapper(BusConsole.class);



    }


}