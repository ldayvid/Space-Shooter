// Moving block class
public class MovingBlock extends Ground{
	
	// Attributes
	private int distance;
	private int startX, startY;
	private int startDir;
	
	// Constructor to initialize moving block direction and speed
	public MovingBlock(int x, int y, int v, boolean vert, int d, int dis){
		super(x, y, 150, v, vert, d);
		startX = x;
		startY = y;
		startDir = d;
		distance = dis;
		setLocation(x, y);
	}
	
	// Move the moving block
	public void move(){
	
		// If the block moves vertically
		if(getVertical()){
		
			// Move on y-axis
			y += getVel()*getDir();
			
			// If it is a down block
			if(startDir == 1){
				
				// Reverse direction if it reaches the bottom limit
				if(y<startY-distance){
					changeDir();
				}
				
				// Reverse direction if it reaches the original position
				else if(y>startY){
					changeDir();
				}
			}
			
			else{
				// Reverse direction if it reaches the top limit
				if(y>startY+distance){
					changeDir();
				}
				// Reverse direction if it reaches the original position
				else if(y<startY){
					changeDir();
				}
			}
		}
		
		// If the block moves horizontally
		else{
		
			// Move on x-axis
			x += getVel()*getDir();
			
			// If it is the block moving left
			if(startDir == -1){
				
				// If it reaches the left limit, reverse direction
				if(x<startX-distance){
					changeDir();
				}
				
				// Block reverses direction if it reaches original position
				else if(x>startX){
					changeDir();
				}
			}
			
			// Right moving block
			else{
				
				// If reaches right limit, reverse direction
				if(x>startX+distance){
					changeDir();
				}
				
				// If it reaches original position, reverse direction
				else if(x<startX){
					changeDir();
				}
			}
		}
		setLocation(x, y);
	}
}