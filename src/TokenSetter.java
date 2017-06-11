import java.awt.Color;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

/**
 * ����ڰ� �Է�â�� �Է��� ��ū�� ����ŭ�� ��ū�� ���Ӻ��忡 ��ġ�Ѵ�.
 */
public class TokenSetter {

	GameBoard gameBoard;

	List<JLabel> emptySpace;

	private int red = 0;
	private int target = 0;
	private int mirror = 0;
	private int green = 0;
	private int blue = 0;
	private int yellow = 0;
	private int totalToken;

	/**
	 * ������
	 * @param gameBoard
	 */
	public TokenSetter(GameBoard gameBoard) {
		// TODO Auto-generated constructor stub
		this.gameBoard = gameBoard;
		emptySpace = new ArrayList<JLabel>();
		checkEmptyplace();	// �� ������ �˻��Ѵ�;
	}
	
	public int getTotalToken() {
		return totalToken;
	}

	public void setTotalToken(int totalToken) {
		this.totalToken = totalToken;
	}
	
	/*
	 * ��ū�� ��ġ�Ѵ�.
	 */
	public boolean setUserToken() {
		// TODO Auto-generated method stub
		
		setTotalToken(red + target + mirror + green + blue + yellow);
		
		// ���� ������ �Է��� ��ū�� ������ ������ ������ ������ �����Ѵ�.
		if(emptySpace.size() < getTotalToken()){
			System.out.println("[*]The token entered is more than the remaining space");
			return false;
		}
		
		getUserInput();	// ����ڰ� �Է��� ��ū�� ���� �д´�.
		resetToken(); // �ڵ����� ��ġ�� ��ū�� ȸ���Ѵ�. (��ġ/���ġ�� �ݺ��ϱ� ���ؼ�)
		setToken(); //  ��ū�� �ڵ����� ��ġ�Ѵ�.
		
		return true;
		

	}

	/**
	 * ��ū�� ȸ���Ѵ�.
	 */
	private void resetToken() {
		// TODO Auto-generated method stub
		
		for(int i=0; i<getTotalToken(); i++){
			emptySpace.get(i).setIcon(new ImageIcon("White.jpg"));
			emptySpace.get(i).setBorder(null);
		}
		
	}

	/**
	 * ��ū�� ��ġ�Ѵ�.
	 */
	private void setToken() {
		// TODO Auto-generated method stub
		
		int tokenCount = 0;	
		int i;
		
		Collections.shuffle(emptySpace);
		
		// Set red token
		for(i=0; i<red; i++){
			emptySpace.get(tokenCount).setIcon(new ImageIcon("RedR.jpg"));
			emptySpace.get(tokenCount).setBorder(new LineBorder(Color.BLUE,3));
			tokenCount++;
		}
		
		// Set target token
		for(i=0; i<target; i++){
			emptySpace.get(tokenCount).setIcon(new ImageIcon("TargetR.jpg"));
			emptySpace.get(tokenCount).setBorder(new LineBorder(Color.BLUE,3));
			tokenCount++;
		}
		
		//set mirror token
		for(i=0; i<mirror; i++){
			emptySpace.get(tokenCount).setIcon(new ImageIcon("MirrorR.jpg"));
			emptySpace.get(tokenCount).setBorder(new LineBorder(Color.BLUE,3));
			tokenCount++;
		}
		
		// set green token
		for(i=0; i<green; i++){
			emptySpace.get(tokenCount).setIcon(new ImageIcon("GreenR.jpg"));
			emptySpace.get(tokenCount).setBorder(new LineBorder(Color.BLUE,3));
			tokenCount++;
		}
		
		// set blue token
		for(i=0; i<blue; i++){
			emptySpace.get(tokenCount).setIcon(new ImageIcon("BlueR.jpg"));
			emptySpace.get(tokenCount).setBorder(new LineBorder(Color.BLUE,3));
			tokenCount++;
		}
		
		// set yellow token
		for(i=0; i<yellow; i++){
			emptySpace.get(tokenCount).setIcon(new ImageIcon("YellowR.jpg"));
			emptySpace.get(tokenCount).setBorder(new LineBorder(Color.BLUE,3));
			tokenCount++;
		}
		
		
	}
	
	/**
	 * ����� �Է��� �д´�.
	 */
	private void getUserInput() {
		
		for (int i=0; i<gameBoard.userInput.length; i++) {
			
			// ���� �Է�â�� �Էµ� ���� ������ 0���� �ʱ�ȭ�Ѵ�.
			if(gameBoard.userInput[i].getText().equals("")){
					gameBoard.userInput[i].setText("0");
			}
			
			// ���� �Է�â�� ���� ���ڰ� �ƴϸ� 0���� �ʱ�ȭ�Ѵ�.
			if(!isStringInt(gameBoard.userInput[i].getText())){
				
				System.out.println(gameBoard.userInput[i].getText());
				
				for(Integer j=0; j < 6 ; j++){
					gameBoard.userInput[i].setText("0");
					
				} // End inner for
				return;
			}// End inner for

		}//end for

		red = Integer.parseInt(gameBoard.userInput[0].getText());
		target = Integer.parseInt(gameBoard.userInput[1].getText());
		mirror = Integer.parseInt(gameBoard.userInput[2].getText());
		green = Integer.parseInt(gameBoard.userInput[3].getText());
		blue = Integer.parseInt(gameBoard.userInput[4].getText());
		yellow = Integer.parseInt(gameBoard.userInput[5].getText());

	}
	

	/**
	 * ���ڰ� ���ڷ� ��ȯ�� ������ �������� Ȯ���Ѵ�.
	 * 
	 * @param s
	 * @return
	 */
	public boolean isStringInt(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * �� ������ �˻��Ѵ�.
	 */
	public void checkEmptyplace() {

		for (int y = 0; y < GameBoard.TABLE_SIZE; y++) {
			for (int x = 0; x < GameBoard.TABLE_SIZE; x++) {

				if (gameBoard.gameBoard[y][x].getIcon().toString() == "White.jpg") {
					emptySpace.add(gameBoard.gameBoard[y][x]);
				} // End if

			} // End inner if
		} // End outer if

	} //End checkEmptyPlace func



}	//End class
