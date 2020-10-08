import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class HMAC {
    public byte[] key;
    public byte[] hmac;

    public static byte[] keyGenerate() throws NoSuchAlgorithmException {
        SecureRandom random = SecureRandom.getInstanceStrong();
        byte[] values = new byte[32];
        random.nextBytes(values);
        return values;
    }
    public void printKey(byte[] key){
    System.out.printf("Key: %032x%n", new BigInteger(1, key));
    }
    public static byte[] hmacGenerate(byte[] secretKey, byte[] message) {
        byte[] hmacSha256;
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey, "HmacSHA256");
            mac.init(secretKeySpec);
            hmacSha256 = mac.doFinal(message);
        }
        catch (Exception e) {
            throw new RuntimeException("Failed to calculate hmac-sha256", e);
        }
        return hmacSha256;
    }
    public void printHMAC(byte[] hmac){
        System.out.printf("HMAC: %032x%n", new BigInteger(1, hmac));
    }
}