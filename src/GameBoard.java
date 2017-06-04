import javax.swing.JLabel;
import javax.swing.JTextField;

public class GameBoard {
	
	public JLabel[][] gameBoard;
	public JTextField[] userInput;
	private JLabel selectedLabel;	// user selected token
	public static final int TABLE_SIZE = 5;
	private boolean yellowToken = true;
	private boolean gameClear = false;
	JLabel numberOfTargets;
	
	/**
	 * set default gameboard conf
	 * @param gameBoard
	 */
	public GameBoard(JLabel... gameBoard){
		
		int i, j;

		this.gameBoard = new JLabel[TABLE_SIZE][TABLE_SIZE];
		
		
		// Init game board
		int cnt = 0;
		for(i=0; i < this.gameBoard.length; i++){
			for(j=0; j<this.gameBoard[i].length;j++){
				this.gameBoard[i][j] = gameBoard[cnt];
				cnt++;
			}
		} // finish "for" control
				
	} // finish GameBoard constructor
	
	public void setUserInput(JTextField... userInput){
		
		final int fieldCount = 6;
		this.userInput = new JTextField[fieldCount];
		
		for(int i=0; i< fieldCount; i++){
			this.userInput[i] = userInput[i];
		}
	}
	
	public boolean isGameClear() {
		return gameClear;
	}
	
	
	public void setGameClear(boolean gameClear) {
		this.gameClear = gameClear;
	}
	
	
	public boolean isYellowToken() {
		return yellowToken;
	}



	public void setYellowToken(boolean yellowToken) {
		this.yellowToken = yellowToken;
	}
	


	/**
	 * selectedIcon getter
	 * @return
	 */
	public JLabel getSelectedLabel() {
		return this.selectedLabel;
	}

	/**
	 * selectedIcon setter
	 * @param selectedILabel
	 */
	public void setSelectedLabel(JLabel selectedILabel) {
		this.selectedLabel = selectedILabel;
	}


	/**
	 * Check game board State
	 */
	public void checkGameBoard(){
		System.out.println();
		
		for(JLabel[] x : gameBoard){
			for(JLabel y : x){
				System.out.print(y.getIcon().toString() + "\t");
			}
			System.out.println();
		} // finish for control
		
		System.out.println();
		
	} // finish check GameBoard func

	public void checkRotate() {
		// TODO Auto-generated method stub
		
		System.out.println();
		for(int i=0; i<TABLE_SIZE;i++){
			for(int j=0; j<TABLE_SIZE;j++){
				System.out.print(gameBoard[i][j].getName() + "\t");
			}
			System.out.println();
		}
		
		System.out.println();
	}

	public void setNumberOfTargets(JLabel numberOfTargets) {
		// TODO Auto-generated method stub
		this.numberOfTargets = numberOfTargets;
	}
	
	public int getNumberOfTargets(){
		return Integer.parseInt(numberOfTargets.getText());
	}
	
}
