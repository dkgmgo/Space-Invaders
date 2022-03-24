
import java.util.ArrayList;
import java.util.ListIterator;

import org.newdawn.slick.Animation;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;


public class SpaceInvaders extends BasicGame {
	private Ennemi[][] e = new Ennemi[10][6];
	private ArrayList<Ennemi> ei = new ArrayList<Ennemi>();
	private Vaisseau v;
	private ArrayList<Projectile> p = new ArrayList<Projectile>();
	private int compteur;
	private int score;
	private Image backg;
	private boolean chg = true;
	
	public SpaceInvaders(String title) {
		super(title);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void render(GameContainer arg0, Graphics arg1) throws SlickException {
		// TODO Auto-generated method stub
		arg1.drawImage(backg, 0, 0);
		for(int i=0; i<ei.size(); i++) {
			ei.get(i).dessiner(arg1);
		}
		v.dessiner(arg1);
		for(int i=0; i<p.size(); i++) {
			p.get(i).dessiner(arg1);
		}
		arg1.setColor(Color.green);
		if(ei.size() > 30)
			arg1.drawString("Score: "+String.valueOf(score*5), 20, 20);
		else
			arg1.drawString("Score: "+String.valueOf(score*10), 20, 20);
		if(ei.size()==0)
			arg1.drawString("FIN DE PARTIE", 200, 200);
	}

	@Override
	public void init(GameContainer arg0) throws SlickException {
		// TODO Auto-generated method stub
		backg = new Image("src/img/background.jpeg");
		for(int i=0; i<6;i++) {
			for(int j=0; j<10; j++) {
				e[j][i] = new Ennemi(155 + j * 33, 50 + i * 33, anim(i));
				ei.add(e[j][i]);
			}
		}
		Image i = new Image("src/img/Ship.png");
		v = new Vaisseau(i);	
	}

	@Override
	public void update(GameContainer arg0, int arg1) throws SlickException {
		// TODO Auto-generated method stub
		Input inp = arg0.getInput();
		if (inp.isKeyPressed(Input.KEY_RIGHT)) {
			v.droite();
		}
		if (inp.isKeyPressed(Input.KEY_LEFT)) {
			v.gauche();
		}
		if (inp.isKeyPressed(Input.KEY_SPACE) && compteur<=4) {
			Projectile proj = new Projectile(v.getX()-2, v.getY(), 100);
			p.add(proj);
			compteur++;
		}
		if(inp.isKeyPressed(Input.KEY_ESCAPE)) {
			arg0.exit();
		}
		for (int i = 0; i < p.size(); i++) {
			if (p.get(i) != null)
				p.get(i).deplacer(arg1);
			if (p.get(i).horsEcran(arg0)) {
				p.remove(i);
				compteur--;
				break;
			}
			for (int j = 0; j < ei.size(); j++) {
				if(p.get(i).testCollision(ei.get(j))) {
					p.remove(i);
					ei.remove(j);
					score++;
					compteur--;
					break;
				}
			}
		}
		for(int i=0; i<6; i++) {
			for(int j =0; j<10; j++) {
				if(e[0][0].getX()>10 && chg) {
						e[j][i].gauche(arg1);
				}
				else {
					chg = false;
					if(e[9][0].getX()<arg0.getWidth()-30) {
							e[j][i].droite(arg1);
					}
					else
						chg = true;
				}
			}
		}
	}
	
	//fonction qui cree l'ennemi en fonction du type
	public Animation anim(int t) throws SlickException {
		String chemin;
		if (t == 0)
			chemin = "src/img/invader_1.png";
		else if (t == 1)
			chemin = "src/img/invader_2.png";
		else if (t == 2)
			chemin = "src/img/invader_3.png";
		else if (t == 3)
			chemin = "src/img/invader_4.png";
		else if (t == 4)
			chemin = "src/img/invader_5.png";
		else
			chemin = "src/img/invader_6.png";
		SpriteSheet sheet = new SpriteSheet(chemin, 30, 30);
		Animation anime = new Animation();
		anime.addFrame(sheet.getSprite(0, 0), 200);
		anime.addFrame(sheet.getSprite(0, 1), 200);
		return anime;
	}
}
