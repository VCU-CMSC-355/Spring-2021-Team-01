/* *********************************************************************************** *
 *   Service Broker Module
 *
 * Component: Orchestration 
 * *********************************************************************************** *
 * Function:  Calls the desired service.
 * 
 *----------------------------------------------------------------------------------------------------------------------------------------
 *    Input:   Parameters – Service Code, Parameter List
 *    
 *    Output:  Return – Service Call
 *    
 *----------------------------------------------------------------------------------------------------------------------------------------
 *    Author: Tirth Patel
 *    Review: Sailesh Devkota, Sabri Anan, Chuan Zheng, Gary Preston
 *    Version 04/30/2021   CMCS 355 
 * *********************************************************************************** */ 

import java.io.IOException;
import java.io.InputStream;


public class Service 
{
	public static void main (String []args) throws InterruptedException, IOException 
	{
		
		String serper = args[0];
		String lan = args[1];
		
		int comma = serper.indexOf(',');
	    String lookup = serper.substring(0, comma);
	    String parameter = serper.substring(comma+1);
	    
	    Process proc;
		try {
			
			proc = Runtime.getRuntime().exec("java -jar textbroker.jar"+" "+lookup+" service.txt");
			proc.waitFor();
			InputStream input = proc.getInputStream();
		    
			
		    byte b[]=new byte[input.available()];
		    input.read(b,0,b.length);
		    String y =(new String(b));

		
		    
		    Process proc2 = Runtime.getRuntime().exec(y+" "+parameter+System.lineSeparator()+lan);
		    proc2.waitFor();

		    InputStream input2 = proc2.getInputStream();
		   
		    
		    byte d[]=new byte[input2.available()];
		    input2.read(d,0,d.length);
		    String y2 =(new String(d));

		  
		    
		    System.out.println(y2);
		    
			
		} 
		catch (IOException e1) 
		{
			lan = lan+",703";
	    	  
	    	  Process proc2 = Runtime.getRuntime().exec("java -jar message.jar"+" "+lan);
	  	    proc2.waitFor();

	  	    InputStream input2 = proc2.getInputStream();
	  	   
	  	    
	  	    byte d[]=new byte[input2.available()];
	  	    input2.read(d,0,d.length);
	  	    String y2 =(new String(d));

	  	   
	  	    
	  	    System.out.println(y2);
	    	  
	    	  //out = Message.message (defaultlan);
	    	  
	    	  
	    	 
			
		}
		
	
		
	}
	
}
