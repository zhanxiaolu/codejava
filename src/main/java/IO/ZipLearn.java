package IO;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipLearn {
	/**
	 * 压缩当前目录下文件
	 * @param foldPath
	 * @throws IOException
	 */
	public void zipFiles(String foldPath) throws IOException {
		FileOutputStream fout = new FileOutputStream("test.zip");
		ZipOutputStream zout = new ZipOutputStream(fout);
		PrintWriter pw = new PrintWriter(zout);

		File[] files = (new File(foldPath)).listFiles();
		for (File file : files) {
			if(file.isDirectory()){
				continue;
			}
			ZipEntry ze = new ZipEntry(file.getName());
			zout.putNextEntry(ze);
			//send data
			BufferedInputStream bs = new BufferedInputStream(new FileInputStream(file));
			byte[] buffered = new byte[1024]; 
			while(bs.read(buffered)!=-1){
				zout.write(buffered);
			}
			bs.close();
			zout.closeEntry();
		}
		pw.close();
		zout.close();
	}

}
