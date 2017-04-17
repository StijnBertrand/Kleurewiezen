package CardGame.state.objects.tables;

import CardGame.state.factories.DeckFactory;
import CardGame.state.objects.Deck;
import CardGame.state.objects.Player;
import CardGame.state.objects.Slag;
import CardGame.state.objects.enums.CardColor;
import java.util.ArrayList;
import java.util.List;

public class Table {
	//used for the flow of the game, indicates wheter the game has finished or not
	private boolean finished = false;

	private Deck deck;
	//private Deck deck = df.troelTest();
	protected Player[] players;
	//keeps track of who the dealer is
	private int dealer=0;
	//keeps track of who may start the next round
	private int starter=0;

	//allows control over the end of the game
	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	//keeps track of the players their slagen
	private List<Slag>[] slagen;
	private Slag currSlag;
	private Slag prevSlag;

	
	public Table(Deck deck, Player... players){
		this.deck=deck;
		this.players = players;
		for(int i=0;i<players.length;i++){
			players[i].setTable(this,i);
		}

		//initrialize the Slagen Array
		slagen = (ArrayList<Slag>[])new ArrayList[players.length];
		for(int i= 0;i< slagen.length;i++)
			slagen[i]= new ArrayList<Slag>();
		currSlag = new Slag(players.length);
	}
	
	//getters and setters
	public Player getPlayer(int player){
		return players[player];
	}

	public int getDealer(){
		return dealer;
	}

	public void setDealer(int dealer){
		this.dealer=dealer;
	}

	public int getStarter() {
		return starter;
	}

	public void setStarter(int starter) {
		this.starter = starter;
	}

	public int getAmountOfPlayers(){
		return players.length;
	}

	public Deck getDeck(){
		return deck;
	}

	public Slag getCurrSlag(){
		return currSlag;
	}

	public Slag getPrevSlag(){
		return prevSlag;
	}


	//methods to handle the flow of the game
	public void letPlayerPlay(int player){
		currSlag.playCard(players[player].letPlay(),player);
	}

	public void appointSlag(int winner) {
		slagen[winner].add(currSlag);
		newSlag();
	}

	//resets the board for a new round
	public void reset(){
		collectCards();
		this.prevSlag = null;
	}

	//private methods
	private void collectCards(){
		for(List<Slag> a :slagen ){
			while(!a.isEmpty()){
				Slag s = a.get(0);
				for(int i = 0;i<getAmountOfPlayers();i++){
					deck.addCard(s.getCard((s.getStarter()+i)%getAmountOfPlayers()));
				}
				a.remove(0);
			}
		}
		//todo: collect cards still in the players hands
	}

	private void newSlag(){
		prevSlag = currSlag;
		currSlag = new Slag(getAmountOfPlayers());
	}

}
