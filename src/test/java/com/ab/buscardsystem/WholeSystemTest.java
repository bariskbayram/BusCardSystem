package com.ab.buscardsystem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WholeSystemTest {

    @Test
    @DisplayName("CreationDBFacadeConsoleTest")
    void getDbFacade() {
        WholeSystem wholeSystem = new WholeSystem();
        assertNotNull(wholeSystem.getDbFacade());
    }

    @Test
    @DisplayName("CreationBusConsoleTest")
    void getBusConsole() {
        WholeSystem wholeSystem = new WholeSystem();
        assertNotNull(wholeSystem.getBusConsole());
    }

}