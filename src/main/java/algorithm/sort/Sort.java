package algorithm.sort;

public class Sort {
	/**
	 * ð��������ϸ��汾����ÿ��ѡ����Сֵ�ŵ�ǰ��
	 * 
	 * @param data
	 */
	public static void bubbleMin(int[] data) {
		int n = data.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = n - 1; j > i; j--) {
				if (data[j] < data[j - 1]) {// ��С��Ԫ�ػ���ǰ��
					swap(data, j, j - 1);
				}
			}
		}
	}

	/**
	 * ð��������³��汾����ÿ��ѡ�����ֵ�ŵ�����
	 * 
	 * @param data
	 */
	public static void bubbleMax(int[] data) {
		int n = data.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i; j < n - 1 - i; j++) {
				if (data[j] > data[j + 1]) {// �Ѵ��Ԫ�ػ���ǰ��
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
		int n = data.length;
		quickPartition(data, 0, n - 1);
	}

	private static void quickPartition(int[] data, int start, int end) {
		int i = start;
		int key = data[i];// ��ʼ���õ�һ��Ԫ��Ϊkey
		int j = end;
		while (i < j) {// i,jδ����
			while (j > i && data[j] >= key) {// �Ӻ���ǰѰ�ұ�keyС��Ԫ��
				j--;
			}
			if (data[j] < key) {// ����λ�ã�����֮��key��j��λ��
				swap(data, j, i);
			}
			while (j > i && data[i] <= key) {// ��ǰ����Ѱ�ұ�key���Ԫ��
				i++;
			}
			if (data[i] > key) {// ����λ�ã�����֮��key��i��λ��
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
	 * �鲢����
	 * 
	 * @param data
	 */
	public static void merge(int[] data) {
		mergeSort(data, 0, data.length - 1);
	}

	/**
	 * �ֽ�
	 * 
	 * @param data
	 * @param start
	 * @param end
	 */
	private static void mergeSort(int[] data, int start, int end) {
		int mid = (start + end) / 2;
		if (start < end) {// �ֽ⵽ֻʣһ��Ԫ���˳�
			mergeSort(data, start, mid);
			mergeSort(data, mid + 1, end);
			mergeArray(data, start, mid, end);
		}
	}

	/**
	 * �ϲ�������������飬start->mid ----- mid+1->end
	 * 
	 * @param data
	 * @param start
	 * @param mid
	 * @param end
	 */
	private static void mergeArray(int[] data, int start, int mid, int end) {
		int[] temp = new int[end - start + 1];// ��ʱ�ռ�洢�ϲ����
		int l = start;// ��������ʼλ��
		int r = mid + 1;// ��������ʼλ��
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
		for (int j = 0; j <= temp.length - 1; j++) {// �ϲ�������ǻ�����
			data[start + j] = temp[j];
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

	public static void simpleChoose(int[] data) {
		int n = data.length;
		for (int i = 0; i < n; i++) {// ���һ�ֱ�����ʵ����Ҫ
			int min = i;// ��СԪ��λ�ó�ʼ��Ϊ��ʼԪ�ص�λ��
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
	 * ��ĳ��Ԫ�ز��뵽���������У����������ǰ����ȣ��ҵ�����λ�ã���λ�ú���Ԫ��ȫ������һλ
	 * 
	 * @param data
	 */
	public static void insert(int[] data) {
		int n = data.length;
		for (int i = 1; i < n; i++) {// �ӵڶ���Ԫ�ؿ�ʼ
			for (int j = 0; j < i; j++) {// 0---i-1�������򣬴�С����
				if (data[j] < data[i]) {
					int temp = data[i];
					for (int k = i - 1; k >= j; k++) {// j----i-1��������Ԫ�غ���
						data[k + 1] = data[k];
					}
					data[j] = temp;
					break;
				}
			}
		}
	}

	/**
	 * ��ĳ��Ԫ�ز��뵽���������У���������Ӻ���ǰ�ȣ�ͨ�������ķ�ʽ�������Ĺ��� ֱ�Ӳ�����ð�ݵĽ��
	 * 
	 * @param data
	 */
	public static void insertImprove(int[] data) {
		int n = data.length;
		for (int i = 1; i < n; i++) {// �ӵڶ���Ԫ�ؿ�ʼ
			for (int j = i - 1; j >= 0 && data[j] > data[j + 1]; j--) {
				swap(data, j, j + 1);
			}
		}
	}

	/**
	 * ��ͨϣ�������߼�����̫�������
	 * 
	 * @param data
	 */
	public static void shell(int[] data) {
		int n = data.length;
		for (int gap = n / 2; gap > 0; gap /= 2) {// ���������粽��Ϊx�����±�Ϊ0Ԫ������������0��x��2x��3x
			shell(data, gap);
		}
	}

	public static void shell(int[] data, int gap) {
		for (int i = gap; i < data.length; i += gap) {// �ӵڶ���Ԫ�ؿ�ʼ
			for (int j = i - gap; j >= 0 && data[j] > data[j + gap]; j -= gap) {
				swap(data, j, j + gap);
			}
		}
	}

	/**
	 * ����ֱ�Ӳ�������ĸĽ�������Ҳ�ǴӺ���ǰ��ͨ�������������
	 * 
	 * @param data
	 */
	public static void shellImprove(int[] data) {
		int n = data.length;
		for (int gap = n / 2; gap > 0; gap /= 2) {// ����
			for (int i = gap; i < n; i++) {
				for (int j = i - gap; j >= 0 && data[j] > data[j + gap]; j -= gap) {
					swap(data, j, j + gap);
				}
			}
		}
	}

	public static void radix(int[] data) {
		int n = 5;// �������������ֵ������5λ��
		for (int p = 1; p <= 5; p++) {// Ϊ��λ����ֵ����λ��
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
		insertImprove(datasInsert);
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
		// ϣ������
		System.out.println("");
		System.out.println("ϣ���Ľ�����");
		int[] datasShell2 = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		System.out.print("����ǰ��");
		for (int data : datasShell2) {
			System.out.print(data + ".");
		}
		System.out.println("");
		shellImprove(datasShell2);
		System.out.print("�����");
		for (int data : datasShell2) {
			System.out.print(data + ".");
		}

		// ��������
		System.out.println("");
		System.out.println("��������");
		int[] datasradix = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		System.out.print("����ǰ��");
		for (int data : datasradix) {
			System.out.print(data + ".");
		}
		System.out.println("");
		radix(datasradix);
		System.out.print("�����");
		for (int data : datasradix) {
			System.out.print(data + ".");
		}
	}
}
