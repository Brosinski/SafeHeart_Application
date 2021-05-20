import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class noteGUI extends JPanel{
    private JPanel noteMainPanel;
    private JTextArea noteTextArea;
    private JLabel noteHeader;
    private JButton saveNoteBtn;

    public noteGUI(Clinician c){

        this.setLayout(new GridLayout(1,1));
        this.add(noteMainPanel);

        saveNoteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String noteText = noteTextArea.getText();
                Database db = new Database();
            }

        }
        );
    }
}
