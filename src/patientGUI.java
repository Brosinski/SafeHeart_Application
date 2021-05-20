import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class patientGUI extends JPanel {
    private JPanel pMainPanel;
    private JButton calculateBtn;

    private JButton viewRecommendationsBtn;
    private JLabel riskScoreValue;
    private JLabel dID;
    private JLabel dIDLabel;
    private JLabel newRiskScoreLabel;
    private JLabel riskScoreLabel;
    private JPanel patientPanel;


    //patientGUI
    public patientGUI(Patient p){
        ReynoldsRiskScore risk = new ReynoldsRiskScore();
        this.setLayout(new GridLayout(1,1));
        this.add(pMainPanel);
        this.dID.setText(Integer.toString(p.getId()));
        riskScoreValue.setText(Double.toString(risk.calulateRRS(p)));
        patientPanel.setLayout(new GridLayout(1,1));

        patientPanel.add(new viewPatientDetailsGUI("Your current vitals",p));
        calculateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });


        viewRecommendationsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

    }
}
