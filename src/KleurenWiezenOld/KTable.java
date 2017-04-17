package KleurenWiezenOld;

import java.util.ArrayList;

import CardGame.state.factories.DeckFactory;
import CardGame.state.objects.Hand;
import CardGame.state.objects.Player;
import CardGame.state.objects.Slag;
import CardGame.state.objects.tables.Table;

public class KTable extends Table {
	
	private Slag discarted = new Slag(4);
	private boolean bidding = false;
	private BedSystem beds;
	private boolean[] visibility;
	
	public KTable(Player p1, Player p2, Player p3, Player p4 ){
		super(DeckFactory.getInstance().getDeck52(),p1,p2,p3,p4);
		beds = new BedSystem();
		visibility = new boolean[4];
	}
	
	//returns what game is being played
	public int[] getGame(){
		return beds.getGame();
	}
	
//methods to give a player information
	public Hand getHand(int player) {
		if(visibility[player]){
			return players[player].getHand();
		}else{
			return null;
		}
	}
	
	public boolean isTroelFound() {
		return beds.isTroelFound();
	}
	
	//returns the options for the player in seat 
	public boolean[] getOptions(int seat) {
		return beds.getOptions(seat);
	}

//methods to control the flow of the game
	public void showCards(){
		if(beds.getGame()[0]==10){
			for(int i = 1; beds.getGame().length >i;i++){
				visibility[beds.getGame()[i]]= true;
			}
		}
	}
	
	@Override
	public void reset(){
		super.reset();
		beds = new BedSystem();
		visibility = new boolean[4]; 
	}

	//lets the player discard a card
	public void letDiscardCard(int player) {
		discarted.playCard(((KPlayer)players[player]).letDiscard(), player);;
	}
	
	//all methods that have to do with the betting
	public void letNextPlayerBed(){
		beds.setNextBed(((KPlayer)players[beds.getCurrtPlayer()]).letBid());	
	}

	public ArrayList<int[]> getBeds() {
		return beds.getBeds();
	}

	public boolean getBidding() {
		return bidding;
	}

	public void startBidding(int starter) {
		beds.setStarter(starter);
		this.bidding = true;
	}
	
	public void stopBidding(){
		this.bidding = false;
	}

	public int getRound(){
		return beds.getRound();
	}
	
	public boolean finishedBidding() {
		return beds.finished();
	}
}
