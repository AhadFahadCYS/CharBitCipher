
package charbit.cipher;
import java.util.Scanner;
public class CharBitCipher {

    public static void main(String[] args) {
       Scanner input=new Scanner(System.in);
       System.out.println("Enter the plaintext you want to encrypt");
        String plaintext= input.next();
        plaintext=plaintext.toUpperCase();
         System.out.println("Enter the first key 'To shift' ");
        int key1=input.nextInt();
       String shiftText=(shiftText(plaintext, key1));
        System.out.println( shiftText);
        
        //2
        String binaryPlaintext = stringToBinary(shiftText);
        System.out.println("ciphertext1 in Binary " + binaryPlaintext);
         binaryPlaintext = binaryPlaintext.replaceAll("[^0-1]", "");
        System.out.println("Enter the second key as the same length as the plaintext ");
        String keyXor=input.next();
        keyXor=keyXor.toUpperCase();
        String binaryKey=stringToBinary(keyXor);
        System.out.println("Key in binary : "+binaryKey);
            binaryKey= binaryKey.replaceAll("[^0-1]", "");
        String rotatedKey=rotateBinary(binaryKey);
        System.out.println("Key after Rotate "+rotatedKey);
           rotatedKey= rotatedKey.replaceAll("[^0-1]", "");
        String XorResultBinary=XOR(binaryPlaintext, rotatedKey);
        System.out.println("XOR between plaintext and rotated key : "+XorResultBinary);
        String XorResultString= binaryToString(XorResultBinary) ;
        System.out.println("The CipherText : "+XorResultString);
       
        //Decryption
        System.out.println("Enter the ciphertext: ");
        String ciphertext = input.next();
        ciphertext=ciphertext.toUpperCase();
      String cipherTextBinary=stringToBinary(ciphertext);
      cipherTextBinary=cipherTextBinary.replaceAll("[^0-1]", "");
        System.out.println("Enter the key ");
       String keyCipher = input.next();
       keyCipher=keyCipher.toUpperCase();
          String cipherKeyBinary=stringToBinary(keyCipher);
          cipherKeyBinary=cipherKeyBinary.replaceAll("[^0-1]", "");
         
           String rotatedKey2=rotateBinary(cipherKeyBinary);
          String XorResultBinary2=XOR(cipherTextBinary, rotatedKey2);
          String plaintext1=binaryToString(XorResultBinary2) ;
          System.out.println("The result of step1: "+XorResultBinary2);
           System.out.println("Enter the shift key : ");
           int shiftKey=input.nextInt();
           String originalPlaintext= reverseShiftText(plaintext1, shiftKey);
           System.out.println("The plaintext is : "+originalPlaintext);
        
    
      
        
    }
        
        
    
    

    
    public static void encrypt(){
        
    }
      public static void decrypt(){
        
    }
      //Apply Step1 in CharBit cipher 
    public static String shiftText(String plaintext, int key) {
        String cipher1 = "";
        for (int i = 0; i < plaintext.length(); i++) {
            char c = (char) (((int) plaintext.charAt(i)
                    + key - 65) % 26 + 65);
            cipher1 += c;
        }
        return cipher1;
    }

    public static String reverseShiftText(String plaintext, int key) {
        String plaintext1 = "";
        for (int i = 0; i < plaintext.length(); i++) {
            char c = (char) (((int) plaintext.charAt(i)
                    - key - 65) % 26 + 65);
            plaintext1 += c;
        }
        return plaintext1;
    }
    //Covert a given String to Binary
        static String stringToBinary(String s) {
        byte[] bytes = s.getBytes();
        StringBuilder binary = new StringBuilder();
        for (byte b : bytes) {
            String str=Integer.toBinaryString(b);
            StringBuilder padding= new StringBuilder();
            for (int i = 0; i < (8-str.length());i++)
                padding.append("0");
            binary.append(padding).append(str).append(" ");
        }
        System.out.println(binary);
        return binary.toString();
    }
    //Convert a given Binary Represenation to String
    public static String binaryToString(String binaryString) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < binaryString.length(); i += 8) {
        String binaryByte = binaryString.substring(i, Math.min(i + 8, binaryString.length()));
        int decimalValue = Integer.parseInt(binaryByte, 2);
        stringBuilder.append((char) decimalValue);
    }
    return stringBuilder.toString();
}
    

    public static String rotateBinary(String binaryString) {
        String rotatedString = binaryString.substring(1) + binaryString.charAt(0);
        return rotatedString;
    }

  public static String XOR(String inputString, String key) {
        String outputString = "";

        int len = key.length();

        for (int i = 0; i < len; i++) {
            outputString = outputString +
                    ((inputString.charAt(i) ^ key.charAt(i)));
        }

        return outputString;
    }
  
  
}
    
    

  
  
  
  
    
  
    
    

