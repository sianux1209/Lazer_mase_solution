import javax.swing.JLabel;

public class GameBoard {
	
	JLabel[][] gameBoard;
	
	/**
	 * set default gameboard conf
	 * @param gameBoard
	 */
	public GameBoard(JLabel... gameBoard){

		this.gameBoard = new JLabel[5][5];
		
		int cnt = 0;
		for(int i=0; i < this.gameBoard.length; i++){
			for(int j=0; j<this.gameBoard[i].length;j++){
				this.gameBoard[i][j] = gameBoard[cnt];
				cnt++;
			}
		} // finish for control
				
	} // finish GameBoard constructor

	public void checkGameBoard(){
		
		for(JLabel[] x : gameBoard){
			for(JLabel y : x){
				System.out.print(y.getIcon().toString() + "\t");
			}
			System.out.println();
		} // finish for control
		
	} // finish check GameBoard func
}
