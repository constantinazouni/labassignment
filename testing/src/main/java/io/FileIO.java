package io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
* The FileIO provides simple file input/output operations
* that serve as hands-on practice on Unit Testing.
*
* @author  agkortzis, constantinazouni
* @version 1.1
* @since   2020-04-06 
*/
public class FileIO {
	
	/**
	 * Reads a file that contains numbers line by line 
	 * and returns an array of the integers found in the file.
	 * Avoids lines that are not Integers
	 * @param filepath the file that contains the numbers
	 * @return an array of numbers
	 * @exception IllegalArgumentException when the given file does not exist
	 * @exception IllegalArgumentException when the given file is empty
	 * @exception IOException when an IO interruption occurs (not required to be tested)
	 */
	public int[] readFile(String filepath) {
		File file = new File(filepath);
		if (!file.exists()) 
			throw new IllegalArgumentException("Input file does not exist");
		
		List<Integer> numbersList = new ArrayList<>();
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(file));
			String line = null;
			while ((line = reader.readLine()) != null) {
				if (isInteger(line)){
					int number = Integer.parseInt(line);
				    numbersList.add(number);
				}			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if (numbersList.size() == 0) 
			throw new IllegalArgumentException("Given file is empty");
		
		// Convert a List to an array using 
		return numbersList.stream().mapToInt(i -> i).toArray();
	}

	/**
	 * Performs a parseInt() to the string parameter. If an exception
	 * happens that means that the input is not integer and the
	 * method returns false. Otherwise it returns true
	 * @param line is a string element from the file
	 * @return true or false
	 */
	public static boolean isInteger(String line) {
		int integer;
		try {
			integer = Integer.parseInt(line);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
