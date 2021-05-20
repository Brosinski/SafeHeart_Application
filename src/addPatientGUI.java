import javax.swing.*;
import javax.swing.JCheckBox;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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

    public addPatientGUI(){

        this.setLayout(new GridLayout(1,1));
        this.add(addPatientMainPanel);


        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String text1 = textField1.getText();
                int text2 = Integer.parseInt(textField2.getText());
                int text3 = Integer.parseInt(textField3.getText());
                int text4 = Integer.parseInt(textField4.getText());
                double text5 = Integer.parseInt(textField5.getText());
                int text6 = Integer.parseInt(textField6.getText());
                double text7 = Double.parseDouble(textField7.getText());
                boolean checkbox1 = patientHasDiabetesCheckBox.isSelected();
                boolean checkbox2 = patientSmokesCheckBox.isSelected();
                boolean checkbox3 = famHistoryCheckBox.isSelected();
            }
        });
    }
}
