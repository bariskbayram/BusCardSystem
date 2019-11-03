package com.ab.buscardsystem;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CityCardConsoleTest {

    @InjectMocks
    CityCardConsole cityCardConsole;
    @Mock
    AddingCard addingCard;
    @Mock
    DBFacade dbFacade;
    @Mock
    Card card;

    @Test
    void enterCardInfo() {
        //Given
        when(addingCard.setCardInfo(any(Card.class))).thenReturn(card);
        doNothing().when(dbFacade).put(card);
        doNothing().when(dbFacade).put(addingCard);
        //When
        cityCardConsole.enterCardInfo(addingCard);
        //Then
        verify(addingCard).setCardInfo(any(Card.class));
        verify(dbFacade).put(card);
        verify(dbFacade).put(addingCard);
    }
}