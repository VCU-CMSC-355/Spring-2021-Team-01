//Author - Tirth Patel
//Co-Author - Sailesh Devkota

import java.io.*;
import java.util.Scanner;
public class Translatorapp 
{
	public static void main (String []args) throws IOException, InterruptedException
	{
		String para = args[0];
		//String filename = args[1];
		
		//System.out.println("Translaror found");
		//Scanner in = new Scanner(System.in);
		//String serper = in.next();
		
		int comma = para.indexOf(',');
	    String lookup = para.substring(0, comma);
	    String word = para.substring(comma+1);
	    
	   
		
	    Process proc = Runtime.getRuntime().exec("java -jar textbroker.jar"+" "+lookup+" translator.txt");
	    proc.waitFor();

	    InputStream input = proc.getInputStream();
	    InputStream err = proc.getErrorStream();
	    
	   // String out;
		
	    byte b[]=new byte[input.available()];
	    input.read(b,0,b.length);
	    String language = (new String(b));
	    //System.out.println(language);
	    byte c[]=new byte[err.available()];
	    err.read(c,0,c.length);
	    String lanerr = (new String(c));
	   // System.out.println(lanerr);
	    
	    language = language.trim();
	    lanerr = lanerr.trim();
	    /* ******************************************* *
	     * add remaining
	     * ******************************************* */
	    //System.out.println(lookup+" "+language+" "+word);
	    translator(language,word);
	    //in.close();
	}
	
	
	public static void translator(String Language , String word )throws IOException, InterruptedException
	
	{
		
		
		/*int comma = parameter.indexOf(',');
        String Language = parameter.substring(0, comma);
        String word = parameter.substring(comma+1);
        */
		 String defaultlan = "english";
		  //Scanner sc1 = new Scanner(System.in);
	      //String word = sc1.next();
	      boolean flag = false;
	      String out = null ;
	      String line = null;
	      int count = 0;
	      //System.out.println("Contents of the line");
	      //Reading the contents of the file
	      Scanner sc = null;
	      if(Language.contains("error"))
	      {
	    	 // System.out.println("cought error");
	    	  defaultlan = defaultlan+",805";
	    	  //System.out.println("805 error");
	    	  Process proc2 = Runtime.getRuntime().exec("java -jar message.jar "+defaultlan);
	  	    proc2.waitFor();

	  	    InputStream input2 = proc2.getInputStream();
	  	    InputStream err2 = proc2.getErrorStream();
	  	    
	  	  byte d[]=new byte[input2.available()];
		    input2.read(d,0,d.length);
		    String y2 =(new String(d));

	  	    byte e[]=new byte[err2.available()];
	  	    err2.read(e,0,e.length);
	  	    String z2 = (new String(e));
	  	    
	  	    
	  	  System.out.println(y2);	    	  
	      }
	      
	      else
	      {
	    	  
	    	  
	    	  sc = new Scanner(new FileInputStream(Language));
	    	  while(sc.hasNextLine() && flag == false) 
		      {
		         line = sc.nextLine();
		         
		         //System.out.println(line);
		         if(line.contains(word.toLowerCase())) 
		         {
		            flag = true;
		            count = count+1;
		            	            	  	         
		         }
		      // System.out.println(count);
		         
		        	 
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
	 	  	    InputStream err2 = proc2.getErrorStream();
	 	  	    
	 	  	    byte d[]=new byte[input2.available()];
	 	  	    input2.read(d,0,d.length);
	 	  	    String y2 =(new String(d));

	 	  	    byte e[]=new byte[err2.available()];
	 	  	    err2.read(e,0,e.length);
	 	  	    String z2 = (new String(e));
	 	  	    
	 	  	    out = y2; 
	 	  	 //System.out.println(out);
		      }
	      }
	      
	      
	      
	   
	     
		    sc.close();		    
		    System.out.println(out);
		    
	}

	
}
