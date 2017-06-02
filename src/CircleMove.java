import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;

public class CircleMove extends JFrame
{
    Ball b = new Ball();
    public CircleMove()
    {
        setTitle("공 움직이기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        //c.setLayout(new FlowLayout());
        b.setLayout(null);
        b.setPreferredSize(new Dimension(600, 500));
        c.add(b);
       
        pack();//Ball 클래스의 크기에 맞게 화면 맞추기
        //setSize(600, 500);
        setVisible(true);
    }
    
}
//
//
//