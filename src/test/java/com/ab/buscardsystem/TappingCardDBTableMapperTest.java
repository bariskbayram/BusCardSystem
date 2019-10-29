package com.ab.buscardsystem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TappingCardDBTableMapperTest {

    @InjectMocks
    TappingCardDB tappingCardDBTest;

    @Mock
    HashMap hashMapTest;

    @Test
    @DisplayName("getMapperMethod of TappingCardDBMapper Test")
    public void getMapperMethodTest(){

        TappingCard tappingCardTest1 = new TappingCard(1);
        TappingCard tappingCardTest2 = new TappingCard(2);

        when(hashMapTest.get(tappingCardTest1.getId())).thenReturn(tappingCardTest1);
        when(hashMapTest.get(tappingCardTest2.getId())).thenReturn(tappingCardTest2);

        assertEquals(tappingCardTest1, tappingCardDBTest.getItem(1));
        assertEquals(tappingCardTest2, tappingCardDBTest.getItem(2));


    }

   /* @Test
    @DisplayName("putToMapperMethod of TappingCardDBMapper Test")
    public void putToMethodTest(){

        TappingCard tappingCardTest1 = new TappingCard(1);
        //TappingCard tappingCardTest2 = new TappingCard(2);

        when(hashMapTest1.put(tappingCardTest1.getId(),tappingCardTest1)).thenReturn(null);
        //doNothing().when(hashMapTest).put(tappingCardTest2.getId(), tappingCardTest2);

        tappingCardDBMapperTest.putToMapper(tappingCardTest1);
        //tappingCardDBMapperTest.putToMapper(tappingCardTest2);

        verify(hashMapTest1).put(tappingCardTest1.getId(),tappingCardTest1);
        //verify(hashMapTest).put(tappingCardTest2.getId(),tappingCardTest2);


    }*/

}