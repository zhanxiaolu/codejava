package algorithm.sort;

public class SortCopy2 {
	/**
	 * 
	 * 上浮型冒泡
	 * 
	 * @param data
	 */
	public static void bubbleMin(int[] data) {
		int n = data.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = n - 1; j > i; j--) {
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
		for (int i = n - 1; i > 0; i--) {
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
		quickSort(data, 0, data.length - 1);
	}

	public static void quickSort(int[] data, int start, int end) {
		int key = data[start];
		int s = start;
		int e = end;
		while (s < e) {
			while (data[e] >= key && e > s) {// 从后往前找比key小的元素
				e--;
			}
			if (data[e] < key) {
				swap(data, s, e);
			}
			while (data[s] <= key && e > s) {
				s++;
			}
			if (data[s] > key) {
				swap(data, s, e);
			}
		}
		if (start < s - 1) {
			quickSort(data, start, s - 1);
		}
		if (s + 1 < end) {
			quickSort(data, s + 1, end);
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
		if (start < end) {
			if (start < mid) {
				mergeSort(data, start, mid);
			}
			if (end > mid + 1) {
				mergeSort(data, mid + 1, end);
			}
			mergeArray(data, start, mid, end);
		}
	}

	/**
	 * start~mid和mid+1~end的两个数组有序合并
	 * 
	 * @param data
	 * @param start
	 * @param mid
	 * @param end
	 */
	public static void mergeArray(int[] data, int start, int mid, int end) {
		int[] temp = new int[end - start + 1];
		int ls = start;
		int rs = mid + 1;
		int x = 0;
		while (ls <= mid && rs <= end) {
			if (data[ls] <= data[rs]) {
				temp[x++] = data[ls++];
			}
			if (data[ls] > data[rs]) {
				temp[x++] = data[rs++];
			}
		}
		while (ls <= mid) {
			temp[x++] = data[ls++];
		}
		while (rs <= end) {
			temp[x++] = data[rs++];
		}
		for (int t : temp) {
			data[start++] = t;
		}
	}

	/**
	 * 堆排序
	 * 
	 * @param data
	 */
	public static void heap(int[] data) {
		int n = data.length - 1;
		while (n > 0) {
			int startnode = (n - 1) / 2;
			for (int i = startnode; i >= 0; i--) {// 自底向上建立大顶堆
				buildMaxHeap(data, i, n - 1);
			}
			swap(data, 0, n);
			n--;
		}
	}

	/**
	 * 建立大顶堆，假设下面的子堆都已符合条件
	 * 
	 * @param data
	 * @param root
	 *            根节点
	 * @param lastnode
	 *            最后一个节点
	 */
	public static void buildMaxHeap(int[] data, int root, int lastnode) {
		int child = 2 * root + 1;// 从左孩子开始
		if (child <= lastnode) {
			if (child + 1 <= lastnode && data[child] < data[child + 1]) {
				child++;
			}
			if (data[child] > data[root]) {// 交换父子节点，子堆需要重新建立大顶堆
				swap(data, root, child);
				buildMaxHeap(data, child, lastnode);
			}
		}
	}

	/**
	 * 简单选择排序
	 * 
	 * @param data
	 */
	public static void simpleChoose(int[] data) {
		int n = data.length;
		for (int i = 0; i < n; i++) {
			int min = i;
			for (int j = i + 1; j < n; j++) {
				if (data[j] < data[min]) {
					min = j;
				}
			}
			if (min != i) {
				swap(data, min, i);
			}
		}

	}

	/**
	 * 插入排序
	 * 
	 * @param data
	 */
	public static void insert(int[] data) {
		// 从后往前比较，结合交换方式完成排序
		for (int i = 1; i < data.length; i++) {// 只有第一个元素的序列有序，从第二个元素开始
			for (int j = i - 1; j >= 0 && data[j] > data[j + 1]; j--) {// 如果i比j小进入该循环
				swap(data, j, j + 1);
			}
		}
	}

	/**
	 * 希尔排序，步长初始为全长的一半，并每次缩小一倍
	 * 
	 * @param data
	 */
	public static void shell(int[] data) {
		for (int gap = data.length / 2; gap > 0; gap /= 2) {
			insert(data, gap);
		}
	}

	public static void insert(int[] data, int gap) {
		// 从后往前比较，结合交换方式完成排序
		for (int i = gap; i < data.length; i++) {
			for (int j = i - gap; j >= 0 && data[j] > data[j + gap]; j -= gap) {
				swap(data, j, j + gap);
			}
		}
	}

	/**
	 * 
	 * @param data
	 * @param number
	 *            位数 假设数组中最大值不超过number位数
	 */
	public static void radix(int[] data, int number) {
		for (int p = 1; p <= number; p++) {// 为各位数的值分配位置
			int temp[][] = new int[10][data.length];// 存储分配结果
			int tempnum[] = new int[10];// 存储每个值位置的元素个数
			// 位数计算
			int d = 1;
			for (int i = 1; i < p; i++) {
				d = d * 10;
			}
			// 把一维数组按每个元素的个/十/百/千/万位数字转存为二维数组
			for (int j = 0; j < data.length; j++) {
				int x = (data[j] / d) % 10;
				temp[x][tempnum[x]++] = data[j];
			}
			// 二维数组元素按顺序转存为一维数组
			int index = 0;
			for (int k = 0; k < 10; k++) {
				for (int l = 0; l < tempnum[k]; l++) {
					data[index++] = temp[k][l];
				}
				tempnum[k] = 0;
			}
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
		// 堆排序
		System.out.println("");
		System.out.println("堆排序：");
		int[] datasHeap = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		System.out.print("排序前：");
		for (int data : datasHeap) {
			System.out.print(data + ".");
		}
		System.out.println("");
		heap(datasHeap);
		System.out.print("排序后：");
		for (int data : datasHeap) {
			System.out.print(data + ".");
		}
		// 简单选择排序
		System.out.println("");
		System.out.println("简单选择排序：");
		int[] datasSimple = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		System.out.print("排序前：");
		for (int data : datasSimple) {
			System.out.print(data + ".");
		}
		System.out.println("");
		simpleChoose(datasSimple);
		System.out.print("排序后：");
		for (int data : datasSimple) {
			System.out.print(data + ".");
		}
		// 直接插入排序
		System.out.println("");
		System.out.println("直接插入排序：");
		int[] datasInsert = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		System.out.print("排序前：");
		for (int data : datasInsert) {
			System.out.print(data + ".");
		}
		System.out.println("");
		insert(datasInsert);
		System.out.print("排序后：");
		for (int data : datasInsert) {
			System.out.print(data + ".");
		}
		// 希尔排序
		System.out.println("");
		System.out.println("希尔排序：");
		int[] datasShell = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		System.out.print("排序前：");
		for (int data : datasShell) {
			System.out.print(data + ".");
		}
		System.out.println("");
		shell(datasShell);
		System.out.print("排序后：");
		for (int data : datasShell) {
			System.out.print(data + ".");
		}
	
		// 基数排序
		System.out.println("");
		System.out.println("基数排序：");
		int[] datasradix = { 1000, 9, 88888, 7, 6, 5, 4, 3, 2, 1, 0 };
		System.out.print("排序前：");
		for (int data : datasradix) {
			System.out.print(data + ".");
		}
		System.out.println("");
		radix(datasradix,5);
		System.out.print("排序后：");
		for (int data : datasradix) {
			System.out.print(data + ".");
		}
	}
}
