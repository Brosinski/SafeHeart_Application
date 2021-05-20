import javax.swing.*;
import java.awt.*;

public class patientDetailsGUI extends JPanel {
    private JRadioButton radioButton1;
    private JPanel patientDetailsMainPanel;
    private JLabel patientIDLabel;
    private JLabel genderLabel;
    private JLabel ageLabel;
    private JLabel patientNameLabel;

    public patientDetailsGUI() {

        this.setLayout(new GridLayout(1, 1));
        this.add(patientDetailsMainPanel);

    }

}
