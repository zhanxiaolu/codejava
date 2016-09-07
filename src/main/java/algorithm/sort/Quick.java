package algorithm.sort;

/**
 * 快速排序(交换)
 * 
 * @author Administrator
 * 
 */
public class Quick {

	public static void sort(int[] datas) {
		partition(datas, 0, datas.length - 1);
	}

	public static void partition(int[] datas, int start, int end) {
		int key = datas[start];//选用第一个元素作为分割值
		int i = start;
		int j = end;
		while (i < j) {
			while(j>i && datas[j] >= key){//往前搜索比key小的值
				j--;
			}
			if(datas[j]<key){//key存在i，互换j和key的位置，
				swap(datas, i, j);
			}
			while(j>i && datas[i] <= key){//往后搜索比key大的值
				i++;
			}
			if(datas[i]>key){//key存在j，互换i和key的位置
				swap(datas, i, j);
			}
		}
		// i==j,递归对已分割的两个数组排序
		if (start < i - 1) {
			partition(datas, start, i - 1);
		}
		if (end > i + 1) {
			partition(datas, i + 1, end);
		}
	}

	public static void swap(int[] datas, int i, int j) {
		int temp = datas[i];
		datas[i] = datas[j];
		datas[j] = temp;
	}

	public static void main(String[] args) {
		int[] datas = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
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
