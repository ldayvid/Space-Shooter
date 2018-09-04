import java.awt.*;
import javax.swing.ImageIcon;

// Spike class
public class Spikes extends Rectangle{
	
	// Image
	private static final ImageIcon SPIKE_IMAGE = new ImageIcon("src\\Images\\spikes.png");
	
	// Constructor for Spikes
	public Spikes(int x, int y){
		super(x, y, 50, 50);
	}
	
	// Render image of spikes
	public void render(Graphics g){
		g.drawImage(SPIKE_IMAGE.getImage(), x, y, null);
	}
}