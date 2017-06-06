import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * 버튼 이벤트를 처리하는 클래스
 * 
 */
public class ButtonEvent {
	
	final int LIMIT = 10000000;	//해법 찾기 반복 횟수

	private Init init;
	private GameBoard gameBoard;
	private Direction direction;
	private PathTracer pathTracer;
	private TokenSetter tokenSetter;

	/**
	 * 게임보드를 초기화한다.
	 * 
	 * @param init
	 * @param gameBoard
	 */
	public ButtonEvent(Init init, GameBoard gameBoard) {
		this.init = init;
		this.gameBoard = gameBoard;
		this.direction = new Direction();
		this.pathTracer = new PathTracer(gameBoard);
		
		
	}

	/**
	 * 사용자가 클릭한 버튼의 이벤트를 실행한다.
	 * 
	 * @param JButton
	 * @param gameBoard
	 */
	public void action(JButton jb) {
		
		if (jb.getIcon().toString().equals("Start.jpg")) {
		
			start();
			
			gameBoard.checkGameBoard();
			//gameBoard.checkRotate();
			

		} else if (jb.getIcon().toString().equals("Clear.jpg")) {
			clear();

		} else if (jb.getIcon().toString().equals("Laser.jpg")) {
			laser();

		} else if (jb.getIcon().toString().equals("Left.jpg")) {
			left();

		} else if (jb.getIcon().toString().equals("Right.jpg")) {
			right();

		}
	}

	/**
	 * 시작 버튼을 눌럿을 때, 발생하는 이벤트
	 * 알고리즘을 시작하고 해법을 찾는다.
	 */
	public void start() {
		System.out.println("Act the start");
		
		gameBoard.setGameClear(false);
		this.tokenSetter = new TokenSetter(gameBoard);
		
		
		
		// trouble shooting
		// if there is token but the directions is null, initialize it
		for (int i = 0; i < GameBoard.TABLE_SIZE; i++) {
			for (int j = 0; j < GameBoard.TABLE_SIZE; j++) {
				String token = gameBoard.gameBoard[i][j].getIcon().toString();
				String rotate = gameBoard.gameBoard[i][j].getName();

				if (!token.equals("White.jpg") && rotate == null) {
					gameBoard.gameBoard[i][j].setName("UP");
				}

			}
		} // end trouble shooting
		
		
		
		
		int cnt = 0;
		boolean state = true;
		
		state = tokenSetter.setUserToken();
		init.checkTargets();
				
		while(gameBoard.isGameClear() == false){
			
			if (cnt > LIMIT || state == false ){
				break;
			}

			state = tokenSetter.setUserToken();
			pathTracer.start();
			
			cnt++;
			
		}
		
		
		pathTracer.printResult();

	} // finish start func
	

	/**
	 * 게임보드를 초기화한다.
	 */
	public void clear() {
		System.out.println("Act the clear");

		for (int i = 0; i < GameBoard.TABLE_SIZE; i++) {
			for (int j = 0; j < GameBoard.TABLE_SIZE; j++) {
				gameBoard.gameBoard[i][j].setIcon(new ImageIcon("White.jpg"));
				gameBoard.gameBoard[i][j].setName(null);
				gameBoard.gameBoard[i][j].setBorder(null);
			} // end inner for
		} // end outer for
		
	} // finish clear func

	/**
	 * 레이저 경로를 그린다
	 */
	public void laser() {
		System.out.println("Act the laser");
		
		new LaserDrawer(pathTracer.getLaser());
		

	} // finish laser func

	
	/**
	 * 게임보드의 아이콘을 왼쪽으로 회전시킨다.
	 */
	public void left() {

		System.out.println("Act the left");
		direction.turnLeft(gameBoard);
	}

	/**
	 * 게임보드의 아이콘을 오른쪽으로 회전시킨다.
	 */
	public void right() {
		System.out.println("Act the rightt");
		direction.turnRight(gameBoard);
		
	}
}
//