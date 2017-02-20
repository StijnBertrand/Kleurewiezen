
import HartenJagen.*;

import Graphics.Screen;
import HartenJagen.objects.HJAIPlayer;
import HartenJagen.objects.HJPlayer;


public class Main {
	
	
	private static Screen s = new Screen();
	
	
	public static void main(String[] args) {

		HJPlayer player1 = new HJPlayer();
		HJAIPlayer player2 = new HJAIPlayer();
		HJAIPlayer player3 = new HJAIPlayer();
		HJAIPlayer player4 = new HJAIPlayer();

		new Thread(s).start();
		player1.giveScreen(s);

		HartenJagen hj = new HartenJagen(player1,player2,player3,player4);
		hj.start();
/*
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
*/
	}
}
