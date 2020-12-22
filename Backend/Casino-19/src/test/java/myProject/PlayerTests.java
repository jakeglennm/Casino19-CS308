package myProject;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import myProject.Game.Blackjack;
import myProject.Game.GamePacket;
import myProject.Game.GameState;
import myProject.GamePieces.Hand;
import myProject.GamePieces.Player;

@RunWith(MockitoJUnitRunner.class)
public class PlayerTests {

	@Mock
	Hand mockHand = mock(Hand.class);
	
	@Test
	public void testBestHandValueOnBust() {
		
		Player testPlayer = new Player("testPlayer");
		testPlayer.setHand(mockHand);
		
		ArrayList<Integer> mockValues = new ArrayList<Integer>();
		mockValues.add(23);
		mockValues.add(22);
		mockValues.add(45);

		when(mockHand.getPossibleValues()).thenReturn(mockValues);
				
		assertEquals(-1, testPlayer.getBestHandValue());
		assertEquals("busted", testPlayer.getTurnAction());

	}
	
	@Test
	public void testBestHandValueOnBlackJack() {
		
		Player testPlayer = new Player("testPlayer");
		testPlayer.setHand(mockHand);
		
		ArrayList<Integer> mockValues = new ArrayList<Integer>();
		mockValues.add(21);
		mockValues.add(10);
		mockValues.add(45);

		when(mockHand.getPossibleValues()).thenReturn(mockValues);
				
		assertEquals(21, testPlayer.getBestHandValue());
		assertEquals("blackjack", testPlayer.getTurnAction());

			
	}
	
	@Test
	public void testBestHandValueOnUnder() {
		
		Player testPlayer = new Player("testPlayer");
		testPlayer.setHand(mockHand);
		
		ArrayList<Integer> mockValues = new ArrayList<Integer>();
		mockValues.add(0);
		mockValues.add(14);
		mockValues.add(-6);
		mockValues.add(-100);
		mockValues.add(12);
		mockValues.add(14);
		mockValues.add(19);


		when(mockHand.getPossibleValues()).thenReturn(mockValues);
				
		assertEquals(19, testPlayer.getBestHandValue());
		assertEquals("new", testPlayer.getTurnAction());

			
	}
	
	@Test
	public void testBestHandValueOnAny() {
		
		Player testPlayer = new Player("testPlayer");
		testPlayer.setHand(mockHand);
		
		ArrayList<Integer> mockValues = new ArrayList<Integer>();
		mockValues.add(18);
		mockValues.add(19);
		mockValues.add(22);
		mockValues.add(45);
		mockValues.add(20);
		mockValues.add(16);

		when(mockHand.getPossibleValues()).thenReturn(mockValues);
				
		assertEquals(20, testPlayer.getBestHandValue());
		assertEquals("new", testPlayer.getTurnAction());

	}
	
	
}
	