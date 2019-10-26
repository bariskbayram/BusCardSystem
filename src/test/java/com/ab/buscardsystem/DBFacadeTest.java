package com.ab.buscardsystem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DBFacadeTest {

    @Test
    @DisplayName("CreationDBFacadeTest")
    void getMapper() {
        DBFacade dbFacade = new DBFacade();
        assertNotNull(dbFacade.getMapper());
    }
}