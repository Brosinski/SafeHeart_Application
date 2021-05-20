import java.util.Date;
import java.text.SimpleDateFormat;

public class Patient{

    private int bloodPressure;
    private int totalCholesterol;
    private int HDLCholesterol;
    private String gender;
    private int age;
    private int hsCRP;
    private double rrs;
    private double HbA1C;
    private boolean smoker;
    private boolean diabetes;



    private boolean familyHistory;
    public Patient(){

    }
    public Patient(int cl, int bp, int rr, int hs){

        totalCholesterol= cl;
        bloodPressure = bp;
        hsCRP = hs;
        rrs = rr;
    }
    public int getHDLCholesterol() {
        return HDLCholesterol;
    }

    public void setHDLCholesterol(int HDLCholesterol) {
        this.HDLCholesterol = HDLCholesterol;
    }
    public void setTotalCholesterol(int cl){
        totalCholesterol = cl;
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
        return totalCholesterol;
    }

    public int getBloodPressure(){
        return bloodPressure;
    }

     public void setGender(String gender){
        this.gender=gender;
     }
    public String getGender(){
        return gender;
    }

    public boolean getSmokerStatus(){
        return smoker;
    }
    public void setSmoker(boolean smoker) {
        this.smoker = smoker;
    }
    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age=age;
    }
    public boolean isFamilyHistory() {
        return familyHistory;
    }

    public double getHbA1C() {
        return HbA1C;
    }

    public void setHbA1C(double hbA1C) {
        HbA1C = hbA1C;
    }

    public void setFamilyHistory(boolean familyHistory) {
        this.familyHistory = familyHistory;
    }
    public boolean isDiabetes() {
        return diabetes;
    }

    public void setDiabetes(boolean diabetes) {
        this.diabetes = diabetes;
    }
    public int getHsCRP() {
        return hsCRP;
    }

    public void setHsCRP(int hsCRP) {
        this.hsCRP = hsCRP;
    }
    public String printPatientDocument(String msg){
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
        Date dateTime = new Date();

        msg = df.format(dateTime) + "\nNursing Notes: \n" + bloodPressure
                + "\n" + totalCholesterol + "\n" + rrs + "\n" + smoker + "\n" + hsCRP +"\n"+HDLCholesterol;
        return msg;
    }
}