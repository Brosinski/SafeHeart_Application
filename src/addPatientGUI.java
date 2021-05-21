import javax.swing.*;
import javax.swing.JCheckBox;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;


public class addPatientGUI extends JPanel {

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
    private JPanel buttonPanel;
    private String gender;
    private doctorGUI docGUI;
    private ReynoldsRiskScore reynoldsRiskScore = new ReynoldsRiskScore();
    boolean error ;
    private DecimalFormat df =new DecimalFormat("##.##");
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double screenwidth;
    double screenheight;
    private boolean refreshFlag;
    public addPatientGUI(String title, int patId){
        boolean isFemale;
        this.setLayout(new GridLayout(1,1));
        this.add(addPatientMainPanel);
        detailsHeader.setText(title);
        ButtonGroup butG=new ButtonGroup();
        butG.add(maleRadioButton);
        butG.add(femaleRadioButton);
        Database db =new Database();
        Patient p= new Patient();

        if(db.getPatientInformation(patId,p)) {
            textField2.setText(Integer.toString(p.getAge()));
            textField3.setText(Integer.toString(p.getCholesterol()));
            textField4.setText(Integer.toString(p.getHDLCholesterol()));
            textField5.setText(Integer.toString(p.getBloodPressure()));
            textField6.setText(Integer.toString(p.getHsCRP()));
            textField7.setText(Double.toString(p.getHbA1C()));
            p.getGender();
            System.out.println("Hello again" );
            if (p.getGender().equals("Male")) {
                maleRadioButton.setSelected(true);

            } else {
                femaleRadioButton.setSelected(true);
            }
            if (p.isSmoker())
                patientSmokesCheckBox.setSelected(true);
            if (p.isDiabetes())
                patientHasDiabetesCheckBox.setSelected(true);
        }
        else{

        }
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                error = true;

                    if (maleRadioButton.isSelected()) {
                        gender = "Male";
                    } else if (femaleRadioButton.isSelected()) {
                        gender = "Female";
                    } else {
                        error = false;
                    }
                int text2;
                int text3;
                int text4;
                int text5;
                int text6;
                double text7;
                boolean checkbox1;
                boolean checkbox2;
                boolean checkbox3;
                    try {
                         text2 = Integer.parseInt(textField2.getText());
                         text3 = Integer.parseInt(textField3.getText());
                         text4 = Integer.parseInt(textField4.getText());
                         text5 = Integer.parseInt(textField5.getText());
                         text6 = Integer.parseInt(textField6.getText());
                         text7 = Double.parseDouble(textField7.getText());
                         checkbox1 = patientHasDiabetesCheckBox.isSelected();
                         checkbox2 = patientSmokesCheckBox.isSelected();
                         checkbox3 = famHistoryCheckBox.isSelected();
                         boolean success =db.setPatientInformation(patId, gender, text2, text3, text4, text5, text6, text7, checkbox1, checkbox2, checkbox3);
                         System.out.println(success);
                         if(refreshFlag){
                             docGUI.refreshPatients();
                             refreshFlag=false;
                             Component comp = (Component) actionEvent.getSource();
                             JFrame f =(JFrame) SwingUtilities.getRoot(comp);
                             db.closeConnection();
                             f.dispose();

                         }
                         else{
                             Component comp = (Component) actionEvent.getSource();
                             JFrame f =(JFrame) SwingUtilities.getRoot(comp);
                             Window mainWind = (Window) f;
                             JOptionPane.showMessageDialog(f,"You have entered safeheart");
                             mainWind.setWindow(new SignIn());

                         }
                    }
                    catch (NumberFormatException e) {

                    }





                }

            }
        );

    }
    public addPatientGUI(String title,Patient p){
        this.setLayout(new GridLayout(1,1));
        this.add(addPatientMainPanel);
        detailsHeader.setText(title);
        saveBtn.setText("Calculate");
        textField2.setText(Integer.toString(p.getAge()));
        textField3.setText(Integer.toString(p.getCholesterol()));
        textField4.setText(Integer.toString(p.getHDLCholesterol()));
        textField5.setText(Integer.toString(p.getBloodPressure()));
        textField6.setText(Integer.toString(p.getHsCRP()));
        textField7.setText(Double.toString(p.getHbA1C()));
        if(p.getGender().equals("Male")) {
            maleRadioButton.setSelected(true);

        }
        else{
            femaleRadioButton.setSelected(true);
        }
        if(p.isSmoker())
            patientSmokesCheckBox.setSelected(true);
        if(p.isDiabetes())
            patientHasDiabetesCheckBox.setSelected(true);
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int text2;
                int text3;
                int text4;
                int text5;
                int text6;
                double text7;
                boolean checkbox1;
                boolean checkbox2;
                boolean checkbox3;
                try {
                    text2 = Integer.parseInt(textField2.getText());
                    text3 = Integer.parseInt(textField3.getText());
                    text4 = Integer.parseInt(textField4.getText());
                    text5 = Integer.parseInt(textField5.getText());
                    text6 = Integer.parseInt(textField6.getText());
                    text7 = Double.parseDouble(textField7.getText());
                    checkbox1 = patientHasDiabetesCheckBox.isSelected();
                    checkbox2 = patientSmokesCheckBox.isSelected();
                    checkbox3 = famHistoryCheckBox.isSelected();
                    Patient pat = new Patient();
                    String gen;
                    if(maleRadioButton.isSelected()) {
                        gen = "Male";
                    }else if(femaleRadioButton.isSelected()){
                        gen ="Female";
                    }
                    else{
                        throw new NumberFormatException();
                    }

                    pat.setGender(gen);
                    pat.setAge(text2);
                    pat.setHsCRP(text6);
                    pat.setBloodPressure(text5);
                    pat.setHbA1C(text7);
                    pat.setTotalCholesterol(text3);
                    pat.setHDLCholesterol(text4);
                    pat.setSmoker(checkbox2);
                    pat.setFamilyHistory(checkbox3);
                    pat.setDiabetes(checkbox1);
                    Component comp = (Component) actionEvent.getSource();
                    JFrame f =(JFrame) SwingUtilities.getRoot(comp);
                    JOptionPane.showMessageDialog(f,"New RRS for patient is : \n"+"       "+df.format(reynoldsRiskScore.calulateRRS(pat)));
                }
                catch (NumberFormatException e) {
                    Component comp = (Component) actionEvent.getSource();
                    JFrame f =(JFrame) SwingUtilities.getRoot(comp);
                    JOptionPane.showMessageDialog(f,"You have entered one or more values incorrectly");
                }
            }
        });

    }
    public void setForRefresh(doctorGUI gui){
        docGUI=gui;
        refreshFlag=true;


    }

}
