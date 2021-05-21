import javax.swing.*;
import java.awt.*;


public class PatientFrame extends JFrame {
    public PatientFrame(String name)  {
        super(name);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double screenwidth;
        double screenheight;
        JFrame display = new JFrame("RRS Calculator");
        this.setLayout(new GridLayout(1,1));
        screenwidth = screenSize.getWidth();
        screenheight = screenSize.getHeight();
        this.setBounds((int)screenwidth / 2 -300,(int)screenheight / 2 -250, 600,500);
        this.setVisible(true);
    }
}
