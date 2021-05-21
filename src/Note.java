import javax.swing.*;
import java.awt.*;

public class Note extends JPanel {
    private JButton backButton;
    private JPanel noteDate;
    private JPanel noteMainPanel;
    private JTextArea noteTextArea;
    private JLabel noteHeader;
    private JButton saveNoteBtn;
    private Database db = new Database();
    public Note(Clinician clin,Patient pat) {
        this.setLayout(new GridLayout(1,1));
        this.add(noteMainPanel);
    }
}
