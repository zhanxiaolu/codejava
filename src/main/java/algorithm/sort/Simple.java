package algorithm.sort;

/**
 * 简单选择排序
 * 
 * @author Administrator
 * 
 */
public class Simple {

	public static void sort(int[] datas) {
		int n = datas.length;
		for (int i = 0; i < n - 1; i++) {// n-1次遍历，数组下标0到n-2，因为只剩1个待排序元素时，该元素肯定是最大的
			sort(datas, i, n - i);
		}

	}

	/**
	 * 
	 * @param datas
	 * @param i
	 *            起始位置
	 * @param n
	 *            长度
	 */
	public static void sort(int[] datas, int i, int n) {
		int key = datas[i];
		int index = i;
		for (int j = i + 1; j < n; j++) {
			if (datas[j] < key) {
				key = datas[j];
				index = j;
			}
		}
		if (index != i) {
			swap(datas, i, index);
		}
	}

	public static void swap(int[] datas, int i, int j) {
		int temp = datas[i];
		datas[i] = datas[j];
		datas[j] = temp;
	}

	public static void main(String[] args) {
		int[] datas = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
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

		System.out.println("");
		int[] datas2 = { 1, 2, 3, 7, 6, 5, 4, 8, 9, 10 };
		System.out.print("排序前：");
		for (int data : datas2) {
			System.out.print(data + ".");
		}
		System.out.println("");
		sort(datas2);
		System.out.print("排序后：");
		for (int data : datas2) {
			System.out.print(data + ".");
		}
	}
}
