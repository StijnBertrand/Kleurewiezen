package Graphics;

public class Sprite {
	private final int width;
	private final int height;
	private int[] pixels;
	
	public Sprite(int width, int height, int[] pixels) {
		this.width = width;
		this.height = height;
		this.pixels = pixels;
	}

	public void render(View view, int xOff, int yOff, boolean sideways) {
		if(sideways){
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					view.putPixel(xOff + height -y, yOff + x, pixels[y * width + x]);
				}
			}		
		}else{
			for (int y = 0; y < height; y++) {
				for (int x = 0; x < width; x++) {
					view.putPixel(xOff + x, yOff + y, pixels[y * width + x]);
				}
			}
			
		}
		
	}
}
