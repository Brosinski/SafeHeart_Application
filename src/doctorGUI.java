import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class doctorGUI extends JPanel {
    private JPanel dMainPanel;
    private JButton editPatientBtn;
    private JTextField patientCodeText;
    private JLabel jLabel2;
    private JButton addPatientBtn;
    private JScrollPane patientViewPanel;
    private JButton calculateBtn;
    private JButton addRecommendationBtn;
    private JButton addNoteBtn;
    private JLabel dID;
    private JLabel dIDLabel;

    public doctorGUI(Clinician clin) {

        this.setLayout(new GridLayout(1,1));
        this.add(dMainPanel);
        dID.setText(Integer.toString(clin.getID()));
        calculateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        addPatientBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        editPatientBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        addRecommendationBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JPanel recommendationPanel = new recommendationsGUI();
            }
        });

        addNoteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JPanel notePanel = new noteGUI(clin);
            }
        });
    }

}