/* *********************************************************************************** *
 *   Tax Calculator Module
 *
 * Component: Task Manager
 * *********************************************************************************** *
 * Function:  Calculate tax due based total wages and tax percentage of that tax year.
 * 
 *----------------------------------------------------------------------------------------------------------------------------------------
 *    Input:   Parameters – Total Wages, Tax Year
 *    
 *    Output:  Return – Tax Due
 *    
 *----------------------------------------------------------------------------------------------------------------------------------------
 *    Author: Tirth Patel
 *    Review:  Sailesh Devkota, Sabri Anan, Chuan Zheng, Gary Preston
 *    Version 04/29/2021   CMCS 355 
 * ************************************************************************************ */ 

import java.io.*;
import java.util.Scanner;
public class Taxcalc {

	public static void main (String []args) throws IOException, InterruptedException
	{
		String para = args[0];
		String lan = args[1];
		
		
		int comma = para.indexOf(',');
	    String amount = para.substring(0, comma);
	    String lookup = para.substring(comma+1);

	    
	   
		
	    Process proc = Runtime.getRuntime().exec("java -jar textbroker.jar"+" "+lookup+" tax.txt");
	    proc.waitFor();

	    InputStream input = proc.getInputStream();
	   
		
	    byte b[]=new byte[input.available()];
	    input.read(b,0,b.length);
	    String year = (new String(b));

	    
	    
	    year = year.trim();
	    
	    
	    tax(year,amount,lan);
	    
	}

	
	
	public static void tax (String year, String amountS, String defaultlan) throws IOException, InterruptedException
	{
		
        double amount = Double.parseDouble(amountS);
        
		
	      boolean flag = false;
	      double tax =0;
	      String taxS = null;
	     
	      Scanner sc = null;
	      
	     if ((year.contains("error")) )
	      {
	    	 defaultlan = defaultlan+",903";
	    	 Process proc2 = Runtime.getRuntime().exec("java -jar message.jar "+defaultlan);
		  	    proc2.waitFor();

		  	    InputStream input2 = proc2.getInputStream();
		  	    
		  	  byte d[]=new byte[input2.available()];
			    input2.read(d,0,d.length);
			    String y2 =(new String(d));

		  	  
		  	    System.out.println(y2);
		    	  
		    	
	      }
	      else
	      {
	    	  sc = new Scanner(new FileInputStream(year));
	    	  
	    	  while(sc.hasNextLine() && flag == false) {
		    	  
		    	  
	 	         String line = sc.nextLine();
	 	         int comma2 = line.indexOf(',');
	 	         String parts = line.substring(0, comma2);
	 	         
	 	         double slab = Double.parseDouble(parts);  
	 	         
	 	         //System.out.println(line);
	 	         
	 	         if( amount <= slab) {
	 	            flag = true;
	 	           
	 	         //  System.out.println("counter pass");
	 	            	            
	 	            
	 	  	    /*  else 
	 	  	      {
	 	  	         System.out.println("File does not contain the specified word");
	 	  	      } */		   
	 	         }
	 	         if(flag) 
	 	  	      {
	 	            	String rate = line.substring(line.lastIndexOf(",") + 1);
	 	            //	System.out.println(rate);
	 	            	double rateP = Double.parseDouble(rate); 
	 	            //  System.out.println(rateP);
	 	            	 tax = amount*rateP;
	 	            	
	 	  	            
	 	  	      } 
	 	         
	 	      }
	 	      taxS = String.valueOf(tax); 
	 	     sc.close();
	 	    System.out.println(taxS);
	      }
	      
	      	
	
	}
}


