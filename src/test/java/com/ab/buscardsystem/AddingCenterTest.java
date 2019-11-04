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
class AddingCenterTest {
    @InjectMocks
    AddingCenter addingCenter;
    @Mock
    FactoryInput factoryInput;

    @Test
    @DisplayName("Correct Name Input With Aslan")
    void takeNameWithCorrectInput() {
        //Given
        when(factoryInput.inputStringName()).thenReturn("Aslan");

        //When
        addingCenter.takeName();

        //Then
        assertEquals(1, addingCenter.getIsCorrect());
        verify(factoryInput).inputStringName();
    }

    @Test
    @DisplayName("InCorrect Name Input With NoName")
    void takeNameWithInCorrectInputNoName() {
        //Given
        when(factoryInput.inputStringName()).thenReturn("");

        //When
        addingCenter.takeName();

        //Then
        assertEquals(0, addingCenter.getIsCorrect());
        verify(factoryInput, times(3)).inputStringName();
    }

    @Test
    @DisplayName("InCorrect Name Input With Start With Space")
    void takeNameWithInCorrectInputStartWithSpace() {
        //Given
        when(factoryInput.inputStringName()).thenReturn(" ");

        //When
        addingCenter.takeName();

        //Then
        assertEquals(0, addingCenter.getIsCorrect());
        verify(factoryInput, times(3)).inputStringName();
    }

    @Test
    @DisplayName("3 Times Incorrect Name Input With More Than 14 Letters")
    void takeNameWithIncorrectInput3Times(){
        //Given
        when(factoryInput.inputStringName()).thenReturn("Muhammed Bekir Cinnah")
                                            .thenReturn("Barış Kaan Bayram")
                                            .thenReturn("Ata Osman Özgüz");

        //When
        addingCenter.takeName();
        //Then
        assertEquals(0, addingCenter.getIsCorrect());
        verify(factoryInput, times(3)).inputStringName();
    }

    @Test
    @DisplayName("2 Times Incorrect Name Input")
    void takeNameWithInCorrectInputTwoTimes() {
        //Given
        when(factoryInput.inputStringName()).thenReturn("").thenReturn(" ").thenReturn("Ali");

        //When
        addingCenter.takeName();

        //Then
        assertEquals(1, addingCenter.getIsCorrect());
        verify(factoryInput, times(3)).inputStringName();
    }

    @Test
    @DisplayName("1 Times Incorrect Name Input")
    void takeNameWithInCorrectInputOneTimes() {
        //Given
        when(factoryInput.inputStringName()).thenReturn("").thenReturn("Felis");

        //When
        addingCenter.takeName();

        //Then
        assertEquals(1, addingCenter.getIsCorrect());
        verify(factoryInput, times(2)).inputStringName();
    }

    @Test
    @DisplayName("Correct Address Input With CorrectAddress")
    void takeAddressWithCorrectInput() {
        //Given
        when(factoryInput.inputStringAddress()).thenReturn("Boğazkent Mahallesi, Ladin sokak 4/3 Çanakkale/Merkez");

        //When
        addingCenter.takeAddress();

        //Then
        assertEquals(1, addingCenter.getIsCorrect());
        verify(factoryInput).inputStringAddress();
    }

    @Test
    @DisplayName("InCorrect Address Input With NoName And Start With Space")
    void takeAddressWithInCorrectInputNoName() {
        //Given
        when(factoryInput.inputStringAddress()).thenReturn("").thenReturn(" ").thenReturn("");

        //When
        addingCenter.takeAddress();

        //Then
        assertEquals(0, addingCenter.getIsCorrect());
        verify(factoryInput, times(3)).inputStringAddress();
    }

    @Test
    @DisplayName("1 Times Incorrect Name Input")
    void takeAddressWithInCorrectInputOneTimes() {
        //Given
        when(factoryInput.inputStringAddress()).thenReturn("").thenReturn("CorrectAddress");

        //When
        addingCenter.takeAddress();

        //Then
        assertEquals(1, addingCenter.getIsCorrect());
        verify(factoryInput, times(2)).inputStringAddress();
    }

    @Test
    @DisplayName("2 Times Incorrect Name Input")
    void takeAddressWithInCorrectInputTwoTimes() {
        //Given
        when(factoryInput.inputStringAddress()).thenReturn("").thenReturn("").thenReturn("CorrectAddress");

        //When
        addingCenter.takeAddress();

        //Then
        assertEquals(1, addingCenter.getIsCorrect());
        verify(factoryInput, times(3)).inputStringAddress();
    }

    @Test
    @DisplayName("InCorrect Address Input With Long Address")
    void takeAddressWithInCorrectInputLongAddress() {
        //Given
        when(factoryInput.inputStringAddress()).thenReturn("KahramanMaras/GaziMustafaKemalPasa HakimiyetKayıtsızŞartsızMilletindir Mahallesi DumlupınarSavasları Apartmanı Kat 7 Daire 18");

        //When
        addingCenter.takeAddress();

        //Then
        assertEquals(0, addingCenter.getIsCorrect());
        verify(factoryInput, times(3)).inputStringAddress();
    }

    @Test
    @DisplayName("Correct CenterId Input")
    void takeCenterIdWithCorrectInput(){
        //Given
        when(factoryInput.inputIntegerId()).thenReturn(3);
        //When
        addingCenter.takeCenterId();
        //Then
        assertEquals(1, addingCenter.getIsCorrect());
        verify(factoryInput).inputIntegerId();
    }

    @Test
    @DisplayName("InCorrect CenterId Input with Negative And Zero ")
    void takeCenterIdWithInCorrectInputZeroAndNegative(){
        //Given
        when(factoryInput.inputIntegerId()).thenReturn(0).thenReturn(-5).thenReturn(-5000);
        //When
        addingCenter.takeCenterId();
        //Then
        assertEquals(0, addingCenter.getIsCorrect());
        verify(factoryInput, times(3)).inputIntegerId();
    }

    @Test
    @DisplayName("InCorrect CenterId Input with Too Big ")
    void takeCenterIdWithInCorrectInputTooBig(){
        //Given
        when(factoryInput.inputIntegerId()).thenReturn(10000).thenReturn(15000).thenReturn(10000000);
        //When
        addingCenter.takeCenterId();
        //Then
        assertEquals(0, addingCenter.getIsCorrect());
        verify(factoryInput, times(3)).inputIntegerId();
    }

    @Test
    @DisplayName("2 Times Incorrect Name Input ")
    void takeCenterIdWithInCorrectInputTwoTimes(){
        //Given
        when(factoryInput.inputIntegerId()).thenReturn(10000).thenReturn(15000).thenReturn(100);
        //When
        addingCenter.takeCenterId();
        //Then
        assertEquals(1, addingCenter.getIsCorrect());
        verify(factoryInput, times(3)).inputIntegerId();
    }

    @Test
    @DisplayName("1 Times Incorrect Name Input ")
    void takeCenterIdWithInCorrectInputOneTimes(){
        //Given
        when(factoryInput.inputIntegerId()).thenReturn(10000).thenReturn(5);
        //When
        addingCenter.takeCenterId();
        //Then
        assertEquals(1, addingCenter.getIsCorrect());
        verify(factoryInput, times(2)).inputIntegerId();
    }

    @Test
    @DisplayName("Verify SetCenterInfo Parameter with Null Throw Exception")
    void verifySetCenterInfoParameterWithNullThrowException(){
        //Given
        String expectedMassage = "CenterConsole is null";
        String actualMassage = null;

        //When - Then
        try{
            addingCenter.setCenterInfo(null);
        }catch (NullPointerException e){
            actualMassage = e.getMessage();
        }
        assertEquals(expectedMassage,actualMassage);
    }


    @Test
    @DisplayName("Verify setCenterInfo Method Calls")
    void setCenterInfoMethodCallsVerify(){
        //Given
        CenterConsole centerConsole = new CenterConsole();
        when(factoryInput.inputStringName()).thenReturn("muhsin");
        when(factoryInput.inputStringAddress()).thenReturn("canakkale");
        when(factoryInput.inputIntegerId()).thenReturn(77);


        //When
        addingCenter.setCenterInfo(centerConsole);

        //Then
        assertAll("SetUp CenterConsole's Info",
                ()-> assertEquals(77, centerConsole.getId()),
                ()-> assertEquals("muhsin", centerConsole.getName()),
                ()->assertEquals("canakkale", centerConsole.getAddress()),
                ()->assertEquals(addingCenter.getCenterConsole(), centerConsole),
                ()->assertEquals(1, addingCenter.getIsCorrect())
        );

        verify(factoryInput).inputStringName();
        verify(factoryInput).inputStringAddress();
        verify(factoryInput).inputIntegerId();
    }

    @Test
    @DisplayName("Verify setCenterInfo Method Calls With 3 Wrong Name Input")
    void setCenterInfoMethodCallsVerify3WrongNameInput(){
        //Given
        CenterConsole centerConsole = new CenterConsole();
        when(factoryInput.inputStringName()).thenReturn("").thenReturn(" ").thenReturn("IncorrectNameIncorrectName");

        //When
        addingCenter.setCenterInfo(centerConsole);

        //Then
        verify(factoryInput, times(3)).inputStringName();
    }

    @Test
    @DisplayName("Verify setCenterInfo Method Calls With 3 Wrong Address Input")
    void setCenterInfoMethodCallsVerify3WrongAddressInput(){
        //Given
        CenterConsole centerConsole = new CenterConsole();
        when(factoryInput.inputStringName()).thenReturn("muhsin");
        when(factoryInput.inputStringAddress())
                .thenReturn("KahramanMaras/GaziMustafaKemalPasa HakimiyetKayıtsızŞartsızMilletindir Mahallesi DumlupınarSavasları Apartmanı Kat 7 Daire 18")
                .thenReturn("")
                .thenReturn(" ");


        //When
        addingCenter.setCenterInfo(centerConsole);

        //Then

        verify(factoryInput).inputStringName();
        verify(factoryInput, times(3)).inputStringAddress();
    }

    @Test
    @DisplayName("Verify setCenterInfo Method Calls With 3 Wrong ID Input")
    void setCenterInfoMethodCallsVerify3WrongIdInput(){
        //Given
        CenterConsole centerConsole = new CenterConsole();
        when(factoryInput.inputStringName()).thenReturn("muhsin");
        when(factoryInput.inputStringAddress()).thenReturn("canakkale");
        when(factoryInput.inputIntegerId()).thenReturn(77777).thenReturn(-23).thenReturn(0);

        //When
        addingCenter.setCenterInfo(centerConsole);

        //Then
        verify(factoryInput).inputStringName();
        verify(factoryInput).inputStringAddress();
        verify(factoryInput, times(3)).inputIntegerId();
    }



}