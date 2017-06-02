

public class Solver {
	
	Laser laser;
	GameBoard gameBoard;
	Token token;
	
	public Solver(GameBoard gameBoard){
		this.gameBoard = gameBoard;
	}
	
	public void start() {
		// TODO Auto-generated method stub
		
		
		laser = new Laser(gameBoard);
		token = new Token(laser, gameBoard);
		
		if(laser.currentLocation == null)
			return;
		
		String tokenName = "";
		String rotate = "";
		
		int x;
		int y;
		
		final int LIMIT = 2;	// limit the laser shot
		int count=0;
		
		while(count < LIMIT){
			
			x = ( laser.currentLocation.getX() / 100 )-1;
			y = ( laser.currentLocation.getY() / 100 )-1;
			
			//System.out.println("[3] "+ laser.currentLocation);
			
			tokenName = gameBoard.gameBoard[y][x].getIcon().toString();	// Get token name
			rotate = gameBoard.gameBoard[y][x].getName();	// Get token rotate
			
			System.out.println("Current status >> [ " +  tokenName + "," + rotate 
								+ ", (" + x + "," + y + ") ]");
			
			if(tokenName == "Red.jpg"){
				token.red(rotate);
			}
			else if(tokenName == "Target.jpg"){
				token.target(rotate);
				
			}
			else if(tokenName == "Mirror.jpg"){
				
			}
			else if(tokenName == "Green.jpg"){
				
			}
			else if(tokenName == "Blue.jpg"){
				
			}
			else if(tokenName == "Yellow.jpg"){
				
			}
			else if(tokenName == "Black.jpg"){
					
			}

			// If laser is off, quit
			if(laser.condition == false)
				break;
			
			count++;
		}
		
		
		
		
	}

}
