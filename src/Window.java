import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double screenwidth;
    double screenheight;
    static JComponent currentScreen; // Use to keep track of current displayed screen

    public Window(){

        super("SafeHeart Appplication");
        getContentPane().setBackground(Color.white);
        this.screenwidth = this.screenSize.getWidth();
        this.screenheight = this.screenSize.getHeight();
        this.setBounds((int)this.screenwidth / 2 -500,(int)this.screenheight / 2 -250, 1000,500);   //Sets size of log in window and centers it to middle of screen

        this.setLayout(new GridLayout(1, 1, 20, 0));







    }

    //This method will change the current displayed Panel of the Window class
    public void setScreen(JComponent currentScreen){
        this.remove(currentScreen);
        this.currentScreen=currentScreen;
        this.validate();
        this.repaint();
        this.add(currentScreen);
        this.setVisible(true);
    }
}
