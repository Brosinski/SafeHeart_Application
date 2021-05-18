import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

public class SignIn extends JPanel {

    private boolean regFlag =false;
    JPanel titleLogo;
    JLabel titleLable;
    JLabel titleLable2;
    JPanel titleWelcome;
    JPanel filler;
    JPanel filler2;
    JLabel loginImage;
    JLabel displayImage;
    JPanel logInformation;
    JPanel emailBox;
    JLabel emailText;
    JPanel passwordBox;
    JPanel signPanel;
    JPanel regPanel;
    JPanel login;
    JPanel titleText;
    final String code="x5DeB";
    JLabel passText;
    final JButton signButton =new JButton("Sign in");
    final JButton regButton = new JButton("Register");
    JLabel register;
    private JPasswordField password;
    private JTextField email;
    JPanel loginBut;
    Database db = new Database();
    public SignIn() {

        this.setLayout(new GridLayout(1, 2, 0, 0));
        this.setBackground(Color.white);
        titleLogo=new JPanel();
        titleLogo.setLayout(new GridLayout(2,1,10,10));
        titleLogo.setBackground(Color.white);
        //Top half of titleLogo
        titleWelcome = new JPanel();
        titleWelcome.setLayout(new GridLayout(2,1,0,0));
        titleWelcome.setBackground(Color.white);

        titleText = new JPanel();
        titleText.setLayout(new GridLayout(2,1,0,0));
        titleLable = new JLabel("Welcome to SafeHeart",SwingConstants.CENTER);
        titleLable2 = new JLabel("Sign In",SwingConstants.CENTER);
        titleLable.setFont(new Font("Verdana",Font.BOLD,20));
        titleLable2.setFont(new Font("Verdana",Font.BOLD,20));

        titleText.setBackground(Color.white);
        titleText.add(titleLable);
        titleText.add(titleLable2);
        //Images for SignIn screen
        ImageIcon i = new ImageIcon("doctors.jpg");
        ImageIcon heart = new ImageIcon("heart.jpg");
        loginImage = new JLabel(heart);
        displayImage = new JLabel(i);

        titleWelcome.add(loginImage);
        titleWelcome.add(titleText);

        email = new JTextField(SwingConstants.LEFT);
        emailBox = new JPanel();
        emailBox.setLayout(new GridBagLayout());
        emailBox.setBackground(Color.WHITE);
        GridBagConstraints c= new GridBagConstraints();
        emailText = new JLabel("Email:");

        emailText.setFont(new Font("Verdana",Font.BOLD,15));
        c.fill = GridBagConstraints.PAGE_START;
        c.gridx =3;
        c.gridy = 0;
        c.ipadx =20;
        emailBox.add(emailText,c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx=3;
        c.gridy = 1;
        c.gridwidth= 3;
        c.ipadx =230;



        c.insets=new Insets(5,0,0,0);
        emailBox.add(email,c);
        filler2 = new JPanel();
        filler2.setBackground(Color.WHITE);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx=4;
        c.gridwidth = 2;
        c.gridy= 3;
        emailBox.add(filler2,c);
////////////////////////////////////////
        ////////////////////////////////
        password = new JPasswordField(SwingConstants.LEFT);
        passwordBox = new JPanel();
        passwordBox.setLayout(new GridBagLayout());
        passwordBox.setBackground(Color.WHITE);

        passText = new JLabel("Password:");

        passText.setFont(new Font("Verdana",Font.BOLD,15));
        c.fill = GridBagConstraints.PAGE_START;
        c.gridx =3;
        c.gridy = 0;
        passwordBox.add(passText,c);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx=3;
        c.gridy = 1;
        c.gridwidth= 3;
        c.ipadx =200;



        c.insets=new Insets(5,0,0,0);
        passwordBox.add(password,c);
        filler = new JPanel();
        filler.setBackground(Color.WHITE);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx=4;
        c.gridwidth = 2;
        c.gridy= 3;
        passwordBox.add(filler,c);


        login = new JPanel();
        login.setBackground(Color.white);
        login.setLayout(new GridLayout(3,1,0,0));
        login.add(emailBox);
        login.add(passwordBox);

        loginBut = new JPanel();
        loginBut.setLayout(new GridLayout(2,1,0,0));
        signPanel = new JPanel();
        regPanel = new JPanel();
        signPanel.setLayout(new FlowLayout());
        regPanel.setLayout(new FlowLayout());
        signPanel.setBackground(Color.WHITE);
        regPanel.setBackground(Color.WHITE);
        loginBut.add(signPanel);
        loginBut.add(regPanel);
        loginBut.setBackground(Color.WHITE);

        ActionListener listener;

        listener = new ActionListener(){
            public void actionPerformed(ActionEvent e) {


                if(e.getSource()==signButton) {

                    signIn(e);
                }
                else if(e.getSource()==regButton) {

                    String code1=JOptionPane.showInputDialog("Enter Code for Registration");
                    if(code1.equals(code)) {
                        db.sendCredentials(email.getText(),new String(password.getPassword()));

                    }
                    else {
                        Component comp = (Component) e.getSource();
                        JFrame f =(JFrame) SwingUtilities.getRoot(comp);
                        JOptionPane.showMessageDialog(f,"Wrong credentials");

                    }
                    }

                }


        };
        KeyListener keyListener = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyChar()== KeyEvent.VK_ENTER) {
                    signIn(e);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
        signButton.addActionListener(listener);
        regButton.addActionListener(listener);
        password.addKeyListener(keyListener);
        email.addKeyListener(keyListener);
        login.add(loginBut);
        loginBut.add(signPanel);
        loginBut.add(regPanel);
        signPanel.add(signButton);
        regPanel.add(regButton);
        titleLogo.add(titleWelcome);
        titleLogo.add(login);




        logInformation = new JPanel();


        this.add(titleLogo);
        this.add(displayImage);



    }
public void signIn(AWTEvent e) {


    boolean dude =db.confirmCredentials(email.getText(),new String(password.getPassword()));
    Component comp = (Component) e.getSource();
    JFrame f =(JFrame) SwingUtilities.getRoot(comp);
    JOptionPane jj = new JOptionPane();
    if(dude == false) {
        jj.showMessageDialog(f,"Wrong credentials");
    }
    else if(dude == true){
        jj.showMessageDialog(f,"Logged in!");
        
        Window mainWind = (Window) f;
        mainWind.setWindow(new patientGUI());
        }
    }
}

