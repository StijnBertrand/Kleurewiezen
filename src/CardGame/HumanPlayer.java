package CardGame;

import CardGameGraphics.PlayerController;
import Graphics.Screen;

public class HumanPlayer extends Player{
	
	protected final Object lock = new Object();
	protected boolean myTurn = false;
	protected int cardToPlay = -1;
	
	public void playCard(int index){
		synchronized(lock){
			if(myTurn & canPlay(index)){
				cardToPlay = index;
				myTurn = false;
				lock.notify();
			}
		}		
	}
	
	@Override
	public Card letPlay() {
		try {
			synchronized(lock){
				myTurn = true;
				lock.wait();
			}		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return hand.play(cardToPlay);
	}
	
	public void giveScreen(Screen s){
		new PlayerController(s, this);
	}
	
	public synchronized boolean getMyTurn(){
		return myTurn;
	}
	
	protected boolean canPlay(int card){
		return true;
	}
}
