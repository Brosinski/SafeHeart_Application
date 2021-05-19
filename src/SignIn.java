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
    //No form was used for this code, hence the absolute chaos.
    private boolean regFlag =false;  JLabel titleLable2;
    JLabel passText;
    JLabel passText2;
    JLabel displayImage;
    JLabel ageText;
    JLabel emailText;
    JLabel loginImage;
    JLabel firstText;
    JLabel familyText;
    JPanel titleLogo;
    JPanel titleRegister;
    JLabel titleLable;
    JPanel titleWelcome;
    JPanel filler;
    JPanel filler2;
    JPanel logInformation;
    JPanel emailBox;
    JPanel passwordBox;
    JPanel passwordBox2;
    JPanel ageBox;
    JPanel signPanel;
    JPanel regPanel;
    JPanel login;
    JPanel loginReg;
    JPanel titleText;
    JPanel loginBut;
    JPanel registerTop;
    JPanel firstNameBox;
    JPanel familyNameBox;
    JPanel userTypeBox;
    KeyListener keyListener;
    KeyListener keyListener2;
    JRadioButton clinician;
    JRadioButton patient;
    JRadioButton male;
    JRadioButton female;
    final String code="SafeHeart";
    final JButton signButton =new JButton("Sign in");
    final JButton regButton = new JButton("Register");
    final JButton createButton = new JButton("Create Account");
    final JButton backButton = new JButton("Back");
    private JPasswordField password;
    private JPasswordField password2;
    private JTextField email;
    private JTextField firstName;
    private JTextField familyName;
    Component comp;
    JFrame f;

    Database db = new Database();
    GridBagConstraints c= new GridBagConstraints();
    public SignIn() {
        System.out.println("Working");
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
        /////////////////////////////
        //
        titleWelcome.add(loginImage);
        titleWelcome.add(titleText);
        //BOTTOM HALF
        email = new JTextField(SwingConstants.LEFT);
        emailBox = new JPanel();
        emailBox.setLayout(new GridBagLayout());
        emailBox.setBackground(Color.WHITE);

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
                        startRegScreen();


                    }
                    else {
                        Component comp = (Component) e.getSource();
                        JFrame f =(JFrame) SwingUtilities.getRoot(comp);
                        JOptionPane.showMessageDialog(f,"Wrong credentials");

                    }
                    }

                }


        };
        keyListener = new KeyListener() {
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


    int dude =db.confirmCredentials(email.getText(),new String(password.getPassword()));
    comp = (Component) e.getSource();
    f=(JFrame) SwingUtilities.getRoot(comp);
    JOptionPane jj = new JOptionPane();
    if(dude == 0) {
        jj.showMessageDialog(f,"Wrong credentials");
    }
    else if(dude == 1){
        jj.showMessageDialog(f,"Logged in!");
        
        Window mainWind = (Window) f;
        mainWind.setWindow(new patientGUI());
        }
    else{
        jj.showMessageDialog(f,"There is a connection error, please connect to the internet.");
    }
    }



    public void startRegScreen(){
        this.remove(titleLogo);
        this.remove(displayImage);

        titleRegister=new JPanel();
        titleRegister.setLayout(new GridLayout(2,1,0,10));
        titleRegister.setBackground(Color.white);

        registerTop = new JPanel();
        registerTop.setLayout(new GridLayout(4,1,10,10));
        registerTop.setBackground(Color.white);
        titleLable2 = new JLabel("Register",SwingConstants.CENTER);
        titleLable2.setFont(new Font("Verdana",Font.BOLD,15));
        registerTop.add(titleLable2);
        firstNameBox = new JPanel();
        familyNameBox = new JPanel();
        userTypeBox = new JPanel();
        firstNameBox.setLayout(new GridBagLayout());
        familyNameBox.setLayout(new GridBagLayout());
        userTypeBox.setLayout(new GridLayout(1,1,10,0));
        JPanel hold = new JPanel(new FlowLayout());
        JPanel hold2 = new JPanel(new FlowLayout());
        JPanel hold3 = new JPanel(new FlowLayout());
        hold.setBackground(Color.WHITE);
        hold2.setBackground(Color.WHITE);
        hold3.setBackground(Color.WHITE);

        firstNameBox.setBackground(Color.white);
        familyNameBox.setBackground(Color.white);

        userTypeBox.setBackground(Color.WHITE);
        patient = new JRadioButton("Patient");
        clinician = new JRadioButton("Clinician");
        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        patient.setBackground(Color.WHITE);
        clinician.setBackground(Color.WHITE);
        male.setBackground(Color.WHITE);
        female.setBackground(Color.WHITE);

        ButtonGroup selection = new ButtonGroup();
        ButtonGroup selection2 = new ButtonGroup();
        selection.add(patient);
        selection.add(clinician);
        selection2.add(male);
        selection2.add(female);

        hold.add(patient);
        hold.add(clinician);
        userTypeBox.add(hold);


        firstText = new JLabel("First Name:");
        familyText= new JLabel("Second Name:");
        firstText.setFont(new Font("Verdana",Font.BOLD,15));
        familyText.setFont(new Font("Verdana",Font.BOLD,15));
        c.fill = GridBagConstraints.PAGE_START;
        c.gridx =3;
        c.gridy = 0;
        firstNameBox.add(firstText,c);
        familyNameBox.add(familyText,c);

        firstName = new JTextField(SwingConstants.LEFT);
        familyName = new JTextField(SwingConstants.LEFT);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx=3;
        c.gridy = 1;
        c.gridwidth= 3;
        c.ipadx =200;
        c.insets=new Insets(5,0,0,0);
        firstNameBox.add(firstName,c);
        familyNameBox.add(familyName,c);


        filler = new JPanel();
        filler.setBackground(Color.WHITE);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx=4;
        c.gridwidth = 2;
        c.gridy= 3;


        firstNameBox.add(filler,c);
        familyNameBox.add(filler,c);




        registerTop.add(titleLable2);
        registerTop.add(firstNameBox);
        registerTop.add(familyNameBox);
        registerTop.add(userTypeBox);


        titleRegister.add(registerTop);




        //Bottom half of titleRegister


        loginReg = new JPanel();
        loginReg.setBackground(Color.white);
        loginReg.setLayout(new GridLayout(3,1,0,0));

        loginReg.add(emailBox);
        loginReg.add(passwordBox);

        regPanel.add(backButton);
        regPanel.remove(regButton);
        regPanel.add(createButton);
        loginReg.add(regPanel);
        titleWelcome.remove(titleLable2);
        titleWelcome.remove(titleLogo);


        titleRegister.add(loginReg);

        ActionListener listener;

        listener = new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                comp = (Component) e.getSource();
                f =(JFrame) SwingUtilities.getRoot(comp);

                if(e.getSource()==backButton) {
                    Window mainWind = (Window) f;
                    mainWind.setWindow(new SignIn());

                }
                else if(e.getSource()==regButton) {

                    String code1=JOptionPane.showInputDialog("Enter Code for Registration");
                    if(code1.equals(code)) {
                        //ENTER DATABASE METHOD FOR REGISTERING USER


                    }
                    else {
                        comp = (Component) e.getSource();
                         f =(JFrame) SwingUtilities.getRoot(comp);
                        JOptionPane.showMessageDialog(f,"Wrong credentials");

                    }
                }

            }



        };
        createButton.addActionListener(listener);
        backButton.addActionListener(listener);
        keyListener2 = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyChar()== KeyEvent.VK_ENTER) {
                    //Call the register method from database
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
        this.add(titleRegister);
        this.add(displayImage);
        this.validate();
        this.repaint();
        this.setVisible(true);
    }
    }


