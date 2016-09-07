package algorithm.sort;

/**
 * ��������
 * 
 * @author Administrator
 * 
 */
public class Radix {
	public static void sort(int[] datas) {
		int[][] temp = new int[10][datas.length];
		int n = 6;// �������������������6λ
		int p = 1;
		while (p <= n) {
			sort(datas, temp,p++);
		}

	}
	/**
	 * 
	 * @param datas ����������
	 * @param temp  �洢�����������ʱ���
	 * @param p ��Ԫ�ؾ��������λ�ã�����1�����λ��2����ʮλ��3�����λ
	 */
	public static void sort(int[] datas, int[][] temp, int p) {
		int d=1;
		int dtemp=1;
		while(dtemp<p){
			d = d*10;
			dtemp++;
		}
		
		int[] xnum = new int[10];// �洢��ά����temp[x]��Ԫ�ظ���
		for (int i = 0; i < datas.length; i++) {
			int x = (datas[i] / d) % 10;
			temp[x][xnum[x]] = datas[i];
			xnum[x] = xnum[x] + 1;
		}
		int index = 0;
		for (int j = 0; j < 10; j++) {
			if (xnum[j] > 0) {
				for (int k = 0; k < xnum[j]; k++) {
					datas[index++] = temp[j][k];
				}
			}
			xnum[j]=0;//����
		}
	}

	public static void main(String[] args) {
		int[] datas =  {73, 22, 93, 43, 55, 14, 28, 65, 39, 81, 33, 100};
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

	}
}
