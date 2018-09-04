import java.awt.*;

// Big bullet class
public class BigBullet extends Bullet{
	
	// Constructor for BigBullet
	public BigBullet(int x, int y, int dir) {
		super(x, y, dir, 30, 200, 20, 6);
	}
	
	// Render big bullet as big green rectangle
	public void render(Graphics g) {
		g.setColor(Color.green);
		g.fillRect(x, y, width, height);
	}
}