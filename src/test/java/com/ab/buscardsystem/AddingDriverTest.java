package com.ab.buscardsystem;

import com.ab.buscardsystem.BusinessLayer.AddingDriver;
import com.ab.buscardsystem.BusinessLayer.Driver;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AddingDriverTest {

    @InjectMocks
    AddingDriver addingDriver;
    @Mock
    FactoryInput factoryInput;

    @Test
    @DisplayName("Correct Name Input With Barış")
    void takeNameWithCorrectInput() {
        //Given
        when(factoryInput.inputStringName()).thenReturn("Barış");
        //When
        addingDriver.takeName();
        //Then
        assertEquals(1, addingDriver.getIsCorrect());
        verify(factoryInput).inputStringName();
    }

    @Test
    @DisplayName("Incorrect Name Input With NoName or Start With Space")
    void takeNameWithCorrectInputNoNameOrStartWithSpace() {
        //Given
        when(factoryInput.inputStringName()).thenReturn("").thenReturn(" ").thenReturn("  ");
        //When
        addingDriver.takeName();
        //Then
        assertEquals(0, addingDriver.getIsCorrect());
        verify(factoryInput, times(3)).inputStringName();
    }

    @Test
    @DisplayName("Incorrect Name Input With More Than 14 Letters")
    void takeNameWithIncorrectInputWithMoreThan14Letters() {
        //Given
        when(factoryInput.inputStringName()).thenReturn("Muhammed Bekir Cinnah")
                .thenReturn("Lionel Rodriguez Messi")
                .thenReturn("Cristiano Bekir Ronaldo");
        //When
        addingDriver.takeName();
        //Then
        assertEquals(0, addingDriver.getIsCorrect());
        verify(factoryInput, times(3)).inputStringName();
    }

    @Test
    @DisplayName("2 Times Incorrect Name Input")
    void takeNameWithIncorrectInput2Times() {
        //Given
        when(factoryInput.inputStringName()).thenReturn("Muhammed Bekir Cinnah").thenReturn("").thenReturn("Selami");
        //When
        addingDriver.takeName();
        //Then
        assertEquals(1, addingDriver.getIsCorrect());
        verify(factoryInput, times(3)).inputStringName();
    }

    @Test
    @DisplayName("1 Times Incorrect Name Input")
    void takeNameWithIncorrectInput1Times() {
        //Given
        when(factoryInput.inputStringName()).thenReturn("Muhammed Bekir Cinnah").thenReturn("Kardelen");
        //When
        addingDriver.takeName();
        //Then
        assertEquals(1, addingDriver.getIsCorrect());
        verify(factoryInput, times(2)).inputStringName();
    }

    @Test
    @DisplayName("Correct Surname Input With Osman")
    void takeSurnameWithCorrectInput() {
        //Given
        when(factoryInput.inputStringSurname()).thenReturn("Osman");
        //When
        addingDriver.takeSurname();
        //Then
        assertEquals(1, addingDriver.getIsCorrect());
    }

    @Test
    @DisplayName("Incorrect Surname Input With NoName or Start With Space")
    void takeSurnameWithCorrectInputNoNameOrStartWithSpace() {
        //Given
        when(factoryInput.inputStringSurname()).thenReturn("").thenReturn(" ").thenReturn("  ");
        //When
        addingDriver.takeSurname();
        //Then
        assertEquals(0, addingDriver.getIsCorrect());
        verify(factoryInput, times(3)).inputStringSurname();
    }

    @Test
    @DisplayName("Incorrect Surname Input With More Than 14 Letters")
    void takeSurnameWithIncorrectInput() {
        //Given
        when(factoryInput.inputStringSurname()).thenReturn("Muhammed Bekir Cinnah");
        //When
        addingDriver.takeSurname();
        //Then
        assertEquals(0, addingDriver.getIsCorrect());
        verify(factoryInput, times(3)).inputStringSurname();
    }

    @Test
    @DisplayName("2 Times Incorrect Surname Input")
    void takeSurnameWithIncorrectInput2Times() {
        //Given
        when(factoryInput.inputStringSurname()).thenReturn("Muhammed Bekir Cinnah").thenReturn("").thenReturn("Selami");
        //When
        addingDriver.takeSurname();
        //Then
        assertEquals(1, addingDriver.getIsCorrect());
        verify(factoryInput, times(3)).inputStringSurname();
    }

    @Test
    @DisplayName("1 Times Incorrect Surname Input")
    void takeSurnameWithIncorrectInput1Times() {
        //Given
        when(factoryInput.inputStringSurname()).thenReturn("Muhammed Bekir Cinnah").thenReturn("Kardelen");
        //When
        addingDriver.takeSurname();
        //Then
        assertEquals(1, addingDriver.getIsCorrect());
        verify(factoryInput, times(2)).inputStringSurname();
    }

    @Test
    @DisplayName("Correct DriverId Input")
    void takeIdWithCorrectInput() {
        //Given
        when(factoryInput.inputIntegerId()).thenReturn(1);
        //When
        addingDriver.takeId();
        //Then
        assertEquals(1, addingDriver.getIsCorrect());
        verify(factoryInput).inputIntegerId();
    }

    @Test
    @DisplayName("Incorrect DriverId Input Negative and Zero")
    void takeIdWithIncorrectInputWithNegativeInteger() {
        //Given
        when(factoryInput.inputIntegerId()).thenReturn(-23).thenReturn(-223).thenReturn(0);
        //When
        addingDriver.takeId();
        //Then
        assertEquals(0, addingDriver.getIsCorrect());
        verify(factoryInput, times(3)).inputIntegerId();
    }

    @Test
    @DisplayName("Incorrect DriverId Input Plus 9.999")
    void takeIdWithIncorrectInputWithPlus10000() {
        //Given
        when(factoryInput.inputIntegerId()).thenReturn(10000).thenReturn(13232).thenReturn(99999);
        //When
        addingDriver.takeId();
        //Then
        assertEquals(0, addingDriver.getIsCorrect());
        verify(factoryInput, times(3)).inputIntegerId();
    }

    @Test
    @DisplayName("2 Times Incorrect DriverId Input")
    void takeIdWithIncorrectInput2Times() {
        //Given
        when(factoryInput.inputIntegerId()).thenReturn(10000).thenReturn(153400).thenReturn(9999);
        //When
        addingDriver.takeId();
        //Then
        assertEquals(1, addingDriver.getIsCorrect());
        verify(factoryInput, times(3)).inputIntegerId();
    }

    @Test
    @DisplayName("1 Times Incorrect DriverId Input")
    void takeIdWithIncorrectInput1Times() {
        //Given
        when(factoryInput.inputIntegerId()).thenReturn(10000).thenReturn(4);
        //When
        addingDriver.takeId();
        //Then
        assertEquals(1, addingDriver.getIsCorrect());
        verify(factoryInput, times(2)).inputIntegerId();
    }

    @Test
    @DisplayName("Verify setDriverInfo Method Calls")
    void setDriverInfoMethodCallsVerify() {
        //Given
        Driver driver = new Driver(0);
        when(factoryInput.inputStringName()).thenReturn("Ayşe");
        when(factoryInput.inputStringSurname()).thenReturn("Selim");
        when(factoryInput.inputIntegerId()).thenReturn(999);

        //When
        addingDriver.setDriverInfo(driver);

        //Then

        assertAll("SetUp Driver's Info",
                () -> assertEquals(999, driver.getId()),
                () -> assertEquals("Ayşe", driver.getName()),
                () -> assertEquals("Selim", driver.getSurname()),
                () -> assertEquals(addingDriver.getDriver(), driver),
                () -> assertEquals(1, addingDriver.getIsCorrect())
        );

        verify(factoryInput).inputStringName();
        verify(factoryInput).inputStringSurname();
        verify(factoryInput).inputIntegerId();
    }

    @Test
    @DisplayName("Verify setDriverInfo Method Calls With Wrong Name Input 3 Times")
    void setDriverInfoMethodCallsVerifyWrongNameInput3Times() {
        //Given
        Driver driver = new Driver(0);
        when(factoryInput.inputStringName()).thenReturn("Barış Kaan Bayram")
                .thenReturn("Slavan Abul Ahmet Cimo")
                .thenReturn("Kemalletin Seyit Onbaşı");

        //When
        addingDriver.setDriverInfo(driver);

        //Then
        assertEquals(0, addingDriver.getIsCorrect());
        verify(factoryInput, times(3)).inputStringName();
    }

    @Test
    @DisplayName("Verify setDriverInfo Method Calls With Wrong Surname Input 3 Times")
    void setDriverInfoMethodCallsVerifyWrongSurnameInput3Times() {
        //Given
        Driver driver = new Driver(0);
        when(factoryInput.inputStringName()).thenReturn("Kemal");
        when(factoryInput.inputStringSurname()).thenReturn("Barış Kaan Bayram")
                .thenReturn("Slavan Abul Ahmet Cimo")
                .thenReturn("Kemalletin Seyit Onbaşı");

        //When
        addingDriver.setDriverInfo(driver);

        //Then
        assertEquals(0, addingDriver.getIsCorrect());
        verify(factoryInput).inputStringName();
        verify(factoryInput, times(3)).inputStringSurname();
    }

    @Test
    @DisplayName("Verify setDriverInfo Method Calls With Wrong ID Input 3 Times")
    void setDriverInfoMethodCallsVerifyWrongIdInput3Times() {
        //Given
        Driver driver = new Driver(0);
        when(factoryInput.inputStringName()).thenReturn("Barış");
        when(factoryInput.inputStringSurname()).thenReturn("Salih");
        when(factoryInput.inputIntegerId()).thenReturn(-23).thenReturn(232422).thenReturn(0);

        //When
        addingDriver.setDriverInfo(driver);

        //Then
        assertEquals(0, addingDriver.getIsCorrect());
        verify(factoryInput).inputStringName();
        verify(factoryInput).inputStringSurname();
        verify(factoryInput, times(3)).inputIntegerId();
    }

    @Test
    @DisplayName("Verify SetDriverInfo Parameter with Null Throw Exception")
    void verifySetDriverInfoParameterWithNullThrowException() {
        //Given
        String expectedMessage = "Driver is null";
        String actualMessage = null;

        //When
        try {
            addingDriver.setDriverInfo(null);
        } catch (Exception e) {
            actualMessage = e.getMessage();
        }

        //Then
        assertEquals(expectedMessage, actualMessage);
    }


}