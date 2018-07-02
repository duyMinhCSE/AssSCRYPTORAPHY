package asscry;



import org.apache.commons.io.IOUtils;
import org.apache.commons.io.input.BOMInputStream;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Security;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

public class clsRSA {

    private static PrivateKey generatePrivateKey(KeyFactory factory, String filename)
            throws InvalidKeySpecException, FileNotFoundException, IOException {
        PemFileRead pemFile = new PemFileRead(filename);
        byte[] content = pemFile.getPemObject().getContent();
        PKCS8EncodedKeySpec privKeySpec = new PKCS8EncodedKeySpec(content);
        return factory.generatePrivate(privKeySpec);
    }

    private static PublicKey generatePublicKey(KeyFactory factory, String filename)
            throws InvalidKeySpecException, FileNotFoundException, IOException {
        PemFileRead pemFile = new PemFileRead(filename);
        byte[] content = pemFile.getPemObject().getContent();
        X509EncodedKeySpec pubKeySpec = new X509EncodedKeySpec(content);
        return factory.generatePublic(pubKeySpec);
    }


    public void rsaEncrypt(String keyFileName, String inputFileName, String encryptedFileName) {
        try {
            Security.addProvider(new BouncyCastleProvider());
            KeyFactory factory = KeyFactory.getInstance("RSA", "BC");
            byte[] data = readFileAsBytes(inputFileName);
            PublicKey pubKey = generatePublicKey(factory,keyFileName);
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding"); //Dam bao tinh toan ven
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);

            String fileName = makeNameEn(inputFileName);
            //FileUtil.createDirectory("Encrypted", encryptedFileName);
            System.out.println(encryptedFileName);
            FileOutputStream outputFile = new FileOutputStream(encryptedFileName +"\\" + fileName);
            byte[] cipherData = cipher.doFinal(data);
            outputFile.write(cipherData);
            outputFile.close();
            //Log.d("SUCESSFULL", "Da Ma hoa File");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void rsaDecrypt(String keyFileName, String encryptedFilename, String outputFilename) {
        try {
            Security.addProvider(new BouncyCastleProvider());
            KeyFactory factory = KeyFactory.getInstance("RSA", "BC");
            byte[] data = readFileAsBytes(encryptedFilename);
            PrivateKey priKey = generatePrivateKey(factory,keyFileName);
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            cipher.init(Cipher.DECRYPT_MODE, priKey);

            String fileName = makeNameDe(encryptedFilename);
            //FileUtil.createDirectory("Decrypted", outputFilename);
            FileOutputStream outputFile = new FileOutputStream(outputFilename+"\\"+ fileName);
            byte[] plainData = cipher.doFinal(data);
            outputFile.write(plainData);
            outputFile.close();
            //Log.d("SUCESSFULLL", "Da giai ma File");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static byte[] readFileAsBytes(String filePath)
            throws java.io.IOException {
        File file = new File(filePath);
        FileInputStream inputFile = new FileInputStream(file);
        BOMInputStream bomInputStream = new BOMInputStream(inputFile);
        byte[] inputData = IOUtils.toByteArray(bomInputStream);
        bomInputStream.read(inputData);
        inputFile.close();
        bomInputStream.close();
        return inputData;
    }
    public String makeNameEn(String fileName) {
        File f = new File(fileName);
        return "rsa_" + f.getName();
    }
    public String makeNameDe(String fileName) {
        File f = new File(fileName);
        String name = f.getName();
        String[] part = name.split("_", 2);
        return part[1];
    }

}
