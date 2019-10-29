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
class CardDBTableMapperTest {

    @InjectMocks
    TappingCardDB cardDBMapperTest;

    @Mock
    HashMap hashMapTest;

    @Test
    @DisplayName("getMapperMethod of CardDBMapper Test")
    public void getMapperMethodTest(){

        Card cardTest1 = new Card(1);
        Card cardTest2 = new Card(2);

        when(hashMapTest.get(cardTest1.getId())).thenReturn(cardTest1);
        when(hashMapTest.get(cardTest2.getId())).thenReturn(cardTest2);

        assertEquals(cardTest1,cardDBMapperTest.getItem(1));
        assertEquals(cardTest2,cardDBMapperTest.getItem(2));


    }

}