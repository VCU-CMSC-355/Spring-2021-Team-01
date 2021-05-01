/* ************************************************************************************ *
 *   Error Message Module
 *
 * Component: Utility Manager
 * ************************************************************************************ *
 * Function:  Gives an Error Message based on the error code and language provided.
 * 
 *----------------------------------------------------------------------------------------------------------------------------------------
 *    Input:   Parameters – Message Code, Language
 *    
 *    Output:  Return – Error Message
 *    
 *----------------------------------------------------------------------------------------------------------------------------------------
 *    Author: Tirth Patel
 *    Review: Sailesh Devkota, Sabri Anan, Chuan Zheng, Gary Preston
 *    Version 04/30/2021   CMCS 355 
 * ************************************************************************************ */ 


import java.io.*;
import java.util.Scanner;
public class Message 
{
	public static void main (String []args) throws IOException, InterruptedException
	{
		String para = args[0];
		//String filename = args[1];
		
		//System.out.println("Message found");
		//Scanner in = new Scanner(System.in);
		//String serper = in.next();
		
		int comma = para.indexOf(',');
	    String lookup = para.substring(0, comma);
	    String code = para.substring(comma+1);
	    
	   
		
	    Process proc = Runtime.getRuntime().exec("java -jar textbroker.jar"+" "+lookup+" message.txt");
	    proc.waitFor();

	    InputStream input = proc.getInputStream();
	   
	    
	   // String out;
		
	    byte b[]=new byte[input.available()];
	    input.read(b,0,b.length);
	    String language =(new String(b));

	  
	    
	    language = language.trim();
	    
	    
	    System.out.println(message(language,code));
	    
	    //in.close();
	}
	
	public static String message (String Language, String code) throws IOException, InterruptedException
	{
		
		//Scanner sc1 = new Scanner(System.in);
		
		
	      //String word = sc1.next();
	      boolean flag = false;
	      String out = null;
	      String DefaultLan = "english";
	      
	      Scanner sc = null;
	      if (Language.contains("error")) 
	      {
	    	 
	    	  
	    	  
	    	  Process proc = Runtime.getRuntime().exec("java -jar textbroker.jar"+" "+DefaultLan+System.lineSeparator()+"message.txt");
	  	    proc.waitFor();

	  	    InputStream input = proc.getInputStream();
	  	  
	  	    byte b[]=new byte[input.available()];
	  	    input.read(b,0,b.length);
	  	    String y2 = (new String(b));
	  	    
	  	    y2 = y2.trim();

	    	  
	    	  
	    	  Language = y2;
	    	  
	    	  code = "404";
	    	  
	      }
	      
	      
	    	  
	    	  sc = new Scanner(new FileInputStream(Language));
	    	    
	    
	      while(sc.hasNextLine()&& flag == false) {
	         String line = sc.nextLine();
	         //System.out.println(line);
	         if(line.indexOf(code)!=-1) 
	         {
	            flag = true;
	           
	            if(flag) 
	  	      {
	            	out = String.join(" - ",code,(line.substring(line.lastIndexOf(",") + 1)));
	  	           //System.out.println("Number of occurrences is: "+count);
	  	      } 
	  	       
	         }
	         
	      }
	           
	      
		  
	sc.close();
	return out;
	
	
	}
}
