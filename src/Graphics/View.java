package Graphics;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

public class View{

	private  int width, height;
	private BufferedImage im;
	private int[] pixels;

	public View(int h,int w) {
		this.height = h;
		this.width = w;

		im = new BufferedImage( width, height,BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt)im.getRaster().getDataBuffer()).getData();
	}
	
	public int getHeight(){
		return height;
	}
	
	public int getWidth(){
		return width;
	}
	
	public void putPixel(int x, int y, int pixel) {
		try {
			if(x>0 & x<width)pixels[y *width + x] = pixel;			
		} catch (IndexOutOfBoundsException e) {
			return;
		}
	}
	
	public void drawBackGround(int color){
		for( int i = 0; i != pixels.length;i++){
			pixels[i] = color;
		}
	}
	
	public BufferedImage getImage(){
		return im;
	}
	
	public void drawRectangle(int x, int y, int width, int height, boolean open, int collor){
		for(int i= 0; i<width;i++){
			putPixel(x+i, y,collor);
		}
		for(int i=1;i<height-1;i++){
			if(open){
				putPixel(x,y+i,collor);
				putPixel(x+width-1,y+i,collor);
			}else{
				for(int j =0;j< width;j++){
					putPixel(x+j,y+i,collor);
				}
			}
		}
		for(int i= 0; i<width;i++){
			putPixel(x+i, y+ height-1,collor);
		}		
	}
	
	public void drawline(int xOff,int yOff, int length,boolean hor,int collor){		
		if(hor){
			for(int i = 0; i<length;i++){
				putPixel(xOff+i,yOff,collor);
			}
		}else{
			for(int i = 0; i<length;i++){
				putPixel(xOff,yOff+i,collor);
			}
		}
	}
}
