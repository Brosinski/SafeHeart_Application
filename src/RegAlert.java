import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegAlert extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double screenwidth;
    JPanel textPanel;
    static boolean regFlag =false;
    JPanel but1;
    JPanel but2;
    JButton button1;
    final String code="x5DeB";
    JButton button2;
    JTextField textField;
    JPanel buttonPanel;
    double screenheight;
    public RegAlert(){

        super("");
        getContentPane().setBackground(Color.white);
        this.screenwidth = this.screenSize.getWidth();
        this.screenheight = this.screenSize.getHeight();
        System.out.println(screenheight);
        this.setBounds((int)this.screenwidth / 2 -50,(int)this.screenheight / 2 -50, 200,150);
        this.setLayout(new GridLayout(2, 1, 0, 0));
        textField = new JTextField();
        textPanel =new JPanel();
        textField.setHorizontalAlignment(JTextField.CENTER);
        textPanel.setLayout(new FlowLayout());
        textField.setPreferredSize(new Dimension(100,50));
        textPanel.add(textField);

        buttonPanel=new JPanel();
        buttonPanel.setLayout(new GridLayout(1,2,10,0));

        but1 =new JPanel();
        but2 = new JPanel();
        but1.setLayout(new FlowLayout());
        but2.setLayout(new FlowLayout());
        button1 =new JButton("Enter");
        button2 =new JButton("Cancel");
        ActionListener listener;

        listener = new ActionListener(){
            public void actionPerformed(ActionEvent e) {

                Component comp = (Component) e.getSource();
                JFrame f =(JFrame) SwingUtilities.getRoot(comp);
                if(e.getSource()==button1) {
                   String code1= textField.getText();
                   if(code1.equals(code)){
                        setRFlag(true);
                        closeFrame();
                       JOptionPane.showMessageDialog(f,"Account Added!");
                   }
                   else {
                       JOptionPane.showMessageDialog(f,"Wrong code");
                   }

                }
                else if(e.getSource()==button2) {
                    closeFrame();

                }
            }

        };
        but1.add(button1);
        but2.add(button2);
        buttonPanel.add(but1);
        buttonPanel.add(but2);


        this.add(textPanel);
        this.add(buttonPanel);



        this.setVisible(true);
}
    public void setRFlag(boolean b){
        regFlag =b;
    }
    public boolean getRFlag(){
        return regFlag;
    }
    public void closeFrame() {
        this.dispose();
    }
    }

