import java.util.ArrayList;

/**
 * 레이저의 상태 및 행위를 구체화한 클래스
 */
public class Laser {

	GameBoard gameBoard;
	CurrentLocation currentLocation;	// 레이저의 현재 경로
	CurrentLocation previousLocation;	// 레이저의 이전 경로
	ArrayList<CurrentLocation> saveLocation;	// 레이저의 전체 경로
	private boolean condition = true; // 레이저의 활성화 상태
	private boolean success = false;	// 타겟 도착 상태
	
	/**
	 * 레이저 생성자
	 * 
	 * @param gameBaord
	 * @param x
	 * @param y
	 */
	public Laser(GameBoard gameBaord, int x, int y){
		this.gameBoard = gameBaord;
		condition = true;
		saveLocation = new ArrayList<CurrentLocation>();

		currentLocation = new CurrentLocation(x, y);
		saveLocation.add(new CurrentLocation(x, y));
		
		previousLocation = saveLocation.get(0);
	}
	
	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}


	public boolean isCondition() {
		return condition;
	}

	public void setCondition(boolean condition) {
		this.condition = condition;
	}



	/**
	 * 레이저의 위치를 저장하는 내부클래스
	 */
	public class CurrentLocation implements Cloneable {

		private Integer x;
		private Integer y;

		public CurrentLocation(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public void setXY(int x, int y) {
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
			return "[" + Integer.toString(x) + ", " + Integer.toString(y) + "]";
		}

		@Override
		public Object clone() throws CloneNotSupportedException {
			return super.clone();
		}
		
		@Override
		public boolean equals(Object object){
			
			CurrentLocation diff = (CurrentLocation)object;
			
			if(getX() == diff.getX() && getY() == diff.getY()){
				return true;
			} // End if
			
			return false;
		} // End equals
		
		@Override
		public int hashCode(){
			String str = x.toString() + y.toString();
			
			return str.hashCode();
		}
		

	
	}  // End inner class
	
	/**
	 * 레이저를 위로 발사한다.
	 */
	public void shootUp() {
		//System.out.println("[*]shoot Up (" + currentLocation.getX() + ", " + currentLocation.getY() +")");

		try {
			if (currentLocation == null)
				return;

			previousLocation = (CurrentLocation) currentLocation.clone();
			
			int x = currentLocation.getX();
			int y = currentLocation.getY() - 1;
			
			while (y >= 0) {

				if (gameBoard.gameBoard[y][x].getIcon().toString() != "White.jpg") {
					currentLocation.setXY(x, y);
					
					if(TokenDuplicateCheck()){
						saveLocation.add((CurrentLocation) currentLocation.clone());
					}
					
					return;

				} // end if

				y--;
			} // end while

			currentLocation.setXY(x, y + 1);
			saveLocation.add((CurrentLocation) currentLocation.clone());

			//System.out.println("[*]Line over! (Shoot up)");
			condition = false;

		} catch (CloneNotSupportedException e) {
		}

	} // End shootUp func



	/**
	 * 레이저를 아래로 발사한다.
	 */
	public void shootDown() {
		//System.out.println("[*]shoot Down (" + currentLocation.getX() + ", " + currentLocation.getY() +")");

		try {

			if (currentLocation == null)
				return;

			previousLocation = (CurrentLocation) currentLocation.clone();

			int x = currentLocation.getX();
			int y = currentLocation.getY() + 1;
			

			while (y < GameBoard.TABLE_SIZE) {

				if (gameBoard.gameBoard[y][x].getIcon().toString() != "White.jpg") {
					currentLocation.setXY(x, y);
					
					
					
					if(TokenDuplicateCheck()){
						saveLocation.add((CurrentLocation) currentLocation.clone());
					}

					return;
				} // end if

				y++;
			} // end while

			currentLocation.setXY(x, y - 1);
			saveLocation.add((CurrentLocation) currentLocation.clone());

			//System.out.println("[*]Line over! (Shoot down)");
			condition = false;

		} catch (CloneNotSupportedException e) {
		}

	} // End shootDown func

	/**
	 * 레이저를 왼쪽으로 발사한다.
	 */
	public void shootLeft() {
		//System.out.println("[*]shoot Left (" + currentLocation.getX() + ", " + currentLocation.getY() +")");

		try {

			if (currentLocation == null)
				return;

			previousLocation = (CurrentLocation) currentLocation.clone();

			int x = currentLocation.getX() - 1;
			int y = currentLocation.getY();
			

			while (x >= 0) {

				// System.out.println(gameBoard.gameBoard[y][x].getIcon().toString());

				if (gameBoard.gameBoard[y][x].getIcon().toString() != "White.jpg") {
					currentLocation.setXY(x, y);
					
					if(TokenDuplicateCheck()){
						saveLocation.add((CurrentLocation) currentLocation.clone());
					}

					return;

				} // end if

				x--;
			} // end while

			currentLocation.setXY(x + 1, y);
			saveLocation.add((CurrentLocation) currentLocation.clone());

			//System.out.println("[*]Line over! (Shoot left)");
			condition = false;

		} catch (CloneNotSupportedException e) {
		}

	} // End shootLeft func

	/**
	 * 레이저를 오른쪽으로 발사한다.
	 */
	public void shootRight() {
		//System.out.println("[*]shoot Right (" + currentLocation.getX() + ", " + currentLocation.getY() +")");

		try {
			if (currentLocation == null)
				return;

			previousLocation = (CurrentLocation) currentLocation.clone();

			int x = currentLocation.getX() + 1; //
			int y = currentLocation.getY();
			
			while (x < GameBoard.TABLE_SIZE) {

				// System.out.println("[4] " + currentLocation);
				// System.out.println(gameBoard.gameBoard[y][x].getIcon().toString());

				if (gameBoard.gameBoard[y][x].getIcon().toString() != "White.jpg") {

					currentLocation.setXY(x, y);
					
					if(TokenDuplicateCheck()){
						saveLocation.add((CurrentLocation) currentLocation.clone());
					}
					
					return;
				} // end if

				x++;
			} // end while

			currentLocation.setXY(x - 1, y);
			saveLocation.add((CurrentLocation) currentLocation.clone());

			//System.out.println("[*]Line over! (Shoot right)");
			condition = false;

		} catch (CloneNotSupportedException e) {
		}

	} // end shootRight func
	
	/**
	 * 레이저가 벽면에 부딪히면, 현재위치가 이전위치가 같다.
	 * 그 중복을 검사한다.
	 * @return
	 */
	private boolean TokenDuplicateCheck() {
		// TODO Auto-generated method stub
		
		if (previousLocation.toString().equals(currentLocation.toString())){
			setCondition(false);
			return false;
		}
		
		return true;
		
	}

}
