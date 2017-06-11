import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import javax.swing.JLabel;

/**
 * 레이저의 경로를 추적한다
 *
 */
public class PathTracer {

	private final static String randomRotate[] = { "UP", "RIGHT", "DOWN", "LEFT" };

	GameBoard gameBoard;
	Token token;
	Random random = new Random();
	private ArrayList<Laser> laser = new ArrayList<Laser>();
	int tokenCount;
	int targetTokenCount;

	public PathTracer(GameBoard gameBoard) {
		this.gameBoard = gameBoard;
	}

	public ArrayList<Laser> getLaser() {
		return laser;
	}

	/**
	 * 경로추적을 시작한다.
	 */
	public void start() {
		// TODO Auto-generated method stub

		laser.clear(); // 이전의 레코드를 모두 제거한다.
		token = new Token(gameBoard);
		gameBoard.setGameClear(false); // 게임 클리어 상태를 초기화한다.
		findRedToken(); // 시작위치를 찾는다.
		checkYellowToken(); // 옐로우 토큰이 게임보드 상에 존재하는지 찾는다.
		getTokenCount(); // 토큰의 수를 카운트한다.

		// 레이저가 존재하지 않으면 추적을 끝낸다.
		if (laser.isEmpty() == true)
			return;

		setRandomTokenDirection(); // 랜덤 토큰의 방향을 지정한다.

		String tokenName = "";
		String rotate = "";

		int x;
		int y;

		int count = 0;

		int laserNumber;
		int laserCount;

		// 총 토큰의 개수에 따라 레이저의 발사 회수를 제한한다.
		while (count < tokenCount) {

			laserNumber = 0;
			laserCount = laser.size();

			// When the laser is split, both lasers operate.
			while (laserNumber < laserCount) {

				if (laser.get(laserNumber).isCondition() == true) {

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

						if (laser.get(laserNumber).isSuccess() == true) {
							// System.out.println("[*]Found target!!");
							laser.get(laserNumber).setCondition(false);

						} // end if

					} // End target token

					else if (tokenName == "Mirror.jpg") {
						token.mirror(laser.get(laserNumber), rotate);

						if (laser.get(laserNumber).isSuccess() == true) {
							// System.out.println("[*]Found target!!");
							laser.get(laserNumber).setCondition(false);

						} // end if

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
						token.red(laser.get(laserNumber), rotate);
					} // End RedR token

					else if (tokenName == "TargetR.jpg") {
						token.target(laser.get(laserNumber), rotate);
					} // End targetR token

					else if (tokenName == "MirrorR.jpg") {
						token.mirror(laser.get(laserNumber), rotate);
					} // End mirrorR token

					else if (tokenName == "GreenR.jpg") {
						token.green(laser.get(laserNumber), rotate, this);
					} // End greenR token

					else if (tokenName == "BlueR.jpg") {
						token.blue(laser.get(laserNumber), rotate);

					} // End blueR token

					else if (tokenName == "YellowR.jpg") {
						token.yellow(laser.get(laserNumber), rotate);
					}

				} // End laser condition check (if)
				laserNumber++;
			} // end inner while

			// 게임 클리어가 확인되면 경로 추적을 종료한다.
			checkGameClear();
			if (gameBoard.isGameClear() == true) {
				break;
			}
			count++;
		} // End outer while

	} // end start func

	/**
	 * 게임보드에 배치된 토큰의 수를 확인한다.
	 * 
	 * @return
	 */
	private void getTokenCount() {
		// TODO Auto-generated method stub

		int tokenCount = 0;
		int targetTokenCount = 0;

		for (JLabel[] y : gameBoard.gameBoard) {
			for (JLabel x : y) {
				if (!x.getIcon().toString().equals("White.jpg")) {
					tokenCount++;
				}
				if (x.getIcon().toString().equals("Target.jpg") || x.getIcon().toString().equals("TargetR.jpg")) {
					targetTokenCount++;

				}

			} // End inner for

		} // End outer for

		this.tokenCount = tokenCount;
		this.targetTokenCount = targetTokenCount;
	}

	private void setRandomTokenDirection() {
		// TODO Auto-generated method stub

		List<String> randomList = Arrays.asList(
				new String[] { "RedR.jpg", "TargetR.jpg", "MirrorR.jpg", "GreenR.jpg", "BlueR.jpg", "YellowR.jpg" });

		for (int x = 0; x < GameBoard.TABLE_SIZE; x++) {
			for (int y = 0; y < GameBoard.TABLE_SIZE; y++) {

				String tokenName = gameBoard.gameBoard[y][x].getIcon().toString();
				if (randomList.contains(tokenName)) {
					gameBoard.gameBoard[y][x].setName(getRandomRotate());
				} // end if
			} // end inner for

		} // end outer for

	}// end setRandomTokenDirection

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

	/**
	 * 게임이 클리어되었는지 확인한다.
	 */
	private void checkGameClear() {

		int laserNumber = 0;
		int laserCount = laser.size();


		// 총 레이저의 수와 Goal의 수가 다르면 실패
		if (laser.size() != Integer.parseInt(gameBoard.getNumberOfTargets().getText())) {
			//System.out.println("AAAA");
			return;
		}

		// 모든 토큰을 지나야 한다.
		if (checkPassAllToken() == false) {
			//System.out.println("BBBB");
			return;
		}

		// 타겟 토큰의 수가, 마지막 레이저 위치에서 타겟 토큰 수가 일치하여야 한다.
		if (checkTargeting() == false) {
			//System.out.println("CCCC");
			return;
		}

		// CheckPoint(Yellow) 토큰이 존재할 때, 통과하지 못하면 실패
		// 설명서 상에 노란색 토큰은 한개만 존재할 수 있다.
		if (gameBoard.isYellowToken() == false) {
			//System.out.println("DDDD");
			return;
		}

		// 하나의 레이저라도 실패하면, 해당 게임은 실패한 것으로 간주한다.
		while (laserNumber < laserCount) {

			if (laser.get(laserNumber).isSuccess() == false) {
				//System.out.println("EEEE");
				return;
			}

			laserNumber++;
		} // end while

		gameBoard.setGameClear(true);
	}

	

	/**
	 * 타겟 토큰의 수가, 마지막 레이저 위치에서 타겟 토큰 수가 일치하여야 한다.
	 * 
	 * @return
	 */
	private boolean checkTargeting() {
		// TODO Auto-generated method stub

		int laserNumber = 0;
		int laserCount = laser.size();

		int targeting = 0;

		while (laserNumber < laserCount) {

			int saveLaserSize = laser.get(laserNumber).saveLocation.size();

			// 레이저의 마지막 위치
			int x = laser.get(laserNumber).saveLocation.get(saveLaserSize - 1).getX();
			int y = laser.get(laserNumber).saveLocation.get(saveLaserSize - 1).getY();

			// 레이저 마지막 위치가 Target이면 카운트 증가
			if (gameBoard.gameBoard[y][x].getIcon().toString() == "Target.jpg"
					|| gameBoard.gameBoard[y][x].getIcon().toString() == "TargetR.jpg") {
				targeting++;
			}
			laserNumber++;

		} // End outer while

		//System.out.println("**********" + targeting + targetTokenCount);

		// 타겟 토큰의 수가, 마지막 레이저 위치에서 타겟 토큰 수가 일치하면 True
		if (targeting == targetTokenCount) {
			return true;
		}

		return false;
	}

	private boolean checkPassAllToken() {
		// TODO Auto-generated method stub

		HashSet<Laser.CurrentLocation> allPath = getAllPath();

		if (tokenCount == allPath.size()) {
			return true;
		}
		return false;

	}

	private HashSet<Laser.CurrentLocation> getAllPath() {

		int laserNumber = 0;
		int laserCount = laser.size();

		// 모든 경로를 저장한다.
		HashSet<Laser.CurrentLocation> allPath = new HashSet<Laser.CurrentLocation>();

		while (laserNumber < laserCount) {

			int saveLaserNumber = 0;
			int saveLaserCount = laser.get(laserNumber).saveLocation.size();

			while (saveLaserNumber < saveLaserCount) {

				allPath.add(laser.get(laserNumber).saveLocation.get(saveLaserNumber));

				saveLaserNumber++;

			} // End inner while

			// System.out.println("[" + laserNumber + "] :" +
			// laser.get(laserNumber).isCondition());
			laserNumber++;

		} // End outer while

		return allPath;

	};

	/**
	 * 결과를 출력한다.
	 */
	public void printResult() {
		int laserNumber = 0;
		int laserCount = laser.size();

		System.out.println();
		System.out.println("[*]CheckPoint(Yellow token) : " + gameBoard.isYellowToken());

		System.out.println("[*]GameClear : " + gameBoard.isGameClear());

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

			// System.out.println("[" + laserNumber + "] :" +
			// laser.get(laserNumber).isCondition());
			laserNumber++;

		} // End outer while

	} // End printResult func

	/**
	 * 시작 토큰(Red)를 검색한다.
	 * 
	 * @return
	 */
	public void findRedToken() {

		int x;
		int y;

		for (int i = 0; i < GameBoard.TABLE_SIZE; i++) {
			for (int j = 0; j < GameBoard.TABLE_SIZE; j++) {

				if (gameBoard.gameBoard[i][j].getIcon().toString() == "Red.jpg"
						|| gameBoard.gameBoard[i][j].getIcon().toString() == "RedR.jpg") {

					x = (gameBoard.gameBoard[i][j].getX() / 100) - 1;
					y = (gameBoard.gameBoard[i][j].getY() / 100) - 1;

					laser.add(new Laser(gameBoard, x, y));

				} // End if

			} // End inner for
		} // End outer for

		if (laser.isEmpty()) {
			System.out.println("[*]Not found Red token!!");

		}

	} // End findRedToken func

} // End class
