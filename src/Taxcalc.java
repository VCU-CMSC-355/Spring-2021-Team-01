//Author - Tirth Patel


import java.io.*;
import java.util.Scanner;
public class Taxcalc {

	public static void main (String []args) throws IOException, InterruptedException
	{
		String para = args[0];
		//String filename = args[1];
		
		//System.out.println("Tax found");
		//Scanner in = new Scanner(System.in);
		//String serper = in.next();
		
		int comma = para.indexOf(',');
	    String amount = para.substring(0, comma);
	    String lookup = para.substring(comma+1);

	    
	   
		
	    Process proc = Runtime.getRuntime().exec("java -jar textbroker.jar"+" "+lookup+" tax.txt");
	    proc.waitFor();

	    InputStream input = proc.getInputStream();
	    InputStream err = proc.getErrorStream();
	    
	   // String out;
		
	    byte b[]=new byte[input.available()];
	    input.read(b,0,b.length);
	    String year = (new String(b));

	    byte c[]=new byte[err.available()];
	    err.read(c,0,c.length);
	    String yearerr = (new String(c));
	    
	    year = year.trim();
	    yearerr = yearerr.trim();
	    
	    tax(year,amount);
	    /* ******************************************* *
	     * add remaining
	     * ******************************************* */
	    
	   // in.close();
	}

	
	
	public static void tax (String year, String amountS) throws IOException, InterruptedException
	{
		
        double amount = Double.parseDouble(amountS);
        
		 String defaultlan = "english";
		
		  //Scanner sc1 = new Scanner(System.in);
	      //String word = sc1.next();
	      boolean flag = false;
	      double tax =0;
	      String taxS = null;
	      int count = 0;
	      //System.out.println("Contents of the line");
	      //Reading the contents of the file
	      Scanner sc = null;
	      
	     if ((year.contains("error")) )
	      {
	    	 defaultlan = defaultlan+",903";
	    	 //System.out.println("903 error");
	    	  //sc = new Scanner(new FileInputStream("messageE.txt"));
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
		    	  
		    	  //out = Message.message (defaultlan);
		    	  
		    	  //return out;
	    	  //return taxS;
	    	  
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
	 	            count = count+1;
	 	            
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

	      }
	      
	      	sc.close();
	System.out.println(taxS);
	}
}


