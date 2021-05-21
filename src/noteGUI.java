import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class noteGUI extends JPanel{
    private JPanel noteMainPanel;
    private JTextArea noteTextArea;
    private JLabel noteHeader;
    private JButton saveNoteBtn;
    private JScrollPane scrollPane;

    public noteGUI(Clinician c,Patient p){

        this.setLayout(new GridLayout(1,1));
        this.add(noteMainPanel);

        saveNoteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String noteText = noteTextArea.getText();
                Database db = new Database();
                Component comp = (Component) actionEvent.getSource();
                JFrame f =(JFrame) SwingUtilities.getRoot(comp);
                if(db.setPatientNote(noteText,p.getId(),c.getID())==false) {
                    JOptionPane jj = new JOptionPane();
                    jj.showMessageDialog(f,"Note was too long");
                }
                else{
                    f.dispose();
                    db.closeConnection();
                    }


            }

        }
        );
    }
}
