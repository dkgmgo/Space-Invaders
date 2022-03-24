import org.newdawn.slick.Animation;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Ennemi {
	private float x, y;
	private Animation an = new Animation();
	
	public Ennemi(float x, float y, Animation an) {
		this.x = x;
		this.y = y;  
		this.an = an;
	}
	
	//fonction de dessin pour le rendu
	public void dessiner(Graphics g) {
		g.drawAnimation(an, x, y);
	}
	
	public boolean contenir(float i, float j) {
		return  i>=x && i<=x+30 && j>=y && j<=y+30;
	}
	
	public float getX() {
		return x;
	}
	
	public void gauche(int delta) {
		x -= 60*delta/1000f;
	}
	
	public void droite(int delta) {
		x += 60*delta/1000f;
	}
	
	public void setX(float x) {
		this.x = x;
	}
}
