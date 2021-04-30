/* *************************************************************************************
 *   Translator Module
 *
 * Component: Task Manager
 * *********************************************************************************** *
 * Function:  Translates given word into specified language.
 * 
 *----------------------------------------------------------------------------------------------------------------------------------------
 *    Input:   Parameters – Language, Word
 *    
 *    Output:  Return – Translated Word
 *    
 *----------------------------------------------------------------------------------------------------------------------------------------
 *    Author: Tirth Patel
 *    Co-Author: Sailesh Devkota
 *    Review:  Sabri Anan, Chuan Zheng, Gary Preston
 *    Version 04/30/2021   CMCS 355 
 * *********************************************************************************** */ 


import java.io.*;
import java.util.Scanner;
public class Translatorapp 
{
	public static void main (String []args) throws IOException, InterruptedException
	{
		String para = args[0];
		String lan = args[1];
		
		int comma = para.indexOf(',');
	    String lookup = para.substring(0, comma);
	    String word = para.substring(comma+1);
	    
	   
		
	    Process proc = Runtime.getRuntime().exec("java -jar textbroker.jar"+" "+lookup+" translator.txt");
	    proc.waitFor();

	    InputStream input = proc.getInputStream();
	  
	    byte b[]=new byte[input.available()];
	    input.read(b,0,b.length);
	    String language = (new String(b));
	    
	    language = language.trim();
	    translator(language,word,lan);
	   
	}
	
	
	public static void translator(String Language , String word, String defaultlan )throws IOException, InterruptedException
	
	{
		   boolean flag = false;
	      String out = null ;
	      String line = null;
	      
	      Scanner sc = null;
	      if(Language.contains("error"))
	      {
	    	
	    	  defaultlan = defaultlan+",805";
	    	 
	    	  Process proc2 = Runtime.getRuntime().exec("java -jar message.jar "+defaultlan);
	  	    proc2.waitFor();

	  	    InputStream input2 = proc2.getInputStream();
	  	    
	  	  byte d[]=new byte[input2.available()];
		    input2.read(d,0,d.length);
		    String y2 =(new String(d));
    
	  	  System.out.println(y2);
	  	  return;
	      }
	      
	      else
	      {
	    	  
	    	  
	    	  sc = new Scanner(new FileInputStream(Language));
	    	  while(sc.hasNextLine() && flag == false) 
		      {
		         line = sc.nextLine();
		         
		         
		         if(line.contains(word.toLowerCase())) 
		         {
		            flag = true;
		         
		            	            	  	         
		         }
		     
		         
		        	 
		       }
		      
		      
		      if(flag == true) 
	  	      {
	            	
	            	out = (line.substring(line.lastIndexOf(",") + 1));
	            		  	            
	  	      } 
	         else
	         {
	        	 defaultlan = defaultlan+",813";
	        	 //out = Message.message (defaultlan);
	        	 //System.out.println("813 error");
	        	Process proc2 = Runtime.getRuntime().exec("java -jar message.jar "+defaultlan);
	 	  	    proc2.waitFor();

	 	  	    InputStream input2 = proc2.getInputStream();
	 	  	    
	 	  	    byte d[]=new byte[input2.available()];
	 	  	    input2.read(d,0,d.length);
	 	  	    String y2 =(new String(d));

	 	  	    
	 	  	    out = y2; 
	 	  	 
		      }
		      sc.close();
		      
			    System.out.println(out);
	      }
	    
		    
	}

	
}
