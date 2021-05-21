import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class recommendationsGUI extends JPanel {

    private JPanel recomMainPanel;
    private JButton saveBtn;
    private JButton saveExerciseBtn;
    private JLabel exerciseLabel;
    private JLabel dietLabel;
    private JLabel recomHeader;
    private JTextArea textArea1;
    private JTextArea textArea2;
    Database db = new Database();

    public recommendationsGUI(Clinician c, Patient p){

        this.setLayout(new GridLayout(1,1));
        this.add(recomMainPanel);

        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String exerciseRec = textArea1.getText();
                String dietRec = textArea2.getText();
                Component comp = (Component) actionEvent.getSource();
                JFrame f =(JFrame) SwingUtilities.getRoot(comp);
                JOptionPane jj = new JOptionPane();
                if(db.setRecommendation(dietRec,exerciseRec,p.getId(),c.getID())){
                    jj.showMessageDialog(f,"Sent recommendation");
                    db.closeConnection();
                    f.dispose();
                }
                else{
                    jj.showMessageDialog(f,"Failed to send recommendation");
                }

            }
        });

    }

}
