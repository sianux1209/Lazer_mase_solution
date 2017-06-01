import javax.swing.Icon;
import javax.swing.JButton;

public class ButtonEvent {

	public Init init;
	public GameBoard gameBoard;
	
	/**
	 * set get init and gameBoard
	 * @param init
	 * @param gameBoard
	 */
	public ButtonEvent(Init init, GameBoard gameBoard){
		this.init = init;
		this.gameBoard = gameBoard;
	}
	
	/**
	 * Check the user-clicked button and execute the function
	 * @param JButton
	 */
	public void action(JButton jb, Init init, GameBoard gameBoard){
		
		if (jb.getIcon().toString().equals("Start.jpg")){
			start();
			gameBoard.checkGameBoard();

			
		}
		else if(jb.getIcon().toString().equals("Clear.jpg")){
			clear();

			
		}
		else if(jb.getIcon().toString().equals("Laser.jpg")){
			laser();

			
		}
		else if(jb.getIcon().toString().equals("Left.jpg")){
			left();

			
		}
		else if(jb.getIcon().toString().equals("Right.jpg")){
			right();

			
		}
	}
	
	
	/**
	 * Start the algorithm and find a solution
	 */
	public void start(){
		System.out.println("Act the start");
		
		
		
	} // finish start func
	
	/**
	 * clear the Game board
	 */
	public void clear(){
		System.out.println("Act the clear");
		
		
	} // finish clear func
	
	/**
	 * shot the laser
	 */
	public void laser(){
		System.out.println("Act the laser");
		
		
	} // finish laser func
	
	/**
	 * Rotate the token to the left
	 */
	public void left(){
		System.out.println("Act the left");
		
		Icon icon = gameBoard.getSelectedIcon().getIcon();
		RotatedIcon rotatedIcon = new RotatedIcon(icon, RotatedIcon.Rotate.UP);
		gameBoard.getSelectedIcon().setIcon(rotatedIcon);;
		
	}
	
	/**
	 * Rotate the token to the right
	 */
	public void right(){
		System.out.println("Act the rightt");
		
		Icon icon = gameBoard.getSelectedIcon().getIcon();
		RotatedIcon rotatedIcon = new RotatedIcon(icon, RotatedIcon.Rotate.DOWN);
		gameBoard.getSelectedIcon().setIcon(rotatedIcon);;
		
	}
}
