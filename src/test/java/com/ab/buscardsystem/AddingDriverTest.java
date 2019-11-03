package com.ab.buscardsystem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class AddingDriverTest {

    @InjectMocks
    AddingDriver addingDriver;
    @Mock
    FactoryInput factoryInput;
    @Mock
    Driver driver;

    @Test
    @DisplayName("Correct Name Input With Barış")
    void takeNameWithCorrectInput(){
        //Given
        when(factoryInput.inputStringName()).thenReturn("Barış");
        //When
        addingDriver.takeName();
        //Then
        assertEquals(1, addingDriver.getIsCorrect());
    }

    @Test
    @DisplayName("Incorrect Name Input With More Than 14 Letters")
    void takeNameWithIncorrectInput(){
        //Given
        when(factoryInput.inputStringName()).thenReturn("Muhammed Bekir Cinnah");
        //When
        addingDriver.takeName();
        //Then
        assertEquals(0, addingDriver.getIsCorrect());
    }

    @Test
    @DisplayName("Correct Surname Input With Osman")
    void takeSurnameWithCorrectInput(){
        //Given
        when(factoryInput.inputStringSurname()).thenReturn("Osman");
        //When
        addingDriver.takeSurname();
        //Then
        assertEquals(1, addingDriver.getIsCorrect());
    }

    @Test
    @DisplayName("Incorrect Surname Input With More Than 14 Letters")
    void takeSurnameWithIncorrectInput(){
        //Given
        when(factoryInput.inputStringSurname()).thenReturn("Muhammed Bekir Cinnah");
        //When
        addingDriver.takeSurname();
        //Then
        assertEquals(0, addingDriver.getIsCorrect());
    }

    @Test
    @DisplayName("Correct CardId Input")
    void takeIdWithCorrectInput(){
        //Given
        when(factoryInput.inputIntegerId()).thenReturn(1);
        //When
        addingDriver.takeId();
        //Then
        assertEquals(1, addingDriver.getIsCorrect());
    }

    @Test
    @DisplayName("Incorrect CardId Input 7")
    void takeIdWithIncorrectInputWith7(){
        //Given
        when(factoryInput.inputIntegerId()).thenReturn(7);
        //When
        addingDriver.takeId();
        //Then
        assertEquals(0, addingDriver.getIsCorrect());
    }

    @Test
    @DisplayName("Incorrect CardId Input 18")
    void takeIdWithIncorrectInputWith18(){
        //Given
        when(factoryInput.inputIntegerId()).thenReturn(18);
        //When
        addingDriver.takeId();
        //Then
        assertEquals(0, addingDriver.getIsCorrect());
    }

    @Test
    @DisplayName("Incorrect CardId Input -23")
    void takeIdWithIncorrectInputWithNegativeInteger(){
        //Given
        when(factoryInput.inputIntegerId()).thenReturn(-23);
        //When
        addingDriver.takeId();
        //Then
        assertEquals(0, addingDriver.getIsCorrect());
    }

    @Test
    @DisplayName("Incorrect CardId Input Plus 10.000")
    void takeIdWithIncorrectInputWithPlus10000(){
        //Given
        when(factoryInput.inputIntegerId()).thenReturn(10000);
        //When
        addingDriver.takeId();
        //Then
        assertEquals(0, addingDriver.getIsCorrect());
    }


    @Test
    @DisplayName("Verify setCardInfo Method Calls")
    void setCardInfoMethodCallsVerify(){
        //Given
        when(factoryInput.inputStringName()).thenReturn("Baris");
        when(factoryInput.inputStringSurname()).thenReturn("Osman");
        when(factoryInput.inputIntegerId()).thenReturn(1);
        doNothing().when(driver).setName("Baris");
        doNothing().when(driver).setSurname("Osman");
        doNothing().when(driver).setId(1);
        //When
        addingDriver.setDriverInfo(driver);
        //Then
        verify(driver).setName("Baris");
        verify(driver).setSurname("Osman");
        verify(driver).setId(1);
        verify(factoryInput).inputStringName();
        verify(factoryInput).inputStringSurname();
        verify(factoryInput).inputIntegerId();

    }


}