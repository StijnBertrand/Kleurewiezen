package CardGame;

import java.util.ArrayList;

public abstract class Player {

	protected Hand hand = new Hand();
	protected Table table;
	//this is the position the player has at the table
	protected int seat = -1;
	//allows for cards to be selected (keep canSelect false to ignore
	private boolean canSelect = false;
	private ArrayList<Card> selected = new ArrayList();

	public void giveCard(Card card) {
		hand.addCard(card);
		if(hand.size()==13){
			hand.order();
		}
	}

	public int getAmountOfCards() {
		return hand.size();
	}
	
	public abstract Card letPlay();	
	
	public Hand getHand(){
		return hand;
	}
	
	public void setTable(Table t, int seat){
		table = t;
		this.seat = seat;
	}
	
	public Slag getCurrSlag(){
		return table.getCurrSlag();
	}
	public int getSeat(){
		return seat;
	}
	
	public int getAmountOfCards(int playerSeat){
		return table.getAmountOfCards(playerSeat);
	}
	
	protected boolean hasCards(CardColor colour){
		return hand.hasCards(colour);
	}


	//logic to select cards
	//geters and setters
	public boolean getCanSelect() {
		return canSelect;
	}

	public void setCanSelect(boolean canSelect) {
		this.canSelect = canSelect;
	}

	public ArrayList<Card> getSelected() {
		return selected;
	}

	//logic
	public void selectDeselect(int card){
		if(canSelect){
			for(Card c:selected){
				if(c.equals(hand.getCard(card)) ){
					selected.remove(c);
					return ;
				}
			}
			selected.add(hand.getCard(card));
		}
	}

	public boolean isSelected(int card){
		for(Card c:selected){
			if(c.equals(hand.getCard(card)) ){
				return true;
			}
		}
		return false;
	}

	public boolean hasCard(CardColor color,int number){
		for(Card card:hand){
			if(card.getColour()==color && card.getNumber()==number)return true;
		}
		return false;
	}
}
