import java.util.ArrayList;

/**
 * �������� ���� �� ������ ��üȭ�� Ŭ����
 */
public class Laser {

	GameBoard gameBoard;
	CurrentLocation currentLocation;	// �������� ���� ���
	CurrentLocation previousLocation;	// �������� ���� ���
	ArrayList<CurrentLocation> saveLocation;	// �������� ��ü ���
	private boolean condition = true; // �������� Ȱ��ȭ ����
	private boolean success = false;	// Ÿ�� ���� ����
	
	/**
	 * ������ ������
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
	 * �������� ��ġ�� �����ϴ� ����Ŭ����
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
	 * �������� ���� �߻��Ѵ�.
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
	 * �������� �Ʒ��� �߻��Ѵ�.
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
	 * �������� �������� �߻��Ѵ�.
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
	 * �������� ���������� �߻��Ѵ�.
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
	 * �������� ���鿡 �ε�����, ������ġ�� ������ġ�� ����.
	 * �� �ߺ��� �˻��Ѵ�.
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
