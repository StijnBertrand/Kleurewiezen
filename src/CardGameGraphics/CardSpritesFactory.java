package CardGameGraphics;

import Graphics.Sprite;
import Graphics.SpriteSheet;

public class CardSpritesFactory {

	private static CardSpritesFactory instance = new CardSpritesFactory();
	private SpriteSheet sheet;
	private int rows = 5;
	private int coll = 13;
	Sprite[] sprites;
	
	public static CardSpritesFactory getInstance(){
		return instance;
	}
	
	//private constructor
	private CardSpritesFactory(){
		sheet = new SpriteSheet("/cardsheet.png",rows,coll);
		sprites = new Sprite[rows*coll];
		load();
	}
	
	//Loads the sprites
	private void load(){	
		// 0 = hearts		0 = ace 
		// 1 = dimonds
		// 2 = clubs
		// 3 = spades 
		// ID = 13* color + number
		for(int row = 0;row < rows;row++){
			for(int colum = 0;colum<coll;colum++){
				sprites[row*coll+colum]=new Sprite(sheet.getSpriteWidth(), sheet.getSpriteHeight(), sheet.getSprite(row, colum));
			}
		}
	}

	public Sprite getSprite(int id){
		return sprites[id];
	}
	
	public int getSpriteWidth(){
		return sheet.getSpriteWidth();
	}
	
	public int getSpriteHeight(){
		return sheet.getSpriteHeight();
	}
}
