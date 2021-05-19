import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class recommendationsGUI extends JPanel {

    private JPanel recomMainPanel;
    private JButton saveDietBtn;
    private JButton saveExerciseBtn;
    private JLabel exerciseLabel;
    private JLabel dietLabel;
    private JLabel recomHeader;
    private JTextField textField1;
    private JTextField dietTextField;

    public recommendationsGUI(){

        this.setLayout(new GridLayout(1,1));
        this.add(recomMainPanel);

        saveExerciseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });

        saveDietBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

            }
        });
    }

}
