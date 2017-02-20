package KleurenWiezenOld;

import CardGame.state.objects.Player;

public class KleureWiezenFactory {

	private static KleureWiezenFactory pf = new KleureWiezenFactory();
	
	public static KleureWiezenFactory getInstance(){
		return pf;
	}
	
	private KleureWiezenFactory(){};
	
	public KHumanPlayer getKHumanPlayer(){
		return new KHumanPlayer();
	}
	
	public AIPlayer getAIPlayer(){
		return new AIPlayer();
	}

	public Game getGame(Player p1){
		return new Game(p1,getAIPlayer(),getAIPlayer(),getAIPlayer());
	}

	public Game getGame(Player p1 , Player p2){
		return new Game(p1,p2,getAIPlayer(),getAIPlayer());
	}
	
	public Game getGame(Player p1 , Player p2, Player p3){
		return new Game(p1,p2,p3,getAIPlayer());
	}
	
	public Game getGame(Player p1,Player p2,Player p3,Player p4){
		return new Game(p1,p2,p3,p4);
	}

}
