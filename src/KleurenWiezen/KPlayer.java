package KleurenWiezen;

import CardGame.Card;
import CardGame.Hand;


public interface KPlayer {
	public int letBid();
	public boolean hasCard(int color,int number);
	public Card letDiscard();
}
