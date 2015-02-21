package Graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {
	private String path;
	//dimentions of the sheet in sprites
	private int rows;
	private int colums;
	//dimensions of a single sprite in pixels
	private int spriteWidth;
	private int spriteHeight;
	private int[] sheet;
	
	//
	public SpriteSheet(String path,int rows,int colums){
		this.path = path;
		this.rows = rows;
		this.colums = colums;
		load();
	}
	
	
	private void load(){
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			this.spriteWidth = w/colums;
			int h = image.getHeight();
			this.spriteHeight = h/rows;
			sheet = new int[w*h];
			image.getRGB(0, 0, w, h, sheet, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	
	//missing some code for in case the asked sprite does not exist
	public int[] getSprite(int row,int colum){
		int[] sprite = new int[spriteHeight*spriteWidth];
		for(int y = 0; y < spriteHeight; y++){
			for(int x = 0;x < spriteWidth; x++){
				sprite[x + y * spriteWidth]= sheet[(spriteHeight*row+y)*(spriteWidth*colums)+(spriteWidth*colum)+x];
			}
		}
		return sprite;
	}

	public int getSpriteWidth() {
		return spriteWidth;
	}

	public int getSpriteHeight() {
		return spriteHeight;
	}
}
