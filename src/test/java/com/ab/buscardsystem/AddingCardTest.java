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

    @Test
    @DisplayName("Correct Type Input With Student")
    void takeTypeWithCorrectInputStudent1() {
        //Given
        when(factoryInput.inputStringType()).thenReturn("Student");

        //When
        addingCard.takeType();

        //Then
        assertEquals(1, addingCard.getIsCorrect());
    }

    @Test
    @DisplayName("Correct Type Input With student")
    void takeTypeWithCorrectInputStudent2() {
        //Given
        when(factoryInput.inputStringType()).thenReturn("student");

        //When
        addingCard.takeType();

        //Then
        assertEquals(1, addingCard.getIsCorrect());
    }

    @Test
    @DisplayName("Correct Type Input With Normal")
    void takeTypeWithCorrectInputNormal1() {
        //Given
        when(factoryInput.inputStringType()).thenReturn("Normal");

        //When
        addingCard.takeType();

        //Then
        assertEquals(1, addingCard.getIsCorrect());
    }

    @Test
    @DisplayName("Correct Type Input With normal")
    void takeTipWithCorrectInputNormal2() {
        //Given
        when(factoryInput.inputStringType()).thenReturn("normal");

        //When
        addingCard.takeType();

        //Then
        assertEquals(1, addingCard.getIsCorrect());
    }

    @Test
    @DisplayName("3 Times Incorrect Type Input")
    void takeTipWithIncorrectInput3Times() {
        //Given
        when(factoryInput.inputStringType()).thenReturn("Doctor").thenReturn("Pilot").thenReturn("Child");

       //When
        addingCard.takeType();

        //Then
       assertEquals(0, addingCard.getIsCorrect());
       verify(factoryInput, times(3)).inputStringType();

    }

    @Test
    @DisplayName("2 Times Incorrect Type Input")
    void takeTipWithIncorrectInput2Times(){
        //Given
        when(factoryInput.inputStringType()).thenReturn("Doctor").thenReturn("").thenReturn("Normal");

        //When
        addingCard.takeType();

        //Then
        assertEquals(1, addingCard.getIsCorrect());
        verify(factoryInput, times(3)).inputStringType();
    }

    @Test
    @DisplayName("1 Times Incorrect Type Input")
    void takeTipWithIncorrectInput1Times(){
        //Given
        when(factoryInput.inputStringType()).thenReturn("Doctor").thenReturn("Normal");

        //When
        addingCard.takeType();

        //Then
        assertEquals(1, addingCard.getIsCorrect());
        verify(factoryInput, times(2)).inputStringType();
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
    @DisplayName("Correct Name Input With NoName")
    void takeNameWithCorrectInputNoName(){
        //Given
        when(factoryInput.inputStringName()).thenReturn("");
        //When
        addingCard.takeName();
        //Then
        assertEquals(1, addingCard.getIsCorrect());
    }

    @Test
    @DisplayName("3 Times Incorrect Name Input With More Than 14 Letters")
    void takeNameWithIncorrectInput3Times(){
        //Given
        when(factoryInput.inputStringName()).thenReturn("Muhammed Bekir Cinnah")
                                            .thenReturn("Barış Kaan Bayram")
                                            .thenReturn("Ata Osman Özgüz");

        //When
        addingCard.takeName();
        //Then
        assertEquals(0, addingCard.getIsCorrect());
        verify(factoryInput, times(3)).inputStringName();
    }

    @Test
    @DisplayName("2 Times Incorrect Name Input With More Than 14 Letters")
    void takeNameWithIncorrectInput2Times(){
        //Given
        when(factoryInput.inputStringName()).thenReturn("Muhammed Bekir Cinnah")
                                            .thenReturn("Barış Kaan Bayram")
                                            .thenReturn("Kemal");
        //When
        addingCard.takeName();
        //Then
        assertEquals(1, addingCard.getIsCorrect());
        verify(factoryInput, times(3)).inputStringName();
    }

    @Test
    @DisplayName("1 Times Incorrect Name Input With More Than 14 Letters")
    void takeNameWithIncorrectInput1Times(){
        //Given
        when(factoryInput.inputStringName()).thenReturn("Muhammed Bekir Cinnah").thenReturn("Kemal");
        //When
        addingCard.takeName();
        //Then
        assertEquals(1, addingCard.getIsCorrect());
        verify(factoryInput, times(2)).inputStringName();
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
    @DisplayName("Correct Surname Input With NoName")
    void takeSurnameWithCorrectInputNoName(){
        //Given
        when(factoryInput.inputStringSurname()).thenReturn("");
        //When
        addingCard.takeSurname();
        //Then
        assertEquals(1, addingCard.getIsCorrect());
    }

    @Test
    @DisplayName("3 Times Incorrect Surname Input With More Than 14 Letters")
    void takeSurnameWithIncorrectInput3Times(){
        //Given
        when(factoryInput.inputStringSurname()).thenReturn("Muhammed Bekir Cinnah")
                                                .thenReturn("Joseph Henry Blackburn")
                                                .thenReturn("Zlatan Kennedy Ibrahimovic");
        //When
        addingCard.takeSurname();
        //Then
        assertEquals(0, addingCard.getIsCorrect());
        verify(factoryInput, times(3)).inputStringSurname();
    }

    @Test
    @DisplayName("2 Times Incorrect Surname Input With More Than 14 Letters")
    void takeSurnameWithIncorrectInput2Times(){
        //Given
        when(factoryInput.inputStringSurname()).thenReturn("Muhammed Bekir Cinnah")
                .thenReturn("Barış Kaan Bayram")
                .thenReturn("Kemal");
        //When
        addingCard.takeSurname();
        //Then
        assertEquals(1, addingCard.getIsCorrect());
        verify(factoryInput, times(3)).inputStringSurname();
    }

    @Test
    @DisplayName("1 Times Incorrect Surname Input With More Than 14 Letters")
    void takeSurnameWithIncorrectInput1Times(){
        //Given
        when(factoryInput.inputStringSurname()).thenReturn("Muhammed Bekir Cinnah").thenReturn("Mehmet");
        //When
        addingCard.takeSurname();
        //Then
        assertEquals(1, addingCard.getIsCorrect());
        verify(factoryInput, times(2)).inputStringSurname();
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
        verify(factoryInput, times(3)).inputIntegerId();
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
        verify(factoryInput, times(3)).inputIntegerId();
    }

    @Test
    @DisplayName("Incorrect CardId Input -23")
    void takeIdWithIncorrectInputWithNegativeInteger(){
        //Given
        when(factoryInput.inputIntegerId()).thenReturn(-23).thenReturn(-40).thenReturn(-132);
        //When
        addingCard.takeId();
        //Then
        assertEquals(0, addingCard.getIsCorrect());
        verify(factoryInput, times(3)).inputIntegerId();
    }

    @Test
    @DisplayName("Incorrect CardId Input Plus 10.000")
    void takeIdWithIncorrectInputWithPlus10000(){
        //Given
        when(factoryInput.inputIntegerId()).thenReturn(10000).thenReturn(15000).thenReturn(234243);
        //When
        addingCard.takeId();
        //Then
        assertEquals(0, addingCard.getIsCorrect());
        verify(factoryInput, times(3)).inputIntegerId();
    }

    @Test
    @DisplayName("2 Times Incorrect CardId Input")
    void takeIdWithIncorrectInput2Times(){
        //Given
        when(factoryInput.inputIntegerId()).thenReturn(10000).thenReturn(15000).thenReturn(4);
        //When
        addingCard.takeId();
        //Then
        assertEquals(1, addingCard.getIsCorrect());
        verify(factoryInput, times(3)).inputIntegerId();
    }

    @Test
    @DisplayName("1 Times Incorrect CardId Input")
    void takeIdWithIncorrectInput1Times(){
        //Given
        when(factoryInput.inputIntegerId()).thenReturn(10000).thenReturn(4);
        //When
        addingCard.takeId();
        //Then
        assertEquals(1, addingCard.getIsCorrect());
        verify(factoryInput, times(2)).inputIntegerId();
    }


    @Test
    @DisplayName("Verify setCardInfo Method Calls")
    void setCardInfoMethodCallsVerify(){
        //Given
        Card card = new Card(0);
        when(factoryInput.inputStringName()).thenReturn("Barış");
        when(factoryInput.inputStringType()).thenReturn("Student");
        when(factoryInput.inputIntegerId()).thenReturn(11);
        when(factoryInput.inputStringSurname()).thenReturn("Osman");

        //When
        addingCard.setCardInfo(card);

        //Then
        assertAll("SetUp Card's Info",
                ()-> assertEquals(11, card.getId()),
                ()-> assertEquals("Barış", card.getName()),
                ()->assertEquals("Osman", card.getSurname()),
                ()->assertEquals("STUDENT", card.getType()),
                ()->assertEquals(0, card.getBalance()),
                ()->assertEquals(addingCard.getCard(), card)
        );

        verify(factoryInput).inputStringName();
        verify(factoryInput).inputStringType();
        verify(factoryInput).inputIntegerId();
        verify(factoryInput).inputStringSurname();
    }

    @Test
    @DisplayName("Verify SetCardInfo Parameter with Null Throw Exception")
    void verifySetCardInfoParameterWithNullThrowException(){
        //Given
        Card card = null;
        //When - Then
        assertThrows(NullPointerException.class, ()->addingCard.setCardInfo(card), "Card is null");
    }

}