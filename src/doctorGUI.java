import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
    private JScrollPane scrollPane;
    private Database db = new Database();
    private Component comp;
    private JFrame f;
    public doctorGUI(Clinician clin) {


        ArrayList<Integer> patIDArray= db.getPatientList(clin.getID());
        ArrayList<Patient> patientArray = new ArrayList<>();
        for(int i=0;i<patIDArray.size();i++){
            Patient patientAdd = new Patient();
            db.getPatientInformation(patIDArray.get(i),patientAdd);
            patientArray.add(patientAdd);
        }

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
                Patient p = new Patient();
                try {
                    int patientCode = Integer.parseInt(patientCodeText.getText());
                    if(db.getPatientInformation(patientCode));
                }
                catch(NumberFormatException e) {
                    e.printStackTrace();
                    comp = (Component) actionEvent.getSource();
                    f=(JFrame) SwingUtilities.getRoot(comp);
                    JOptionPane jj = new JOptionPane();
                    jj.showMessageDialog(f,"This was not a number");
                }


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
                //JPanel recommendationPanel = new recommendationsGUI();
            }
        });

        addNoteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {


            }
        });
    }

}