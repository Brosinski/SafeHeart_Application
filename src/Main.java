import java.text.SimpleDateFormat;

public class Main {
    static char currentwindow;   // Use to keep track of current displayed screen
    // SignIn == 'S'  PatientScreen = 'P'  ClinicianScreen = 'C' InformationScreen =='I'
    static Window window =  new Window();

    public static void main(String[] args) {

        new Window().setWindow(new recommendationsGUI());
        window.setWindow(new SignIn());
        currentwindow = 'S';

        }


}


