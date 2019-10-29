package com.ab.buscardsystem;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WholeSystemTest {

    @InjectMocks
    WholeSystem wholeSystem;

    @Mock
    BusConsole busConsole;


    @Test
    @DisplayName("Initiliazing Start Method Test")
    public void startTest() {

    doNothing().when(busConsole).enterCardId(32);
    wholeSystem.start();
    verify(busConsole).enterCardId(32);

    }
}