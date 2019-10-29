package com.ab.buscardsystem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DBFacadeTest {

    @Mock
    private IDataBase cardDBMapper;
    @Mock
    private TableMapper tableMapper;
    @Mock
    private Card card;
    @Mock
    private TappingCard tappingCard;
    @Mock
    private TappingCardDB tappingCardDB;

    @InjectMocks
    private DBFacade dbFacade;

    @Test
    @DisplayName("getTest with Card")
    public void getCardTest() {

        when(tableMapper.getMapper(Card.class)).thenReturn(cardDBMapper);
        when(cardDBMapper.getItem(anyInt())).thenReturn(card);
        
        assertEquals(card, dbFacade.get(anyInt(), Card.class));

        verify(tableMapper).getMapper(Card.class);
        verify(cardDBMapper).getItem(anyInt());

    }

    @Test
    @DisplayName("getTest with TappingCard")
    void getTappingCardTest() {

        when(tableMapper.getMapper(TappingCard.class)).thenReturn(tappingCardDB);
        when(tappingCardDB.getItem(anyInt())).thenReturn(tappingCard);

        assertEquals(tappingCard, dbFacade.get(anyInt(), TappingCard.class));
        assertEquals(tappingCard, dbFacade.get(anyInt(), TappingCard.class));
        assertEquals(tappingCard, dbFacade.get(anyInt(), TappingCard.class));

        verify(tableMapper, times(3)).getMapper(TappingCard.class);
        verify(tappingCardDB, times(3)).getItem(anyInt());
    }
}