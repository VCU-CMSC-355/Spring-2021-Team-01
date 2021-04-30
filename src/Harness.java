/* *********************************************************************************** *
 *   Harness
 *
 * 
 * *********************************************************************************** *
 * Function:  Calculate tax due based total wages and tax percentage of that tax year.
 * 
 *----------------------------------------------------------------------------------------------------------------------------------------
 *    Input:   Parameters – Service, Message Language
 *    
 *    Output:  Return – Tax Due
 *    
 *----------------------------------------------------------------------------------------------------------------------------------------
 *    Author: Tirth Patel
 *    Review:  Sailesh Devkota, Sabri Anan  
 *    Version 04/30/2021   CMCS 355 
 * *********************************************************************************** */ 

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Harness 
{
	public static void main(String []args) throws IOException, InterruptedException 
	{
		System.out.println("Enter service in the format (Servicecode,Parameter 1,Parameter 2)");	
	Scanner in = new Scanner(System.in);
	String parameter = in.next();
	System.out.println("Enter Message Language");	
	String lan = in.next();
	Process proc = Runtime.getRuntime().exec("java -jar service.jar "+parameter+" "+lan);
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
