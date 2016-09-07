package algorithm.sort;

/**
 * ֱ�Ӳ�������
 * 
 * @author Administrator
 * 
 */
public class Insert {
	public static void sort(int[] datas) {
		for(int i=1;i<datas.length;i++){//n-1�α����������±�1��n-1��ֱ�Ӵӵڶ���Ԫ�ؿ�ʼ
			sort(datas, i);
		}
	}

	public static void sort(int[] datas, int i) {
		for (int j = 0; j < i; j++) {
			if (datas[j] > datas[i]) {
				int temp = datas[i];
				for (int k = i-1; k >= j; k--) {// ��j��ʼ����Ԫ�غ���
					datas[k+1] = datas[k];
				}
				datas[j] = temp;
				break;
			}
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
