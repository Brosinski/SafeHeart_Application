import javax.swing.*;
import javax.swing.JCheckBox;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class addPatientGUI extends JPanel {

    private JPanel addPatientMainPanel;
    private JCheckBox patientHasDiabetesCheckBox;
    private JCheckBox patientSmokesCheckBox;
    private JCheckBox motherFatherHeartAttackCheckBox;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;
    private JButton saveBtn;

    public addPatientGUI(){

        this.setLayout(new GridLayout(1,1));
        this.add(addPatientMainPanel);


        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String text1 = textField1.getText();
                String text2 = textField2.getText();
                String text3 = textField3.getText();
                String text4 = textField4.getText();
                String text5 = textField5.getText();
                String text6 = textField6.getText();
                String text7 = textField7.getText();
                boolean checkbox1 = patientHasDiabetesCheckBox.isSelected();
                boolean checkbox2 = patientSmokesCheckBox.isSelected();
                boolean checkbox3 = motherFatherHeartAttackCheckBox.isSelected();
            }
        });
    }
}
