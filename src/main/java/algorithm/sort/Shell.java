package algorithm.sort;

/**
 * œ£∂˚≈≈–Ú
 * 
 * @author Administrator
 * 
 */
public class Shell {

	public static void sort(int[] datas) {
		int gap = datas.length / 2;
		while (gap > 0) {
			insertsort(datas, gap);
			gap = gap / 2;
		}
	}

	public static void insertsort(int[] datas, int gap) {
		for (int i = gap; i < datas.length; i++) 
			for (int k = i - gap; k >= 0; k = k - gap) 
				if (datas[k] > datas[k + gap]) 
					swap(datas, k, k+gap);
	}

	public static void swap(int[] datas, int i, int j) {
		int temp = datas[i];
		datas[i] = datas[j];
		datas[j] = temp;
	}

	public static void main(String[] args) {
		int[] datas = { 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		System.out.print("≈≈–Ú«∞£∫");
		for (int data : datas) {
			System.out.print(data + ".");
		}
		System.out.println("");
		sort(datas);
		System.out.print("≈≈–Ú∫Û£∫");
		for (int data : datas) {
			System.out.print(data + ".");
		}

		System.out.println("");
		int[] datas2 = { 1, 2, 3, 7, 6, 5, 4, 8, 9, 10 };
		System.out.print("≈≈–Ú«∞£∫");
		for (int data : datas2) {
			System.out.print(data + ".");
		}
		System.out.println("");
		sort(datas2);
		System.out.print("≈≈–Ú∫Û£∫");
		for (int data : datas2) {
			System.out.print(data + ".");
		}
	}
}
