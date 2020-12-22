package com.example.casino_19;

import com.example.casino_19.Games.Pieces.Hand;
import com.example.casino_19.Games.Pieces.Player;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PlayerTests {

    @Mock
    Hand mockHand = mock(Hand.class);

    @Test
    public void testBestHand(){
        Player testPlayer = new Player("user1");

        when(mockHand.getPossibleValues()).thenReturn(new ArrayList<Integer>(Arrays.asList(9,13,11,15,8,20,12)));
        testPlayer.hand = mockHand;

        assertEquals(20,testPlayer.getBestHandValue());

    }
}
