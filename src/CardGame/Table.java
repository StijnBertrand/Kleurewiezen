package CardGame;

import java.util.ArrayList;

public class Table {

	private DeckFactory df = DeckFactory.getInstance();
	private Deck deck = df.getDeck52();
	//private Deck deck = df.troelTest();
	protected Player[] players;
	//keeps track of who the dealer is
	private int dealer=0;
	//keeps track of who may start the next round
	private int starter=0;


	//keeps track of the players their slagen
	private ArrayList<Slag>[] slagen;
	private Slag currSlag;
	private Slag prevSlag;
	//in some games there is a troef, can be ignored if this stays -1
	private CardColor troef = CardColor.NONE;
	
	public Table(){
		players = new Player[4];
		
		slagen = (ArrayList<Slag>[])new ArrayList[4];
		slagen[0] = new ArrayList<Slag>();
		slagen[1] = new ArrayList<Slag>();
		slagen[2] = new ArrayList<Slag>();
		slagen[3] = new ArrayList<Slag>();
		
		currSlag = new Slag(players.length);
	}
	
	//getters and setters
	public Player getPlayer(int player){
		return players[player];
	}

	public void setPlayer(Player player, int place) {
		players[place] = player;
		player.setTable(this, place);
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

	public CardColor getTroef() {
		return troef;
	}

	public void setTroef(CardColor troef) {
		this.troef = troef;
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
		this.troef = CardColor.NONE;

	}






	//private methods
	private void collectCards(){
		for(ArrayList<Slag> a :slagen ){
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




	@Deprecated
	public int getAmountOfCards(int playerSeat) {
		return players[playerSeat].getAmountOfCards();
	}

	@Deprecated
 	public void distributeCards(){
		for(Player p: players){
			for(int i = 0; i != 4; i++){
			p.giveCard(deck.takeCard());
			}
		}
		for(Player p: players){
			for(int i = 0; i != 4; i++){
			p.giveCard(deck.takeCard());
			}
		}
		for(Player p: players){
			for(int i = 0; i != 5; i++){
			p.giveCard(deck.takeCard());
			}
		}
	}


	


}
