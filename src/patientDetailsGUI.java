import javax.swing.*;
import java.awt.*;

public class patientDetailsGUI extends JPanel {
    private JPanel patientDetailsMainPanel;
    private JLabel patientIDLabel;
    private JLabel genderLabel;
    private JLabel ageLabel;
    private JLabel patientNameLabel;
    private JButton nextButton;
    private JButton backButton;

    public patientDetailsGUI(Patient p) {

        this.setLayout(new GridLayout(1, 1));
        this.add(patientDetailsMainPanel);


    }

}
