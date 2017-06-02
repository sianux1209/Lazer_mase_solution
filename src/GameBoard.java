import javax.swing.JLabel;

public class GameBoard {
	
	public JLabel[][] gameBoard;
	private JLabel selectedLabel;	// user selected token
	private Direction direction;
	public static final int TABLE_SIZE = 5;
	
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
	 * set default gameboard conf
	 * @param gameBoard
	 */
	public GameBoard(JLabel... gameBoard){
		
		int i, j;

		this.gameBoard = new JLabel[TABLE_SIZE][TABLE_SIZE];;
		
		// Init game board
		int cnt = 0;
		for(i=0; i < this.gameBoard.length; i++){
			for(j=0; j<this.gameBoard[i].length;j++){
				this.gameBoard[i][j] = gameBoard[cnt];
				cnt++;
			}
		} // finish "for" control
	
		
				
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

	public void checkRotate() {
		// TODO Auto-generated method stub
		for(int i=0; i<TABLE_SIZE;i++){
			for(int j=0; j<TABLE_SIZE;j++){
				System.out.print(gameBoard[i][j].getName() + "\t");
			}
			System.out.println();
		}
	}
	
	
	/**
	 * Check token direction in game board
	 */
	


}
//