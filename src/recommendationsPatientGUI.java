import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class recommendationsPatientGUI extends JPanel {
    private JButton nextButton;
    private JPanel recomMainPanel;
    private JLabel exerciseLabel;
    private JLabel dietLabel;
    private JLabel recomHeader;
    private JButton backButton;
    private JTextArea textArea1;
    private JTextArea textArea2;
    private ArrayList<Recommendation> recArray;
    private Database db = new Database();
    private Recommendation currentRec;
    private int arrayIndex;
    public recommendationsPatientGUI(Patient pat) {
        java.util.Date date = new java.util.Date();
        java.sql.Date Date =new java.sql.Date(date.getTime());
        currentRec=new Recommendation("Empty","Empty",Date);
        recArray = db.getRecommendation(pat.getId());
        this.setLayout(new GridLayout(1, 1));
        this.add(recomMainPanel);
        if (!(recArray == null)) {
            if(!(recArray.size()== 0)) {
                currentRec = recArray.get(arrayIndex);
            }

            changeDetails(currentRec);
        }
         else {
            changeDetails(currentRec);
            textArea1.setText("Error connecting to database");
        }
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                noteTracker(true);
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                noteTracker(false);
            }
        });
        this.setVisible(true);
    }

        public void noteTracker(boolean next) {
            if (recArray.size()>0) {
                if (next) {
                    if (!(arrayIndex == recArray.size() - 1)) {
                        arrayIndex++;
                        currentRec = recArray.get(arrayIndex);
                        changeDetails(currentRec);


                    }
                } else {


                    if (arrayIndex == 0) {
                    } else {

                        arrayIndex--;
                        currentRec = recArray.get(arrayIndex);
                        changeDetails(currentRec);

                    }


                }
            }
        }
    public void changeDetails(Recommendation rec){
        Clinician clini = new Clinician();
        textArea1.setText(rec.getRecommendedExercise());
        textArea2.setText(rec.getRecommendedDiet());
        db.getClinicianName(rec.getClinId(),clini);
        recomHeader.setText("Recommendations from Dr. "+clini.getFamilyName());


    }
}
