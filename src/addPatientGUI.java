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
    private JRadioButton femaleRadioButton;
    private JRadioButton maleRadioButton;
    private JLabel detailsHeader;
    private String gender;
    boolean error ;
    public addPatientGUI(String title, int patId){
        boolean isFemale;
        this.setLayout(new GridLayout(1,1));
        this.add(addPatientMainPanel);
        detailsHeader.setText(title);
        ButtonGroup butG=new ButtonGroup();
        butG.add(maleRadioButton);
        butG.add(femaleRadioButton);
        Database db =new Database();

        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                error=false;
            while(!error)
                if(maleRadioButton.isSelected()) {
                    gender ="Male";
                }
                else if(femaleRadioButton.isSelected()){
                    gender ="Female";
                }
                else{
                    error =true;
                }

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
