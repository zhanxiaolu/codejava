package IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * NIO学习
 * 
 * @author Administrator
 * 
 */
public class NioLearn {
	public void nioChannelCopy(String srcPath, String destPath)
			throws IOException {
		Long t1 = System.currentTimeMillis();

		FileInputStream src = null;
		RandomAccessFile dest = null;
		try {
			// 定义文件输入输出流
			src = new FileInputStream(srcPath);
			dest = new RandomAccessFile(destPath, "rw");
			// 获取通道
			FileChannel srcChanel = src.getChannel();
			FileChannel destChanel = dest.getChannel();
			// 获取文件长度
			long srcLength = srcChanel.size();
			destChanel.transferFrom(srcChanel, 0, srcLength);
			srcChanel.close();
			destChanel.close();
		} catch (IOException e) {
			// TODO: handle exception

		} finally {
			if (src != null) {
				src.close();
			}
			if (dest != null) {
				dest.close();
			}
		}
		Long t2 = System.currentTimeMillis();
		System.out.println("用时：" + (t2 - t1));
	}

	public void nioMapperCopy(String srcPath, String destPath)
			throws IOException {
		Long t1 = System.currentTimeMillis();

		FileInputStream src = null;
		RandomAccessFile dest = null;
		try {
			// 定义文件输入输出流
			src = new FileInputStream(srcPath);
			dest = new RandomAccessFile(destPath, "rw");
			// 获取通道
			FileChannel srcChanel = src.getChannel();
			FileChannel destChanel = dest.getChannel();
			// 获取文件长度
			long srcLength = srcChanel.size();
			// 获取MappedBu
			MappedByteBuffer srcMapBuffer = srcChanel.map(
					FileChannel.MapMode.READ_ONLY, 0, srcLength);
			MappedByteBuffer destMapbuBuffer = destChanel.map(
					FileChannel.MapMode.READ_WRITE, 0, srcLength);
			destMapbuBuffer.put(srcMapBuffer);
			srcMapBuffer.clear();
			destMapbuBuffer.clear();
			srcChanel.close();
			destChanel.close();
		} catch (IOException e) {
			// TODO: handle exception

		} finally {
			if (src != null) {
				src.close();
			}
			if (dest != null) {
				dest.close();
			}
		}
		Long t2 = System.currentTimeMillis();
		System.out.println("用时：" + (t2 - t1));
	}

	/**
	 * 传统输入输出流
	 * 
	 * @param srcPath
	 * @param destPath
	 * @throws IOException
	 */
	public void copyFile(String srcPath, String destPath) throws IOException {
		Long t1 = System.currentTimeMillis();
		InputStream src = null;
		OutputStream dest = null;
		try {
			// 定义文件输入输出流
			src = new FileInputStream(srcPath);
			dest = new FileOutputStream(destPath);
			byte[] data = new byte[1024];
			while (src.read(data) != -1) {
				dest.write(data);
			}
		} catch (IOException e) {
			// TODO: handle exception

		} finally {
			if (src != null) {
				src.close();
			}
			if (dest != null) {
				dest.close();
			}
		}

		Long t2 = System.currentTimeMillis();
		System.out.println("用时：" + (t2 - t1));

	}
}
