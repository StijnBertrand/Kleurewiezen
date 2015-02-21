package CardGameGraphics;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import CardGame.Card;
import CardGame.Hand;
import CardGame.HumanPlayer;
import Graphics.Screen;

public class PlayerController extends PlayerViewer implements MouseMotionListener,MouseListener{

	public PlayerController(Screen s, HumanPlayer p) {
		super(s , p);
		addListeners(s);
	}
	
	@Override
	protected void drawPlayerHand(int x,int y, int space , Hand hand,boolean horizontal){
		if(card != -1){
			Card drag = player.getHand().getCard(card);
			int xDrag = end.x - start.x + x + (space + sf.getSpriteWidth())*card;
			int yDrag = end.y - start.y + y;
			boolean drawn = false;
			
			for(Card c:hand){
				if(c == drag){
					//skip this card because the position of this card has changed
					x += space + sf.getSpriteWidth();
					continue;
				}else{					
					if(x > xDrag +2*sf.getSpriteWidth()/3 & !drawn){
						drawCard(xDrag,yDrag,drag,false);
						drawn = true;
					}
					drawCard(x,y,c,false);
					x += space + sf.getSpriteWidth();
				}
			}
			if(!drawn){
				drawCard(xDrag,yDrag,drag,false);
			}
		}else{
			super.drawHand(x, y, space, hand,horizontal);
		}	
	}
	
	
	/*
	 * From this point are the Mouse Listeners
	 * 
	 */
	
	private void addListeners(Screen s){
		s.addMouseListener(this);
		s.addMouseMotionListener(this);
	}
	
	//variables used for when a card is being dragged
	private int card = -1;
	private Point start,end;

	

	@Override
	public void mouseClicked(MouseEvent e) {
		Point p = e.getPoint();
		int card = onCard(p.x, p.y);
		if(card != -1){
			if(((HumanPlayer)player).getMyTurn()){
				((HumanPlayer)player).playCard(card);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		start = end = e.getPoint();
		card = onCard(start.x,start.y);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		card = -1;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		end = e.getPoint();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	//helper method to check if a specific position is on a card
	protected int onCard(int x, int y){
		int xOffHand = getXOffHand();
		if(y>handHeight & y < handHeight + sf.getSpriteHeight() ){
			if(x> xOffHand & x < xOffHand + lengthHand()){
				if(player.getHand().size()-1<(x-xOffHand)/(space + sf.getSpriteWidth())){
					return player.getHand().size()-1;		
				}else{
					return (x-xOffHand)/(space + sf.getSpriteWidth());
				}
			}	
		}
		return -1;
	}
	
	
}
