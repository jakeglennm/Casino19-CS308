package myProject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Map;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import myProject.Game.Blackjack;
import myProject.Game.GameState;
import myProject.GamePieces.Player;
import myProject.UserDatabase.User;
import myProject.UserDatabase.UserController;
import myProject.UserDatabase.UserDB;

@Controller      // this is needed for this to be an endpoint to springboot
@ServerEndpoint(value = "/chat/{username}/{type}")  // this is Websocket url
public class GameSocketServer {

	public static UserDB userDB; 

	private static Blackjack gameRunner; 
	
	//TODO game state stuff (separate from game class)
	//use hash (game state object?)
	public static Map<Session, String> sessionUsernameMap = new Hashtable<>();
	public static Map<Session, GameState> sessionGameMap = new Hashtable<>();
	public static Map<String, Session> usernameSessionMap = new Hashtable<>();

	public final Logger logger = LoggerFactory.getLogger(GameSocketServer.class);

	@Autowired
	public void setUserRepository(UserDB repo) {userDB = repo;}
	
	@OnOpen
	public void onOpen(Session session, @PathParam("username") String username, @PathParam("type") String type) 
      throws IOException {
		
		logger.info(username + " looking for " + type + " game!");
		
		//add stuff to session
		sessionUsernameMap.put(session, username);
		usernameSessionMap.put(username, session);
		
		//instantiates user so we can run fresh start method
		//look through games and find  
		ArrayList<GameState> games = new ArrayList<GameState>(sessionGameMap.values());
	
		if(sessionGameMap.isEmpty()) {
			sessionGameMap.put(session, new GameState("blackjack", sessionGameMap.size() + 1,this));
		}else {
			for(GameState game : games) {
				
				if(game != null) {					
					if(game.isOpen()) {
						sessionGameMap.put(session, game);
					}				
				}else {
					System.out.println("Null!!");
				}
			}
			if(!sessionGameMap.containsKey(session)) {
				sessionGameMap.put(session, new GameState("blackjack", sessionGameMap.size() + 1,this));
			}
		}		

		GameState game = sessionGameMap.get(session);
		game.addPlayer(username);
		
		String message = "User: " + username + " has entered game: " + sessionGameMap.get(session).getID();
		System.out.println(message);
		
	}
	
	@OnMessage
	public void onMessage(Session session, String message) throws IOException {

		String username = sessionUsernameMap.get(session);
		GameState game = sessionGameMap.get(session);
		ArrayList<Player> players = sessionGameMap.get(session).getPlayers();
		User user = userDB.findByUsername(username).get(0);


		if(message.startsWith("bet:")) {
			
			System.out.println(message);
			
			int startInd = message.indexOf(":");
			int bet = Integer.parseInt(message.substring(startInd+1));
			
			if(game.findPlayerByUsername(username).getBet() == 0) {
				
				game.addBetToPlayer(bet, username);
				
				sendMessageToParticularUser(username, "balance:" + (user.getBalance() - bet));
				
				System.out.println(username + " has placed thier bet");
				
				int flag = 0;
				
				//check all players have placed bet
				for(Player player : players) {
					if(player.getBet() == 0) {
						flag = 1;
					}
				}
				
				if(flag == 0) {
					gameRunner = new Blackjack(this, game);
					gameRunner.start();
					//game.newGame();
					game.setGameThread(gameRunner);			
				}
				
				
			}
			
		}else if(message.startsWith("balance:")) { //get balance
			
			String balance = "balance:" + user.getBalance();
			sendMessageToParticularUser(username, balance);
			
		}else if(message.startsWith("play:")) {
			
			String command = message.substring(message.indexOf(":") + 1);
			System.out.println("doing " + command + " on " + username);
			
			game.play(command, username);
			
			int flag = 0;
			
			for(Player player : players) {
				if(player.getTurnAction().equals("new") || player.getTurnAction().equals("waiting")) {
					flag = 1;
				}
			}
			
			//all players have played
			if(flag == 0) {
				
				game.getGameThread().interrupt();

			}

		}
		
	}


	public void sendMessageToParticularUser(String username, String message) {
		try {
			usernameSessionMap.get(username).getBasicRemote().sendText(message);
		} 
		catch (IOException e) {
			logger.info("Exception: " + e.getMessage().toString());
			e.printStackTrace();
		}
	}

	
	@OnClose
	public void onClose(Session session) throws IOException {
		logger.info("Entered into Close");
		
		String username = sessionUsernameMap.get(session);
		
		GameState game = sessionGameMap.get(session);
		game.removePlayer(username);
		
		if(game.getPlayers().size() == 0) {
			sessionGameMap.remove(session);
			game.getGameThread().interrupt();
			game.getGameThread().terminate();
		}
		
		sessionUsernameMap.remove(session);
		usernameSessionMap.remove(username);
		
		String message = username + " has left the game";
		game.getPacket().setMessage(message);
		
	}

	public void broadcast(String message) {
		sessionUsernameMap.forEach((session, username) -> {
			try {
				session.getBasicRemote().sendText(message);
			} 
      catch (IOException e) {
				logger.info("Exception: " + e.getMessage().toString());
				e.printStackTrace();
			}
		});
	}

	@OnError
	public void onError(Session session, Throwable throwable) {
		logger.info("Entered into Error");
		System.out.println(throwable.getCause().getClass());
		throwable.printStackTrace();
	}

}





