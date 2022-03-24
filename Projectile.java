import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Projectile {
	private float x, y, vy;
	
	public Projectile(float x, float y, float vy) {
		this.x = x;
		this.y = y;
		this.vy = vy;
	}
	
	public void dessiner(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(x, y, 3, 3);
	}
	
	public void deplacer(int delta) {
		y -= vy*delta/1000f;
	}
	
	public boolean horsEcran(GameContainer g) {
		return y < 0;
	}
	
	public boolean testCollision(Ennemi e) {
		return e.contenir(x, y);
	}

}
