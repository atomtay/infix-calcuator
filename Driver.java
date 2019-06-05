/*
* File Name : Driver.java
*
* The Science of Data Structures
*
* Course : CSC172 SPRING 2015
*
* Assignment : PROJECT 2
*
* Author : Annabelle Taylor
*
* Lab Partner : n/a
*
* Lab Session : TR 4:50-6:05 pm
*
* Lab TA : Pauline Chen
*
* Last Revised : March 8, 2015
*
*/

import java.io.*;

public class Driver
{	
	public static void main(String[] args) throws IOException
	{
		String inFile = args[0];
		String outFile = args[1];
		
		BufferedReader inputStream = null;
        File dir = new File(".");
		String loc = dir.getCanonicalPath() + File.separator + outFile;
		FileWriter fstream = new FileWriter(loc, true);
		BufferedWriter out = new BufferedWriter(fstream);
		
		File file = new File(outFile);
		if (!file.exists())
				file.createNewFile();
 
			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);

		try
		{
			inputStream = new BufferedReader(new FileReader(inFile));
            String l;
            while ((l = inputStream.readLine()) != null)
			{
				String delims = "[ ]+";
				String[] tokens = l.split(delims);
				Calculator eval = new Calculator(tokens);
				double answer = eval.calculations(eval.parseArray());
				bw.write(answer + "");
				bw.newLine(); 
            }
        }
		
		finally
		{
            if (inputStream != null)
				inputStream.close();
            if (bw != null)
                bw.close();
        }
    }

	// test method; not relevant to final implementation
	public static void printArray(String[] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			System.out.print(array[i]);
		}
	}
}