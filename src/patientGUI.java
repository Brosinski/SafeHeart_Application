import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class patientGUI extends JPanel {
    private JPanel mainPanel;
    private JScrollPane pViewPanel;
    private JButton calculateBtn;
    private JButton viewNotesButton;
    private JButton viewRecommendationsButton;
    private JLabel riskScoreValue;
    private JLabel dID;
    private JLabel dIDLabel;

    //paientGUI
    public patientGUI(){


        this.setLayout(new GridLayout(1,1));
        this.add(mainPanel);

        calculateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

    }


}
