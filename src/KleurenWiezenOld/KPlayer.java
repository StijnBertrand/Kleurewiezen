package KleurenWiezenOld;

import CardGame.state.objects.Card;


public interface KPlayer {
	public int letBid();
	public boolean hasCard(int color,int number);
	public Card letDiscard();
}
