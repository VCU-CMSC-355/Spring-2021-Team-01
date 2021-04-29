

import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class textbroker 
{
	public static void main (String []args) throws IOException, InterruptedException
	{
		
		
		String lookup = args[0];
		String filename = args[1];
		
	    String out = null;
	    String line = null;
	    boolean flag = false;
	    
	       Scanner sc = new Scanner(new FileInputStream(filename));
	       
	       while (sc.hasNextLine()&& flag == false)
	       {
	    	   
	    	   line = sc.nextLine();
		       if (line.toLowerCase().contains(lookup.toLowerCase())) 
			   {
		    	  flag = true;
		    	  int comma = line.indexOf(',');
		    	  out=(line.substring(comma+1));
		    	  
		       }
		      else
		       {
		    	  
		         out = "error";
		    	   
		       }
		      
	       }
	       sc.close();
	       
	       System.out.println(out);
	       
	}
}
