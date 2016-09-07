package algorithm.sort;

/**
 * ������(ѡ��) ����
 * 
 * @author Administrator
 * 
 */
public class Heap {
	public static void sort(int[] data) {
		int last = data.length - 1;//
		int startNode = (last - 1) / 2;
		while (last >= 0) {
			// ��������
			for (int node = startNode; node >= 0; node--) {
				buildMaxHeap(data, node, last);
			}
			swap(data, 0, last);// �Ѷ�Ԫ�أ����ֵ���Ƶ����λ��
			last--;// ���λ��ǰ��
		}
	}

	public static void buildMaxHeap(int[] data, int node, int last) {
		int child = 2 * node + 1;// ����
		while (child <= last) {
			if (child + 1 <= last && data[child + 1] > data[child]) {// �Һ��Ӹ���
				child++;
			}
			if (data[child] > data[node]) {// �ӽڵ���󣬽���λ�ã�������������
				swap(data, child, node);
				node = child;
				child = 2 * node + 1;
			} else {
				break;// �Ѿ������ѣ��˳�ѭ��
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
