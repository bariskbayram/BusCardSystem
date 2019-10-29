package com.ab.buscardsystem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class CardDBMapperTest {

    CardDBMapper cardDBMapperTest = new CardDBMapper();

    @Test
    @DisplayName("beni yorma")
    void getMapperTest() {


        HashMap<Integer,Object> hashMapTest = new HashMap<>();
        cardDBMapperTest.setCardDBMapper(hashMapTest);
        Card cardTest1 = new Card(1);
        Card cardTest2 = new Card(2);

        hashMapTest.put(1,cardTest1);
        hashMapTest.put(2,cardTest2);

        assertEquals(cardTest1,cardDBMapperTest.getItem(1));
    }

    @Test
    @DisplayName("nedir???")
    void putToMapperTest(){
        HashMap<Integer,Object> hashMapTest = new HashMap<>();
        Card cardTest1 = new Card(1);
        Card cardTest2 = new Card(2);

        Card cardEkelenen = (Card)hashMapTest.put(1,cardTest1);

    }

}