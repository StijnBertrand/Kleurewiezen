package CardGame.state.objects;

import CardGame.state.objects.enums.CardColor;
import CardGame.state.objects.enums.CardNumber;
import CardGame.state.objects.tables.SlagTable;
import CardGame.state.objects.tables.Table;

import java.util.ArrayList;

public abstract class Player {

	//the table this player sits on
	protected SlagTable table;
	//this is the position the player has at the table
	protected int seat = -1;
	//the player his cards
	protected Hand hand = new Hand();
	//allows for cards to be selected (keep canSelect false to ignore
	private boolean canSelect = false;
	private ArrayList<Card> selected = new ArrayList();

	// Table Logic
	public void setTable(SlagTable t, int seat){
		table = t;
		this.seat = seat;
	}
	
	public Slag getCurrSlag(){
		return table.getCurrSlag();
	}

	public int getSeat(){
		return seat;
	}

	//logic about the player his cards
	public void giveCard(Card card) {
		hand.addCard(card);
		if(hand.size()==13){
			hand.order();
		}
	}

	public abstract Card letPlay();

	//Information about the player his cards
	public int getAmountOfCards() {
		return hand.size();
	}

	public Hand getHand(){
		return hand;
	}

	public int getAmountOfCards(int playerSeat){
		if (table != null){
			return table.getPlayer(playerSeat).getAmountOfCards();
		}else{
			return 0;
		}
	}
	
	protected boolean hasCards(CardColor colour){
		return hand.hasCards(colour);
	}

	public boolean hasCard(CardColor color,CardNumber number){
		for(Card card:hand){
			if(card.getColour()==color && card.getNumber()==number)return true;
		}
		return false;
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

	public void emptySelected(){
		selected = new ArrayList<>();
	}

}
