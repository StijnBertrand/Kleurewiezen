package CardGame.state.objects.tables;

import CardGame.state.factories.DeckFactory;
import CardGame.state.objects.Deck;
import CardGame.state.objects.Player;
import CardGame.state.objects.Slag;
import CardGame.state.objects.enums.CardColor;
import java.util.ArrayList;
import java.util.List;

public abstract class Table {
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
	
	public Table(Deck deck, Player... players){
		this.deck=deck;
		this.players = players;
	}
	
	public abstract void letPlayerPlay(int player);
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

}
