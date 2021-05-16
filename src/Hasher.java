import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hasher {

    public String hashStringSHA256(String password) {
        String hashed;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder hexString = new StringBuilder();
            for (int i: hash) {
                hexString.append(String.format("%02x", i));
            }
            hashed = new String(hexString);

            password=hashed;


        } catch (NoSuchAlgorithmException e) {
            System.out.println("Could not hash password");

        }
        return password;
    }

}
