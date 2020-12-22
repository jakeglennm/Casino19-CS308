package com.example.casino_19;

import com.example.casino_19.Games.Pieces.Card;
import com.example.casino_19.Games.Pieces.Hand;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class HandTests {

    @Mock
    Card mockCard1 = mock(Card.class);

    @Mock
    Card mockCard2 = mock(Card.class);

    @Mock
    Card mockCard3 = mock(Card.class);

    @Mock
    Card mockCard4 = mock(Card.class);

    @Test
    public void testGetValuesWithoutAces(){
        Hand testHand = new Hand();

        when(mockCard1.getValue()).thenReturn(5);
        when(mockCard2.getValue()).thenReturn(10);

        ArrayList<Card> cards = new ArrayList<Card>(Arrays.asList(mockCard1,mockCard2));
        testHand.cards = cards;

        assertEquals(cards,testHand.getCards());

        ArrayList<Integer> values = testHand.getPossibleValues();
        int handValue = values.get(0);

        assertEquals(15,handValue);
    }

    @Test
    public void testGetValuesWithAces(){
        Hand testHand = new Hand();

        when(mockCard1.getValue()).thenReturn(1);
        when(mockCard2.getValue()).thenReturn(5);

        ArrayList<Card> cards = new ArrayList<Card>(Arrays.asList(mockCard1,mockCard2));
        testHand.cards = cards;

        assertEquals(cards,testHand.getCards());

        ArrayList<Integer> values = testHand.getPossibleValues();
        int aceAsOne = values.get(0);
        int aceAsEleven = values.get(1);

        assertEquals(6,aceAsOne);
        assertEquals(16,aceAsEleven);
    }

}
