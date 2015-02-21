package CardGame;

import java.util.ArrayList;

public class Deck {
	ArrayList<Card> cards;
	
	public Deck(){
		cards = new ArrayList<Card>();
	}
	
	
	public void addCard(Card card){
		cards.add(card);
	}
	
	public Card takeCard(){
		return cards.remove(cards.size()-1);
	}
	
	public void shufle(){
		
	}

	public void Cut(){
		
	}
}
