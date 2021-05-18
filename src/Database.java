import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.sql.DataSource;

public class Database {
    private Connection connect = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    Hasher hashed= new Hasher();
    public Database() {
        try {
            Class.forName("com.mysql.jdbc.Driver");


            // Setup the connection with the DB
            connect = DriverManager.getConnection("jdbc:mysql://sql11.freemysqlhosting.net:3306/sql11409918"
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
                    .executeQuery("select * from credentials where email = '" + email + "'");
            if (resultSet.next() == false) {
                System.out.println("There were no results");
                val = false;
            }

            //Hashes the passed in value
            pass = hashed.hashStringSHA256(pass);         //Hashes password and compares it to one associated with entered email.
            resultSet.beforeFirst();
            while (resultSet.next()) {
                String password =resultSet.getString("password");
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

    public boolean sendCredentials(String email, String password) {

        password =hashed.hashStringSHA256(password);


        try {
            statement = connect.createStatement();


              PreparedStatement preparedStatement= connect.prepareStatement("insert into credentials (email, password)" + "values(?,?)");
              preparedStatement.setString(1,email);
              preparedStatement.setString(2,password);
              preparedStatement.execute();


        }catch(Exception e) {
                System.out.println("Failed to insert");
                e.printStackTrace();
                return false;

        }
        return true;
    }
}
