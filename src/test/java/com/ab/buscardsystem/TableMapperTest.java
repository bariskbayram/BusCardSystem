package com.ab.buscardsystem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TableMapperTest {

    @Test
    @DisplayName("MapperCreationTest")
    void getMapper() {
        TableMapper tableMapper = new TableMapper();
        assertNotNull(tableMapper.getMapper());
    }

    @Test
    @DisplayName("CardDBMapperCreationTest")
    void getCardDBMapper() {
        TableMapper tableMapper = new TableMapper();
        assertNotNull(tableMapper.getCardDB());
    }

    @Test
    @DisplayName("TappingCardDBMapperCreationTest")
    void getTappingCardDBMapper() {
        TableMapper tableMapper = new TableMapper();
        assertNotNull(tableMapper.getTappingCardDB());
    }

    @InjectMocks
    TableMapper tableMapperTest;

    @Mock
    HashMap hashMapTest;

    @Test
    @DisplayName("getMethod of Mapper Test")
    public void getMethodTest(){

        TappingCardDB tappingCardDB = new TappingCardDB();
        CardDB cardDB = new CardDB(new SqliteDB());

        when(hashMapTest.get(TappingCard.class)).thenReturn(tappingCardDB);
        when(hashMapTest.get(Card.class)).thenReturn(cardDB);

        assertEquals(tappingCardDB, tableMapperTest.getMapper(TappingCard.class));
        assertEquals(cardDB, tableMapperTest.getMapper(Card.class));

    }


}