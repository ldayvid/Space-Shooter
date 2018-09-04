import java.awt.*;
import javax.swing.*;

// Boss Enemy class
public class BossEnemy extends Enemy{
	
	// Images
	private static final ImageIcon BOSS_ENEMY_0_0 = new ImageIcon("src\\Images\\Boss0_0.png");
	private static final ImageIcon BOSS_ENEMY_0_1 = new ImageIcon("src\\Images\\Boss0_1.png");
	private static final ImageIcon BOSS_ENEMY_0_2 = new ImageIcon("src\\Images\\Boss0_2.png");
	private static final ImageIcon BOSS_ENEMY_1_0 = new ImageIcon("src\\Images\\Boss1_0.png");
	private static final ImageIcon BOSS_ENEMY_1_1 = new ImageIcon("src\\Images\\Boss1_1.png");
	private static final ImageIcon BOSS_ENEMY_1_2 = new ImageIcon("src\\Images\\Boss1_2.png");
	private static final ImageIcon BOSS_ENEMY_2_0 = new ImageIcon("src\\Images\\Boss2_0.png");
	private static final ImageIcon BOSS_ENEMY_2_1 = new ImageIcon("src\\Images\\Boss2_1.png");
	private static final ImageIcon BOSS_ENEMY_2_2 = new ImageIcon("src\\Images\\Boss2_2.png");
	private static final ImageIcon bossImages[][] = {{BOSS_ENEMY_0_0, BOSS_ENEMY_0_1, BOSS_ENEMY_0_2},
													 {BOSS_ENEMY_1_0, BOSS_ENEMY_1_1,BOSS_ENEMY_1_2},
													 {BOSS_ENEMY_2_0, BOSS_ENEMY_2_1,BOSS_ENEMY_2_2}};
	
	// Attributes
	private int xDir, yDir;
	
	// Constructor for BossEnemy
	public BossEnemy(int x, int y) {
		super(x, y, 100, 100, 50, 3);
		xDir = 1;
		yDir = 1;
	}
	
	// Render boss enemy
	public void render(Graphics g){
	
		// Set the image indices
		if(getVX() < 0){
			xDir = 0;
		}
		else if (getVX() == 0){
			xDir = 1;
		}
		else{
			xDir = 2;
		}
		
		if(getVY() < 0){
			yDir = 0;
		}
		else if (getVY() == 0){
			yDir = 1;
		}
		else{
			yDir = 2;
		}
			
		g.drawImage(bossImages[yDir][xDir].getImage(), x, y, null);
		
		// Add time delay to bullet firing
		if(getBulDelay() > 0) {
			setBulDelay(getBulDelay()-1);
		}
	}
	
	// Detection of player
	public Rectangle detection(){
		return new Rectangle(x - 1500, y - 1500, 3000, 3000);
	}
	
	// Method to shoot bullets
	public Bullet fire() {
		
		// Shoot accordingly to get direction
		if(getDir() == 0) {
			return new Bullet((int)(getCenterX()),(int)(y+height/2), -1, 10, 40, 5, 2);
		}
		return new Bullet((int)(getCenterX()),(int)(y+height/2), 1, 10, 40, 5, 2);
	}
	
	// Shooting range rectangle
	public Rectangle shootingRange(){
		return new Rectangle(x - 1500, y, 3000, height);
	}
}