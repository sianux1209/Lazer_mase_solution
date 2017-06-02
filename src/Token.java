
public class Token {
	


	public Laser laser;
	public GameBoard gameBoard;
	
	public Token(Laser laser, GameBoard gameBoard){
		
		this.laser = laser;
		this.gameBoard = gameBoard;
		
	}
	
	public enum HitDirection {
		UPtoDOWN,
		RIGHTtoLEFT,
		DOWNtoUP,
		LEFTtoRIGHT
	}
	
	/**
	 * Features of red token in the game board
	 * 
	 * Provides the laser beam. Push the button
	 * at the top of this token to engage the beam. 
	 * 
	 * @param x
	 * @param y
	 * @param rotate
	 */
	public void red(String rotate){
		

		
		if(rotate == "UP"){
			laser.shootDown();
		}
		
		else if(rotate == "RIGHT"){
			laser.shootLeft();
			
			
		}
		else if(rotate == "DOWN"){
			laser.shootUp();
			
			
		}
		else if(rotate == "LEFT"){
			laser.shootRight();
			
		}
		
		
		
	} // End red func
	
	/**
	 * Features of target token in the game board
	 * 
	 * Can be used as a target, a mirror, or both. 
	 * Only the transparent red side of the token 
	 * is a valid target. 
	 * 
	 * @param rotate
	 */
	public void target(String rotate){
		
		HitDirection hitDirection = checkHitDirection();
		
		
		
	} // End target func
	
	/**
	 * Features of blue token in the game board
	 * 
	 * Both sides of this token reflect the beam 90 degrees.
	 */
	public void blue(int x, int y, String rotate){
		
	} // End blue func
	
	/**
	 * Features of green token in the game board
	 * 
	 * Splits the beam in two paths. One path is 
	 * reflected 90 degrees and the other path passes 
	 * straight through the token
	 */
	public void green(int x, int y, String rotate){
		
	}
	
	/**
	 * Features of yellow token in the game board
	 * 
	 * Serves as a token that the laser beam must pass through. 
	 * 
	 * @param x
	 * @param y
	 * @param rotate
	 */
	public void yellow(int x, int y, String rotate){
		
	}
	
	/**
	 * Features of yellow token in the game board
	 * 
	 * Prevents other tokens from being placed 
	 * in the cell which it inhabits. 
	 * This token will not block the path of the laser.
	 * 
	 * @param x
	 * @param y
	 */
	public void Black(int x, int y){
		
	}
	
	public HitDirection checkHitDirection(){
		
		HitDirection hitDirection = null;
		
		int px = laser.previousLocation.getX();
		int py = laser.previousLocation.getY();
		
		int cx = laser.currentLocation.getX();
		int cy = laser.currentLocation.getY();
		
		if(cy > py){
			hitDirection = HitDirection.UPtoDOWN;
		}
		else if(cy < py){
			hitDirection = HitDirection.DOWNtoUP;
		}
		else if(cx > px){
			hitDirection = HitDirection.LEFTtoRIGHT;
		}
		else if(cx < px){
			hitDirection = HitDirection.RIGHTtoLEFT;
		}
		
		return hitDirection;
		
		
		
	}
	
}
