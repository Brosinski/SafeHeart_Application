

import javax.swing.*;
import javax.swing.JCheckBox;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class viewPatientDetailsGUI extends JPanel {

    private JPanel addPatientMainPanel;
    private JCheckBox patientHasDiabetesCheckBox;
    private JCheckBox patientSmokesCheckBox;
    private JCheckBox famHistoryCheckBox;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JButton saveBtn;
    private JRadioButton femaleRadioButton;
    private JRadioButton maleRadioButton;
    private JLabel detailsHeader;
    private JLabel gender;
    boolean error ;
    private JLabel genderLabel;
    private JLabel ageLabel;
    private JLabel age;
    private JLabel totalCholestrol;
    private JLabel HDL;
    private JLabel bp;
    private JLabel hbcrp;
    private JLabel Hba1c;
    private JLabel totCholLabel;
    private JLabel hdlLabel;
    private JLabel bpLabel;
    private JLabel hbCRPLabel;
    private JLabel HbA1CLabel;
    private JLabel header;
    private JPanel viewPatientMain;
    private JPanel jp2;

    public viewPatientDetailsGUI(String title,Patient p){
        boolean isFemale;
        this.setLayout(new GridLayout(1,1));
        this.add(viewPatientMain);
        header.setText(title);
        genderLabel.setText(p.getGender());
        bpLabel.setText(Integer.toString(p.getBloodPressure()));
        totCholLabel.setText(Integer.toString(p.getCholesterol()));
        hdlLabel.setText(Integer.toString(p.getHDLCholesterol()));
        HbA1CLabel.setText(Double.toString((p.getHbA1C())));
        hbCRPLabel.setText(Integer.toString(p.getHsCRP()));
        ageLabel.setText(Integer.toString(p.getAge()));


    }
}

