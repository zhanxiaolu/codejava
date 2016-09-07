package algorithm.sort;

public class SortCopy2 {
	/**
	 * 
	 * �ϸ���ð��
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
	 * �³���ð��
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
	 * ��������
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
			while (data[e] >= key && e > s) {// �Ӻ���ǰ�ұ�keyС��Ԫ��
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
	 * �鲢����
	 * 
	 * @param data
	 */
	public static void merge(int[] data) {
		mergeSort(data, 0, data.length - 1);
	}

	/**
	 * �ֽ�+�ϲ�����
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
	 * start~mid��mid+1~end��������������ϲ�
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
	 * ������
	 * 
	 * @param data
	 */
	public static void heap(int[] data) {
		int n = data.length - 1;
		while (n > 0) {
			int startnode = (n - 1) / 2;
			for (int i = startnode; i >= 0; i--) {// �Ե����Ͻ����󶥶�
				buildMaxHeap(data, i, n - 1);
			}
			swap(data, 0, n);
			n--;
		}
	}

	/**
	 * �����󶥶ѣ�����������ӶѶ��ѷ�������
	 * 
	 * @param data
	 * @param root
	 *            ���ڵ�
	 * @param lastnode
	 *            ���һ���ڵ�
	 */
	public static void buildMaxHeap(int[] data, int root, int lastnode) {
		int child = 2 * root + 1;// �����ӿ�ʼ
		if (child <= lastnode) {
			if (child + 1 <= lastnode && data[child] < data[child + 1]) {
				child++;
			}
			if (data[child] > data[root]) {// �������ӽڵ㣬�Ӷ���Ҫ���½����󶥶�
				swap(data, root, child);
				buildMaxHeap(data, child, lastnode);
			}
		}
	}

	/**
	 * ��ѡ������
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
	 * ��������
	 * 
	 * @param data
	 */
	public static void insert(int[] data) {
		// �Ӻ���ǰ�Ƚϣ���Ͻ�����ʽ�������
		for (int i = 1; i < data.length; i++) {// ֻ�е�һ��Ԫ�ص��������򣬴ӵڶ���Ԫ�ؿ�ʼ
			for (int j = i - 1; j >= 0 && data[j] > data[j + 1]; j--) {// ���i��jС�����ѭ��
				swap(data, j, j + 1);
			}
		}
	}

	/**
	 * ϣ�����򣬲�����ʼΪȫ����һ�룬��ÿ����Сһ��
	 * 
	 * @param data
	 */
	public static void shell(int[] data) {
		for (int gap = data.length / 2; gap > 0; gap /= 2) {
			insert(data, gap);
		}
	}

	public static void insert(int[] data, int gap) {
		// �Ӻ���ǰ�Ƚϣ���Ͻ�����ʽ�������
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
	 *            λ�� �������������ֵ������numberλ��
	 */
	public static void radix(int[] data, int number) {
		for (int p = 1; p <= number; p++) {// Ϊ��λ����ֵ����λ��
			int temp[][] = new int[10][data.length];// �洢������
			int tempnum[] = new int[10];// �洢ÿ��ֵλ�õ�Ԫ�ظ���
			// λ������
			int d = 1;
			for (int i = 1; i < p; i++) {
				d = d * 10;
			}
			// ��һά���鰴ÿ��Ԫ�صĸ�/ʮ/��/ǧ/��λ����ת��Ϊ��ά����
			for (int j = 0; j < data.length; j++) {
				int x = (data[j] / d) % 10;
				temp[x][tempnum[x]++] = data[j];
			}
			// ��ά����Ԫ�ذ�˳��ת��Ϊһά����
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
		System.out.print("����ǰ��");
		for (int data : datas) {
			System.out.print(data + ".");
		}
		System.out.println("");
		bubbleMin(datas);
		System.out.print("�����");
		for (int data : datas) {
			System.out.print(data + ".");
		}

		System.out.println("");
		int[] datas2 = { 1, 2, 3, 7, 6, 5, 4, 8, 9, 10 };
		System.out.print("����ǰ��");
		for (int data : datas2) {
			System.out.print(data + ".");
		}
		System.out.println("");
		bubbleMax(datas2);
		System.out.print("�����");
		for (int data : datas2) {
			System.out.print(data + ".");
		}

		System.out.println("");
		int[] datas3 = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		System.out.print("����ǰ��");
		for (int data : datas3) {
			System.out.print(data + ".");
		}
		System.out.println("");
		quick(datas3);
		System.out.print("�����");
		for (int data : datas3) {
			System.out.print(data + ".");
		}

		// �鲢����
		System.out.println("");
		int[] datasMerge = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		System.out.print("����ǰ��");
		for (int data : datasMerge) {
			System.out.print(data + ".");
		}
		System.out.println("");
		merge(datasMerge);
		System.out.print("�����");
		for (int data : datasMerge) {
			System.out.print(data + ".");
		}
		// ������
		System.out.println("");
		System.out.println("������");
		int[] datasHeap = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		System.out.print("����ǰ��");
		for (int data : datasHeap) {
			System.out.print(data + ".");
		}
		System.out.println("");
		heap(datasHeap);
		System.out.print("�����");
		for (int data : datasHeap) {
			System.out.print(data + ".");
		}
		// ��ѡ������
		System.out.println("");
		System.out.println("��ѡ������");
		int[] datasSimple = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		System.out.print("����ǰ��");
		for (int data : datasSimple) {
			System.out.print(data + ".");
		}
		System.out.println("");
		simpleChoose(datasSimple);
		System.out.print("�����");
		for (int data : datasSimple) {
			System.out.print(data + ".");
		}
		// ֱ�Ӳ�������
		System.out.println("");
		System.out.println("ֱ�Ӳ�������");
		int[] datasInsert = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		System.out.print("����ǰ��");
		for (int data : datasInsert) {
			System.out.print(data + ".");
		}
		System.out.println("");
		insert(datasInsert);
		System.out.print("�����");
		for (int data : datasInsert) {
			System.out.print(data + ".");
		}
		// ϣ������
		System.out.println("");
		System.out.println("ϣ������");
		int[] datasShell = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		System.out.print("����ǰ��");
		for (int data : datasShell) {
			System.out.print(data + ".");
		}
		System.out.println("");
		shell(datasShell);
		System.out.print("�����");
		for (int data : datasShell) {
			System.out.print(data + ".");
		}
	
		// ��������
		System.out.println("");
		System.out.println("��������");
		int[] datasradix = { 1000, 9, 88888, 7, 6, 5, 4, 3, 2, 1, 0 };
		System.out.print("����ǰ��");
		for (int data : datasradix) {
			System.out.print(data + ".");
		}
		System.out.println("");
		radix(datasradix,5);
		System.out.print("�����");
		for (int data : datasradix) {
			System.out.print(data + ".");
		}
	}
}
