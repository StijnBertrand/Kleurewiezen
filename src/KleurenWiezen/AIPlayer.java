package KleurenWiezen;

import java.util.ArrayList;

import CardGame.Card;
import CardGame.Player;

public class AIPlayer extends Player implements KPlayer{
	
	public Card letPlay() {
		for(int i = 0;i<hand.size();i++){
			if(canPlay(i))return hand.play(i);
		}
		return hand.play(0);
	}
	

	protected boolean canPlay(int card){
		int starter = table.getCurrSlag().getStarter();
		if(-1 == starter)return true;
		/*
		int colour = table.getCurrSlag().getCard(starter).getColour();
		if(hasCards(colour)){
			if( colour != hand.getCard(card).getColour()){
				return false;
			}
		}*/
		return true;
	}

	private int troel(){
		int aces = 0;
		boolean[] b = new boolean[9];
		for(Card c :hand){
			if(c.getNumber() == 0)aces++;
			/*
			if(c.getColour() == 0){
				try{
					b[12-c.getColour()] = true;
				}catch(Exception e){
					continue;
				}
			}
			*/
		}	
		if(aces >= 3 ){
			if(aces == 4){
				for(int i = 0; i <b.length;i++){
					if(!b[i])return 21+i;
				}
			}else{
				return 20;
			}
		}
		return 1;
	}

	@Override
	public int letBid() {
		if(((KTable)table).getRound() <= 1 & ((KTable)table).getBeds().get(0)[seat]==0){
			calculate();
			return troel();
		}
		
		return 12;
	}
	
	@Override
	public boolean hasCard(int color, int number) {
		for(Card c:hand){
			//if(color== c.getColour()&number == c.getNumber())return true;
		}		
		return false;
	}
	
	
	private int hearts = 0;
	private int diamonds = 0;
	private int clubs = 0;
	private int spades = 0;
	
	
	private void calculate(){
		preliminaryCalculations();
	}
	
	
	private void preliminaryCalculations(){
		hearts = 0;
		diamonds = 0;
		clubs = 0;
		spades = 0;
		for(Card c : hand){
			switch(c.getColour()){
			case HEARTS:{
				hearts++;
				break;
			}
				case DIMONDS:{
				diamonds++;
				break;
			}
				case CLUBS:{
				clubs++;
				break;
			}
				case SPADES:{
				spades++;
				break;
			}
			}
		}
	}
	
	
	private void maxSlagen(){
		
	}
	
	private boolean small = true;
	private int disCard = -1;
	private boolean big = true;
	private boolean naked = true;
	
	private void posibleMisery(){
		
		
		
		
		
		
		
		
	}


	@Override
	public Card letDiscard() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
