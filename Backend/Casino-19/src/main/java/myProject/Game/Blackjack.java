package myProject.Game;


import myProject.GameSocketServer;

public class Blackjack extends Thread{
	
	private GameState game;
	private GameSocketServer socket;
	private boolean running;
	
	public Blackjack(GameSocketServer socket, GameState game) {
		this.game = game;
		this.socket = socket;
	}

	@Override
	public void run() {
		running = true;
		
		System.out.println("----------------\nStarting Game!\n----------------");
		
		game.deal();
		
		updateSendAndPrint("New Deal");
		
		while(running) {
			
			if(game.refreshPlayers()) {
			
				try {
					Thread.sleep(25000);
					System.out.println("Forcing players to stand (no action)");		
					game.forceActions();
				} catch (InterruptedException e1) {
					System.out.println("\nending wait \n");
				}
			}else { //for testing
				try {
					Thread.sleep(500);
				} catch (InterruptedException e1) {

				}
			}
			
			updateSendAndPrint("Updating Dealer");

			if(game.gameOver()) { break; }
		
				
		}
		
		endGame();
		
		System.out.println("GAME ENDED...");

	}

	public void endGame() {
		game.updateDealer();
		game.updatePlayers();
		
		GameState.updateBalances(GameSocketServer.userDB, game.getPlayers());

		updateSendAndPrint("Game Over");
		running = false;
		game.endGame();
	}
	
	public void updateSendAndPrint(String gameMessage) {
		game.getPacket().setMessage(gameMessage);
		socket.broadcast(game.getPacket().toJson());
		System.out.println(game.getPacket().toJson());		
		System.out.println(gameMessage);
		//System.out.println("----Json----\n" + game.packet.toJson() + "\n----Json----\n");
	}
	
	public boolean isRunning() {
		return running;
	}
	
	public void broadcastJson() {
		socket.broadcast(game.packet.toJson());

	}
	
	public void terminate() {
		this.running = false;
	}

}
