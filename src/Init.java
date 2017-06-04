
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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
import javax.swing.border.LineBorder;

public class Init extends JFrame implements MouseListener {

	private JPanel contentPane;
	public ButtonEvent buttonEvent;
	public GameBoard gameBoard;
	
	JLabel numberOfTargets;
	
	JLabel red;
	JLabel redR;
	JLabel target;
	JLabel targetR;
	JLabel mirror;
	JLabel mirrorR;
	JLabel green;
	JLabel greenR;
	JLabel blue;
	JLabel blueR;
	JLabel yellow;
	JLabel yellowR;
	JLabel black;
	JLabel token;

	/**
	 * Create the frame.
	 */
	public Init() {
		init();		
		buttonEvent = new ButtonEvent(this, gameBoard);

	}
	// end maze func
	
	/**
	 *  Implement Mouse event 
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO mouse Pressed func

		JComponent jc = (JComponent) e.getSource();
		jc.setBorder(new LineBorder(Color.red, 3));
		
		/* jc commponent type check */
		
		// Button type
		if (jc.getUIClassID().equals("ButtonUI")) {;
			JButton jb = (JButton)jc;
			buttonEvent.action(jb, this, gameBoard);
			
		}
		// Label UI
		else if (jc.getUIClassID().equals("LabelUI")) {
	
			TransferHandler th = jc.getTransferHandler();
			th.exportAsDrag(jc, e, TransferHandler.COPY);
			gameBoard.setSelectedLabel((JLabel)jc);

		}
		
		// trouble shooting
		// if direction of selected label is null
		// that direction initialize in game-board.
		if(gameBoard.getSelectedLabel().getName() == null && gameBoard.getSelectedLabel().getIcon().toString() != "White.jpg"){
			gameBoard.getSelectedLabel().setName("UP");
			String iconName = gameBoard.getSelectedLabel().getIcon().toString();
			gameBoard.getSelectedLabel().setIcon(new ImageIcon(iconName));
		} //end trouble shooting

	}
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {
		JComponent jc = (JComponent) e.getSource();
		jc.setBorder(new LineBorder(Color.red,0));
		checkTargets();	// check the number of targets
		setControlToken();
	}
	@Override
	public void mouseReleased(MouseEvent e) {}
	
	/**
	 * Check the number of targets
	 */
	public void checkTargets(){
		
		Integer targetCount = 0;
		for(int i=0; i<GameBoard.TABLE_SIZE; i++){
			for(int j=0; j<GameBoard.TABLE_SIZE; j++){
				String token = gameBoard.gameBoard[i][j].getIcon().toString();
				if(token == "Target.jpg" || token == "TargetR.jpg"){
					targetCount++;
				} // if end
			} // inner for
		} // end outer for
		
		this.numberOfTargets.setText(targetCount.toString());
		
		
	} // end checkTargets func
	
	
	/*
	 * set tokens of control panel
	 * func for trouble shooting
	 */
	public void setControlToken(){
		
		red.setIcon(new ImageIcon("Red.jpg"));
		redR.setIcon(new ImageIcon("RedR.jpg"));
		target.setIcon(new ImageIcon("Target.jpg"));
		targetR.setIcon(new ImageIcon("TargetR.jpg"));
		mirror.setIcon(new ImageIcon("Mirror.jpg"));
		mirrorR.setIcon(new ImageIcon("MirrorR.jpg"));
		green.setIcon(new ImageIcon("Green.jpg"));
		greenR.setIcon(new ImageIcon("GreenR.jpg"));
		blue.setIcon(new ImageIcon("Blue.jpg"));
		blueR.setIcon(new ImageIcon("BlueR.jpg"));
		yellow.setIcon(new ImageIcon("Yellow.jpg"));
		yellowR.setIcon(new ImageIcon("YellowR.jpg"));
		black.setIcon(new ImageIcon("Black.jpg"));
		token.setIcon(new ImageIcon("Token.jpg"));
		
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

		red = new JLabel(new ImageIcon("Red.jpg"));
		redR = new JLabel(new ImageIcon("RedR.jpg"));
		target = new JLabel(new ImageIcon("Target.jpg"));
		targetR = new JLabel(new ImageIcon("TargetR.jpg"));
		mirror = new JLabel(new ImageIcon("Mirror.jpg"));
		mirrorR = new JLabel(new ImageIcon("MirrorR.jpg"));
		green = new JLabel(new ImageIcon("Green.jpg"));
		greenR = new JLabel(new ImageIcon("GreenR.jpg"));
		blue = new JLabel(new ImageIcon("Blue.jpg"));
		blueR = new JLabel(new ImageIcon("BlueR.jpg"));
		yellow = new JLabel(new ImageIcon("Yellow.jpg"));
		yellowR = new JLabel(new ImageIcon("YellowR.jpg"));
		black = new JLabel(new ImageIcon("Black.jpg"));
		token = new JLabel(new ImageIcon("Token.jpg"));

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

		numberOfTargets = new JLabel("0");
		numberOfTargets.setHorizontalAlignment(JLabel.CENTER);
		numberOfTargets.setFont(new Font("Arial", Font.PLAIN, 40));
		
		JTextField inputRedR = new JTextField();
		inputRedR.setHorizontalAlignment(JLabel.CENTER);
		inputRedR.setFont(new Font("Arial", Font.PLAIN, 40));
		
		JTextField inputTargetR = new JTextField();
		inputTargetR.setHorizontalAlignment(JLabel.CENTER);
		inputTargetR.setFont(new Font("Arial", Font.PLAIN, 40));
		
		JTextField inputMirrorR = new JTextField();
		inputMirrorR.setHorizontalAlignment(JLabel.CENTER);
		inputMirrorR.setFont(new Font("Arial", Font.PLAIN, 40));
		
		JTextField inputGreenR = new JTextField();
		inputGreenR.setHorizontalAlignment(JLabel.CENTER);
		inputGreenR.setFont(new Font("Arial", Font.PLAIN, 40));
		
		JTextField inputBlueR = new JTextField();
		inputBlueR.setHorizontalAlignment(JLabel.CENTER);
		inputBlueR.setFont(new Font("Arial", Font.PLAIN, 40));
		
		JTextField inputYellowR = new JTextField();
		inputYellowR.setHorizontalAlignment(JLabel.CENTER);
		inputYellowR.setFont(new Font("Arial", Font.PLAIN, 40));
		
		
		

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

		numberOfTargets.setBounds(0, 800, 100, 100);
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

		start.addMouseListener(this);
		clear.addMouseListener(this);
		laser.addMouseListener(this);
		
		left.addMouseListener(this);
		right.addMouseListener(this);

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

		getContentPane().add(numberOfTargets);
		getContentPane().add(inputRedR);
		getContentPane().add(inputTargetR);
		getContentPane().add(inputMirrorR);
		getContentPane().add(inputGreenR);
		getContentPane().add(inputBlueR);
		getContentPane().add(inputYellowR);
		
		/************ set Gameboard ************/
		
		gameBoard = new GameBoard(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, 
								p15, p16, p17, p18, p19, p20, p21, p22, p23, p24, p25);
		
		gameBoard.setSelectedLabel(p1);	// selectedIcon init
		
		/***************************************/

		getContentPane().setLayout(null);
		setSize(1110, 943);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	// End init func

}

//