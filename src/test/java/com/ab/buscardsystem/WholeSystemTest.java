package com.ab.buscardsystem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.SQLException;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class WholeSystemTest {

    @InjectMocks
    WholeSystem wholeSystem;

    @Mock
    BusConsole busConsole;

    @Test
    @DisplayName("Yaraklara geldik")
    public void startTest() throws SQLException {

        doNothing().when(busConsole).enterCardId(1, true);
        wholeSystem.start();

        verify(busConsole).enterCardId(1, true);

    }

}