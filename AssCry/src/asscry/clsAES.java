/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package asscry;


//import java.awt.RenderingHints.Key;


import org.apache.commons.io.IOUtils;
import org.apache.commons.io.input.BOMInputStream;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.modes.AEADBlockCipher;
import org.bouncycastle.crypto.modes.GCMBlockCipher;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 *
 * @author 
 */
public class clsAES {
  AEADBlockCipher cipher = new GCMBlockCipher(new AESEngine());
  //can public key + file
    public void aesEncrypt(String keyFileName, String inputFileName, String encryptedFileName ){
        try{
            byte[] key = readFileAsBytes(keyFileName);
            cipher.init(true, new AEADParameters(new KeyParameter(key),128,key));
            byte[] cipherText  = readFileAsBytes(inputFileName);
            byte[] rv = new byte[cipher.getOutputSize(cipherText.length)];
            int tam = cipher.processBytes(cipherText,0,cipherText.length,rv,0);
            try{
                cipher.doFinal(rv, tam);
            }catch (Exception e){
                e.printStackTrace();
            }
            String fileName = makeNameEn(inputFileName);
            //FileUtil.createDirectory("Encrypted",encryptedFileName);
            FileOutputStream outputFile = new FileOutputStream(encryptedFileName+"\\"+fileName);
            
            outputFile.write(rv);
            outputFile.close();
            //Log.d("SUCESSFULL","Da Ma hoa File");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void aesDecrypt(String keyFileName, String encryptedFilename, String outputFilename){
        try{
            byte[] key = readFileAsBytes(keyFileName);
            cipher.init(false, new AEADParameters(new KeyParameter(key),128,key));
            byte[] cipherText  = readFileAsBytes(encryptedFilename);
            byte[] rv = new byte[cipher.getOutputSize(cipherText.length)];
            int tam = cipher.processBytes(cipherText,0,cipherText.length,rv,0);
            try{
                cipher.doFinal(rv, tam);
            }catch (Exception e){
                e.printStackTrace();
            }
            String fileName = makeNameDe(encryptedFilename);
            //FileUtil.createDirectory("Decrypted",outputFilename);
            //
            //
            FileOutputStream outputFile = new FileOutputStream(outputFilename+"\\"+fileName);
            outputFile.write(rv);
            outputFile.close();
            //Log.d("SUCESSFULLL","Da giai ma File");
            //
            //
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private static byte[] readFileAsBytes(String filePath)
            throws java.io.IOException{
        File file = new File(filePath);
        FileInputStream inputFile = new FileInputStream(file);
        BOMInputStream bomInputStream = new BOMInputStream(inputFile);
        byte[] inputData = IOUtils.toByteArray(bomInputStream);
        bomInputStream.read(inputData);
        inputFile.close();
        bomInputStream.close();
        return inputData;
    }


    public String makeNameEn(String fileName){
        File f = new File(fileName);
        return "aes_"+f.getName();
    }
    public String makeNameDe(String fileName){
        File f = new File(fileName);
        String name = f.getName();
        String[] part = name.split("_",2);
        return part[1];
    }
    
}
