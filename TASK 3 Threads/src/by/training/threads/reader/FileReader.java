package by.training.threads.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.threads.exception.NullResultException;

public class FileReader {
	private static final Logger LOGGER = LogManager.getRootLogger();
	private static final String REGEX = "\\s+";
	
	/**
	 * Method reads data from file.
	 * @param fileName
	 *            - String path to file to read;
	 * @return ArrayList{@code<String>} of rows from file;
	 * @throws NullResultException
	 *             - when file not exists or no access for reading;
	 */

	public int[] read(final String fileName) throws NullResultException {

		int[] numbers = null;
			try {
				Stream<String> stream = Stream.of(new String(Files.readAllBytes(Paths.get(fileName))).split(REGEX));
				numbers = stream.mapToInt(Integer::parseInt)./*peek(s -> LOGGER.info(s)).*/toArray();
			} catch (IOException e) {
				throw new NullResultException("File access error", e);
			}

	   return numbers;
	}

}
