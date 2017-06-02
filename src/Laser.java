import javax.swing.JLabel;

public class Laser {
	
	GameBoard gameBoard;
	CurrentLocation currentLocation;
	CurrentLocation previousLocation;
	boolean condition;
	
	/**
	 * Laser Constructor
	 * 
	 * @param gameBaord
	 */
	public Laser(GameBoard gameBaord){
		this.gameBoard = gameBaord;
		condition = true;
		
		JLabel start = findRedToken();
		
		if(start != null)
			currentLocation = new CurrentLocation(start.getX(), start.getY());
	}
	
	
	/**
	 * Look for red tokens at startup.
	 * 
	 * @return 
	 */
	public JLabel findRedToken(){
		
		boolean find = true;;
		
		for(int i=0; i<GameBoard.TABLE_SIZE; i++){
			for(int j=0; j<GameBoard.TABLE_SIZE; j++){
				
				if(gameBoard.gameBoard[i][j].getIcon().toString() == "Red.jpg"){
					return gameBoard.gameBoard[i][j];
				}
				
			} // End inner for
		} // End outer for
		
		
		System.out.println("[*]Not found Red token!!");
		return null;
		
	} // End findRedToken func
	
	
	
	/**
	 * The current location class of the laser
	 */
	public class CurrentLocation implements Cloneable{
		
		private int x;
		private int y;
		
		public CurrentLocation(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		public void setXY(int x, int y){
			this.x = x;
			this.y = y;
		}
		
		public int getX() {
			return x;
		}
		public void setX(int x) {
			this.x = x;
		}
		public int getY() {
			return y;
		}
		public void setY(int y) {
			this.y = y;
		}
		
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "Current Location >> [" + Integer.toString(x) + ", " + Integer.toString(y) + "]";
		}
		
		public Object clone() throws CloneNotSupportedException{
			return super.clone();
		}
		
	}
	
	
	/**
	 * shoot the laser upwards
	 */
	public void shootUp(){
		
		if(currentLocation == null)
			return;
		
		try{
			previousLocation = (CurrentLocation)currentLocation.clone();
		}catch(CloneNotSupportedException e){}
		
		int x = (currentLocation.getX() / 100 ) - 1;
		int y = (currentLocation.getY() / 100 ) - 2;
		
		while(y >= 0){

			//System.out.println(gameBoard.gameBoard[y][x].getIcon().toString());
			
			if(gameBoard.gameBoard[y][x].getIcon().toString() != "White.jpg"){
				currentLocation.setXY(gameBoard.gameBoard[y][x].getX(), gameBoard.gameBoard[y][x].getY());
				//System.out.println("[1] " + currentLocation);
				return;
				
			} // end if
			
			y--;
		} //end while
	
		currentLocation.setXY(x, y+1);
		//System.out.println("[2] "+ currentLocation);
		System.out.println("[*]Line over! (Shoot up)");
		condition = false;
		
	} // End shootUp func
	
	
	/**
	 * shoot the laser down
	 */
	public void shootDown(){
		
		if(currentLocation == null)
			return;
		
		try{
			previousLocation = (CurrentLocation)currentLocation.clone();
		}catch(CloneNotSupportedException e){}
		
		int x = (currentLocation.getX() / 100) -1 ; //
		int y = currentLocation.getY() / 100;
		
		
		
		while(y < GameBoard.TABLE_SIZE){
			
			
			//System.out.println("[4] " + currentLocation);
			//System.out.println(gameBoard.gameBoard[y][x].getIcon().toString());
			
			if(gameBoard.gameBoard[y][x].getIcon().toString() != "White.jpg"){
				currentLocation.setXY(gameBoard.gameBoard[y][x].getX(), gameBoard.gameBoard[y][x].getY());
				//System.out.println("[1] " + currentLocation);
				return;
			} // end if
			
			y++;
		} // end while
		
		currentLocation.setXY(x, y-1);
		//System.out.println("[2] "+ currentLocation);
		System.out.println("[*]Line over! (Shoot down)");
		condition = false;
	
	} //End shootDown func
	
	
	/**
	 * Shoot the laser left
	 */
	public void shootLeft(){
		
		if(currentLocation == null)
			return;
		
		try{
			previousLocation = (CurrentLocation)currentLocation.clone();
		}catch(CloneNotSupportedException e){}
		
		int x = (currentLocation.getX() / 100 ) - 2;
		int y = (currentLocation.getY() / 100 ) - 1;
		
		while(x >= 0){

			//System.out.println(gameBoard.gameBoard[y][x].getIcon().toString());
			
			if(gameBoard.gameBoard[y][x].getIcon().toString() != "White.jpg"){
				currentLocation.setXY(gameBoard.gameBoard[y][x].getX(), gameBoard.gameBoard[y][x].getY());
				//System.out.println("[1] " + currentLocation);
				return;
				
			} // end if
			
			x--;
		} //end while
	
		currentLocation.setXY(x+1, y);
		//System.out.println("[2] "+ currentLocation);
		System.out.println("[*]Line over! (Shoot left)");
		condition = false;
		
	} // End shootLeft func
	
	public void shootRight(){
		
		if(currentLocation == null)
			return;
		
		try{
			previousLocation = (CurrentLocation)currentLocation.clone();
		}catch(CloneNotSupportedException e){}
		
		int x = (currentLocation.getX() / 100); //
		int y = (currentLocation.getY() / 100) -1;
		
		while(x < GameBoard.TABLE_SIZE){
			
			//System.out.println("[4] " + currentLocation);
			//System.out.println(gameBoard.gameBoard[y][x].getIcon().toString());
			
			if(gameBoard.gameBoard[y][x].getIcon().toString() != "White.jpg"){
				currentLocation.setXY(gameBoard.gameBoard[y][x].getX(), gameBoard.gameBoard[y][x].getY());
				//System.out.println("[1] " + currentLocation);
				return;
			} // end if
			
			x++;
		} // end while
		
		currentLocation.setXY(x-1, y);
		//System.out.println("[2] "+ currentLocation);
		System.out.println("[*]Line over! (Shoot right)");
		condition = false;
		
	} // end shootRight func
	
	
	
	
	
	
	

}
