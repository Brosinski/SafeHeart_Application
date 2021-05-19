
public class Main {
    static char currentwindow;   // Use to keep track of current displayed screen
    // SignIn == 'S'  PatientScreen = 'P'  ClinicianScreen = 'C' InformationScreen =='I'
    static Window window =  new Window();

    public static void main(String[] args) {
        System.out.println("Working");
        Database db = new Database();
        db.createUser("cameronholm982@gmail.com","October","Cameron","Holm");

        new Window().setWindow(new recommendationsGUI());
        window.setWindow(new SignIn());
        currentwindow = 'S';

        }


}


