package algorithm.sort;

/**
 * 堆排序(选择) 最大堆
 * 
 * @author Administrator
 * 
 */
public class Heap {
	public static void sort(int[] data) {
		int last = data.length - 1;//
		int startNode = (last - 1) / 2;
		while (last >= 0) {
			// 建立最大堆
			for (int node = startNode; node >= 0; node--) {
				buildMaxHeap(data, node, last);
			}
			swap(data, 0, last);// 堆顶元素（最大值）移到最后位置
			last--;// 最后位置前移
		}
	}

	public static void buildMaxHeap(int[] data, int node, int last) {
		int child = 2 * node + 1;// 左孩子
		while (child <= last) {
			if (child + 1 <= last && data[child + 1] > data[child]) {// 右孩子更大
				child++;
			}
			if (data[child] > data[node]) {// 子节点更大，交换位置，继续遍历子树
				swap(data, child, node);
				node = child;
				child = 2 * node + 1;
			} else {
				break;// 已经是最大堆，退出循环
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
		System.out.print("排序前：");
		for (int data : datas) {
			System.out.print(data + ".");
		}
		System.out.println("");
		sort(datas);
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
		sort(datas2);
		System.out.print("排序后：");
		for (int data : datas2) {
			System.out.print(data + ".");
		}
	}
}
