package Graphics;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;


public class Screen extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	private static int width = 300;
	private static int height = 169;
	private static int scale = 3;
	
	private JFrame frame;
	private boolean running = false; 

	private Controller c;
	
	//constructor
	public Screen() {
		this(width, height, scale,false);
	}

	public Screen(int width, int height, int scale, boolean resizeable) {
		Dimension d = new Dimension (width *scale, height*scale);
		setPreferredSize(d);

		frame = new JFrame();
		frame.setResizable(resizeable);
		frame.add(this);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public synchronized void setController(Controller c){
		this.c = c;
	}

	private synchronized void render(){
		BufferStrategy bs = getBufferStrategy();
		if(bs == null){
			createBufferStrategy(3);
			bs = getBufferStrategy();
		}				
		Graphics g = bs.getDrawGraphics();		
		g.drawImage(c.getImage(), 0, 0, getWidth(),getHeight(), null);
		g.dispose();
		bs.show();
	}
	
	private synchronized void updateImage(){
		c.update();
	}
	
	private synchronized boolean test(){
		return c != null;
	}

	@Override
	public void run() {
		running = true;
		while( running){
			if(test()){
				updateImage();
				render();
			}
		}
	}
}
