package com.ab.buscardsystem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class BusConsoleTest {

    @Test
    @DisplayName("StartingTest for enterCardId Method")
    void enterCardIdTest() {

        BusConsole busConsole = mock(BusConsole.class);
        doNothing().when(busConsole).enterCardId(anyInt());

        busConsole.enterCardId(anyInt());
        verify(busConsole).enterCardId(anyInt());

    }
}