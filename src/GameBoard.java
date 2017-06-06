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
	 * 게임보드 생성자
	 * 게임보드의 설정을 초기화한다
	 * 
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
	
	/**
	 * 사용자 입력창의 토큰 수를 저장한다.
	 * 
	 * @param userInput
	 */
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
	
	public JLabel getSelectedLabel() {
		return this.selectedLabel;
	}

	public void setSelectedLabel(JLabel selectedILabel) {
		this.selectedLabel = selectedILabel;
	}


	/**
	 * 게임보드에 배치된 토큰을 콘솔로 확인한다.
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

	/**
	 * 게임보드에 배치된 토큰의 방향을 확인한다.
	 */
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

	public JLabel getNumberOfTargets(){
		return numberOfTargets;
	}

	public void setNumberOfTargets(JLabel numberOfTargets) {
		// TODO Auto-generated method stub
		
		this.numberOfTargets = numberOfTargets;
		
	}
	
}
