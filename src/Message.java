//Author - Tirth Patel

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
	    InputStream err = proc.getErrorStream();
	    
	   // String out;
		
	    byte b[]=new byte[input.available()];
	    input.read(b,0,b.length);
	    String language =(new String(b));

	    byte c[]=new byte[err.available()];
	    err.read(c,0,c.length);
	    String lanerr = (new String(c));
	    
	    language = language.trim();
	    lanerr = lanerr.trim();
	    /* ******************************************* *
	     * add remaining
	     * ******************************************* */
	    
	    System.out.println(message(language,code));
	    
	    //in.close();
	}
	
	public static String message (String Language, String code) throws FileNotFoundException
	{
		
		//Scanner sc1 = new Scanner(System.in);
		
		
	      //String word = sc1.next();
	      boolean flag = false;
	      String out = null;
	      
	      int count = 0;
	      //System.out.println("Contents of the line");
	      //Reading the contents of the file
	      Scanner sc = null;
	      if (Language.contains("error")) 
	      {
	    	  sc = new Scanner(new FileInputStream("msgEng.txt"));
	    	  code = "404";
	      }
	      
	      else
	      {
	    	  
	    	  sc = new Scanner(new FileInputStream(Language));
	    	    
	      }
	      while(sc.hasNextLine()&& flag == false) {
	         String line = sc.nextLine();
	         //System.out.println(line);
	         if(line.indexOf(code)!=-1) 
	         {
	            flag = true;
	            count = count+1;
	            if(flag) 
	  	      {
	            	out = String.join(" - ",code,(line.substring(line.lastIndexOf(",") + 1)));
	  	           //System.out.println("Number of occurrences is: "+count);
	  	      } 
	  	      else 
	  	      {
	  	         out = "File does not contain the specified word";
	  	      }		   
	         }
	         
	      }
	           
	      
		  
	sc.close();
	return out;
	
	
	}
}
