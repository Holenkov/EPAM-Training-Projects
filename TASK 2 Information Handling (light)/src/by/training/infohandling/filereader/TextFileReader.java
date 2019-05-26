package by.training.infohandling.filereader;
/**
 * Public class for reading text from file.
 * Methods : ReadTest(String fileName);
 */

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import by.training.infohandling.exception.NullResultException;

/**
 * Public class, provides method readText(final String fileName), that reads
 * text from file.
 */

public class TextFileReader {

	/**
	 * Method reads text from file and returns it as String.
	 * @param fileName
	 *            - String path to file to read;
	 * @return ArrayList{@code<String>} of rows from file;
	 * @throws NullResultException
	 *             - when file not exists or no access for reading;
	 */

	public String readText(final String fileName) throws NullResultException {
		String lineSeparator = System.lineSeparator();
		StringBuilder stringBuilder = new StringBuilder();
		List<String> lines = null;
		try {
			lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
		} catch (IOException e) {
			throw new NullResultException("File access error", e);
		}

		for (String line : lines) {
			stringBuilder.append(line).append(lineSeparator);
		}

		return stringBuilder.toString();
	}
}
