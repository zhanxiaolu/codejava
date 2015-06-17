package IO;

import java.io.IOException;

import org.junit.Test;

public class ZipLearnTest {
	private ZipLearn zl = new ZipLearn();
	@Test
	public void testZipFiles() throws IOException {
		zl.zipFiles(this.getClass().getResource("").getPath());
	}

}
