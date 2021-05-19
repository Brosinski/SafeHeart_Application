import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.sql.DataSource;

public class Database {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    Hasher hashed = new Hasher();

    public Database() {
        try {
            Class.forName("com.mysql.jdbc.Driver");


            // Setup the connection with the DB
            connect = DriverManager.getConnection("jdbc:mysql://35.157.16.43:3306/sql11409918"
                    , "sql11409918", "ebpMf3ffjG");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("FAILED");

        }
    }


    public boolean confirmCredentials(String email, String pass) {
        boolean val = true;
        try {

            statement = connect.createStatement();
            resultSet = statement
                    .executeQuery("select * from User where User_Email = '" + email + "'");
            if (resultSet.next() == false) {
                System.out.println("There were no results");
                val = false;
            }

            //Hashes the passed in value
            pass = hashed.hashStringSHA256(pass);         //Hashes password and compares it to one associated with entered email.
            resultSet.beforeFirst();
            while (resultSet.next()) {
                String password = resultSet.getString("User_Password");
                if (password.equals(pass)) {         //Returns true if password is correct
                    val = true;

                } else if (!password.equals(pass)) {
                    val = false;


                    System.out.println(password);


                }

            }


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("FAILED");
            return false;
        }
        System.out.println("Successfully Established connection");
        return val;
    }
    public boolean registerPatient(String email, String password, String firstName, String familyName){
        boolean val = true;

        if(createUser(email,password,firstName,familyName)) {
            int id = generateIDCode();
            if(!checkForID(id)==true) {
                try {
                    statement = connect.createStatement();


                    PreparedStatement preparedStatement = connect.prepareStatement("insert into Patient(Pat_Email, Pat_ID)" + "values(?,?)");
                    preparedStatement.setString(1, email);
                    preparedStatement.setInt(2, id);
                    preparedStatement.execute();

                } catch (SQLException e) {
                    val =false;
                }
            }
            else {
            val=false;
            }


        }
        else{
            val=false;
        }
        return val;
    }

    public boolean registerClinician(String email, String password, String firstName, String familyName,boolean isSpecialPrac){
        boolean val = true;
        String type;
        if(createUser(email,password,firstName,familyName)) {
            int id = generateIDCode();
            if(isSpecialPrac) {
                type="GP";
            }
            else{
                type="SP";
            }
            if(!checkForID(id)==true) {
                try {
                    statement = connect.createStatement();


                    PreparedStatement preparedStatement = connect.prepareStatement("insert into Clinicianggggggggg (Clin_Email, Clin_ID, Clin_Type)" + "values(?,?,?)");
                    preparedStatement.setString(1, email);
                    preparedStatement.setInt(2, id);
                    preparedStatement.setString(3, type);
                    preparedStatement.execute();

                } catch (SQLException e) {
                    val =false;
                }
            }
            else {
                val=false;
            }


        }
        else{
            val=false;
        }
        return val;
    }
    public boolean createUser(String email, String password, String firstName, String familyName) {

        password = hashed.hashStringSHA256(password);


        try {

            statement = connect.createStatement();


            PreparedStatement preparedStatement = connect.prepareStatement("insert into User(User_Email, User_Password, User_FirstName,User_FamilyName)" + "values(?,?,?,?)");
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, familyName);
            preparedStatement.execute();

        } catch (SQLException e) {
            System.out.println("This user already exists in the database");
            return false;
        } catch (Exception e) {
            System.out.println("An unknown error occured");
            e.printStackTrace();
            return false;

        }
        return true;
    }

    public int getPatientID(String email) {         //Returns an int of zero on SQL
        int val = 0;
        try {

            statement = connect.createStatement();
            resultSet = statement
                    .executeQuery("select Pat_ID from Patient where Pat_email = '" + email + "'");
            if (resultSet.next() == false) {
                System.out.println("There were no results");
                return val;
            }
            val = resultSet.getInt("Pat_ID");

        } catch (SQLException e) {
            System.out.println("Email doesn't exist in database");
        }
        return val;
    }


    public int getClinicianID(String email) {         //Returns an int of zero on SQL
        int val = 0;
        try {

            statement = connect.createStatement();
            resultSet = statement
                    .executeQuery("select Clin_ID from Clinician where Clin_Email = '" + email + "'");
            if (resultSet.next() == false) {
                System.out.println("There were no results");
                return val;
            }
            val = resultSet.getInt("Clin_ID");

        } catch (SQLException e) {
            System.out.println("Email doesn't exist in database");
        }
        return val;
    }

    public int generateIDCode() {
        String code ="";
        int intcode =0;
        String c;
        for(int i =0; i<8;i++) {
            if(i==0) {
                c=String.valueOf((int)(Math.random()*11+1));
                code = code +c;
            }
            else{

                c=String.valueOf((int)(Math.random()*11));
                code = code +c;
            }

        }
        intcode =Integer.parseInt(code);
        return intcode;
    }
    public boolean checkForID(int id){
        boolean val = false;
        try {
            statement = connect.createStatement();
            resultSet = statement
                    .executeQuery("select * from Clinician where Clin_ID  = '" + id + "'");
            if (resultSet.next() == true) {
                System.out.println("This already exists");
                return true;
            }

        }catch(SQLException e){
            System.out.println("Something went wrong");
        }
        try {
            statement = connect.createStatement();
            resultSet = statement
                    .executeQuery("select * from Patient where Pat_ID  = '" + id + "'");
            if (resultSet.next() == true) {
                System.out.println("There were no results");
                return true;
            }

        }catch(SQLException e){
            System.out.println("Something went wrong");
        }

        return val;
    }
    public boolean pairPatient(int Pat_id,int Clin_id) {
        boolean val=true;
        try {
            statement = connect.createStatement();


            PreparedStatement preparedStatement = connect.prepareStatement("insert into PatientClinician(Pat_ID, Clin_ID)" + "values(?,?)");
            preparedStatement.setInt(1, Pat_id);
            preparedStatement.setInt(2, Clin_id);
            preparedStatement.execute();
            }
        catch (SQLException e) {
            System.out.println("Patient was already paired with clinician");
            val =true;
        }
        return val;
    }
    public ArrayList<Integer> getPatientList(int id) {
        ArrayList<Integer> array = new ArrayList<>();
        try {
            statement = connect.createStatement();
            resultSet = statement
                    .executeQuery("select * from PatientClinician where Clin_ID  = '" + id + "'");
            while(resultSet.next()) {
                array.add(resultSet.getInt("Pat_ID"));
            }

        }
        catch(SQLException e){
            System.out.println("There was an error retrieving the patient list");
        }
        return array;
    }

    public boolean setPatientInformation(int id,String gender, int age,int totalcholestorol,int hdlcholestorol, int bloodpressure, int hsCRP,boolean diabetes,boolean smokes,boolean family_history){
        boolean val =true;
        try {
            statement = connect.createStatement();


            PreparedStatement preparedStatement = connect.prepareStatement("insert into PatientInformation(Pat_ID,Pat_Gender,Pat_Age,Pat_TotalCholestorol,Pat_HDLCholestorol,Pat_BP,Pat_hsCRP,Pat_Diabetes,Pat_Smokes,Pat_FamilyHistory)" + "values(?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, gender);
            preparedStatement.setInt(3, age);
            preparedStatement.setInt(4, totalcholestorol);
            preparedStatement.setInt(5, hdlcholestorol);
            preparedStatement.setInt(6, bloodpressure);
            preparedStatement.setInt(7, hsCRP);
            preparedStatement.setBoolean(8, diabetes);
            preparedStatement.setBoolean(9, smokes);
            preparedStatement.setBoolean(10, family_history);
            preparedStatement.execute();
        }
        catch (SQLException e) {
        }

        return val;
    }
    public boolean getPatientInformation(int id){
        boolean val=true;
        try {

            statement = connect.createStatement();
            resultSet = statement
                    .executeQuery("select * from PatientInformation where Pat_ID= '" + id + "'");
            if (resultSet.next() == false) {
                System.out.println("There were no results");
                val = false;
            }
            else{

                //FILL PATIENT INFORMATION OBJECT WITH RESULTS

            }

        }
        catch (SQLException e){

        }
        return val;
    }
    }


