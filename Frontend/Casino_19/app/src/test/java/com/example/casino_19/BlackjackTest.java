package com.example.casino_19;

import android.view.View;

import com.example.casino_19.Games.BlackJack.BlackJackActivity;

import org.java_websocket.client.WebSocketClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BlackjackTest {

    @Test
    public void balanceDisplayTest(){
        String testBalance = "115200";
        assertEquals(testBalance, BlackJackActivity.checkBalance(testBalance));
    }

    @Test
    public void brokeBalanceTest(){
        String testBalance = "-72";
        String brokeDisplay = "you're broke";
        assertEquals(brokeDisplay, BlackJackActivity.checkBalance(testBalance));
    }
}
