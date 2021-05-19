import java.util.Date;
import java.text.SimpleDateFormat;

public class Patient{
    private int cholesterolLevel;
    private int bloodPressure;

    private int hsCRP;
    private double rrs;
    private boolean smoker;

    public Patient(int cl, int bp, int rr, int hs){

        cholesterolLevel = cl;
        bloodPressure = bp;
        hsCRP = hs;
        rrs = rr;
    }

    public void setCholesterol(int cl){
        cholesterolLevel = cl;
    }

    public void sethsCRP(int hs){
        hsCRP = hs;
    }

    public void setBloodPressure(int bp){
        bloodPressure = bp;
    }

    public void setRRS(int a, int b, int c, int d){
        rrs = Math.round((a /(a+b)) / (c /(c+d)) * 100.0) / 100.0;
    }

    public void isSmoker(char s){
        if(s == 'Y'){
            this.smoker = true;
        }

        else if(s == 'N'){
            this.smoker = false;
        }
    }

    public int getCholesterol(){
        return cholesterolLevel;
    }

    public int getBloodPressure(){
        return bloodPressure;
    }



    public boolean getSmokerStatus(){
        return smoker;
    }

    public String printPatientDocument(String msg){
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateTime = new Date();

        msg = df.format(dateTime) + "\nNursing Notes: \n" + bloodPressure
                + "\n" + cholesterolLevel + "\n" + rrs + "\n" + smoker + "\n" + hsCRP +"\nImage Results:  ";
        return msg;
    }
}