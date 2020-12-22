package myProject.GamePieces;

public class Card {
	
	public enum Values{
		
		ACE,
		TWO,
		THREE,
		FOUR,
		FIVE,
		SIX,
		SEVEN,
		EIGHT,
		NINE,
		TEN,
		JACK,
		QUEEN,
		KING
		
	}
	
	public enum Suits{
		HEARTS,
		DIAMONDS,
		SPADES,
		CLUBS,
	}

	Values rank;
	Suits suit;
	int value;

	public Card(Integer value, Integer suit){
		this.rank = Values.values()[value];
		this.suit = Suits.values()[suit];
		this.value = value + 1;
	}
	
	public Values getRank() { return rank; } 
	public Suits getSuit() { return suit; }
	public int getValue() { return value; }
	
	@Override
	public String toString() {
		return rank + " of " + suit;
	}
	
}
