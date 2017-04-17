package KleurenWiezenOld;

import java.util.ArrayList;

import CardGame.state.objects.Card;
import CardGame.state.objects.enums.CardColor;
import CardGame.state.objects.Hand;
import CardGame.state.objects.HumanPlayer;
import CardGame.state.objects.enums.CardNumber;
import Graphics.Screen;

public class KHumanPlayer extends HumanPlayer implements KPlayer{
	private boolean first = true;
	private int bed = 0;
	private boolean myTurnToBed = false;
	private boolean myTurnToDiscard = false;
	
	@Override
	protected boolean canPlay(int card){
		// hier moet nog iets komen voor als het troel is
		int starter = table.getCurrSlag().getStarter();
		if(-1 == starter)return true;
		/*
		int colour = table.getCurrSlag().getCard(starter).getColour();
		if(hasCards(colour)){
			if( colour != hand.getCard(card).getColour()){
				return false;
			}
		}
		*/
		return true;
	}
	
	private int troel(){
		int aces = 0;
		boolean[] b = new boolean[9];
		for(Card c :hand){
			if(c.getNumber() == CardNumber.ACE)aces++;
			if(c.getColour() == CardColor.HEARTS){
				try{
					b[12-c.getColour().getValue()] = true;
				}catch(Exception e){
					continue;
				}
			}
		}	
		if(aces >= 3 ){
			if(aces == 4){
				for(int i = 0; i <b.length;i++){
					if(!b[i])return 55+i;
				}
			}else{
				return 54;
			}
		}
		return 1;
	}

	@Override
	public int letBid() {
		try{
			if(((KTable)table).getRound() <= 1 & ((KTable)table).getBeds().get(0)[seat]==0){
				return troel();
			}
			if(((KTable)table).getGame()[0]==1 & !((KTable)table).isTroelFound()){
				int number = ((KTable)table).getGame()[1];
				if(number == 0){
					//fourth ace joins
					for(Card c: hand){
						if(c.getNumber()== CardNumber.ACE)return 64;
					}
				}else{
					for(Card c: hand){
						if(c.getColour()==CardColor.HEARTS & c.getNumber().getValue() == (13 - number))return 64;
					}			
					System.out.println("hier3");
				}
				return 0;
			}
			synchronized(lock){
				myTurnToBed = true;
				lock.wait();
			}
			return bed;
		}catch(Exception e){
			return bed;	
		}
	}
	
	public ArrayList<int[]> getBeds(){
		return ((KTable)table).getBeds();
	}
	
	public boolean[] getOptions(){
		return ((KTable)table).getOptions( seat);		
	}
	
	public void bed(int bed){
		synchronized(lock){
			if(myTurnToBed & canBed(bed)){
				this.bed  = bed;
				myTurnToBed = false;
				lock.notify();
			}
		}	
	}

	private boolean canBed(int bed) {
		return true;
	}

	public boolean getMyTurnToBed(){
		return myTurnToBed;
	}
	public boolean isBidding() {
		return ((KTable)table).getBidding();
	}


	@Override
	public boolean hasCard(int color, int number) {
		for(Card c:hand){
			if(color== c.getColour().getValue()&number == c.getNumber().getValue())return true;
		}		
		return false;
	}

	@Override
	public Card letDiscard() {
		try {
			synchronized(lock){
				myTurnToDiscard = true;
				lock.wait();
			}		
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return hand.play(cardToPlay);
	}
	
	public void discardCard(int index){
		synchronized(lock){
			if(myTurnToDiscard & canPlay(index)){
				cardToPlay = index;
				myTurnToDiscard = false;
				lock.notify();
			}
		}		
	}
	
	public Hand getHand(int player){
		return ((KTable) table).getHand(player); 
	}
	
	public boolean isMyTurnToDiscard(){
		return myTurnToDiscard;
	}
}
