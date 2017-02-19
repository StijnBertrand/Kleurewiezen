package CardGameGraphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import CardGame.Card;
import CardGame.Hand;
import CardGame.Player;
import CardGame.Slag;
import Graphics.Controller;
import Graphics.Screen;
import Graphics.Text;

public class PlayerViewer extends Controller {

	protected Player player;
	protected CardSpritesFactory sf = CardSpritesFactory.getInstance();
	
	//this number + the width of the sprite is the space between two cards
	protected int space = -50;
	//at this height the hand will be drawn ( this depends on the height of the canvas
	protected int handHeight; 
	

	
	public PlayerViewer(Screen s, Player p) {
		super(s);
		this.player = p;
		this.handHeight = -100 + view.getHeight();
	}

	@Override
	public void update() {
		try{			
			drawBackGround();
			drawCurrSlag();
			drawPlayers();		
		}catch(Exception e){
			return;
		}
	}
	
	protected void drawBackGround(){
		view.drawBackGround(0x216A12);	
		//4 white squares:
		view.drawRectangle((view.getWidth() -sf.getSpriteWidth())/2 -sf.getSpriteWidth()+20, (view.getHeight() -sf.getSpriteHeight())/2, sf.getSpriteWidth(), sf.getSpriteHeight(), true, 0xFFFFFF);
		view.drawRectangle((view.getWidth() -sf.getSpriteWidth())/2 +sf.getSpriteWidth()-20, (view.getHeight() -sf.getSpriteHeight())/2, sf.getSpriteWidth(), sf.getSpriteHeight(), true, 0xFFFFFF);
		view.drawRectangle((view.getWidth() -sf.getSpriteWidth())/2, (view.getHeight() -sf.getSpriteHeight())/2 -20 + sf.getSpriteHeight(), sf.getSpriteWidth(), sf.getSpriteHeight(), true, 0xFFFFFF);
		view.drawRectangle((view.getWidth() -sf.getSpriteWidth())/2, (view.getHeight() -sf.getSpriteHeight())/2 +20 - sf.getSpriteHeight(), sf.getSpriteWidth(), sf.getSpriteHeight(), true, 0xFFFFFF);
	}

	protected void drawCurrSlag(){
		Slag s = player.getCurrSlag();
		int pos = player.getSeat();
		int starter = s.getStarter();
		//in case no cards have been played yet
		if(starter == -1)return;
		for(int i = 0 ;i<4;i++){			
			switch(((starter-pos)+4)%4){	
			case(0)	:{
				drawCard((view.getWidth() -sf.getSpriteWidth())/2, (view.getHeight() -sf.getSpriteHeight())/2 -20 + sf.getSpriteHeight(),s.getCard(pos),false); 
				break;
			}
			case(1):{
				drawCard((view.getWidth() -sf.getSpriteWidth())/2 -sf.getSpriteWidth()+20, (view.getHeight() -sf.getSpriteHeight())/2 ,s.getCard((pos+1)%4),false); 
				break;
			}
			case(2):{
				drawCard((view.getWidth() -sf.getSpriteWidth())/2, (view.getHeight() -sf.getSpriteHeight())/2 +20 - sf.getSpriteHeight(),s.getCard((pos+2)%4),false); 
				break;
			}
			case(3):{
				drawCard((view.getWidth() -sf.getSpriteWidth())/2 +sf.getSpriteWidth()-20, (view.getHeight() -sf.getSpriteHeight())/2 ,s.getCard((pos+3)%4),false); 
				break;
			}
			}
			starter++;
		}
	}
	
	protected void drawPlayers(){
		int i = player.getSeat();

		//left player	
		int x = (view.getHeight() - ((player.getAmountOfCards((i+1)%4 )-1)*(sf.getSpriteWidth()+space)+sf.getSpriteWidth()))/2;
		Text.drawText(view,100,x-50,"player"+ (((i+1)%4)+1),25);
		drawCardsBack(100, x, space, player.getAmountOfCards((i+1)%4 ), false);
		
		//top player	
		x=getXOffHand();
		Text.drawText(view,x-100,90-sf.getSpriteHeight(),"player"+ (((i+2)%4)+1),25);
		drawCardsBack(x, 100-sf.getSpriteHeight(), space, player.getAmountOfCards((i+2)%4 ), true);
		
		//right player
		Text.drawText(view,view.getWidth()-100-sf.getSpriteHeight(),x-50,"player" + (((i+3)%4)+1),25);
		int y =(view.getHeight() - ((player.getAmountOfCards((i+3)%4 )-1)*(sf.getSpriteWidth()+space)+sf.getSpriteWidth()))/2;
		drawCardsBack(view.getWidth()-100-sf.getSpriteHeight(), y, space, player.getAmountOfCards((i+3)%4 ), false);
		
		//this player, on the bottom	
		 x = getXOffHand();
		Text.drawText(view,x-100,handHeight+20,"player"+ (i+1),25);
		drawPlayerHand(x,handHeight,space, player.getHand(),true);
	}

	protected void drawPlayerHand(int x,int y, int space , Hand hand,boolean horizontal){
		drawHand(x,handHeight,space, player,true);
	}
	
	protected void drawHand(int x,int y, int space , Player player,boolean horizontal){
		if(horizontal){
			for(int i = 0 ; i<player.getAmountOfCards();i++){
				//TODO: adjust the 20 to the card hight
				drawCard(x,y-(player.isSelected(i)?20:0),player.getHand().getCard(i),!horizontal);
				x += space + sf.getSpriteWidth();
			}
		}else{
			//todo: no support for selecting cards when the hand of the player is drawn vertically
			for(Card c:player.getHand()){
				drawCard(x,y,c,!horizontal);
				y += space + sf.getSpriteWidth();
			}
		}
	}
	
	
	protected void drawCardsBack(int x,int y, int space , int amount,boolean horizontal){
		if(horizontal){
			for(int j = amount;j>0;j--){
				drawCardBackGround(x,y,!horizontal);
				x += space + sf.getSpriteWidth();
			}
		}else{
			for(int j = amount;j>0;j--){
				drawCardBackGround(x,y,!horizontal);
				y += space + sf.getSpriteWidth();
			}
		}
	}
	
	//helper methods:
	protected void drawCardBackGround(int x, int y, boolean sideways) {
		sf.getSprite(57).render(view, x, y,sideways);		
	}
	
	protected void drawCard(int x,int y,Card c,boolean sideways){
		if(c != null)sf.getSprite(c.getID()).render(view, x, y,sideways);
	}
	
	protected int getXOffHand(){
		return (view.getWidth() - lengthHand())/2;
	}
	
	protected int lengthHand(){
		return (player.getHand().size()-1)*(sf.getSpriteWidth()+space)+sf.getSpriteWidth();
	}
}
