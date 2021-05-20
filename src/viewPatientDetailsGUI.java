

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
    private String gender;
    boolean error ;
    private JLabel jlabel1;
    private JLabel jLabel2;

    public viewPatientDetailsGUI(String title, int patId){
        boolean isFemale;
        this.setLayout(new GridLayout(1,1));
        this.add(addPatientMainPanel);
        detailsHeader.setText(title);
        ButtonGroup butG=new ButtonGroup();
        butG.add(maleRadioButton);
        butG.add(femaleRadioButton);
        Database db =new Database();
        ErrorAvoidance err= new ErrorAvoidance();
        saveBtn.addActionListener(new ActionListener() {
                                      @Override
                                      public void actionPerformed(ActionEvent actionEvent) {
                                          error = true;
                                          System.out.println("ITS WORKING");
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
                                              db.setPatientInformation(patId, gender, text2, text3, text4, text5, text6, text7, checkbox1, checkbox2, checkbox3);
                                          }
                                          catch (NumberFormatException e) {
                                              System.out.println("broken");
                                          }


                                          System.out.println("IT ENTERED HRE");


                                      }

                                  }
        );

    }
}

