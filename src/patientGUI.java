import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class patientGUI extends JPanel {
    private JPanel mainPanel;
    private JTextField patientCodeText;
    private JButton findPatientBtn;
    private JScrollPane patientViewPanel;
    private JButton calculateBtn;
//paientGUI
    public patientGUI(){


        this.setLayout(new GridLayout(1,1));
        this.add(mainPanel);

        calculateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
        findPatientBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }


}
