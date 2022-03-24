import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;

public class Vaisseau {
	private float x, y;
	private Image i;
	
	
	public Vaisseau(Image i) {
		x = 340;
		y = 400;
		this.i = i;
	}
	
	public void dessiner(Graphics g) {
		g.drawImage(i, x-15, y-15);
	}
	
	public void gauche() {
		setX(getX() - 10);
	}
	
	public void droite() {
		setX(getX() + 10);
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
}
