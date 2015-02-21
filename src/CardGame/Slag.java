package CardGame;

public class Slag {

	private Card[] cards; 
	private int starter = -1;
	
	public Slag(int count){
		cards = new Card[4];
	}
	
	public int getStarter(){
		return starter;
	}
	
	public void playCard(Card c , int position){
		cards[position] = c;
		if(starter == -1)starter = position;
	}
	public Card getCard(int position){
		return cards[position];
	}
}
