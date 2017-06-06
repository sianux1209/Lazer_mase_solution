import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * 저장된 레이저의 경로를 그리는 클래스
 *
 */
public class LaserDrawer extends JFrame implements Runnable {

	int cx;
	int cy;

	int nx;
	int ny;
	
	int xStart;
	int yStart;
	
	int xWidth;
	int yWidth;

	private ArrayList<Laser> laser;
	private Thread thread;

	int currentLocation;
	int nextLocation;

	/**
	 * 생성자
	 */
	public LaserDrawer(ArrayList<Laser> laser) {

		this.laser = laser;

		setTitle("Laser Shoot");
		setPreferredSize(new Dimension(700, 700));
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
		
		

		thread = new Thread(this);
		thread.start();

	}
	
	public void run() {

		int laserNumber = laser.size();
		int laserCount = 0;

		while (laserCount < laserNumber) {

			int saveNumber = laser.get(laserCount).saveLocation.size() - 1;
			int saveCount = 0;

			while (saveCount < saveNumber) {

				currentLocation = saveCount;
				nextLocation = saveCount + 1;

				cx = laser.get(laserCount).saveLocation.get(currentLocation).getX();
				cy = laser.get(laserCount).saveLocation.get(currentLocation).getY();

				nx = laser.get(laserCount).saveLocation.get(nextLocation).getX();
				ny = laser.get(laserCount).saveLocation.get(nextLocation).getY();

				cx = ((cx + 1) * 100) + 50;
				cy = ((cy + 1) * 100) + 50;

				nx = ((nx + 1) * 100) + 50;
				ny = ((ny + 1) * 100) + 50;
				
				while (cx != nx || cy != ny) {

					if (cy < ny) {
						cy++;
					} else if (cx < nx) {
						cx++;

					} else if (cy > ny) {
						cy--;

					} else if (cx > nx) {
						cx--;
					}

					repaint();

					try {
						thread.sleep(4); // Draw spped
					} catch (Exception e) {
					} // End try-catch

				} // End inner while

				saveCount++;
				;

			} // End outer while

			laserCount++;

		} // End while

	} // End run


	public void paint(Graphics g) {
		
		g.setColor(Color.RED);
		g.fillArc(cx, cy, 10, 10, 0, 360);
		
	}

}
