import java.awt.Button;
import java.awt.PopupMenu;
import java.util.ArrayList;

import CardGame.Card;
import CardGame.HumanPlayer;
import CardGame.Player;
import KleurenWiezen.AIPlayer;
import CardGame.Table;
import CardGameGraphics.PlayerController;
import Graphics.Controller;
import Graphics.Screen;
import KleurenWiezen.Game;
import KleurenWiezen.KleureWiezenFactory;


public class Main {
	
	
	private static Screen s = new Screen();
	
	
	public static void main(String[] args) {
		
		KleureWiezenFactory Kf = KleureWiezenFactory.getInstance();
		new Thread(s).start();
		
		HumanPlayer p = Kf.getKHumanPlayer();
		p.giveScreen(s);
		
		//Screen s2 = new Screen();
		//new Thread(s2).start();
		AIPlayer p1 = Kf.getAIPlayer();
		//p1.giveScreen(s2);
		
		Screen s3 = new Screen();
		new Thread(s3).start();
		HumanPlayer p2 = Kf.getKHumanPlayer();
		p2.giveScreen(s3);
		
		Screen s4 = new Screen();
		new Thread(s4).start();
		HumanPlayer p3 = Kf.getKHumanPlayer();
		p3.giveScreen(s4);

		
		
		Game game = Kf.getGame(p,p1,p2,p3);
		
		game.start();
	} 
	
	public void returnToMainMenu(){
		//new MMController(s);
	}
}
