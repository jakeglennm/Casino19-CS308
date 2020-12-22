package myProject;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import myProject.Game.Blackjack;
import myProject.Game.GamePacket;
import myProject.Game.GameState;
import myProject.GamePieces.Player;

@RunWith(MockitoJUnitRunner.class)
public class GameStateTests {

	//mock, game socket
	@Mock
	GameSocketServer mockSocket = mock(GameSocketServer.class);
	
	//mock, game state
	@Mock
	GameState mockGameState = mock(GameState.class);
	
	@Mock
	GamePacket mockGamePacket = mock(GamePacket.class);
	
	@Mock
	Player mockPlayer1 = mock(Player.class);
	
	@Mock
	Player mockPlayer2 = mock(Player.class);
	
	@Mock
	Player mockPlayer3 = mock(Player.class);
	
	@Mock
	Player mockPlayer4 = mock(Player.class);

	ArrayList<Player> mockPlayers = new ArrayList<Player>(Arrays.asList(mockPlayer1, mockPlayer2 , mockPlayer3 , mockPlayer4));

	@Mock
	Player mockDealer = mock(Player.class);
	
	@Test
	public void testEndingGame() {
		
		GameState testGame = new GameState("blackjack" , 1, mockSocket);
		
		for(Player mockPlayer: mockPlayers) {
			//Standing is one of the ways players can play
			when(mockPlayer.getTurnAction()).thenReturn("Standing");
			testGame.addPlayer(mockPlayer);
		}
		
		assertEquals(true, testGame.gameOver());
			
	}
	
	@Test
	public void testContinuingGame() {
		
		GameState testGame = new GameState("blackjack" , 1, mockSocket);
		
		for(Player mockPlayer: mockPlayers) {
			//Standing is one of the ways players can play
			when(mockPlayer.getTurnAction()).thenReturn("new");
			testGame.addPlayer(mockPlayer);
		}
		
		assertEquals(false, testGame.gameOver());
			
	}
	
}
	