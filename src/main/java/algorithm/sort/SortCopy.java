package algorithm.sort;

public class SortCopy {
	/**
	 * 
	 * 上浮型冒泡
	 * 
	 * @param data
	 */
	public static void bubbleMin(int[] data) {
		int n = data.length;
		for (int i = 0; i < n - 1; i++) {// n-1次遍历
			for (int j = n - 1; j > i; j--) {// 从后往前选出最小值放在最前方
				if (data[j] < data[j - 1]) {
					swap(data, j, j - 1);
				}
			}
		}
	}

	/**
	 * 下沉型冒泡
	 * 
	 * @param data
	 */
	public static void bubbleMax(int[] data) {
		int n = data.length;
		for (int i = n - 1; i > 0; i--) {// n-1次遍历
			for (int j = 0; j < i; j++) {
				if (data[j] > data[j + 1]) {
					swap(data, j, j + 1);
				}
			}
		}
	}

	/**
	 * 快速排序
	 * 
	 * @param data
	 */
	public static void quick(int[] data) {
		quickPartition(data, 0, data.length - 1);
	}

	public static void quickPartition(int[] data, int start, int end) {
		int x = data[start];// 参考元素
		int s = start;
		int e = end;
		while (s < e) {// s==e时退出，该位置也是参考元素的最终位置
			// 从后往前找比X小的元素
			while (data[e] >= x && e > s) {
				e--;
			}
			if (data[e] < x) {
				swap(data, s, e);
			}
			// 从前往后找比x大的元素
			while (data[s] <= x && e > s) {
				s++;
			}
			if (data[s] < x) {
				swap(data, s, e);
			}
		}
		if (start < s - 1) {// 只有一个元素时退出
			quickPartition(data, start, s - 1);
		}
		if (end > s + 1) {// 只有一个元素时退出
			quickPartition(data, s + 1, end);
		}
	}

	/**
	 * 归并排序
	 * 
	 * @param data
	 */
	public static void merge(int[] data) {
		mergeSort(data, 0, data.length - 1);
	}

	/**
	 * 分解+合并排序
	 * 
	 * @param data
	 * @param start
	 * @param end
	 */
	public static void mergeSort(int[] data, int start, int end) {
		int mid = (start + end) / 2;
		if (start < end) {// 只有一个元素时退出
			mergeSort(data, start, mid);
			mergeSort(data, mid + 1, end);
			mergeArray(data, start, mid, end);
		}
	}

	public static void mergeArray(int[] data, int start, int mid, int end) {
		int[] temp = new int[end - start + 1];//临时空间存储结果
		int lstart = start;
		int rstart = mid + 1;
		int x = 0;
		while (lstart <= mid && rstart <= end) {
			if (data[lstart] <= data[rstart] ) {// 左数组元素小就进入临时空间
				temp[x++] = data[lstart++];
			}
			if (data[rstart] < data[lstart] ) {// 右数组元素小就进入临时空间
				temp[x++] = data[rstart++];
			}
		}
		while (lstart <= mid) {// 剩下的左数组全部进入临时空间
			temp[x++] = data[lstart++];
		}
		while (rstart <= end) {// 剩下的右数组全部进入临时空间
			temp[x++] = data[rstart++];
		}
		
		for (int t : temp) {
			data[start++] = t;
		}
	}

	private static void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}

	public static void main(String[] args) {
		int[] datas = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		System.out.print("排序前：");
		for (int data : datas) {
			System.out.print(data + ".");
		}
		System.out.println("");
		bubbleMin(datas);
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
		bubbleMax(datas2);
		System.out.print("排序后：");
		for (int data : datas2) {
			System.out.print(data + ".");
		}

		System.out.println("");
		int[] datas3 = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		System.out.print("排序前：");
		for (int data : datas3) {
			System.out.print(data + ".");
		}
		System.out.println("");
		quick(datas3);
		System.out.print("排序后：");
		for (int data : datas3) {
			System.out.print(data + ".");
		}

		// 归并排序
		System.out.println("");
		int[] datasMerge = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		System.out.print("排序前：");
		for (int data : datasMerge) {
			System.out.print(data + ".");
		}
		System.out.println("");
		merge(datasMerge);
		System.out.print("排序后：");
		for (int data : datasMerge) {
			System.out.print(data + ".");
		}
		// // 堆排序
		// System.out.println("");
		// System.out.println("堆排序：");
		// int[] datasHeap = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		// System.out.print("排序前：");
		// for (int data : datasHeap) {
		// System.out.print(data + ".");
		// }
		// System.out.println("");
		// // heap(datasHeap);//数组越界错误
		// System.out.print("排序后：");
		// for (int data : datasHeap) {
		// System.out.print(data + ".");
		// }
		// // 简单选择排序
		// System.out.println("");
		// System.out.println("简单选择排序：");
		// int[] datasSimple = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		// System.out.print("排序前：");
		// for (int data : datasSimple) {
		// System.out.print(data + ".");
		// }
		// System.out.println("");
		// simpleChoose(datasSimple);
		// System.out.print("排序后：");
		// for (int data : datasSimple) {
		// System.out.print(data + ".");
		// }
		// // 直接插入排序
		// System.out.println("");
		// System.out.println("直接插入排序：");
		// int[] datasInsert = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		// System.out.print("排序前：");
		// for (int data : datasInsert) {
		// System.out.print(data + ".");
		// }
		// System.out.println("");
		// insertImprove(datasInsert);
		// System.out.print("排序后：");
		// for (int data : datasInsert) {
		// System.out.print(data + ".");
		// }
		// // 希尔排序
		// System.out.println("");
		// System.out.println("希尔排序：");
		// int[] datasShell = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		// System.out.print("排序前：");
		// for (int data : datasShell) {
		// System.out.print(data + ".");
		// }
		// System.out.println("");
		// shell(datasShell);
		// System.out.print("排序后：");
		// for (int data : datasShell) {
		// System.out.print(data + ".");
		// }
		// // 希尔排序
		// System.out.println("");
		// System.out.println("希尔改进排序：");
		// int[] datasShell2 = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		// System.out.print("排序前：");
		// for (int data : datasShell2) {
		// System.out.print(data + ".");
		// }
		// System.out.println("");
		// shellImprove(datasShell2);
		// System.out.print("排序后：");
		// for (int data : datasShell2) {
		// System.out.print(data + ".");
		// }
		//
		// // 基数排序
		// System.out.println("");
		// System.out.println("基数排序：");
		// int[] datasradix = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		// System.out.print("排序前：");
		// for (int data : datasradix) {
		// System.out.print(data + ".");
		// }
		// System.out.println("");
		// radix(datasradix);
		// System.out.print("排序后：");
		// for (int data : datasradix) {
		// System.out.print(data + ".");
		// }
	}
}
