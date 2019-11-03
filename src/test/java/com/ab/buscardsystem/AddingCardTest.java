package com.ab.buscardsystem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AddingCardTest {

    @InjectMocks
    AddingCard addingCard;
    @Mock
    FactoryInput factoryInput;
    @Mock
    Card card;

    @Test
    @DisplayName("Correct Tip Input With Student")
    void takeTipWithCorrectInputStudent1() {
        //Given
        when(factoryInput.inputStringType()).thenReturn("Student");

        //When
        addingCard.takeType();

        //Then
        assertEquals(1, addingCard.getIsCorrect());
    }

    @Test
    @DisplayName("Correct Tip Input With student")
    void takeTipWithCorrectInputStudent2() {
        //Given
        when(factoryInput.inputStringType()).thenReturn("student");

        //When
        addingCard.takeType();

        //Then
        assertEquals(1, addingCard.getIsCorrect());
    }

    @Test
    @DisplayName("Correct Tip Input With Normal")
    void takeTipWithCorrectInputNormal1() {
        //Given
        when(factoryInput.inputStringType()).thenReturn("Normal");

        //When
        addingCard.takeType();

        //Then
        assertEquals(1, addingCard.getIsCorrect());
    }

    @Test
    @DisplayName("Correct Tip Input With normal")
    void takeTipWithCorrectInputNormal2() {
        //Given
        when(factoryInput.inputStringType()).thenReturn("normal");

        //When
        addingCard.takeType();

        //Then
        assertEquals(1, addingCard.getIsCorrect());
    }

    @Test
    @DisplayName("Incorrect Tip Input")
    void takeTipWithIncorrectInput() {
        //Given
        when(factoryInput.inputStringType()).thenReturn("Doctor");

       //When
        addingCard.takeType();

        //Then
       assertEquals(0, addingCard.getIsCorrect());

    }

    @Test
    @DisplayName("Correct Name Input With Barış")
    void takeNameWithCorrectInput(){
        //Given
        when(factoryInput.inputStringName()).thenReturn("Barış");
        //When
        addingCard.takeName();
        //Then
        assertEquals(1, addingCard.getIsCorrect());
    }

    @Test
    @DisplayName("Incorrect Name Input With More Than 14 Letters")
    void takeNameWithIncorrectInput(){
        //Given
        when(factoryInput.inputStringName()).thenReturn("Muhammed Bekir Cinnah");
        //When
        addingCard.takeName();
        //Then
        assertEquals(0, addingCard.getIsCorrect());
    }

    @Test
    @DisplayName("Correct Surname Input With Osman")
    void takeSurnameWithCorrectInput(){
        //Given
        when(factoryInput.inputStringSurname()).thenReturn("Osman");
        //When
        addingCard.takeSurname();
        //Then
        assertEquals(1, addingCard.getIsCorrect());
    }

    @Test
    @DisplayName("Incorrect Surname Input With More Than 14 Letters")
    void takeSurnameWithIncorrectInput(){
        //Given
        when(factoryInput.inputStringSurname()).thenReturn("Muhammed Bekir Cinnah");
        //When
        addingCard.takeSurname();
        //Then
        assertEquals(0, addingCard.getIsCorrect());
    }

    @Test
    @DisplayName("Correct CardId Input")
    void takeIdWithCorrectInput(){
        //Given
        when(factoryInput.inputIntegerId()).thenReturn(11).thenReturn(100).thenReturn(19);
        //When
        addingCard.takeId();
        //Then
        assertEquals(1, addingCard.getIsCorrect());
    }

    @Test
    @DisplayName("Incorrect CardId Input 7")
    void takeIdWithIncorrectInputWith7(){
        //Given
        when(factoryInput.inputIntegerId()).thenReturn(7);
        //When
        addingCard.takeId();
        //Then
        assertEquals(0, addingCard.getIsCorrect());
    }

    @Test
    @DisplayName("Incorrect CardId Input 18")
    void takeIdWithIncorrectInputWith18(){
        //Given
        when(factoryInput.inputIntegerId()).thenReturn(18);
        //When
        addingCard.takeId();
        //Then
        assertEquals(0, addingCard.getIsCorrect());
    }

    @Test
    @DisplayName("Incorrect CardId Input -23")
    void takeIdWithIncorrectInputWithNegativeInteger(){
        //Given
        when(factoryInput.inputIntegerId()).thenReturn(-23);
        //When
        addingCard.takeId();
        //Then
        assertEquals(0, addingCard.getIsCorrect());
    }

    @Test
    @DisplayName("Incorrect CardId Input Plus 10.000")
    void takeIdWithIncorrectInputWithPlus10000(){
        //Given
        when(factoryInput.inputIntegerId()).thenReturn(10000);
        //When
        addingCard.takeId();
        //Then
        assertEquals(0, addingCard.getIsCorrect());
    }


    @Test
    @DisplayName("Verify setCardInfo Method Calls")
    void setCardInfoMethodCallsVerify(){
        //Given
        when(factoryInput.inputStringName()).thenReturn("Barış");
        when(factoryInput.inputStringType()).thenReturn("Student");
        when(factoryInput.inputIntegerId()).thenReturn(11);
        when(factoryInput.inputStringSurname()).thenReturn("Osman");
        doNothing().when(card).setId(11);
        doNothing().when(card).setBalance(0);
        doNothing().when(card).setName("Barış");
        doNothing().when(card).setSurname("Osman");
        doNothing().when(card).setType("STUDENT");
        //When
        addingCard.setCardInfo(card);
        //Then
        verify(card).setId(11);
        verify(card).setBalance(0);
        verify(card).setName("Barış");
        verify(card).setSurname("Osman");
        verify(card).setType("STUDENT");
        verify(factoryInput).inputStringName();
        verify(factoryInput).inputStringType();
        verify(factoryInput).inputIntegerId();
        verify(factoryInput).inputStringSurname();
    }

}