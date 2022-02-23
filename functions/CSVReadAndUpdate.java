package functions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import exceptions.NotExpectedLengthException;

public class CSVReadAndUpdate {
	public static String split = ",";
	public static BufferedReader reader;

	public static void readFile(int expectedLength, String filePath) throws NotExpectedLengthException{
		String line = "";
		try {
			CSVReadAndUpdate.reader = new BufferedReader(new FileReader(filePath));
			while((line = reader.readLine())!= null) {
				String[] toAdd = line.split(CSVReadAndUpdate.split);
				if(expectedLength!=toAdd.length) throw new NotExpectedLengthException("Each row of your CSV file should be the expected length of " + expectedLength);
				switch(expectedLength) {
					case 2:
						break;
					case 6:
						break;
					default: 
						break;
				}
			}
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
}
