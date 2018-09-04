import java.awt.*;

// Bullet class
public class Bullet extends Rectangle{
	
	// Attributes
	private int dir;
	private int speed;
	private int damage;
	
	// Constructor to initialize bullet location, direction, and speed
	public Bullet(int x, int y, int dir, int speed, int w, int h, int d){
		super(x, y, w, h);
		this.dir = dir;
		this.speed = speed;
		width = w;
		height = h;
		damage = d;
	}
	
	// Render bullet as a filled rectangle
	public void render(Graphics g){
		g.fillRect(x, y, width, height);
	}
	
	// Make bullet move
	public void fire(){
		x += dir*speed;
	}
	
	// Getter for damage
	public int getDamage(){
		return damage;
	}
}