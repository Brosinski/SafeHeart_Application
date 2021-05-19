import java.util.ArrayList;

public class Clinician{

    private int clinicianID;
    private ArrayList<Hospital> hList = new ArrayList<Hospital> ();
    private ArrayList<Patient> pList = new ArrayList<Patient> ();
    private String clinicianType;

    public Clinician(int id, String type){
        clinicianID = id;
        clinicianType = type;
    }

    public void setID(int id){
        this.clinicianID = id;
    }

    public void setType(String type){
        this.clinicianType = type;
    }

    public void addHospital(Hospital h){
        hList.add(h);
    }

    public void addPatient(Patient p){
        pList.add(p);
    }

    public int getID(){
        return clinicianID;
    }

    public String getType(){
        return clinicianType;
    }

    public ArrayList<Hospital> getHospitalList(){
        return hList;
    }

    public Patient searchPatients(Patient p, ArrayList<Patient> pList){
        for(int i = 0; i < pList.size(); i++){
            if(pList.get(i).equals(p)){
                return pList.get(i);
            }
        }
        return p;
    }







}