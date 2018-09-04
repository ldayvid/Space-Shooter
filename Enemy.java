import java.awt.*;
import javax.swing.ImageIcon;
// Rusher class
public class Enemy extends Player{
	
	// Images
	private static final ImageIcon ENEMY_IMAGE_R= new ImageIcon("src\\Images\\Rusher_Right.png");
	private static final ImageIcon ENEMY_IMAGE_R2= new ImageIcon("src\\Images\\Rusher_Right2.png");
	private static final ImageIcon ENEMY_IMAGE_R3= new ImageIcon("src\\Images\\Rusher_Right3.png");
	private static final ImageIcon ENEMY_IMAGE_L= new ImageIcon("src\\Images\\Rusher_Left.png");
	private static final ImageIcon ENEMY_IMAGE_L2= new ImageIcon("src\\Images\\Rusher_Left2.png");
	private static final ImageIcon ENEMY_IMAGE_L3= new ImageIcon("src\\Images\\Rusher_Left3.png");
	private static ImageIcon ANIMATE_ENEMY[][] = {{ENEMY_IMAGE_L,ENEMY_IMAGE_L2,ENEMY_IMAGE_L,ENEMY_IMAGE_L3},{ENEMY_IMAGE_R,ENEMY_IMAGE_R2,ENEMY_IMAGE_R,ENEMY_IMAGE_R3}};
	
	// Attributes
	private int frame;
	private int animeCount;
	private int type;
	private int damage;
	
	// Constructor to initialize location of enemy and other attributes
	public Enemy(int x, int y, int w, int h, int health, int t){
		super(x, y, w, h, health);
		frame = 0;
		animeCount = 0;
		type = t;
		damage = 14;
	}
	
	// Render enemy with specified image
	public void render(Graphics g){
		g.drawImage(ANIMATE_ENEMY[getDir()][frame].getImage(),x,y,null);
		
		// Add time delay to animation
		if(getVX() != 0){
			if(animeCount++ ==10) {
				frame = (frame + 1)%4;
				animeCount = 0;
			}
		}
	}
	
	// Rectangle for player detection
	public Rectangle detection() {
		return new Rectangle(x-560,y-230,1170,460);
	}
	
	// Getter for type
	public int getType(){
		return type;
	}
	
	// Getter for damage
	public int getDamage(){
		return damage;
	}
}