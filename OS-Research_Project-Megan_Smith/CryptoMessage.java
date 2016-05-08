
package cryptomessage;

import java.security.Key; 
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import sun.misc.*;
import java.io.*;
import java.util.*;


public class CryptoMessage {

    private static final String ALGO = "AES";
    private static final byte[] keyValue = 
        new byte[] { 'T', 'h', 'e', 'B', 'e', 's', 't',
'S', 'e', 'c', 'r','e', 't', 'K', 'e', 'y' };
    
    public static String encrypt(String Data) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.ENCRYPT_MODE, key);
        byte[] encVal = c.doFinal(Data.getBytes());
        String encryptedValue = new BASE64Encoder().encode(encVal);
        return encryptedValue;
    }

    public static String decrypt(String encryptedData) throws Exception {
        Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGO);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedData);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }
     private static Key generateKey() throws Exception {
        Key key = new SecretKeySpec(keyValue, ALGO);
        return key;
}

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        // To use the getFolder method, enter in the pathname to a folder containing a large collection of text files
        System.out.println("Enter in pathname for folder containing text files");
        String path = input.nextLine();
   long folder1= getFolder(path);
   long folder2 = getFolder(path);
   long folder3 = getFolder(path);
   //To use the getFile method, enter the file number pretaining to the updated file 
        System.out.println("Enter file number pretaining to the updated file");
        int fileNumber = input.nextInt();
   long file  = getFile(fileNumber);
   long totalfolder = folder1+folder2+folder3;
   System.out.println("folder: "+totalfolder+" file: "+file);

    }
    
   
    public static long getFolder(String path)throws Exception{
        long startTimePassword = System.nanoTime();
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        String[] files = new String[6];

        for (int i = 0; i < listOfFiles.length; i++) {
            File file = listOfFiles[i];
            String wholeText = "";
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    BufferedReader br = null;
		try {
 
			String sCurrentLine;
			br = new BufferedReader(new FileReader(file));
			while ((sCurrentLine = br.readLine()) != null) {
                            wholeText = wholeText + sCurrentLine;
			}
                        files[i] = wholeText;
 
		} catch (IOException e) {
		
  } 
                
}
}
        for(int i = 0; i<listOfFiles.length; i++){
        String passwordEnc = CryptoMessage.encrypt(files[i]);
        String passwordDec = CryptoMessage.decrypt(passwordEnc);
     
        }
       long durationPassword = (System.nanoTime() - startTimePassword);  
       return durationPassword;
}
    public static long getFile(int f) throws Exception{
        long startTimePassword = System.nanoTime();
        File folder = new File("C:\\Users\\megan\\Desktop\\stuff");
        File[] listOfFiles = folder.listFiles();
     
            File file = listOfFiles[f];
            String wholeText = "";
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    BufferedReader br = null;
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(file));
			while ((sCurrentLine = br.readLine()) != null) {
                            wholeText = wholeText + sCurrentLine;
			}
                        
		} catch (IOException e) {
			
                  
  } 
                
}
        String passwordEnc = CryptoMessage.encrypt(wholeText);
        String passwordDec = CryptoMessage.decrypt(passwordEnc);
        long durationPassword = (System.nanoTime() - startTimePassword);  
        return durationPassword;
        
    }
    
}