import java.text.SimpleDateFormat;

public class Main {
    static char currentwindow;   // Use to keep track of current displayed screen
    // SignIn == 'S'  PatientScreen = 'P'  ClinicianScreen = 'C' InformationScreen =='I'
    static Window window =  new Window();

    public static void main(String[] args) {
        System.out.println("Working");
        Database db = new Database();
        db.createUser("cameronholm982@gmail.com","October","Cameron","Holm");
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy");
        java.util.Date date = new java.util.Date();
        java.sql.Date sqldate =new java.sql.Date(date.getTime());
        System.out.println(sqldate);
        new Window().setWindow(new recommendationsGUI());
        window.setWindow(new SignIn());
        currentwindow = 'S';

        }


}


