public class ReynoldsRiskScore extends Patient{
    
    private String riskExplationsList[];
    private Patient p = new Patient();

    public ReynoldsRiskScore(){

    }

    public double CalulateRRS(boolean s, boolean d, boolean fam, double rrs, double percent){
       rrs = (0.07799 * p.getAge()) + (3.137 * Math.log(p.getBloodPressure())) 
           + (0.180 * Math.log(p.getHsCRP())) + (1.382 * Math.log(p.getCholesterol()))
           - (1.172 * Math.log(p.getHDLCholesterol()));

        d = p.isDiabetes();
        s = p.getSmokerStatus();
        fam = p.isFamilyHistory();

           if(d == true && s == true && fam == true){
               rrs += (0.134 * (p.getHbA1C() / 100));
               rrs += 0.818;
               rrs += 0.438;
           }

           else if(d == true && s == true && !fam){
               rrs += (0.134 * (p.getHbA1C() / 100));
               rrs += 0.818;
           }

           else if(d == true && !s && fam == true){
                rrs += (0.134 * (p.getHbA1C() / 100));
                rrs += 0.438;
           }

           else if(!d && s == true && fam == true){
                rrs += 0.818;
                rrs += 0.438;
           }

           else if(d == true && !s && !fam){
                rrs += (0.134 * (p.getHbA1C() / 100));
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

        percent = (1-Math.pow(0.98634,(rrs-22.325)) * 100);

        return percent; 
    }
}
