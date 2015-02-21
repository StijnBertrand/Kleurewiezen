package Graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;


public class Text {

	
	
	
	public static void  drawText(View view, int xOff,int yOff, String text, int fontsize ){
		Font font = new Font("Serif", Font.PLAIN, fontsize);  
	    // use a JLabel to get a FontMetrics object  
	    FontMetrics metrics = new JLabel().getFontMetrics(font);  
        int width = metrics.stringWidth(text);  
        int height = metrics.getHeight();  
        // use ARGB or the background will be black as well  
        BufferedImage bi = new BufferedImage(width+10, height+10, BufferedImage.TYPE_INT_ARGB);  
        // create a Graphics2D object from the BufferedImage  
        Graphics2D g2d = bi.createGraphics();  
        g2d.setFont(font);  
        g2d.setColor(Color.black);  
        g2d.drawString(text, 0, height);  
        g2d.dispose();  
        for(int j = 0; j < height+10; j++){    //Scroll through rows  
            for(int i = 0; i < width+10; i++){ //Scroll through columns  
                if(bi.getRGB(i,j)!=0) {
                	view.putPixel(xOff + i, yOff +j, bi.getRGB(i,j));	
                } 
            }  
        }  				
	}
}
