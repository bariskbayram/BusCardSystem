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
class MapperTest {

    @Test
    @DisplayName("MapperCreationTest")
    void getMapper() {
        Mapper mapper = new Mapper();
        assertNotNull(mapper.getMapper());
    }

    @Test
    @DisplayName("CardDBMapperCreationTest")
    void getCardDBMapper() {
        Mapper mapper = new Mapper();
        assertNotNull(mapper.getCardDBMapper());
    }

    @Test
    @DisplayName("TappingCardDBMapperCreationTest")
    void getTappingCardDBMapper() {
        Mapper mapper = new Mapper();
        assertNotNull(mapper.getTappingCardDBMapper());
    }

    @InjectMocks
    Mapper mapperTest;

    @Mock
    HashMap hashMapTest;

    @Test
    @DisplayName("getMethod of Mapper Test")
    public void getMethodTest(){

        TappingCardDBMapper tappingCardDBMapper = new TappingCardDBMapper();
        CardDBMapper cardDBMapper = new CardDBMapper();

        when(hashMapTest.get(TappingCard.class)).thenReturn(tappingCardDBMapper);
        when(hashMapTest.get(Card.class)).thenReturn(cardDBMapper);

        assertEquals(tappingCardDBMapper,mapperTest.getMapper(TappingCard.class));
        assertEquals(cardDBMapper,mapperTest.getMapper(Card.class));

    }


}