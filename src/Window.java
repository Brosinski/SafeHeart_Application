import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double screenwidth;
    double screenheight;
    static JComponent currentScreen = null; // Use to keep track of current displayed screen

    public Window(){

        super("SafeHeart Appplication");
        getContentPane().setBackground(Color.white);
        this.screenwidth = this.screenSize.getWidth();
        this.screenheight = this.screenSize.getHeight();
        this.setBounds((int)this.screenwidth / 2 -550,(int)this.screenheight / 2 -250, 1100,500);   //Sets size of log in window and centers it to middle of screen

        this.setLayout(new GridLayout(1, 1, 20, 0));







    }

    //This method will change the current displayed Panel of the Window class
    public void setWindow(JComponent currentScreen){
        if(!(this.currentScreen==null))
            this.remove(this.currentScreen);
        this.currentScreen=currentScreen;
        this.validate();
        this.repaint();
        this.add(currentScreen);
        this.setVisible(true);
    }
}
