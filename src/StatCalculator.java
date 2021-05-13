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
 *    Author: Gary Preston
 *    Co-Author: Tirth Patel
 *    Review:  Sabri Anan, Chuan Zheng, Sailesh Devkota
 *    Version 05/13/2021   CMCS 355 
 * *********************************************************************************** */ 


import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
public class StatCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {
		//System.out.print("Please enter a number (x > 0 ) to determine Data set length: "); 

		Scanner in = new Scanner(System.in); // User input.
		
		 String str2= args[0];
		 
		 
		 String lan = args[1];
		 
		 
		 int comma = str2.indexOf(',');
		 String request = str2.substring(0, comma);
		 
		 String str = str2.substring(comma+1);
		
		String[] res = str.split(",");
		
		 int[] result = new int[res.length];
		   for (int i = 0; i < res.length; i++) {
		      result[i] = Integer.parseInt(res[i]);
		      
		   }
		   
		
		
		in.close();
		int[] sortedArray = bubbleSort(result); 
		
		if (request.equalsIgnoreCase("all")) 
		{
			System.out.println("=========Stat Functions==========");
			System.out.print("Mean: ");
			System.out.println(Mean(result)); 
			
			System.out.print("Median: "); 
			System.out.println(Median(sortedArray));
			
			System.out.print("1st Quartile: "); 
			System.out.println(Quartile1(sortedArray));
			
			System.out.print("3rd Quartile: ");
			System.out.println(Quartile3(sortedArray));
			
			System.out.print("Mode: "); 
			System.out.println(Mode(result));
			
			System.out.print("Sample Variance: ");
			System.out.printf("%.3f", SampleVariance(result));
			System.out.println();
			
			System.out.print("Standard Deviation: ");
			System.out.printf("%.3f", StandardDev(result));
			System.out.println();
			
			System.out.print("Range Value: "); 
			System.out.println(Range(result));
			
			System.out.print("Maximum Value: ");
			System.out.println(MaximumValue(result));
			
			System.out.print("Minimum Value: ");  
			System.out.println(MinimumValue(result));
		}
		else if (request.equalsIgnoreCase("mean")) {
		System.out.print("Mean: ");
		System.out.println(Mean(result)); }
		else if (request.equalsIgnoreCase("median")) { 
		System.out.print("Median: "); 
		System.out.println(Median(sortedArray));}
		else if (request.equalsIgnoreCase("Q1")) {
		System.out.print("1st Quartile: "); 
		System.out.println(Quartile1(sortedArray));}
		else if (request.equalsIgnoreCase("Q2")) { 
		System.out.print("3rd Quartile: ");
		System.out.println(Quartile3(sortedArray));}
		else if (request.equalsIgnoreCase("mode")) { 
		System.out.print("Mode: "); 
		System.out.println(Mode(result));}
		else if (request.equalsIgnoreCase("SV")) {
		System.out.print("Sample Variance: ");
		System.out.printf("%.3f%n", SampleVariance(result));
		}
		else if (request.contentEquals("STDDEV")) { 
		System.out.print("Standard Deviation: ");
		System.out.printf("%.3f%n", StandardDev(result));
		}
		else if (request.equalsIgnoreCase("rande")) { 
		System.out.print("Range Value: "); 
		System.out.println(Range(result));}
		else if (request.equalsIgnoreCase("max")) { 
		System.out.print("Maximum Value: ");
		System.out.println(MaximumValue(result));}
		else if (request.equalsIgnoreCase("max")) {
		System.out.print("Minimum Value: ");  
		System.out.println(MinimumValue(result));}
		
		else
		{
			lan = lan+",601";
	    	  
	    	  Process proc2 = Runtime.getRuntime().exec("java -jar message.jar"+" "+lan);
	  	    proc2.waitFor();

	  	    InputStream input2 = proc2.getInputStream();
	  	   
	  	    
	  	    byte d[]=new byte[input2.available()];
	  	    input2.read(d,0,d.length);
	  	    String y2 =(new String(d));

	  	   
	  	    
	  	    System.out.println(y2);
	    	  
		}
	
	}
	
	// Range
	public static double Range (int[] Data)
	{
		return (MaximumValue(Data) - MinimumValue(Data));
	}
	
	// Minimum Value
	public static double MinimumValue (int Data[])
	{
		double min = Data[0];
		for(int i = 1; i < Data.length; i++)
			min = Math.min(min, Data[i]);
			return min;
	}
	
	// Maximum Value
	public static double MaximumValue(int Data[])
	{
		double max = Data[0];
		for (int i = 1; i < Data.length; i++)
			max = Math.max(max, Data[i]);
		return max;
	}
	
	// Standard Deviation (StandardDev)
	public static double StandardDev (int Data[])
	{
		return Math.sqrt(SampleVariance(Data)); // Pulls from Sample Var. Method
	}
	
	// Sample Variance 
	public static double SampleVariance (int Data[]) 
	{
		double dSet = Mean(Data); // Pulls from Mean Method
		double sdSet = 0.0;
		for(int i = 0; i < Data.length; i++) // 
			sdSet += Square2 (dSet - Data[i]);
		
		return (sdSet / (Data.length - 1));
	}
	
	private static double Square2 (double x)
	{
		return (x * x); //place holder to calculate SV DataSet
	}
	
	// Mode
	public static int Mode(int x[])
	  {
		  int maxValue = 0; 
		  int maxCount = 0;   
		  
		  //Determine the number that will appear first (The number should be 0).
		  for (int i = 0; i < x.length; ++i) //Counts
		  {
		    int count = 0;
		    for (int j = 0; j < x.length; ++j) //Counts
		    {
		      if (x[j] == x[i]) ++count;
		    }
		    if (count > maxCount)
		    {
		      maxCount = count;
		      maxValue = x[i];
		    }
		  }
		  return maxValue;
		}
	
	// Quartile 3 (Q3)
	public static double Quartile3 (int largest[]) 
	{
		double a[] = new double [largest.length / 2 ];
		for(int i = 0; i < largest.length / 2; i++)
		{
			if(largest.length % 2 != 0)
			{ 
				a[i] = largest [i + largest.length / 2 + 1];
			}
			else
			{
				a[i] = largest[i + largest.length / 2];
			}
		}
		
	
		double Q3; // Sets up for values
		int tValue = a.length;
		
		if (tValue % 2 == 0)
		{
			double middleValues = (a[tValue / 2] + a[tValue / 2 - 1]); // Calculates Average of Middle Elements(Highest Number and Median)
			Q3 = (((double) middleValues) / 2);
		}
		
		else
		{
			Q3 = (double) (a[a.length / 2]);
		}
		return Q3;
		}
		
	// Quartile 1 (Q1)
	public static double Quartile1 (int small[])
	{ 	// Returns value for Q1
		double a[] = new double [small.length / 2];
		for(int i = 0; i < small.length / 2; i++)
		{
			a[i] = small[i];
		}
		
		double Q1;  
		int tValue = a.length; //Gets count of scores.
		if(tValue % 2 == 0)
		{	// Calculates average of Middle Values (Smallest Number and Median).
			double middleValue = a[tValue / 2] + a[tValue / 2 - 1];
			Q1 = ((double) middleValue) / 2;
		}
		//Test with calc to make sure values are correct (Delete if they are)
		else 
		{
			Q1 = (double) a[a.length /  2]; //Gets average of middle elements
		}
		return Q1;
	}
	
	// Median
	public static double Median (int values[])
		{
			double median; //Declared Value
			int tValues = values.length; //Checks if the total value is an even number
			
			//Average of Middle Elements
			if (tValues %2 == 0)
			{
				int middleValues = (values[tValues/2] + values[tValues /2 -1]);
				median = (((double) middleValues) / 2);
			}
			else {
				median = (double) values[values.length / 2];
			}
			
			return median; 
		}

	// The Mean
	public static double Mean (int Data[])
	{
		double tValue = 0;
		
		for(int i = 0; i < Data.length; i++)
			tValue += Data[i];
		return (tValue / (Data.length));
	}

	// Bubble sort (Revisit and clean up) 
		public static int[] bubbleSort (int array[])
		{
			int s = array.length;
			int temp = 0;
			for(int i = 0; i < array.length; i++) //Increments until largest number.
			{ 
				for(int j = 1; j < (s - 1); j++)
				{ 
					if(array[j-1] > array[j]) //Checks if number before is greater than number after
							{
						temp = array[j - 1]; //Drops number into temp variable. 
						array[j] = array[j + 1]; //Assigns value of 1st num to 2nd num.
						array[j + 1] = temp; //2nd num gets variable.
						
							}
				}
			}
			return array;
		}
		
	

}

