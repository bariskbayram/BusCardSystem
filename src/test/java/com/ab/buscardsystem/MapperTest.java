package com.ab.buscardsystem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

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
}