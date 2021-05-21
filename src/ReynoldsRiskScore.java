public class ReynoldsRiskScore {
    
    private String riskExplationsList[];
    private Patient p ;
    boolean s;
    boolean d;
    boolean fam;
    double rrs;
    double percent;
    private int bloodPressure;
    private int totalCholesterol;
    private int HDLCholesterol;
    private String gender;
    private int age;
    private int hsCRP;
    private double HbA1C;
    private boolean smoker;
    private boolean diabetes;

    public ReynoldsRiskScore(){

    }

    public double calulateRRS(Patient p){
        this.p=p;
        bloodPressure = p.getBloodPressure();
        HDLCholesterol = p.getBloodPressure();
        totalCholesterol = p.getCholesterol();
        age = p.getAge();
        HbA1C = p.getHbA1C();
        hsCRP=p.getHsCRP();

        if(bloodPressure<105)
            bloodPressure=105;
        if(totalCholesterol<140)
            totalCholesterol=140;
        if(HDLCholesterol<30)
            HDLCholesterol=30;
        if(HDLCholesterol>150)
            HDLCholesterol=150;
        if(age>40)
            age =40;

       rrs = (0.07799 * p.getAge()) + (3.137 * Math.log(bloodPressure))
           + (0.180 * Math.log(hsCRP)) + (1.382 * Math.log(totalCholesterol))
           - (1.172 * Math.log(HDLCholesterol));

        d = p.isDiabetes();
        s = p.getSmokerStatus();
        fam = p.isFamilyHistory();

           if(d == true && s == true && fam == true){
               rrs += (0.134 * (HbA1C / 100));
               rrs += 0.818;
               rrs += 0.438;
           }

           else if(d == true && s == true && !fam){
               rrs += (0.134 * (HbA1C / 100));
               rrs += 0.818;
           }

           else if(d == true && !s && fam == true){
                rrs += (0.134 * (HbA1C / 100));
                rrs += 0.438;
           }

           else if(!d && s == true && fam == true){
                rrs += 0.818;
                rrs += 0.438;
           }

           else if(d == true && !s && !fam){
                rrs += (0.134 * (HbA1C / 100));
           }

           else if(!d && !s && fam == true){
                rrs += 0.438;
           }

           else if(!d && s == true && !fam){
                rrs += 0.818;
           }

           else{
               rrs+= 0;
           }

        percent = ((1-Math.pow(0.98634,(rrs-22.325)))*100);



        return percent; 
    }
}
