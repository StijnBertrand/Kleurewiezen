package CardGame;

import java.util.ArrayList;

public class Table {

	private DeckFactory df = DeckFactory.getInstance();
	private Deck deck = df.getDeck52();
	//private Deck deck = df.troelTest();
	protected Player[] players;
	//[0]is voor de eerste speeler zijn slagen,[1]...
	private ArrayList<Slag>[] slagen;
	private Slag currSlag;
	private Slag prevSlag;
	
	public Table(){
		players = new Player[4];
		
		slagen = (ArrayList<Slag>[])new ArrayList[4];
		slagen[0] = new ArrayList<Slag>();
		slagen[1] = new ArrayList<Slag>();
		slagen[2] = new ArrayList<Slag>();
		slagen[3] = new ArrayList<Slag>();
		
		currSlag = new Slag(players.length);
	}
	
	public void setPlayer(Player player, int place) {
		players[place] = player;
		player.setTable(this, place);
	}	
	
	public Player getPlayer(int player){
		return players[player];
	}
	
	//methods for a player to get information 	
	public Slag getPrevSlag(){
		return prevSlag;
	}
	
	public Slag getCurrSlag(){
		return currSlag;
	}

	public int getAmountOfCards(int playerSeat) {
		return players[playerSeat].getAmountOfCards();
	}

	//methods to handle the flow of the game
	public void letPlayerPlay(int player){
		currSlag.playCard(players[player].letPlay(),player);
	}

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

	public void appointSlag(int winner) {
		slagen[winner].add(currSlag);
		newSlag();
	}
	
	public void reset(){
		collectCards();
		prevSlag = null;
	}
	
	
	//private methods
	private void collectCards(){
		for(ArrayList<Slag> a :slagen ){
			while(!a.isEmpty()){
				Slag s = a.get(0);
				deck.addCard(s.getCard(s.getStarter()));
				deck.addCard(s.getCard((s.getStarter()+1)%4));
				deck.addCard(s.getCard((s.getStarter()+2)%4));
				deck.addCard(s.getCard((s.getStarter()+3)%4));
				a.remove(0);
			}
		}
	}
	
	private void newSlag(){
		prevSlag = currSlag;
		currSlag = new Slag(players.length);
	}

}
