
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.border.EmptyBorder;

public class maze extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					maze frame = new maze();
					frame.setVisible(true);
					frame.setResizable(false);
					//CircleMove ex = new CircleMove();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public maze() {

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

		JLabel t1 = new JLabel(new ImageIcon("Red.jpg"));
		JLabel t2 = new JLabel(new ImageIcon("RedR.jpg"));
		JLabel t3 = new JLabel(new ImageIcon("Target.jpg"));
		JLabel t4 = new JLabel(new ImageIcon("TargetR.jpg"));
		JLabel t5 = new JLabel(new ImageIcon("Mirror.jpg"));
		JLabel t6 = new JLabel(new ImageIcon("MirrorR.jpg"));
		JLabel t7 = new JLabel(new ImageIcon("Green.jpg"));
		JLabel t8 = new JLabel(new ImageIcon("GreenR.jpg"));
		JLabel t9 = new JLabel(new ImageIcon("Blue.jpg"));
		JLabel t10 = new JLabel(new ImageIcon("BlueR.jpg"));
		JLabel t11 = new JLabel(new ImageIcon("Yellow.jpg"));
		JLabel t12 = new JLabel(new ImageIcon("YellowR.jpg"));
		JLabel t13 = new JLabel(new ImageIcon("Black.jpg"));
		JLabel t14 = new JLabel(new ImageIcon("Token.jpg"));

		JButton Start = new JButton(new ImageIcon("Start.jpg"));
		JButton Clear = new JButton(new ImageIcon("Clear.jpg"));
		JButton Laser = new JButton(new ImageIcon("Laser.jpg"));
		
		JButton Left = new JButton(new ImageIcon("Left.jpg"));
		JButton Right = new JButton(new ImageIcon("Right.jpg"));
		
		JLabel g = new JLabel(new ImageIcon("Goal.jpg"));
		JLabel o1 = new JLabel(new ImageIcon("RedR.jpg"));
		JLabel o2 = new JLabel(new ImageIcon("TargetR.jpg"));
		JLabel o3 = new JLabel(new ImageIcon("MirrorR.jpg"));
		JLabel o4 = new JLabel(new ImageIcon("GreenR.jpg"));
		JLabel o5 = new JLabel(new ImageIcon("BlueR.jpg"));
		JLabel o6 = new JLabel(new ImageIcon("YellowR.jpg"));

		JTextField tfg = new JTextField();
		JTextField tfo1 = new JTextField();
		JTextField tfo2 = new JTextField();
		JTextField tfo3 = new JTextField();
		JTextField tfo4 = new JTextField();
		JTextField tfo5 = new JTextField();
		JTextField tfo6 = new JTextField();

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

		t1.setBounds(700, 0, 100, 100);
		t2.setBounds(800, 0, 100, 100);
		t3.setBounds(700, 100, 100, 100);
		t4.setBounds(800, 100, 100, 100);
		t5.setBounds(700, 200, 100, 100);
		t6.setBounds(800, 200, 100, 100);
		t7.setBounds(700, 300, 100, 100);
		t8.setBounds(800, 300, 100, 100);
		t9.setBounds(700, 400, 100, 100);
		t10.setBounds(800, 400, 100, 100);
		t11.setBounds(700, 500, 100, 100);
		t12.setBounds(800, 500, 100, 100);
		t13.setBounds(700, 600, 100, 100);
		t14.setBounds(800, 600, 100, 100);

		Start.setBounds(900, 0, 200, 200);
		Clear.setBounds(900, 200, 200, 200);
		Laser.setBounds(900, 400, 200, 200);
		
		Left.setBounds(700, 700, 200, 200);
		Right.setBounds(900, 700, 200, 200);

		g.setBounds(0, 700, 100, 100);
		o1.setBounds(100, 700, 100, 100);
		o2.setBounds(200, 700, 100, 100);
		o3.setBounds(300, 700, 100, 100);
		o4.setBounds(400, 700, 100, 100);
		o5.setBounds(500, 700, 100, 100);
		o6.setBounds(600, 700, 100, 100);

		tfg.setBounds(0, 800, 100, 100);
		tfo1.setBounds(100, 800, 100, 100);
		tfo2.setBounds(200, 800, 100, 100);
		tfo3.setBounds(300, 800, 100, 100);
		tfo4.setBounds(400, 800, 100, 100);
		tfo5.setBounds(500, 800, 100, 100);
		tfo6.setBounds(600, 800, 100, 100);

		//mouse event
		MouseListener m1 = new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				;

			}

			@Override
			public void mousePressed(MouseEvent e) {

				JComponent jc = (JComponent) e.getSource();
			
				//jc commponent type check
				
				//Button type
				if(jc.getUIClassID().equals("ButtonUI")){
					System.out.println(jc);
					
				}
				
				//Label UI
				if(jc.getUIClassID().equals("LabelUI")){
					System.out.println(jc);
					TransferHandler th = jc.getTransferHandler();
					th.exportAsDrag(jc, e, TransferHandler.COPY);
					
				}
				
				
				

				

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				;

			}

			@Override
			public void mouseClicked(MouseEvent e) {

			}
		};

		p1.addMouseListener(m1);
		p2.addMouseListener(m1);
		p3.addMouseListener(m1);
		p4.addMouseListener(m1);
		p5.addMouseListener(m1);
		p6.addMouseListener(m1);
		p7.addMouseListener(m1);
		p8.addMouseListener(m1);
		p9.addMouseListener(m1);
		p10.addMouseListener(m1);
		p11.addMouseListener(m1);
		p12.addMouseListener(m1);
		p13.addMouseListener(m1);
		p14.addMouseListener(m1);
		p15.addMouseListener(m1);
		p16.addMouseListener(m1);
		p17.addMouseListener(m1);
		p18.addMouseListener(m1);
		p19.addMouseListener(m1);
		p20.addMouseListener(m1);
		p21.addMouseListener(m1);
		p22.addMouseListener(m1);
		p23.addMouseListener(m1);
		p24.addMouseListener(m1);
		p25.addMouseListener(m1);

		t1.addMouseListener(m1);
		t2.addMouseListener(m1);
		t3.addMouseListener(m1);
		t4.addMouseListener(m1);
		t5.addMouseListener(m1);
		t6.addMouseListener(m1);
		t7.addMouseListener(m1);
		t8.addMouseListener(m1);
		t9.addMouseListener(m1);
		t10.addMouseListener(m1);
		t11.addMouseListener(m1);
		t12.addMouseListener(m1);
		t13.addMouseListener(m1);
		t14.addMouseListener(m1);

		Start.addMouseListener(m1);
		Clear.addMouseListener(m1);
		Laser.addMouseListener(m1);

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

		t1.setTransferHandler(new TransferHandler("icon"));
		t2.setTransferHandler(new TransferHandler("icon"));
		t3.setTransferHandler(new TransferHandler("icon"));
		t4.setTransferHandler(new TransferHandler("icon"));
		t5.setTransferHandler(new TransferHandler("icon"));
		t6.setTransferHandler(new TransferHandler("icon"));
		t7.setTransferHandler(new TransferHandler("icon"));
		t8.setTransferHandler(new TransferHandler("icon"));
		t9.setTransferHandler(new TransferHandler("icon"));
		t10.setTransferHandler(new TransferHandler("icon"));
		t11.setTransferHandler(new TransferHandler("icon"));
		t12.setTransferHandler(new TransferHandler("icon"));
		t13.setTransferHandler(new TransferHandler("icon"));
		t14.setTransferHandler(new TransferHandler("icon"));

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

		getContentPane().add(t1);
		getContentPane().add(t2);
		getContentPane().add(t3);
		getContentPane().add(t4);
		getContentPane().add(t5);
		getContentPane().add(t6);
		getContentPane().add(t7);
		getContentPane().add(t8);
		getContentPane().add(t9);
		getContentPane().add(t10);
		getContentPane().add(t11);
		getContentPane().add(t12);
		getContentPane().add(t13);
		getContentPane().add(t14);

		getContentPane().add(Start);
		getContentPane().add(Clear);
		getContentPane().add(Laser);
		
		getContentPane().add(Left);
		getContentPane().add(Right);

		getContentPane().add(g);
		getContentPane().add(o1);
		getContentPane().add(o2);
		getContentPane().add(o3);
		getContentPane().add(o4);
		getContentPane().add(o5);
		getContentPane().add(o6);

		getContentPane().add(tfg);
		getContentPane().add(tfo1);
		getContentPane().add(tfo2);
		getContentPane().add(tfo3);
		getContentPane().add(tfo4);
		getContentPane().add(tfo5);
		getContentPane().add(tfo6);

		getContentPane().setLayout(null);
		setSize(1110, 943);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);

	}

}