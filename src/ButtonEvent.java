import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * ��ư �̺�Ʈ�� ó���ϴ� Ŭ����
 * 
 */
public class ButtonEvent {
	
	final int LIMIT = Integer.MAX_VALUE;	//�ع� ã�� �ݺ� Ƚ��
	//int LIMIT = 1000;
	private Init init;
	private GameBoard gameBoard;
	private Direction direction;
	private PathTracer pathTracer;
	private TokenSetter tokenSetter;
	private LaserDrawer2 laserDrawer2;

	/**
	 * ���Ӻ��带 �ʱ�ȭ�Ѵ�.
	 * 
	 * @param init
	 * @param gameBoard
	 */
	public ButtonEvent(Init init, GameBoard gameBoard) {
		this.init = init;
		this.gameBoard = gameBoard;
		this.direction = new Direction();
		this.pathTracer = new PathTracer(gameBoard);
		this.laserDrawer2 = new LaserDrawer2(pathTracer.getLaser(), init);
		
		
	}

	/**
	 * ����ڰ� Ŭ���� ��ư�� �̺�Ʈ�� �����Ѵ�.
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
	 * ���� ��ư�� ������ ��, �߻��ϴ� �̺�Ʈ
	 * �˰����� �����ϰ� �ع��� ã�´�.
	 */
	public void start() {
		System.out.println("Act the start");
		
		gameBoard.setGameClear(false);
		this.tokenSetter = new TokenSetter(gameBoard);
		laserDrawer2.clear();
		
		
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
		pathTracer.getTokenCountWithoutBlack();
				
		while(gameBoard.isGameClear() == false){
			
			if (cnt > LIMIT || state == false ){
				break;
			}

			state = tokenSetter.setUserToken();
			pathTracer.start();
			
			cnt++;
			
		}
		
		
		pathTracer.printResult();
		pathTracer.printRandomToken();

	} // finish start func
	

	/**
	 * ���Ӻ��带 �ʱ�ȭ�Ѵ�.
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
		
		laserDrawer2.clear();
		pathTracer.getLaser().clear();

		
	} // finish clear func

	/**
	 * ������ ��θ� �׸���
	 */
	public void laser() {
		System.out.println("Act the laser");
		
		//new LaserDrawer(pathTracer.getLaser());
		new LaserDrawer2(pathTracer.getLaser(), init);
		laserDrawer2.start();
		

	} // finish laser func

	
	/**
	 * ���Ӻ����� �������� �������� ȸ����Ų��.
	 */
	public void left() {

		System.out.println("Act the left");
		direction.turnLeft(gameBoard);
	}

	/**
	 * ���Ӻ����� �������� ���������� ȸ����Ų��.
	 */
	public void right() {
		System.out.println("Act the rightt");
		direction.turnRight(gameBoard);
		
	}
}
//