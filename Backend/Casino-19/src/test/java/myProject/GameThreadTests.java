package myProject;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import myProject.Game.Blackjack;
import myProject.Game.GamePacket;
import myProject.Game.GameState;

@RunWith(MockitoJUnitRunner.class)
public class GameThreadTests {

	//mock, game socket
	@Mock
	GameSocketServer mockSocket = mock(GameSocketServer.class);
	
	//mock, game state
	@Mock
	GameState mockGameState = mock(GameState.class);
	
	@Mock
	GamePacket mockGamePacket = mock(GamePacket.class);
	
	@Test
	public void testGameThreadCycle() {
		
		
		doNothing().when(mockGameState).deal();
		doNothing().when(mockGameState).updateDealer();
		doNothing().when(mockGameState).updatePlayers();

		//allows for skipping of thread wait
		when(mockGameState.refreshPlayers()).thenReturn(false);
		when(mockGameState.getPacket()).thenReturn(mockGamePacket);
		
		//end the game after one successful thread
		when(mockGameState.gameOver()).thenReturn(true);
		
		doNothing().when(mockGamePacket).setMessage("New Deal");
		doNothing().when(mockGamePacket).setMessage("Updating Dealer");
		doNothing().when(mockGamePacket).setMessage("Game Over");
		
		when(mockGamePacket.toJson()).thenReturn("");

		doNothing().when(mockSocket).broadcast("");

		Blackjack testGame = new Blackjack(mockSocket, mockGameState);
		
		testGame.run();
				
		//Checks for succesful game runthrough
		assertEquals(false, testGame.isRunning());
		assertEquals(false, testGame.isAlive());

	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}



