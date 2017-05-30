import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
class Ball extends JPanel implements Runnable
{
    public int x, y;
    public int x_shift, y_shift;
    
    Thread thread;
    public Ball()
    {
        
            x = (int) (1);
            y = (int) (1);
            x_shift = 1;
            y_shift = 1;
        
        thread = new Thread(this);
        thread.start();
        
    }
    public void run()
    {
        while (true)
        {
          
                x = x + x_shift;
                y = y + y_shift;
                if (x < 0 || x > 600-30)
                {
                    x_shift = x_shift * -1;
                    if (x< 0)
                    {
                        x= 0;
                    }
                    if (x > 600-30)
                    {
                        x = 600-30;
                    }
                    
                }
                if (y < 0 || y > 500-30)
                {
                    y_shift = y_shift * -1;
                    if (y < 0)
                    {
                        y = 0;
                    }
                    if (y > 500-30)
                    {
                        y= 500-30;
                    }
                }
                
                repaint();
                
                try{
                thread.sleep(10);
                }catch(Exception e){}
            }
        
        
    }

    public void paint(Graphics g)
    {
        
        g.setColor(Color.RED);
        //this.setSize(30, 30);
        //this.setLocation(250, 250);
            g.fillArc(x, y, 10, 10, 0, 360);
    }
    public void update(Graphics g)
    {
        paint(g);
    }
}