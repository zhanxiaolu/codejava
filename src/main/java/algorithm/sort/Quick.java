package algorithm.sort;

/**
 * ��������(����)
 * 
 * @author Administrator
 * 
 */
public class Quick {

	public static void sort(int[] datas) {
		partition(datas, 0, datas.length - 1);
	}

	public static void partition(int[] datas, int start, int end) {
		int key = datas[start];//ѡ�õ�һ��Ԫ����Ϊ�ָ�ֵ
		int i = start;
		int j = end;
		while (i < j) {
			while(j>i && datas[j] >= key){//��ǰ������keyС��ֵ
				j--;
			}
			if(datas[j]<key){//key����i������j��key��λ�ã�
				swap(datas, i, j);
			}
			while(j>i && datas[i] <= key){//����������key���ֵ
				i++;
			}
			if(datas[i]>key){//key����j������i��key��λ��
				swap(datas, i, j);
			}
		}
		// i==j,�ݹ���ѷָ��������������
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
