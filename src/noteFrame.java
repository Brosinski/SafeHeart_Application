import javax.swing.*;
import java.awt.*;

public class noteFrame extends JFrame {
    public noteFrame(){
        super("Add");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double screenwidth;
        double screenheight;
        JFrame display = new JFrame("RRS Calculator");
        this.setLayout(new GridLayout(1,1));
        screenwidth = screenSize.getWidth();
        screenheight = screenSize.getHeight();
        this.setBounds((int)screenwidth / 2 -200,(int)screenheight / 2 -150, 400,300);
        this.setVisible(true);
    }
}
