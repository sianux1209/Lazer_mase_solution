import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

/**
 * 저장된 레이저의 경로를 그리는 클래스
 *
 */
public class LaserDrawer2 {

	private Init init;
	private ArrayList<Laser> laser;
	private ArrayList<JLabel> path;

	int cx;
	int cy;

	int nx;
	int ny;

	int currentLocation;
	int nextLocation;

	/**
	 * 생성자
	 */
	public LaserDrawer2(ArrayList<Laser> laser, Init init) {

		this.laser = laser;
		this.init = init;

		path = new ArrayList<JLabel>();

	}

	public void start() {
		// TODO Auto-generated method stub
		
		int laserNumber = laser.size();
		int laserCount = 0;

		JLabel currentPath;

		while (laserCount < laserNumber) {

			int saveNumber = laser.get(laserCount).saveLocation.size() - 1;
			int saveCount = 0;

			int horizontal;
			int vertical;

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

				currentPath = new JLabel();
				currentPath.setOpaque(true);
				currentPath.setBackground(Color.RED);
				currentPath.setBorder(new LineBorder(Color.BLACK, 2));

				// 현재위치가 다음위치보다 아래있을 때
				if (cy < ny) {

					horizontal = 10;
					vertical = ny - cy;
					

					currentPath.setBounds(cx - 5, cy, horizontal, vertical);
					path.add(currentPath);

				}
				// 현재위치가 다음위치보다 왼쪽에 있을 때
				else if (cx < nx) {

					horizontal = nx - cx;
					vertical = 10;
					currentPath.setBounds(cx, cy - 5, horizontal, vertical);
					path.add(currentPath);

					//System.out.println(cx + " " + cy + " " + horizontal + " " + vertical);

				}
				// 현재위치가 다음위치보다 위에 있을 때
				else if (cy > ny) {

					horizontal = 10;
					vertical = cy - ny;
					currentPath.setBounds(nx - 5, ny, horizontal, vertical);
					path.add(currentPath);

					//System.out.println(nx + " " + ny + " " + horizontal + " " + vertical);

				}
				// 현재위치가 다음위치보다 오른쪽에 있을 때
				else if (cx > nx) {

					horizontal = cx - nx;
					vertical = 10;
					currentPath.setBounds(nx, ny - 5, horizontal, vertical);
					path.add(currentPath);

					//System.out.println(nx + " " + ny + " " + horizontal + " " + vertical);
				}

				saveCount++;

			} // End outer while

			laserCount++;

		} // End while

		drawLaser();

	} // End start func

	public void drawLaser() {

		for (int i = 0; i < path.size(); i++) {
			init.jp.add(path.get(i), 1, 0);
		}

		init.validate();
		init.repaint();

	} // End drawLaser func

	public void clear() {

		for (int i = 0; i < path.size(); i++) {
			init.jp.remove(path.get(i));
		} // End for
		
		path.clear();

		init.validate();
		init.repaint();


	} // End clear func

}
