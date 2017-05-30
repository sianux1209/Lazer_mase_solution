
import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.TransferHandler;
import javax.swing.border.EmptyBorder;

public class Maze extends JFrame implements MouseListener {

	public static JLabel selectedIcon;
	
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Maze() {

		init();

	}
	// end maze func
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

		JComponent jc = (JComponent) e.getSource();

		// jc commponent type check

		// Button type
		if (jc.getUIClassID().equals("ButtonUI")) {;
			JButton btn = (JButton)jc;
			System.out.println(btn.getIcon().toString());
			
			System.out.println(selectedIcon);

		}

		// Label UI
		if (jc.getUIClassID().equals("LabelUI")) {
			System.out.println(jc);
			TransferHandler th = jc.getTransferHandler();
			th.exportAsDrag(jc, e, TransferHandler.COPY);
			
			selectedIcon = (JLabel)jc;

		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	/**
	 * init func
	 */
	public void init() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JLabel p1 = new JLabel(new ImageIcon("White.jpg"));
		JLabel p2 = new JLabel(new ImageIcon("White.jpg"));
		JLabel p3 = new JLabel(new ImageIcon("White.jpg"));
		JLabel p4 = new JLabel(new ImageIcon("White.jpg"));
		JLabel p5 = new JLabel(new ImageIcon("White.jpg"));
		JLabel p6 = new JLabel(new ImageIcon("White.jpg"));
		JLabel p7 = new JLabel(new ImageIcon("White.jpg"));
		JLabel p8 = new JLabel(new ImageIcon("White.jpg"));
		JLabel p9 = new JLabel(new ImageIcon("White.jpg"));
		JLabel p10 = new JLabel(new ImageIcon("White.jpg"));
		JLabel p11 = new JLabel(new ImageIcon("White.jpg"));
		JLabel p12 = new JLabel(new ImageIcon("White.jpg"));
		JLabel p13 = new JLabel(new ImageIcon("White.jpg"));
		JLabel p14 = new JLabel(new ImageIcon("White.jpg"));
		JLabel p15 = new JLabel(new ImageIcon("White.jpg"));
		JLabel p16 = new JLabel(new ImageIcon("White.jpg"));
		JLabel p17 = new JLabel(new ImageIcon("White.jpg"));
		JLabel p18 = new JLabel(new ImageIcon("White.jpg"));
		JLabel p19 = new JLabel(new ImageIcon("White.jpg"));
		JLabel p20 = new JLabel(new ImageIcon("White.jpg"));
		JLabel p21 = new JLabel(new ImageIcon("White.jpg"));
		JLabel p22 = new JLabel(new ImageIcon("White.jpg"));
		JLabel p23 = new JLabel(new ImageIcon("White.jpg"));
		JLabel p24 = new JLabel(new ImageIcon("White.jpg"));
		JLabel p25 = new JLabel(new ImageIcon("White.jpg"));

		JLabel red = new JLabel(new ImageIcon("Red.jpg"));
		JLabel redR = new JLabel(new ImageIcon("RedR.jpg"));
		JLabel target = new JLabel(new ImageIcon("Target.jpg"));
		JLabel targetR = new JLabel(new ImageIcon("TargetR.jpg"));
		JLabel mirror = new JLabel(new ImageIcon("Mirror.jpg"));
		JLabel mirrorR = new JLabel(new ImageIcon("MirrorR.jpg"));
		JLabel green = new JLabel(new ImageIcon("Green.jpg"));
		JLabel greenR = new JLabel(new ImageIcon("GreenR.jpg"));
		JLabel blue = new JLabel(new ImageIcon("Blue.jpg"));
		JLabel blueR = new JLabel(new ImageIcon("BlueR.jpg"));
		JLabel yellow = new JLabel(new ImageIcon("Yellow.jpg"));
		JLabel yellowR = new JLabel(new ImageIcon("YellowR.jpg"));
		JLabel black = new JLabel(new ImageIcon("Black.jpg"));
		JLabel token = new JLabel(new ImageIcon("Token.jpg"));

		JButton start = new JButton(new ImageIcon("Start.jpg"));
		JButton clear = new JButton(new ImageIcon("Clear.jpg"));
		JButton laser = new JButton(new ImageIcon("Laser.jpg"));

		JButton left = new JButton(new ImageIcon("Left.jpg"));
		JButton right = new JButton(new ImageIcon("Right.jpg"));

		JLabel goal = new JLabel(new ImageIcon("Goal.jpg"));

		JLabel userRedR = new JLabel(new ImageIcon("RedR.jpg"));
		JLabel userTargetR = new JLabel(new ImageIcon("TargetR.jpg"));
		JLabel userMirrorR = new JLabel(new ImageIcon("MirrorR.jpg"));
		JLabel userGreenR = new JLabel(new ImageIcon("GreenR.jpg"));
		JLabel userBlueR = new JLabel(new ImageIcon("BlueR.jpg"));
		JLabel userYellowR = new JLabel(new ImageIcon("YellowR.jpg"));

		JTextField ex = new JTextField();
		JTextField inputRedR = new JTextField();
		JTextField inputTargetR = new JTextField();
		JTextField inputMirrorR = new JTextField();
		JTextField inputGreenR = new JTextField();
		JTextField inputBlueR = new JTextField();
		JTextField inputYellowR = new JTextField();

		/*
		 * contentPane.add(p1, BorderLayout.SOUTH); contentPane.add(p2,
		 * BorderLayout.SOUTH);
		 */

		p1.setBounds(100, 100, 100, 100);
		p2.setBounds(200, 100, 100, 100);
		p3.setBounds(300, 100, 100, 100);
		p4.setBounds(400, 100, 100, 100);
		p5.setBounds(500, 100, 100, 100);
		p6.setBounds(100, 200, 100, 100);
		p7.setBounds(200, 200, 100, 100);
		p8.setBounds(300, 200, 100, 100);
		p9.setBounds(400, 200, 100, 100);
		p10.setBounds(500, 200, 100, 100);
		p11.setBounds(100, 300, 100, 100);
		p12.setBounds(200, 300, 100, 100);
		p13.setBounds(300, 300, 100, 100);
		p14.setBounds(400, 300, 100, 100);
		p15.setBounds(500, 300, 100, 100);
		p16.setBounds(100, 400, 100, 100);
		p17.setBounds(200, 400, 100, 100);
		p18.setBounds(300, 400, 100, 100);
		p19.setBounds(400, 400, 100, 100);
		p20.setBounds(500, 400, 100, 100);
		p21.setBounds(100, 500, 100, 100);
		p22.setBounds(200, 500, 100, 100);
		p23.setBounds(300, 500, 100, 100);
		p24.setBounds(400, 500, 100, 100);
		p25.setBounds(500, 500, 100, 100);

		red.setBounds(700, 0, 100, 100);
		redR.setBounds(800, 0, 100, 100);
		target.setBounds(700, 100, 100, 100);
		targetR.setBounds(800, 100, 100, 100);
		mirror.setBounds(700, 200, 100, 100);
		mirrorR.setBounds(800, 200, 100, 100);
		green.setBounds(700, 300, 100, 100);
		greenR.setBounds(800, 300, 100, 100);
		blue.setBounds(700, 400, 100, 100);
		blueR.setBounds(800, 400, 100, 100);
		yellow.setBounds(700, 500, 100, 100);
		yellowR.setBounds(800, 500, 100, 100);
		black.setBounds(700, 600, 100, 100);
		token.setBounds(800, 600, 100, 100);

		start.setBounds(900, 0, 200, 200);
		clear.setBounds(900, 200, 200, 200);
		laser.setBounds(900, 400, 200, 200);

		left.setBounds(700, 700, 200, 200);
		right.setBounds(900, 700, 200, 200);

		goal.setBounds(0, 700, 100, 100);

		userRedR.setBounds(100, 700, 100, 100);
		userTargetR.setBounds(200, 700, 100, 100);
		userMirrorR.setBounds(300, 700, 100, 100);
		userGreenR.setBounds(400, 700, 100, 100);
		userBlueR.setBounds(500, 700, 100, 100);
		userYellowR.setBounds(600, 700, 100, 100);

		ex.setBounds(0, 800, 100, 100);
		inputRedR.setBounds(100, 800, 100, 100);
		inputTargetR.setBounds(200, 800, 100, 100);
		inputMirrorR.setBounds(300, 800, 100, 100);
		inputGreenR.setBounds(400, 800, 100, 100);
		inputBlueR.setBounds(500, 800, 100, 100);
		inputYellowR.setBounds(600, 800, 100, 100);

		p1.addMouseListener(this);
		p2.addMouseListener(this);
		p3.addMouseListener(this);
		p4.addMouseListener(this);
		p5.addMouseListener(this);
		p6.addMouseListener(this);
		p7.addMouseListener(this);
		p8.addMouseListener(this);
		p9.addMouseListener(this);
		p10.addMouseListener(this);
		p11.addMouseListener(this);
		p12.addMouseListener(this);
		p13.addMouseListener(this);
		p14.addMouseListener(this);
		p15.addMouseListener(this);
		p16.addMouseListener(this);
		p17.addMouseListener(this);
		p18.addMouseListener(this);
		p19.addMouseListener(this);
		p20.addMouseListener(this);
		p21.addMouseListener(this);
		p22.addMouseListener(this);
		p23.addMouseListener(this);
		p24.addMouseListener(this);
		p25.addMouseListener(this);

		red.addMouseListener(this);
		redR.addMouseListener(this);
		target.addMouseListener(this);
		targetR.addMouseListener(this);
		mirror.addMouseListener(this);
		mirrorR.addMouseListener(this);
		green.addMouseListener(this);
		greenR.addMouseListener(this);
		blue.addMouseListener(this);
		blueR.addMouseListener(this);
		yellow.addMouseListener(this);
		yellowR.addMouseListener(this);
		black.addMouseListener(this);
		token.addMouseListener(this);

		start.addMouseListener(this);
		clear.addMouseListener(this);
		laser.addMouseListener(this);

		p1.setTransferHandler(new TransferHandler("icon"));
		p2.setTransferHandler(new TransferHandler("icon"));
		p3.setTransferHandler(new TransferHandler("icon"));
		p4.setTransferHandler(new TransferHandler("icon"));
		p5.setTransferHandler(new TransferHandler("icon"));
		p6.setTransferHandler(new TransferHandler("icon"));
		p7.setTransferHandler(new TransferHandler("icon"));
		p8.setTransferHandler(new TransferHandler("icon"));
		p9.setTransferHandler(new TransferHandler("icon"));
		p10.setTransferHandler(new TransferHandler("icon"));
		p11.setTransferHandler(new TransferHandler("icon"));
		p12.setTransferHandler(new TransferHandler("icon"));
		p13.setTransferHandler(new TransferHandler("icon"));
		p14.setTransferHandler(new TransferHandler("icon"));
		p15.setTransferHandler(new TransferHandler("icon"));
		p16.setTransferHandler(new TransferHandler("icon"));
		p17.setTransferHandler(new TransferHandler("icon"));
		p18.setTransferHandler(new TransferHandler("icon"));
		p19.setTransferHandler(new TransferHandler("icon"));
		p20.setTransferHandler(new TransferHandler("icon"));
		p21.setTransferHandler(new TransferHandler("icon"));
		p22.setTransferHandler(new TransferHandler("icon"));
		p23.setTransferHandler(new TransferHandler("icon"));
		p24.setTransferHandler(new TransferHandler("icon"));
		p25.setTransferHandler(new TransferHandler("icon"));

		red.setTransferHandler(new TransferHandler("icon"));
		redR.setTransferHandler(new TransferHandler("icon"));
		target.setTransferHandler(new TransferHandler("icon"));
		targetR.setTransferHandler(new TransferHandler("icon"));
		mirror.setTransferHandler(new TransferHandler("icon"));
		mirrorR.setTransferHandler(new TransferHandler("icon"));
		green.setTransferHandler(new TransferHandler("icon"));
		greenR.setTransferHandler(new TransferHandler("icon"));
		blue.setTransferHandler(new TransferHandler("icon"));
		blueR.setTransferHandler(new TransferHandler("icon"));
		yellow.setTransferHandler(new TransferHandler("icon"));
		yellowR.setTransferHandler(new TransferHandler("icon"));
		black.setTransferHandler(new TransferHandler("icon"));
		token.setTransferHandler(new TransferHandler("icon"));

		getContentPane().add(p1);
		getContentPane().add(p2);
		getContentPane().add(p3);
		getContentPane().add(p4);
		getContentPane().add(p5);
		getContentPane().add(p6);
		getContentPane().add(p7);
		getContentPane().add(p8);
		getContentPane().add(p9);
		getContentPane().add(p10);
		getContentPane().add(p11);
		getContentPane().add(p12);
		getContentPane().add(p13);
		getContentPane().add(p14);
		getContentPane().add(p15);
		getContentPane().add(p16);
		getContentPane().add(p17);
		getContentPane().add(p18);
		getContentPane().add(p19);
		getContentPane().add(p20);
		getContentPane().add(p21);
		getContentPane().add(p22);
		getContentPane().add(p23);
		getContentPane().add(p24);
		getContentPane().add(p25);

		getContentPane().add(red);
		getContentPane().add(redR);
		getContentPane().add(target);
		getContentPane().add(targetR);
		getContentPane().add(mirror);
		getContentPane().add(mirrorR);
		getContentPane().add(green);
		getContentPane().add(greenR);
		getContentPane().add(blue);
		getContentPane().add(blueR);
		getContentPane().add(yellow);
		getContentPane().add(yellowR);
		getContentPane().add(black);
		getContentPane().add(token);

		getContentPane().add(start);
		getContentPane().add(clear);
		getContentPane().add(laser);

		getContentPane().add(left);
		getContentPane().add(right);

		getContentPane().add(goal);

		getContentPane().add(userRedR);
		getContentPane().add(userTargetR);
		getContentPane().add(userMirrorR);
		getContentPane().add(userGreenR);
		getContentPane().add(userBlueR);
		getContentPane().add(userYellowR);

		getContentPane().add(ex);
		getContentPane().add(inputRedR);
		getContentPane().add(inputTargetR);
		getContentPane().add(inputMirrorR);
		getContentPane().add(inputGreenR);
		getContentPane().add(inputBlueR);
		getContentPane().add(inputYellowR);

		getContentPane().setLayout(null);
		setSize(1110, 943);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	// End init func

}
