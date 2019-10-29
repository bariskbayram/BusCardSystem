package com.ab.buscardsystem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class TappingCardDBMapperTest {

    TappingCardDBMapper tappingCardDBMapperTest = new TappingCardDBMapper();

    @Test
    @DisplayName("beni yorma")
    void getMapperTest() {


        HashMap<Integer,Object> hashMapTest = new HashMap<>();
        tappingCardDBMapperTest.setTappingCardDBMapper(hashMapTest);
        TappingCard tappingCardTest1 = new TappingCard();
        TappingCard tappingCardTest2 = new TappingCard();

        hashMapTest.put(1,tappingCardTest1);
        hashMapTest.put(2,tappingCardTest2);

        assertEquals(tappingCardTest1,tappingCardDBMapperTest.getItem(1));
    }

    @Test
    @DisplayName("nedir???")
    void putToMapperTest(){
        HashMap<Integer,Object> hashMapTest = new HashMap<>();
        TappingCard tappingCardTest1 = new TappingCard();
        TappingCard tappingCardTest2 = new TappingCard();

        TappingCard tappingCardEkelenen = (TappingCard)hashMapTest.put(1,tappingCardTest1);

    }


}