
public class Main {
    static char currentwindow;   // Use to keep track of current displayed screen
    // SignIn == 'S'  PatientScreen = 'P'  ClinicianScreen = 'C' InformationScreen =='I'
    static Window window =  new Window();
    public static void main(String[] args) {


        window.setScreen(new SignIn());
        currentwindow = 'S';

        }
    public static class Controller {
        public void changeScreen(char windowSet) {

            switch (currentwindow) {
                case 'S':
                    window.setScreen(new SignIn());
                    currentwindow= windowSet;
                    
                case 'P':
                    window.setScreen(new patientGUI());
                    currentwindow= windowSet;
            }

        }
    }
}
