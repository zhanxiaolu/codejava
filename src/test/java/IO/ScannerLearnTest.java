package IO;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;

import org.junit.Test;

import IO.ScannerLearn;

public class ScannerLearnTest {
	private ScannerLearn scanner = new ScannerLearn();
	@Test
	public void testReadConsole() {
		scanner.readConsole();
	}

	@Test
	public void testReadFile() throws FileNotFoundException {
		scanner.readFile();
	}

}
