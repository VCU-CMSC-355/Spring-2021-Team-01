
//import java.io.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Harness 
{
	public static void main(String []args) throws IOException, InterruptedException 
	{
		System.out.println("enter servicecode");	
	Scanner in = new Scanner(System.in);
	String parameter = in.next();
	
	Process proc = Runtime.getRuntime().exec("java -jar service.jar "+parameter);
	proc.waitFor();
	InputStream input = proc.getInputStream();
    InputStream err = proc.getErrorStream();
    
   // String out;
	
    byte b[]=new byte[input.available()];
    input.read(b,0,b.length);
    String y =(new String(b));

    byte c[]=new byte[err.available()];
    err.read(c,0,c.length);
    String z = (new String(c));
    
    System.out.println(y);
    System.out.println(z);
    in.close();
	}
}
