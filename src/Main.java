import java.awt.EventQueue;

public class Main {
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Maze frame = new Maze();
					frame.setVisible(true);
					frame.setResizable(false);
					// CircleMove ex = new CircleMove();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
