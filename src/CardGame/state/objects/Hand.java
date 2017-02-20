package CardGame.state.objects;

import CardGame.state.objects.enums.CardColor;
import CardGame.state.objects.enums.CardNumber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Hand implements Iterable<Card>{
	ArrayList<Card> hand = new ArrayList<Card>();
	
	public void addCard(Card card){
		hand.add(card);
	}

	public Card play(Card card){
		hand.remove(card);
		return card;
	}
	
	public Card play(int index){
		return hand.remove(index);
	}
	
	public int size(){
		return hand.size();
	}

	@Override
	public Iterator<Card> iterator() {
		return hand.iterator();
	}
	
	public boolean hasCards(CardColor colour){
		for(Card c:hand){
			if(colour == c.getColour())return true;
		}
		return false;
	}
	
	public Card getCard(int index){
		try{
			return hand.get(index);
		}catch(Exception e){
			return null;
		}
	} 
	
	public void order(){
		Collections.sort(hand, new Comparator<Card>() {
	        @Override
	        public int compare(Card  c1, Card  c2)
	        {        	
	            int i = c1.getColour().getValue() - c2.getColour().getValue();
	        	if(i == 0){
	        		if(c2.getNumber() == CardNumber.ACE)return +1;
	        		if(c1.getNumber() == CardNumber.ACE)return -1;
	        		return c2.getNumber().getValue()-c1.getNumber().getValue();
	        	}else{
	        		return i;
	        	}
	        }
	    });
	}
}
