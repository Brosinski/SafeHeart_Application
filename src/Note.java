import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Note extends JPanel {
    private JButton backButton;
    private JPanel noteDate;
    private JPanel noteMainPanel;
    private JTextArea noteTextArea;
    private JLabel noteHeader;
    private JButton nextButton;
    private JLabel dateLabel;
    private Database db = new Database();
    private ArrayList<PatientNote> noteArray;
    private int arrayIndex;
    private PatientNote currentNote;
    public Note(Clinician clin,Patient pat) {
        arrayIndex = 0;
        this.setLayout(new GridLayout(1,1));
        this.add(noteMainPanel);
        noteArray = new ArrayList<>();
        noteArray = db.getPatientNote(pat.getId(),clin.getID());
        noteHeader.setText("Note made for "+pat.getFirstName()+" "+pat.getFamilyName());
        if(noteArray!=null) {
            if(noteArray.size()>0) {
                changeDetails(noteArray.get(arrayIndex));
            }
            else {
                noteTextArea.setText("No notes found");
            }
            }
        else{
            noteTextArea.setText("Can't retrieve notes");
        }
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                noteTracker(false);
            }
        });
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                noteTracker(true);
            }
        });
    }
    public void noteTracker(boolean next) {
        if (next) {
            if (!(arrayIndex == noteArray.size() - 1)) {
                arrayIndex++;
                currentNote = noteArray.get(arrayIndex);
                changeDetails(currentNote);


            }
        } else {


            if (arrayIndex == 0) {
            } else {
                arrayIndex--;
                currentNote = noteArray.get(arrayIndex);
                changeDetails(currentNote);

            }


        }
    }
        public void changeDetails(PatientNote note) {
                dateLabel.setText("Note created on :"+note.getNoteDate());
                noteTextArea.setText(note.getNoteContent());

        }
}
