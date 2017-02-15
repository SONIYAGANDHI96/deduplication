
import java.io.FileInputStream;
import java.security.MessageDigest;

public class  SHAChecksumExample
{
    public static void main(String[] args)throws Exception
    {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        MessageDigest md1 = MessageDigest.getInstance("SHA-256");
        FileInputStream fis = new FileInputStream("d:\\programs\\soni\\main1.java");
        FileInputStream fis1 = new FileInputStream("d:\\programs\\soni\\main.java");
        
      

        byte[] dataBytes = new byte[1024];

        int nread = 0;
        while ((nread = fis.read(dataBytes)) != -1) {
          md.update(dataBytes, 0, nread);
        };
        byte[] mdbytes = md.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < mdbytes.length; i++) {
          sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        System.out.println("Hex format : " + sb.toString());
        byte[] dataBytes1 = new byte[1024];

        int nread1 = 0;
        while ((nread1 = fis1.read(dataBytes1)) != -1) {
          md1.update(dataBytes1, 0, nread1);
        };
        byte[] mdbytes1 = md1.digest();

        //convert the byte to hex format method 1
        StringBuffer sb1 = new StringBuffer();
        for (int i = 0; i < mdbytes1.length; i++) {
          sb1.append(Integer.toString((mdbytes1[i] & 0xff) + 0x100, 16).substring(1));
        }

        System.out.println("Hex format : " + sb1.toString());
/*
       //convert the byte to hex format method 2
        StringBuffer hexString = new StringBuffer();
    	for (int i=0;i<mdbytes.length;i++) {
    	  hexString.append(Integer.toHexString(0xFF & mdbytes[i]));
    	}

    	System.out.println("Hex format : " + hexString.toString());*/
    String s1=sb1.toString();
    String s2=sb.toString();
     if(s2.equals(s1))
         System.out.println("same file");
     else
         System.out.println("not same");
    }
}
