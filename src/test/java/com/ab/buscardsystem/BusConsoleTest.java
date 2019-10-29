package com.ab.buscardsystem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BusConsoleTest {

    @Mock
    DBFacade dbFacade;
    @Mock
    Card card;
    @Mock
    TappingCard tappingCard;

    @InjectMocks
    BusConsole busConsole;

    @Test
    @DisplayName("StartingTest for enterCardId Method")
    void enterCardIdTest() {



    }
}