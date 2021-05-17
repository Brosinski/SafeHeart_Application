import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class patientGUI extends JFrame {
    private JPanel mainPanel;
    private JTextField patientCodeText;
    private JButton findPatientBtn;
    private JScrollPane patientViewPanel;
    private JButton calculateBtn;

    public patientGUI(String title){
        super (title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();
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

    public static void main(String[] args) {
        JFrame frame = new patientGUI("Patient");
        frame.setVisible(true);
    }

}
