import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

public class CircleMove extends JFrame
{
    Ball b = new Ball();
    public CircleMove()
    {
        setTitle("�� �����̱�");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        //c.setLayout(new FlowLayout());
        b.setLayout(null);
        b.setPreferredSize(new Dimension(600, 500));
        c.add(b);
       
        pack();//Ball Ŭ������ ũ�⿡ �°� ȭ�� ���߱�
        //setSize(600, 500);
        setVisible(true);
    }
    
}
//
//
//