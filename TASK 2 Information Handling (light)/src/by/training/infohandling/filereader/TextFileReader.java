package by.training.infohandling.filereader;
/**
 * Public class for reading text from file.
 * Methods : ReadTest(String fileName);
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.infohandling.exception.NullResultException;

public class TextFileReader {

	/**
	 * Method reads text from file. 
	 * @param fileName - String path to file to read;
	 * @return ArrayList{@code<String>} of rows from file;
	 * @throws NullResultException - when file not exists or no access for reading;
	 */
	
	public String readText(String fileName) throws NullResultException {
		File file = new File(fileName);
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(file);
		} catch (FileNotFoundException e) {
			throw new NullResultException("File not found", e);
		}
		String lineSeparator = System.lineSeparator();
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line = null;
		try {
			while ((line = bufferedReader.readLine()) != null) {
				stringBuilder.append(line).append(lineSeparator);
			}
		} catch (IOException e) {
			throw new NullResultException("File access error", e);
		} finally {
			try {
				bufferedReader.close();
			} catch (IOException e) {
				throw new NullResultException("File access error", e);
			}
		}
		
		return stringBuilder.toString();
	}

}
