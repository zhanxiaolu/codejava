package algorithm.sort;

public class Sort {
	/**
	 * 冒泡排序的上浮版本，即每次选出最小值放到前面
	 * 
	 * @param data
	 */
	public static void bubbleMin(int[] data) {
		int n = data.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = n - 1; j > i; j--) {
				if (data[j] < data[j - 1]) {// 把小的元素换到前面
					swap(data, j, j - 1);
				}
			}
		}
	}

	/**
	 * 冒泡排序的下沉版本，即每次选出最大值放到后面
	 * 
	 * @param data
	 */
	public static void bubbleMax(int[] data) {
		int n = data.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i; j < n - 1 - i; j++) {
				if (data[j] > data[j + 1]) {// 把大的元素换到前面
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
		int n = data.length;
		quickPartition(data, 0, n - 1);
	}

	private static void quickPartition(int[] data, int start, int end) {
		int i = start;
		int key = data[i];// 初始设置第一个元素为key
		int j = end;
		while (i < j) {// i,j未相遇
			while (j > i && data[j] >= key) {// 从后往前寻找比key小的元素
				j--;
			}
			if (data[j] < key) {// 交换位置，交换之后key在j的位置
				swap(data, j, i);
			}
			while (j > i && data[i] <= key) {// 从前往后寻找比key大的元素
				i++;
			}
			if (data[i] > key) {// 交换位置，交换之后key在i的位置
				swap(data, i, j);
			}
		}
		if (start < i - 1) {
			quickPartition(data, start, i - 1);
		}
		if (i + 1 < end) {
			quickPartition(data, i + 1, end);
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
	 * 分解
	 * 
	 * @param data
	 * @param start
	 * @param end
	 */
	private static void mergeSort(int[] data, int start, int end) {
		int mid = (start + end) / 2;
		if (start < end) {// 分解到只剩一个元素退出
			mergeSort(data, start, mid);
			mergeSort(data, mid + 1, end);
			mergeArray(data, start, mid, end);
		}
	}

	/**
	 * 合并有序的两个数组，start->mid ----- mid+1->end
	 * 
	 * @param data
	 * @param start
	 * @param mid
	 * @param end
	 */
	private static void mergeArray(int[] data, int start, int mid, int end) {
		int[] temp = new int[end - start + 1];// 临时空间存储合并结果
		int l = start;// 左序列起始位置
		int r = mid + 1;// 右序列起始位置
		int index = 0;
		while (l <= mid && r <= end) {
			if (data[l] <= data[r]) {
				temp[index++] = data[l++];
			}
			if (data[l] > data[r]) {
				temp[index++] = data[r++];
			}
		}
		while (l <= mid) {
			temp[index++] = data[l++];
		}
		while (r <= end) {
			temp[index++] = data[r++];
		}
		for (int j = 0; j <= temp.length - 1; j++) {// 合并结果覆盖回数组
			data[start + j] = temp[j];
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

	public static void simpleChoose(int[] data) {
		int n = data.length;
		for (int i = 0; i < n; i++) {// 最后一轮遍历其实不需要
			int min = i;// 最小元素位置初始化为开始元素的位置
			for (int j = i + 1; j < n; j++) {
				if (data[j] < data[min]) {
					min = j;
				}
			}
			if (i != min) {
				swap(data, i, min);
			}

		}
	}

	/**
	 * 把某个元素插入到有序数组中，有序数组从前往后比，找到插入位置，该位置后面元素全部后移一位
	 * 
	 * @param data
	 */
	public static void insert(int[] data) {
		int n = data.length;
		for (int i = 1; i < n; i++) {// 从第二个元素开始
			for (int j = 0; j < i; j++) {// 0---i-1区间有序，从小到大
				if (data[j] < data[i]) {
					int temp = data[i];
					for (int k = i - 1; k >= j; k++) {// j----i-1区间所有元素后移
						data[k + 1] = data[k];
					}
					data[j] = temp;
					break;
				}
			}
		}
	}

	/**
	 * 把某个元素插入到有序数组中，有序数组从后往前比，通过交换的方式完成排序的过程 直接插入与冒泡的结合
	 * 
	 * @param data
	 */
	public static void insertImprove(int[] data) {
		int n = data.length;
		for (int i = 1; i < n; i++) {// 从第二个元素开始
			for (int j = i - 1; j >= 0 && data[j] > data[j + 1]; j--) {
				swap(data, j, j + 1);
			}
		}
	}

	/**
	 * 普通希尔排序逻辑还不太整理清楚
	 * 
	 * @param data
	 */
	public static void shell(int[] data) {
		int n = data.length;
		for (int gap = n / 2; gap > 0; gap /= 2) {// 步长，例如步长为x，则下标为0元素所在数组有0、x、2x、3x
			shell(data, gap);
		}
	}

	public static void shell(int[] data, int gap) {
		for (int i = gap; i < data.length; i += gap) {// 从第二个元素开始
			for (int j = i - gap; j >= 0 && data[j] > data[j + gap]; j -= gap) {
				swap(data, j, j + gap);
			}
		}
	}

	/**
	 * 类似直接插入排序的改进方案，也是从后往前，通过交换完成排序
	 * 
	 * @param data
	 */
	public static void shellImprove(int[] data) {
		int n = data.length;
		for (int gap = n / 2; gap > 0; gap /= 2) {// 步长
			for (int i = gap; i < n; i++) {
				for (int j = i - gap; j >= 0 && data[j] > data[j + gap]; j -= gap) {
					swap(data, j, j + gap);
				}
			}
		}
	}

	public static void radix(int[] data) {
		int n = 5;// 假设数组中最大值不超过5位数
		for (int p = 1; p <= 5; p++) {// 为各位数的值分配位置
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
		insertImprove(datasInsert);
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
		// 希尔排序
		System.out.println("");
		System.out.println("希尔改进排序：");
		int[] datasShell2 = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		System.out.print("排序前：");
		for (int data : datasShell2) {
			System.out.print(data + ".");
		}
		System.out.println("");
		shellImprove(datasShell2);
		System.out.print("排序后：");
		for (int data : datasShell2) {
			System.out.print(data + ".");
		}

		// 基数排序
		System.out.println("");
		System.out.println("基数排序：");
		int[] datasradix = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		System.out.print("排序前：");
		for (int data : datasradix) {
			System.out.print(data + ".");
		}
		System.out.println("");
		radix(datasradix);
		System.out.print("排序后：");
		for (int data : datasradix) {
			System.out.print(data + ".");
		}
	}
}
