import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class patientGUI extends JPanel {
    private JPanel pMainPanel;
    private JScrollPane pScrollPanel;
    private JButton calculateBtn;
    private JButton viewNotesBtn;
    private JButton viewRecommendationsBtn;
    private JLabel riskScoreValue;
    private JLabel dID;
    private JLabel dIDLabel;
    private JLabel newRiskScoreLabel;
    private JLabel riskScoreLabel;

    //paientGUI
    public patientGUI(){


        this.setLayout(new GridLayout(1,1));
        this.add(pMainPanel);

        calculateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

    }


}
