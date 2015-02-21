package CardGame;

public abstract class Player {

	protected Hand hand = new Hand();
	protected Table table;
	//this is the position the player has at the table
	protected int seat = -1;

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
	
	protected boolean hasCards(int colour){
		return hand.hasCards(colour);
	}
}
