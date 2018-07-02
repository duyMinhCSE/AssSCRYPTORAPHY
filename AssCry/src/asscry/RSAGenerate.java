package asscry;



import java.io.File;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class RSAGenerate {
    public static final int KEY_SIZE = 4096;

    public static void saveKeyFile()  {
        try{
            //String filePath = "C:\\";
            //FileUtil.createDirectory("KeyRSA","//storage//emulated//0//Crypto//");
            File directory = new File("");
            String fileName = directory.getAbsolutePath();
            Security.addProvider(new BouncyCastleProvider());
            KeyPair keyPair = generateRSAKeyPair();
            RSAPrivateKey priv = (RSAPrivateKey) keyPair.getPrivate();
            RSAPublicKey pub = (RSAPublicKey) keyPair.getPublic();
            writePemFile(priv, "RSA PRIVATE KEY", fileName+"\\rsa_priv.txt");
            writePemFile(pub, "RSA PUBLIC KEY", fileName+"\\rsa_pub.txt");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static KeyPair generateRSAKeyPair() throws NoSuchAlgorithmException, NoSuchProviderException {
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA", "BC");
        generator.initialize(KEY_SIZE);
        KeyPair keyPair = generator.generateKeyPair();
        return keyPair;
    }

    private static void writePemFile(Key key, String description, String filename)
            throws FileNotFoundException, IOException {
        PemFileWrite pemFile = new PemFileWrite(key, description);
        pemFile.write(filename);}
}

