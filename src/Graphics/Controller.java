package Graphics;

import java.awt.image.BufferedImage;

public abstract class Controller{
	
	protected View view;
	
	public Controller(Screen s){
		this.view = new View(s.getHeight(),s.getWidth());
		s.setController(this);
	}
	
	public abstract void update();
	
	public BufferedImage getImage(){
		return view.getImage();
	}
	
}
