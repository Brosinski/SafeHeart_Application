import javax.swing.*;
import java.awt.*;

public class noteGUI extends JPanel{
    private JPanel noteMainPanel;
    private JTextArea noteTextArea;
    private JLabel noteHeader;
    private JButton saveNoteBtn;

    public noteGUI(){

        this.setLayout(new GridLayout(1,1));
        this.add(noteMainPanel);

    }
}
