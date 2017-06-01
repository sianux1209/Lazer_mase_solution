import java.util.HashMap;

import javax.swing.JLabel;

public class GameBoard {
	
	private JLabel[][] gameBoard;
	private RotatedIcon[][] rotatedIcon;
	private HashMap<Integer, RotatedIcon> boardToken;
	private JLabel selectedIcon;	// user selected token
	public static final int TABLE_SIZE = 5;
	
	/**
	 * selectedIcon getter
	 * @return
	 */
	public JLabel getSelectedIcon() {
		return selectedIcon;
	}

	/**
	 * selectedIcon setter
	 * @param selectedIcon
	 */
	public void setSelectedIcon(JLabel selectedIcon) {
		this.selectedIcon = selectedIcon;
	}
	
	/**
	 * set default gameboard conf
	 * @param gameBoard
	 */
	public GameBoard(JLabel... gameBoard){
		
		int i, j;

		this.gameBoard = new JLabel[TABLE_SIZE][TABLE_SIZE];
		this.rotatedIcon = new RotatedIcon[TABLE_SIZE][TABLE_SIZE];
		
		// Init game board
		int cnt = 0;
		for(i=0; i < this.gameBoard.length; i++){
			for(j=0; j<this.gameBoard[i].length;j++){
				this.gameBoard[i][j] = gameBoard[cnt];
				cnt++;
			}
		} // finish for control
		
		// Init token direction
		cnt = 0;
		for(i=0; i < this.rotatedIcon.length; i++){
			for(j=0; j<this.rotatedIcon[i].length;j++){
				this.rotatedIcon[i][j] = new RotatedIcon(this.gameBoard[i][j].getIcon());
				cnt++;
			}
			
		} // finish for control
		
		// Init board toke
		boardToken = new HashMap<Integer, RotatedIcon>();
		
		for(i=0; i < TABLE_SIZE; i++){
			for(j=0; j < TABLE_SIZE; j++){
				int hashcode = this.gameBoard[i][j].hashCode();
				boardToken.put(hashcode, this.rotatedIcon[i][j]);
			}
			
		}
				
	} // finish GameBoard constructor

	/**
	 * Check game board State
	 */
	public void checkGameBoard(){
		
		for(JLabel[] x : gameBoard){
			for(JLabel y : x){
				System.out.print(y.getIcon().toString() + "\t");
			}
			System.out.println();
		} // finish for control
		
	} // finish check GameBoard func
	
	
	/**
	 * Check token direction in game board
	 */
	public void checkTokenRotate(){
		
		for(RotatedIcon[] x : rotatedIcon){
			for(RotatedIcon y : x){
				System.out.print(y.getRotate().toString() + "\t");
			}
			System.out.println();
		} // finish for control
		
		
	} // finish check Token Roate
	

}
