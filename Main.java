import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main {

	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new SpaceInvaders("Space Invaders Beta"));
		app.setShowFPS(false);
		app.start();
	}

}
