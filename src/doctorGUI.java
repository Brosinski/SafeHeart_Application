import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class doctorGUI extends JFrame {
    private JPanel doctorMainPanel;
    private JButton editPatientButton;
    private JTextField patientCodeText;
    private JLabel jLabel1;
    private JLabel riskScoreLabel;
    private JLabel jLabel2;
    private JButton findPatientBtn;
    private JScrollPane patientViewPanel;
    private JButton calculateBtn;

    public doctorGUI(String title) {
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(doctorMainPanel);
        this.pack();
        this.setVisible(true);
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