import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class doctorGUI extends JPanel {
    private JPanel dMainPanel;
    private JPanel display;
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
    private JButton viewButton;
    private JLabel reynoldLabel;
    private JLabel nameLabel;
    private JLabel patientIDLabel;
    private JButton nextButton;
    private JButton backButton;
    private JPanel doctorPanel;
    private JScrollPane scrollPane;
    private Database db = new Database();
    private Component comp;
    private JFrame f;
    private Patient currentPatient;
    private int arrayIndex =0;
    ArrayList<Patient> patientArray;
    viewPatientDetailsGUI patientDetails;
    ReynoldsRiskScore reynoldsRiskScore = new ReynoldsRiskScore();
    DecimalFormat df =new DecimalFormat("##.##");
    Clinician clin;
    doctorGUI docGui;
    public doctorGUI(Clinician clin) {
        this.clin = clin;
        docGui =this;

        ArrayList<Integer> patIDArray= db.getPatientList(clin.getID());
         patientArray = new ArrayList<>();
        for(int i=0;i<patIDArray.size();i++){
            Patient patientAdd = new Patient();
            db.getPatientInformation(patIDArray.get(i),patientAdd);
            db.getPatientName(patientAdd.getId(),patientAdd);
            patientArray.add(patientAdd);
        }
        if(!(patientArray.size()==0)) {
                currentPatient=patientArray.get(arrayIndex);

        }
        reynoldLabel.setText(df.format(reynoldsRiskScore.calulateRRS(currentPatient)));
        this.setLayout(new GridLayout(1,1));
        this.add(dMainPanel);
        dID.setText(Integer.toString(clin.getID()));
        patientDetails =new viewPatientDetailsGUI("Patient Information",currentPatient);
        display.setLayout(new GridLayout(1,1));
        display.add(patientDetails);
        nameLabel.setText("Patient Name: "+currentPatient.getFirstName()+"   "+currentPatient.getFamilyName());
        patientIDLabel.setText(Integer.toString(currentPatient.getId()));
        calculateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame display = new PatientFrame("RRS Calculator");
                JPanel j = new addPatientGUI("Calculate RRS",currentPatient);
                display.add(j);
                display.setVisible(true);
            }
        });
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                patientTracker(true);
            }
        });
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                patientTracker(false);
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
                            jj.showMessageDialog(f,"Added Patient!");
                            patientArray.add(p);
                            refreshPatients();
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
                         PatientFrame display = new PatientFrame("Edit Patient");
                        addPatientGUI gui =new addPatientGUI("Edit Patient Information",currentPatient.getId());
                        gui.setForRefresh(docGui);
                        display.add(gui);
                        display.setVisible(true);

            }
        });

        addRecommendationBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                noteFrame display = new noteFrame();
                display.add(new recommendationsGUI(clin,currentPatient));
            }
        });
        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                noteFrame display = new noteFrame();
                display.add(new Note(clin,currentPatient));
            }
        });
        addNoteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                noteFrame display=new noteFrame();
                display.add(new noteGUI(clin,currentPatient));

            }
        });
    }
    public void patientTracker(boolean next) {
        if (next) {
            if (!(arrayIndex == patientArray.size() - 1)) {
                arrayIndex++;
                currentPatient = patientArray.get(arrayIndex);
                patientDetails.changeDetails(currentPatient);
                nameLabel.setText(currentPatient.getFirstName() + "   " + currentPatient.getFamilyName());
                patientIDLabel.setText(Integer.toString(currentPatient.getId()));
                reynoldLabel.setText(df.format(reynoldsRiskScore.calulateRRS(currentPatient)));


            }
        } else {


            if (arrayIndex == 0) {
            } else {
                arrayIndex--;
                currentPatient = patientArray.get(arrayIndex);
                patientDetails.changeDetails(currentPatient);
                nameLabel.setText(currentPatient.getFirstName() + "   " + currentPatient.getFamilyName());
                patientIDLabel.setText(Integer.toString(currentPatient.getId()));
                reynoldLabel.setText(df.format(reynoldsRiskScore.calulateRRS(currentPatient)));
            }


        }

    }
    public void refreshPatients(){
        ArrayList<Integer> patIDArray= db.getPatientList(clin.getID());
        patientArray = new ArrayList<>();
        for(int i=0;i<patIDArray.size();i++){
            Patient patientAdd = new Patient();
            display.setVisible(true);
            db.getPatientInformation(patIDArray.get(i),patientAdd);
            db.getPatientName(patientAdd.getId(),patientAdd);
            patientArray.add(patientAdd);
        }
        currentPatient =patientArray.get(arrayIndex);
        patientDetails.changeDetails(currentPatient);
    }
}
