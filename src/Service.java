

//import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class Service 
{
	public static void main (String []args) throws InterruptedException, IOException 
	{
		
		String serper = args[0];
		//Scanner in = new Scanner(System.in);
		int comma = serper.indexOf(',');
	    String lookup = serper.substring(0, comma);
	    String parameter = serper.substring(comma+1);
	    //System.out.println("Select a message language");
	   //String lan = in.next();
	    String lan = "english";
		//in.close();
	    Process proc;
		try {
			//System.out.println(lookup);
			proc = Runtime.getRuntime().exec("java -jar textbroker.jar"+" "+lookup+" service.txt");
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
		    //System.out.println("part 1 pass");
		    //System.out.println(y);
		    
		    Process proc2 = Runtime.getRuntime().exec(y+" "+parameter);
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
		catch (IOException e1) 
		{
			lan = lan+",703";
	    	  
	    	  Process proc2 = Runtime.getRuntime().exec("java -jar message.jar"+" "+lan);
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
	    	  
	    	  
	    	 
			
		}
		
	
		
	}
	
}
