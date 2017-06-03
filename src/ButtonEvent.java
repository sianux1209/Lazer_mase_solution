import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

public class ButtonEvent {

	private Init init;
	private GameBoard gameBoard;
	private Direction direction;
	private Laser laser;
	private Solver solver;

	/**
	 * set init and gameBoard
	 * 
	 * @param init
	 * @param gameBoard
	 */
	public ButtonEvent(Init init, GameBoard gameBoard) {
		this.init = init;
		this.gameBoard = gameBoard;
		this.direction = new Direction();
		this.solver = new Solver(gameBoard);
		
	}

	/**
	 * Check the user-clicked button and execute the function
	 * 
	 * @param JButton
	 */
	public void action(JButton jb, Init init, GameBoard gameBoard) {
		
		

		if (jb.getIcon().toString().equals("Start.jpg")) {
			
			//gameBoard.checkGameBoard();
			
			System.out.println();
			
			start();
			gameBoard.checkRotate();
			
			System.out.println();
			

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
	 * Start the algorithm and find a solution
	 */
	public void start() {
		System.out.println("Act the start");
		
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
		
		
		solver.start();

	} // finish start func

	/**
	 * clear the Game board
	 */
	public void clear() {
		System.out.println("Act the clear");

		for (int i = 0; i < GameBoard.TABLE_SIZE; i++) {
			for (int j = 0; j < GameBoard.TABLE_SIZE; j++) {
				gameBoard.gameBoard[i][j].setIcon(new ImageIcon("White.jpg"));
				gameBoard.gameBoard[i][j].setName(null);
			} // inner for
		} // end outer for
		
	} // finish clear func

	/**
	 * shot the laser
	 */
	public void laser() {
		System.out.println("Act the laser");

	} // finish laser func

	/**
	 * Rotate the token to the left
	 */
	public void left() {

		System.out.println("Act the left");
		direction.turnLeft(gameBoard);
	}

	/**
	 * Rotate the token to the right
	 */
	public void right() {
		System.out.println("Act the rightt");
		direction.turnRight(gameBoard);

	}
}
//