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
    private JPanel display;
    private JPanel scrollPanel;
    private JScrollPane scrollPane;
    private Database db = new Database();
    private Component comp;
    private JFrame f;
    public doctorGUI(Clinician clin) {

        loadPatientPanel();
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
                f=(JFrame) SwingUtilities.getRoot(comp);
                JOptionPane jj = new JOptionPane();
                try {
                    int patientCode = Integer.parseInt(patientCodeText.getText());

                    if(db.getPatientInformation(patientCode,p)) {

                        if(!db.pairPatient(patientCode,clin.getID())){
                           jj.showMessageDialog(f,"You have already added this patient before.");
                        }
                        else {
                            Patient patient = new Patient();

                            patientArray.add(p);
                            jj.showMessageDialog(f,"Added Patient!");
                        }


                    }
                    else{
                        comp = (Component) actionEvent.getSource();

                        jj.showMessageDialog(f,"This patient is not in the database");
                    }
                }
                catch(NumberFormatException e) {
                    e.printStackTrace();

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
    public void loadPatientPanel(){

        display.add(new patientDetailsGUI());


    }
}