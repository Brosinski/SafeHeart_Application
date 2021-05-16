import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double screenwidth;

    double screenheight;
    public Window(){

        super("SafeWay Heart Appplication");
        getContentPane().setBackground(Color.white);
        this.screenwidth = this.screenSize.getWidth();
        this.screenheight = this.screenSize.getHeight();
        System.out.println(screenheight);
        this.setBounds((int)this.screenwidth / 2 -500,(int)this.screenheight / 2 -250, 1000,500);   //Sets size of log in window and centers it to middle of screen

        this.setLayout(new GridLayout(1, 1, 20, 0));


        this.add(new SignIn());

        this.setVisible(true);


    }
}
