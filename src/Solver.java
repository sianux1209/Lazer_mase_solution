import java.util.ArrayList;
import java.util.Random;

public class Solver {

	private final static String randomRotate[] = { "UP", "RIGHT", "DOWN", "LEFT" };

	GameBoard gameBoard;
	Token token;
	Random random = new Random();
	private ArrayList<Laser> laser = new ArrayList<Laser>();

	public Solver(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}

	public ArrayList<Laser> getLaser() {
		return laser;
	}

	public void start() {
		// TODO Auto-generated method stub

		laser.clear(); // Delete previous record
		laser.add(new Laser(gameBoard)); // set default laser
		token = new Token(gameBoard);

		checkYellowToken();

		if (laser.get(0).currentLocation == null)
			return;

		String tokenName = "";
		String rotate = "";

		int x;
		int y;

		final int LIMIT = 50; // limit the laser shot
		int count = 0;

		int laserNumber;
		int laserCount;

		// The laser can shoot only LIMIT times.
		while (count < LIMIT) {

			laserNumber = 0;
			laserCount = laser.size();

			if (laser.get(laserNumber).isCondition() == true) {

				// When the laser is split, both lasers operate.
				while (laserNumber < laserCount) {

					x = laser.get(laserNumber).currentLocation.getX();
					y = laser.get(laserNumber).currentLocation.getY();

					tokenName = gameBoard.gameBoard[y][x].getIcon().toString(); // Get
																				// token
																				// name
					rotate = gameBoard.gameBoard[y][x].getName(); // Get token
																	// rotate

					System.out.println(
							"[*]Current status >> [ " + tokenName + ", " + rotate + ", (" + x + "," + y + ") ]");

					if (tokenName == "Red.jpg") {
						token.red(laser.get(laserNumber), rotate);
					} // End red token

					else if (tokenName == "Target.jpg") {
						token.target(laser.get(laserNumber), rotate);

						// Chack the GameClearFlag;
						if (laser.get(laserNumber).isSuccess() == true) {
							System.out.println("[*]Found solve!!");
							laser.get(laserNumber).setCondition(false);
							// printResult();
							// return;
						} // end if

					} // End target token

					else if (tokenName == "Mirror.jpg") {
						token.mirror(laser.get(laserNumber), rotate);

					} // End mirror token

					else if (tokenName == "Green.jpg") {
						token.green(laser.get(laserNumber), rotate, this);

					} // End green token

					else if (tokenName == "Blue.jpg") {
						token.blue(laser.get(laserNumber), rotate);

					} // End blue token

					else if (tokenName == "Yellow.jpg") {
						token.yellow(laser.get(laserNumber), rotate);
					} // End yellow token

					else if (tokenName == "Black.jpg") {
						token.Black(laser.get(laserNumber));
					} // End black token

					else if (tokenName == "RedR.jpg") {
						rotate = getRandomRotate();
						token.red(laser.get(laserNumber), rotate);
					}

					/*
					// If laser is off, quit
					if (laser.get(laserNumber).isCondition() == false) {
						System.out.println("[*]Not found solve!!");
						// printResult();
						// return;
					}
					*/

					laserNumber++;
				}// end inner while

				
			} // End laser condition check (if) 

			count++;
		} // End outer while

		// CheckSolved();
		printResult();

	} // end start func

	private String getRandomRotate() {
		// TODO Auto-generated method stub
		return randomRotate[random.nextInt(4)];
	}

	/**
	 * Check if there is a yellow token on the game board.
	 */
	private void checkYellowToken() {
		// TODO Auto-generated method stub

		for (int i = 0; i < GameBoard.TABLE_SIZE; i++) {
			for (int j = 0; j < GameBoard.TABLE_SIZE; j++) {
				if (gameBoard.gameBoard[i][j].getIcon().toString().equals("Yellow.jpg")
						|| gameBoard.gameBoard[i][j].getIcon().toString().equals("YellowR.jpg")) {

					gameBoard.setYellowToken(false);

				} // End if

			} // End inner for

		} // End outer for

	} // End checkYellowToken func

	private boolean CheckSolved() {
		// TODO Auto-generated method stub

		int laserNumber = 0;
		int laserCount = laser.size();

		// When the laser is split, both lasers operate.
		while (laserNumber < laserCount) {

			if (laser.get(laserNumber).isSuccess() != true) {
				System.out.println("[*]Mission Fail.....");
				return false;

			}
		}

		System.out.println("[*]Mission complete!!");
		return true;

	}

	public void printResult() {
		int laserNumber = 0;
		int laserCount = laser.size();

		System.out.println("[*]CheckPoint(Yellow token) : " + gameBoard.isYellowToken());

		while (laserNumber < laserCount) {

			int saveLaserNumber = 0;
			int saveLaserCount = laser.get(laserNumber).saveLocation.size();

			System.out.print("[" + laserNumber + "]Result : ");

			while (saveLaserNumber < saveLaserCount) {

				System.out.print(laser.get(laserNumber).saveLocation.get(saveLaserNumber));

				if (saveLaserNumber < saveLaserCount - 1) {
					System.out.print(" >> ");
				} else {
					System.out.println();
				}

				saveLaserNumber++;

			} // End inner while

			laserNumber++;

		} // End outer while

	}

}
