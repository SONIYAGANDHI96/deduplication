
import java.io.FileInputStream;
import java.security.MessageDigest;

public class yyy
{
    public static void main(String[] args)throws Exception
    {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
		MessageDigest md1 = MessageDigest.getInstance("SHA-256");
        FileInputStream fis = new FileInputStream("bb.txt");
		FileInputStream fis1 = new FileInputStream("aa.txt");
		

        byte[] dataBytes = new byte[1024];
		byte[] dataBytes1 = new byte[1024];

        int nread = 0,nread1=0;
        while ((nread = fis.read(dataBytes)) != -1) {
          md.update(dataBytes, 0, nread);
        }
		while ((nread1 = fis1.read(dataBytes1)) != -1) {
          md1.update(dataBytes1, 0, nread1);
        }
        byte[] mdbytes = md.digest();
		byte[] mdbytes1 = md1.digest();

        //convert the byte to hex format method 1
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < mdbytes.length; i++) {
          sb.append(Integer.toString((mdbytes[i] & 0xff) + 0x100, 16).substring(1));
        }

        System.out.println("Hex format : " + sb.toString());
		StringBuffer sb1 = new StringBuffer();
        for (int i = 0; i < mdbytes1.length; i++) {
          sb1.append(Integer.toString((mdbytes1[i] & 0xff) + 0x100, 16).substring(1));
        }

        System.out.println("Hex format : " + sb1.toString());
		String st1=sb.toString();
		String st2=sb1.toString();
		if(st1.equals(st2))
			System.out.println("same");
		else
			System.out.println("not same");


       
    }
}