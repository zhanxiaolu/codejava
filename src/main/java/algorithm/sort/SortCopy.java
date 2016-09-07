package algorithm.sort;

public class SortCopy {
	/**
	 * 
	 * �ϸ���ð��
	 * 
	 * @param data
	 */
	public static void bubbleMin(int[] data) {
		int n = data.length;
		for (int i = 0; i < n - 1; i++) {// n-1�α���
			for (int j = n - 1; j > i; j--) {// �Ӻ���ǰѡ����Сֵ������ǰ��
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
		for (int i = n - 1; i > 0; i--) {// n-1�α���
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
		quickPartition(data, 0, data.length - 1);
	}

	public static void quickPartition(int[] data, int start, int end) {
		int x = data[start];// �ο�Ԫ��
		int s = start;
		int e = end;
		while (s < e) {// s==eʱ�˳�����λ��Ҳ�ǲο�Ԫ�ص�����λ��
			// �Ӻ���ǰ�ұ�XС��Ԫ��
			while (data[e] >= x && e > s) {
				e--;
			}
			if (data[e] < x) {
				swap(data, s, e);
			}
			// ��ǰ�����ұ�x���Ԫ��
			while (data[s] <= x && e > s) {
				s++;
			}
			if (data[s] < x) {
				swap(data, s, e);
			}
		}
		if (start < s - 1) {// ֻ��һ��Ԫ��ʱ�˳�
			quickPartition(data, start, s - 1);
		}
		if (end > s + 1) {// ֻ��һ��Ԫ��ʱ�˳�
			quickPartition(data, s + 1, end);
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
		if (start < end) {// ֻ��һ��Ԫ��ʱ�˳�
			mergeSort(data, start, mid);
			mergeSort(data, mid + 1, end);
			mergeArray(data, start, mid, end);
		}
	}

	public static void mergeArray(int[] data, int start, int mid, int end) {
		int[] temp = new int[end - start + 1];//��ʱ�ռ�洢���
		int lstart = start;
		int rstart = mid + 1;
		int x = 0;
		while (lstart <= mid && rstart <= end) {
			if (data[lstart] <= data[rstart] ) {// ������Ԫ��С�ͽ�����ʱ�ռ�
				temp[x++] = data[lstart++];
			}
			if (data[rstart] < data[lstart] ) {// ������Ԫ��С�ͽ�����ʱ�ռ�
				temp[x++] = data[rstart++];
			}
		}
		while (lstart <= mid) {// ʣ�µ�������ȫ��������ʱ�ռ�
			temp[x++] = data[lstart++];
		}
		while (rstart <= end) {// ʣ�µ�������ȫ��������ʱ�ռ�
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
		// // ������
		// System.out.println("");
		// System.out.println("������");
		// int[] datasHeap = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		// System.out.print("����ǰ��");
		// for (int data : datasHeap) {
		// System.out.print(data + ".");
		// }
		// System.out.println("");
		// // heap(datasHeap);//����Խ�����
		// System.out.print("�����");
		// for (int data : datasHeap) {
		// System.out.print(data + ".");
		// }
		// // ��ѡ������
		// System.out.println("");
		// System.out.println("��ѡ������");
		// int[] datasSimple = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		// System.out.print("����ǰ��");
		// for (int data : datasSimple) {
		// System.out.print(data + ".");
		// }
		// System.out.println("");
		// simpleChoose(datasSimple);
		// System.out.print("�����");
		// for (int data : datasSimple) {
		// System.out.print(data + ".");
		// }
		// // ֱ�Ӳ�������
		// System.out.println("");
		// System.out.println("ֱ�Ӳ�������");
		// int[] datasInsert = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		// System.out.print("����ǰ��");
		// for (int data : datasInsert) {
		// System.out.print(data + ".");
		// }
		// System.out.println("");
		// insertImprove(datasInsert);
		// System.out.print("�����");
		// for (int data : datasInsert) {
		// System.out.print(data + ".");
		// }
		// // ϣ������
		// System.out.println("");
		// System.out.println("ϣ������");
		// int[] datasShell = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		// System.out.print("����ǰ��");
		// for (int data : datasShell) {
		// System.out.print(data + ".");
		// }
		// System.out.println("");
		// shell(datasShell);
		// System.out.print("�����");
		// for (int data : datasShell) {
		// System.out.print(data + ".");
		// }
		// // ϣ������
		// System.out.println("");
		// System.out.println("ϣ���Ľ�����");
		// int[] datasShell2 = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		// System.out.print("����ǰ��");
		// for (int data : datasShell2) {
		// System.out.print(data + ".");
		// }
		// System.out.println("");
		// shellImprove(datasShell2);
		// System.out.print("�����");
		// for (int data : datasShell2) {
		// System.out.print(data + ".");
		// }
		//
		// // ��������
		// System.out.println("");
		// System.out.println("��������");
		// int[] datasradix = { 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
		// System.out.print("����ǰ��");
		// for (int data : datasradix) {
		// System.out.print(data + ".");
		// }
		// System.out.println("");
		// radix(datasradix);
		// System.out.print("�����");
		// for (int data : datasradix) {
		// System.out.print(data + ".");
		// }
	}
}
