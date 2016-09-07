package algorithm.sort;

/**
 * ��ѡ������
 * 
 * @author Administrator
 * 
 */
public class Simple {

	public static void sort(int[] datas) {
		int n = datas.length;
		for (int i = 0; i < n - 1; i++) {// n-1�α����������±�0��n-2����Ϊֻʣ1��������Ԫ��ʱ����Ԫ�ؿ϶�������
			sort(datas, i, n - i);
		}

	}

	/**
	 * 
	 * @param datas
	 * @param i
	 *            ��ʼλ��
	 * @param n
	 *            ����
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
		System.out.print("����ǰ��");
		for (int data : datas) {
			System.out.print(data + ".");
		}
		System.out.println("");
		sort(datas);
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
		sort(datas2);
		System.out.print("�����");
		for (int data : datas2) {
			System.out.print(data + ".");
		}
	}
}
