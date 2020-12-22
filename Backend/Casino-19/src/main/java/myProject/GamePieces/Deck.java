package myProject.GamePieces;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.persistence.Entity;
import javax.persistence.Table;

public class Deck {	

	List<Card> cards, inPlay, inDeck;
		
	// Initializes a single deck of cards
	public Deck(){
		
		cards = generate(1);
		shuffleDeck();
		
		inPlay = new ArrayList<Card>();
		inDeck = cards;
	}

	public Card drawCard() {
		Card card = inDeck.remove(0);
		inPlay.add(card);
		return card;
	}

	public void reshuffleDeck() {
		cards = generate(1);
		shuffleDeck();
		
		inPlay = new ArrayList<Card>();
		inDeck = cards;
	}
	
	public Deck shuffleDeck() {
		Random rnd = new Random();
		int j = 0;
				
		for(int i = 0; i < 52; i++) {
			j = rnd.nextInt(52);
			swap(i,j);
		}
		return this;
		
	}
	
	private ArrayList<Card> generate(int numDecks) {
		
		ArrayList<Card> cards = new ArrayList<Card>();		
		
		for(int y = 0; y < numDecks; y++) {
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 13; j++) {
					//set the deck when adding new card
					cards.add(new Card(j,i));
				}
			}
		}
		
		return cards;
		
	}
	
	private void swap(int i, int j) {
		
		Card temp = null;
		
		temp = cards.get(j);
		cards.set(j, cards.get(i));
		cards.set(i, temp);
		
	}	
	
	public List<Card> getCards() { return cards;}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("Cards in deck: \n");
		
		for(Card card: inDeck) {
			sb.append(card.toString() + "\n");
		}
		
		sb.append("Cards in deck: \n");

		for(Card card: inPlay) {
			sb.append(card.toString() + "\n");
		}
		
		return sb.toString();
	}
	
}
