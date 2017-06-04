import javax.swing.JLabel;

public class Token {

	public GameBoard gameBoard;

	public Token(GameBoard gameBoard) {

		this.gameBoard = gameBoard;

	}

	public enum HitDirection {
		UPtoDOWN, RIGHTtoLEFT, DOWNtoUP, LEFTtoRIGHT
	}

	/**
	 * Features of red token in the game board
	 * 
	 * Provides the laser beam. Push the button at the top of this token to
	 * engage the beam.
	 * 
	 * @param x
	 * @param y
	 * @param rotate
	 */
	public void red(Laser laser, String rotate) {
		System.out.println("[*]red (" + laser.currentLocation.getX() + ", " + laser.currentLocation.getY() + ")");

		//Red tokens only work the first time.
		if (laser.saveLocation.size() == 1) {

			if (rotate == "UP") {
				laser.shootDown();
			}

			else if (rotate == "RIGHT") {
				laser.shootLeft();

			} else if (rotate == "DOWN") {
				laser.shootUp();

			} else if (rotate == "LEFT") {
				laser.shootRight();

			}
		} // end if
		
		else{
			laser.setCondition(false);
		}

	} // End red func

	/**
	 * Features of target token in the game board
	 * 
	 * Can be used as a target, a mirror, or both. Only the transparent red side
	 * of the token is a valid target.
	 * 
	 * @Param laser
	 * @param rotate
	 */
	public void target(Laser laser, String rotate) {
		System.out.println("[*]target (" + laser.currentLocation.getX() + ", " + laser.currentLocation.getY() + ")");

		HitDirection hitDirection = checkHitDirection(laser);

		if (rotate == "UP") {

			if (hitDirection == HitDirection.DOWNtoUP) {
				laser.setSuccess(true);
				laser.setCondition(false);
			} // end inner if

			else if (hitDirection == HitDirection.LEFTtoRIGHT) {
				laser.setSuccess(false);
				laser.setCondition(false);
			} // end inner if

			else if (hitDirection == HitDirection.UPtoDOWN) {
				laser.shootRight();
			} // end inner if

			else if (hitDirection == HitDirection.RIGHTtoLEFT) {
				laser.shootUp();
			} // end inner if

		} // end outer if

		if (rotate == "RIGHT") {

			if (hitDirection == HitDirection.DOWNtoUP) {
				laser.shootRight();

			} // end inner if
			else if (hitDirection == HitDirection.LEFTtoRIGHT) {
				laser.setSuccess(true);
				laser.setCondition(false);

			} // end inner if
			else if (hitDirection == HitDirection.UPtoDOWN) {
				laser.setSuccess(false);
				laser.setCondition(false);

			} // end inner if
			else if (hitDirection == HitDirection.RIGHTtoLEFT) {
				laser.shootDown();

			} // end inner if

		} // end outer if
		if (rotate == "DOWN") {

			if (hitDirection == HitDirection.DOWNtoUP) {
				laser.shootLeft();

			} // end inner if
			else if (hitDirection == HitDirection.LEFTtoRIGHT) {
				laser.shootDown();

			} // end inner if
			else if (hitDirection == HitDirection.UPtoDOWN) {
				laser.setSuccess(true);
				laser.setCondition(false);

			} // end inner if
			else if (hitDirection == HitDirection.RIGHTtoLEFT) {
				laser.setSuccess(false);
				laser.setCondition(false);

			} // end inner if

		} // end outer if
		if (rotate == "LEFT") {

			if (hitDirection == HitDirection.DOWNtoUP) {
				laser.setSuccess(false);
				laser.setCondition(false);

			} // end inner if
			else if (hitDirection == HitDirection.LEFTtoRIGHT) {
				laser.shootUp();

			} // end inner if
			else if (hitDirection == HitDirection.UPtoDOWN) {
				laser.shootLeft();

			} // end inner if
			else if (hitDirection == HitDirection.RIGHTtoLEFT) {
				laser.setSuccess(true);
				laser.setCondition(false);

			} // end inner if

		} // end outer if

	} // End target func

	/**
	 * Features of blue token in the game board
	 * 
	 * Both sides of this token reflect the beam 90 degrees.
	 * 
	 * @Param laser
	 * @param rotate
	 */
	public void blue(Laser laser, String rotate) {
		System.out.println("[*]blue (" + laser.currentLocation.getX() + ", " + laser.currentLocation.getY() + ")");

		HitDirection hitDirection = checkHitDirection(laser);

		if (rotate == "UP") {

			if (hitDirection == HitDirection.DOWNtoUP) {
				laser.shootLeft();
			} // end inner if

			else if (hitDirection == HitDirection.LEFTtoRIGHT) {
				laser.shootDown();
			} // end inner if

			else if (hitDirection == HitDirection.UPtoDOWN) {
				laser.shootRight();
			} // end inner if

			else if (hitDirection == HitDirection.RIGHTtoLEFT) {
				laser.shootUp();
			} // end inner if

		} // end outer if

		if (rotate == "RIGHT") {

			if (hitDirection == HitDirection.DOWNtoUP) {
				laser.shootRight();

			} // end inner if
			else if (hitDirection == HitDirection.LEFTtoRIGHT) {
				laser.shootUp();

			} // end inner if
			else if (hitDirection == HitDirection.UPtoDOWN) {
				laser.shootLeft();

			} // end inner if
			else if (hitDirection == HitDirection.RIGHTtoLEFT) {
				laser.shootDown();

			} // end inner if

		} // end outer if
		if (rotate == "DOWN") {

			if (hitDirection == HitDirection.DOWNtoUP) {
				laser.shootLeft();

			} // end inner if
			else if (hitDirection == HitDirection.LEFTtoRIGHT) {
				laser.shootDown();

			} // end inner if
			else if (hitDirection == HitDirection.UPtoDOWN) {
				laser.shootLeft();

			} // end inner if
			else if (hitDirection == HitDirection.RIGHTtoLEFT) {
				laser.shootUp();

			} // end inner if

		} // end outer if
		if (rotate == "LEFT") {

			if (hitDirection == HitDirection.DOWNtoUP) {
				laser.shootRight();

			} // end inner if
			else if (hitDirection == HitDirection.LEFTtoRIGHT) {
				laser.shootUp();

			} // end inner if
			else if (hitDirection == HitDirection.UPtoDOWN) {
				laser.shootLeft();

			} // end inner if
			else if (hitDirection == HitDirection.RIGHTtoLEFT) {
				laser.shootDown();

			} // end inner if

		} // end outer if

	} // End blue func

	/**
	 * Features of green token in the game board
	 * 
	 * Splits the beam in two paths. One path is reflected 90 degrees and the
	 * other path passes straight through the token
	 * 
	 * @Param laser
	 * @param rotate
	 */
	public Laser green(Laser laser, String rotate, PathTracer solver) {
		System.out.println("[*]green (" + laser.currentLocation.getX() + ", " + laser.currentLocation.getY() + ")");

		int x = laser.currentLocation.getX();
		int y = laser.currentLocation.getY();

		Laser splitLaser = new Laser(gameBoard, x, y);
		solver.getLaser().add(splitLaser);

		HitDirection hitDirection = checkHitDirection(laser);

		if (rotate == "UP") {

			if (hitDirection == HitDirection.DOWNtoUP) {
				laser.shootUp();
				splitLaser.shootLeft();
			} // end inner if

			else if (hitDirection == HitDirection.LEFTtoRIGHT) {
				laser.shootRight();
				splitLaser.shootDown();
			} // end inner if

			else if (hitDirection == HitDirection.UPtoDOWN) {
				laser.shootDown();
				splitLaser.shootRight();
			} // end inner if

			else if (hitDirection == HitDirection.RIGHTtoLEFT) {
				laser.shootLeft();
				splitLaser.shootUp();
			} // end inner if

		} // end outer if

		if (rotate == "RIGHT") {

			if (hitDirection == HitDirection.DOWNtoUP) {
				laser.shootUp();
				splitLaser.shootRight();

			} // end inner if
			else if (hitDirection == HitDirection.LEFTtoRIGHT) {
				laser.shootRight();
				splitLaser.shootUp();

			} // end inner if
			else if (hitDirection == HitDirection.UPtoDOWN) {
				laser.shootDown();
				splitLaser.shootLeft();

			} // end inner if
			else if (hitDirection == HitDirection.RIGHTtoLEFT) {
				laser.shootLeft();
				splitLaser.shootDown();

			} // end inner if

		} // end outer if
		if (rotate == "DOWN") {

			if (hitDirection == HitDirection.DOWNtoUP) {
				laser.shootUp();
				splitLaser.shootLeft();

			} // end inner if
			else if (hitDirection == HitDirection.LEFTtoRIGHT) {
				laser.shootRight();
				splitLaser.shootDown();

			} // end inner if
			else if (hitDirection == HitDirection.UPtoDOWN) {
				laser.shootDown();
				splitLaser.shootLeft();

			} // end inner if
			else if (hitDirection == HitDirection.RIGHTtoLEFT) {
				laser.shootLeft();
				splitLaser.shootUp();

			} // end inner if

		} // end outer if
		if (rotate == "LEFT") {

			if (hitDirection == HitDirection.DOWNtoUP) {
				laser.shootUp();
				splitLaser.shootRight();

			} // end inner if
			else if (hitDirection == HitDirection.LEFTtoRIGHT) {
				laser.shootRight();
				splitLaser.shootUp();

			} // end inner if
			else if (hitDirection == HitDirection.UPtoDOWN) {
				laser.shootDown();
				splitLaser.shootLeft();

			} // end inner if
			else if (hitDirection == HitDirection.RIGHTtoLEFT) {
				laser.shootLeft();
				splitLaser.shootDown();

			} // end inner if

		} // end outer if

		return splitLaser;
	}

	/**
	 * Features of yellow token in the game board
	 * 
	 * Serves as a token that the laser beam must pass through.
	 * 
	 * @Param laser
	 * @param rotate
	 */
	public void yellow(Laser laser, String rotate) {
		System.out.println("[*]yellow (" + laser.currentLocation.getX() + ", " + laser.currentLocation.getY() + ")");

		HitDirection hitDirection = checkHitDirection(laser);

		if (rotate == "UP") {

			if (hitDirection == HitDirection.DOWNtoUP) {

			} // end inner if

			else if (hitDirection == HitDirection.LEFTtoRIGHT) {
				laser.shootRight();
				gameBoard.setYellowToken(true);
			} // end inner if

			else if (hitDirection == HitDirection.UPtoDOWN) {

			} // end inner if

			else if (hitDirection == HitDirection.RIGHTtoLEFT) {
				laser.shootLeft();
				gameBoard.setYellowToken(true);
			} // end inner if

		} // end outer if

		if (rotate == "RIGHT") {

			if (hitDirection == HitDirection.DOWNtoUP) {
				laser.shootUp();
				gameBoard.setYellowToken(true);

			} // end inner if
			else if (hitDirection == HitDirection.LEFTtoRIGHT) {

			} // end inner if
			else if (hitDirection == HitDirection.UPtoDOWN) {
				laser.shootDown();
				gameBoard.setYellowToken(true);

			} // end inner if
			else if (hitDirection == HitDirection.RIGHTtoLEFT) {
				laser.shootDown();

			} // end inner if

		} // end outer if
		if (rotate == "DOWN") {

			if (hitDirection == HitDirection.DOWNtoUP) {

			} // end inner if

			else if (hitDirection == HitDirection.LEFTtoRIGHT) {
				laser.shootRight();
				gameBoard.setYellowToken(true);
			} // end inner if

			else if (hitDirection == HitDirection.UPtoDOWN) {

			} // end inner if

			else if (hitDirection == HitDirection.RIGHTtoLEFT) {
				laser.shootLeft();
				gameBoard.setYellowToken(true);
			} // end inner if

		} // end outer if
		if (rotate == "LEFT") {

			if (hitDirection == HitDirection.DOWNtoUP) {
				laser.shootUp();
				gameBoard.setYellowToken(true);

			} // end inner if
			else if (hitDirection == HitDirection.LEFTtoRIGHT) {

			} // end inner if
			else if (hitDirection == HitDirection.UPtoDOWN) {
				laser.shootDown();
				gameBoard.setYellowToken(true);

			} // end inner if
			else if (hitDirection == HitDirection.RIGHTtoLEFT) {
				laser.shootDown();

			} // end inner if

		} // end outer if

	}

	/**
	 * Features of mirror token in the game board
	 * 
	 * Only the transparent red side of the token is a valid target.
	 * 
	 * @param laser
	 * @param rotate
	 */
	public void mirror(Laser laser, String rotate) {
		System.out.println("[*]mirror (" + laser.currentLocation.getX() + ", " + laser.currentLocation.getY() + ")");

		HitDirection hitDirection = checkHitDirection(laser);

		if (rotate == "UP") {

			if (hitDirection == HitDirection.DOWNtoUP) {

			} // end inner if

			else if (hitDirection == HitDirection.LEFTtoRIGHT) {

			} // end inner if

			else if (hitDirection == HitDirection.UPtoDOWN) {
				laser.shootRight();
			} // end inner if

			else if (hitDirection == HitDirection.RIGHTtoLEFT) {
				laser.shootUp();
			} // end inner if

		} // end outer if

		if (rotate == "RIGHT") {

			if (hitDirection == HitDirection.DOWNtoUP) {
				laser.shootRight();

			} // end inner if
			else if (hitDirection == HitDirection.LEFTtoRIGHT) {

			} // end inner if
			else if (hitDirection == HitDirection.UPtoDOWN) {

			} // end inner if
			else if (hitDirection == HitDirection.RIGHTtoLEFT) {
				laser.shootDown();

			} // end inner if

		} // end outer if
		if (rotate == "DOWN") {

			if (hitDirection == HitDirection.DOWNtoUP) {
				laser.shootLeft();

			} // end inner if
			else if (hitDirection == HitDirection.LEFTtoRIGHT) {
				laser.shootDown();

			} // end inner if
			else if (hitDirection == HitDirection.UPtoDOWN) {

			} // end inner if
			else if (hitDirection == HitDirection.RIGHTtoLEFT) {

			} // end inner if

		} // end outer if
		if (rotate == "LEFT") {

			if (hitDirection == HitDirection.DOWNtoUP) {

			} // end inner if
			else if (hitDirection == HitDirection.LEFTtoRIGHT) {
				laser.shootUp();

			} // end inner if
			else if (hitDirection == HitDirection.UPtoDOWN) {
				laser.shootLeft();

			} // end inner if
			else if (hitDirection == HitDirection.RIGHTtoLEFT) {

			} // end inner if

		} // end outer if

	} // End mirror func

	/**
	 * Features of yellow token in the game board
	 * 
	 * Prevents other tokens from being placed in the cell which it inhabits.
	 * This token will not block the path of the laser.
	 * 
	 * @param Laser
	 */
	public void Black(Laser laser) {
		System.out.println("[*]black (" + laser.currentLocation.getX() + ", " + laser.currentLocation.getY() + ")");

		HitDirection hitDirection = checkHitDirection(laser);

		if (hitDirection == HitDirection.DOWNtoUP) {
			laser.shootUp();

		} // end if
		else if (hitDirection == HitDirection.LEFTtoRIGHT) {
			laser.shootRight();

		} // end if
		else if (hitDirection == HitDirection.UPtoDOWN) {
			laser.shootDown();

		} // end if
		else if (hitDirection == HitDirection.RIGHTtoLEFT) {
			laser.shootLeft();

		} // end if

	} // End black func

	public HitDirection checkHitDirection(Laser laser) {

		HitDirection hitDirection = null;

		int px = laser.previousLocation.getX();
		int py = laser.previousLocation.getY();

		int cx = laser.currentLocation.getX();
		int cy = laser.currentLocation.getY();

		if (cy > py) {
			hitDirection = HitDirection.UPtoDOWN;
		} else if (cy < py) {
			hitDirection = HitDirection.DOWNtoUP;
		} else if (cx > px) {
			hitDirection = HitDirection.LEFTtoRIGHT;
		} else if (cx < px) {
			hitDirection = HitDirection.RIGHTtoLEFT;
		}

		return hitDirection;

	}

}
