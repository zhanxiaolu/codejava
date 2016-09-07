package algorithm.sort;

/**
 * 基数排序
 * 
 * @author Administrator
 * 
 */
public class Radix {
	public static void sort(int[] datas) {
		int[][] temp = new int[10][datas.length];
		int n = 6;// 假设有数组中最大数有6位
		int p = 1;
		while (p <= n) {
			sort(datas, temp,p++);
		}

	}
	/**
	 * 
	 * @param datas 待排序数组
	 * @param temp  存储基数排序的临时结果
	 * @param p 对元素具体排序的位置，例如1代表各位，2代表十位，3代表百位
	 */
	public static void sort(int[] datas, int[][] temp, int p) {
		int d=1;
		int dtemp=1;
		while(dtemp<p){
			d = d*10;
			dtemp++;
		}
		
		int[] xnum = new int[10];// 存储二维数组temp[x]中元素个数
		for (int i = 0; i < datas.length; i++) {
			int x = (datas[i] / d) % 10;
			temp[x][xnum[x]] = datas[i];
			xnum[x] = xnum[x] + 1;
		}
		int index = 0;
		for (int j = 0; j < 10; j++) {
			if (xnum[j] > 0) {
				for (int k = 0; k < xnum[j]; k++) {
					datas[index++] = temp[j][k];
				}
			}
			xnum[j]=0;//重置
		}
	}

	public static void main(String[] args) {
		int[] datas =  {73, 22, 93, 43, 55, 14, 28, 65, 39, 81, 33, 100};
		System.out.print("排序前：");
		for (int data : datas) {
			System.out.print(data + ".");
		}
		System.out.println("");
		sort(datas);
		System.out.print("排序后：");
		for (int data : datas) {
			System.out.print(data + ".");
		}

	}
}
