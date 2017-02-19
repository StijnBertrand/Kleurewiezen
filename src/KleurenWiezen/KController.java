package KleurenWiezen;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import CardGame.Hand;
import CardGame.HumanPlayer;
import CardGameGraphics.PlayerController;
import CardGameGraphics.PlayerViewer;
import Graphics.Screen;
import Graphics.Text;

public class KController extends PlayerController{
	private Screen s;
	public KController(Screen s, KHumanPlayer p) {
		super(s, p);
		this.s = s;
	}
	
	@Override
	public void update(){
		super.update();
		try{
			if(((KHumanPlayer)player).isBidding()){
				drawBeds(((KHumanPlayer)player).getBeds());
				if(((KHumanPlayer)player).getMyTurnToBed()){
					drawCoises();
				}
			}
		}catch(Exception e){
			
		}
	}
	
	@Override 
	protected void drawPlayers(){
		int i = player.getSeat();

		//left player	
		Hand hand = ((KHumanPlayer)player).getHand((i+1)%4);
		int x = (view.getHeight() - ((player.getAmountOfCards((i+1)%4 )-1)*(sf.getSpriteWidth()+space)+sf.getSpriteWidth()))/2;
		Text.drawText(view,100,x-50,"player"+ (((i+1)%4)+1),25);
		if(hand != null){
			drawHand(100,x,space, player,false);
		}else{
			drawCardsBack(100, x, space, player.getAmountOfCards((i+1)%4 ), false);
		}
		
		//top player	
		x=getXOffHand();
		hand = ((KHumanPlayer)player).getHand((i+2)%4);
		Text.drawText(view,x-100,90-sf.getSpriteHeight(),"player"+ (((i+2)%4)+1),25);
		if(hand != null){
			drawHand(x,100-sf.getSpriteHeight(),space, player,true);
		}else{
			drawCardsBack(x, 100-sf.getSpriteHeight(), space, player.getAmountOfCards((i+2)%4 ), true);
		}
		
		//right player
		hand = ((KHumanPlayer)player).getHand((i+3)%4);
		Text.drawText(view,view.getWidth()-100-sf.getSpriteHeight(),x-50,"player" + (((i+3)%4)+1),25);
		int y =(view.getHeight() - ((player.getAmountOfCards((i+3)%4 )-1)*(sf.getSpriteWidth()+space)+sf.getSpriteWidth()))/2;
		if(hand != null){
			drawHand(view.getWidth()-100-sf.getSpriteHeight(), y,space, player,false);
		}else{
			drawCardsBack(view.getWidth()-100-sf.getSpriteHeight(), y, space, player.getAmountOfCards((i+3)%4 ), false);
		}
		
		//this player, on the bottom	
		 x = getXOffHand();
		Text.drawText(view,x-100,handHeight+20,"player"+ (i+1),25);
		drawPlayerHand(x,handHeight,space, player.getHand(),true);
	}
	
	
	private void drawBeds(ArrayList<int[]> beds){
		drawBedsBackground();
		int width = view.getWidth() - 240 - 2*sf.getSpriteHeight();
		int y = 120 + 35;
		for(int[] round:beds){
			int x = 120 + sf.getSpriteHeight();
			for(int bed:round){
				Text.drawText(view,x + 5,y,BedSystem.translate(bed),15);
				x += width/4;
			}
			y += 35;
		}
	}
	
	private void drawBedsBackground(){
		//background
				int width = view.getWidth() - 240 - 2*sf.getSpriteHeight();
				int height = view.getHeight() - 240;
				int xOff = 120 + sf.getSpriteHeight();
				int yOff = 120;
				view.drawRectangle(xOff, yOff ,width,height, false, 0x193BC8);
				view.drawRectangle(xOff, yOff ,width,height, true, 0x000000);
				view.drawline(xOff+(width/4), yOff, height, false, 0x000000);
				view.drawline(xOff+(width/2), yOff, height, false, 0x000000);
				view.drawline(xOff+(3*width/4), yOff, height, false, 0x000000);
				view.drawline(xOff, yOff+35, width, true, 0x000000);
				//player names
				Text.drawText(view,xOff + 5,yOff,"player1",20);
				Text.drawText(view,xOff + 5 + (width/4),yOff ,"player2",20);
				Text.drawText(view,xOff + 5 + (width/2),yOff ,"player3",20);
				Text.drawText(view,xOff + 5 + (3*width/4),yOff,"player4",20);
	}
	
	private boolean shown = false;
	private void drawCoises(){
		if(!shown){		
			final JFrame parent = new JFrame();
			parent.setResizable(true);
			parent.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			parent.setLocationRelativeTo(s);		    
			parent.getContentPane().setLayout(new BoxLayout(parent.getContentPane(), BoxLayout.PAGE_AXIS));
			boolean[] opt = ((KHumanPlayer)player).getOptions();
			for(int i = 0;i< BedSystem.getMaxBeds();i++){
				if(opt[i]){
					final int id = i;
					JButton b = new JButton(BedSystem.translate(i));
					b.addMouseListener(new MouseListener() {						
						public void mouseReleased(MouseEvent e) {};
						public void mousePressed(MouseEvent e) {};
						public void mouseExited(MouseEvent e) {};
						public void mouseEntered(MouseEvent e) {};
						public void mouseClicked(MouseEvent e) {
							((KHumanPlayer)player).bed(id);
							parent.setVisible(false);
							parent.dispose();
							shown = false;
						};				
					});					
					b.setPreferredSize(new Dimension(100, 50));		
					parent.getContentPane().add(b);
				}
			} 
	        parent.pack();
	        parent.setVisible(true);
	        shown = true;
		}	
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Point p = e.getPoint();
		int card = onCard(p.x, p.y);
		if(card != -1){
			if(((HumanPlayer)player).getMyTurn()){
				((HumanPlayer)player).playCard(card);
			}
			if(((KHumanPlayer)player).isMyTurnToDiscard()){
				((KHumanPlayer)player).discardCard(card);
			}
		}
	}
}
