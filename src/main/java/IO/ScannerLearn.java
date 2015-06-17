package IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ScannerLearn {

	/**
	 * 扫描控制台输入
	 */
	public void readConsole() {
		Scanner s = new Scanner(System.in);
		System.out.println("请输入字符串：");
		while (true) {
			String line = s.nextLine();
			if (line.equals("exit"))
				break;
			System.out.println(">>>" + line);
		}
	}
	
	/**
	 * 解析文件
	 * @throws FileNotFoundException 
	 */
	public void readFile() throws FileNotFoundException {
		String filepath = this.getClass().getResource("").getPath()+"test.dat";
		Scanner s = new Scanner(new FileReader(filepath));
		while(s.hasNextLine())
			System.out.println(s.nextLine());
		}

}
