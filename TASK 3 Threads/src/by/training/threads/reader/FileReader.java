package by.training.threads.reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.training.threads.exception.NullResultException;

/**
 * Class contains method read.
 */
public class FileReader {
	/** Logger. */
	private static final Logger LOGGER = LogManager.getRootLogger();
	/** Regex to split values. */
	private static final String REGEX = "\\s+";

	/**
	 * public int[] read(final String fileName) throws NullResultException
	 * Method reads data from file.
	 * @param fileName - String path to file to read;
	 * @return array of data from file;
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
