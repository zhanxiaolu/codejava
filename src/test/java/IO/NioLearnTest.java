package IO;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class NioLearnTest {
	private NioLearn nio = new NioLearn();

	@Test
	public void testCopyFile() throws IOException {
		String srcPath = this.getClass().getResource("").getPath() + "src.txt";
		String destPath = this.getClass().getResource("").getPath()
				+ "dest.txt";
		String destPath2 = this.getClass().getResource("").getPath()
				+ "dest2.txt";
		String destPath3 = this.getClass().getResource("").getPath()
				+ "dest3.txt";
		nio.copyFile(srcPath, destPath);
		nio.nioChannelCopy(srcPath, destPath2);
		nio.nioMapperCopy(srcPath, destPath3);

	}
}
