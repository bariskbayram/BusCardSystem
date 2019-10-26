package com.ab.buscardsystem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class DBFacadeTest {

    @Test
    @DisplayName("CreationDBFacadeTest")
    void getMapper() {
        DBFacade dbFacade = new DBFacade();
        assertNotNull(dbFacade.getMapper());
    }

    @Test
    public void test2(){

        DBFacade dbFacade = mock(DBFacade.class);

        dbFacade.get(32,Card.class);
        verify(dbFacade).get(32,Card.class);
        verify(dbFacade, times(1)).get(32, Card.class);
        verify(dbFacade,times(5)).get(anyInt(), Card.class);

    }
}