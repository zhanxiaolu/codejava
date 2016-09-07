package algorithm.sort;

/**
 * �鲢����
 * 
 * @author Administrator
 * 
 */
public class Merge {

	public static void sort(int[] datas) {
		sort(datas, 0, datas.length - 1);
	}
	public static void sort(int[] datas, int start, int end) {
		int mid = (start + end) / 2;
		if (start<end) {
			sort(datas,start,mid);
			sort(datas,mid+1,end);
			merge(datas, start, mid, end);
		}
	}
	public static void merge(int[] datas,int start,int mid,int end){
		int[] temp = new int[end-start+1];
		int lstart = start;//���������ʼ�±�
		int rstart = mid+1;//�ұ�������ʼ�±�
		int i=0;
		while(lstart<=mid&&rstart<=end){
			if(datas[lstart]<=datas[rstart]){
				temp[i++] = datas[lstart++];
			}else{
				temp[i++] = datas[rstart++];
			}
		}
		while(lstart<=mid){
			temp[i++] = datas[lstart++];
		}
		while(rstart<=end){
			temp[i++] = datas[rstart++];
		}
		for(int t : temp){
			datas[start] = t;
			start++;
		}
	}
	
	public static void swap(int[] datas, int i, int j) {
		int temp = datas[i];
		datas[i] = datas[j];
		datas[j] = temp;
	}
	public static void main(String[] args) {
		int[] datas = {10,9,8,7,6,5,4,3,2,1};
		System.out.print("����ǰ��");
		for(int data : datas){
			System.out.print(data+".");
		}
		System.out.println("");
		sort(datas);
		System.out.print("�����");
		for(int data : datas){
			System.out.print(data+".");
		}
		
		System.out.println("");
		int[] datas2 = {1,2,3,7,6,5,4,8,9,10};
		System.out.print("����ǰ��");
		for(int data : datas2){
			System.out.print(data+".");
		}
		System.out.println("");
		sort(datas2);
		System.out.print("�����");
		for(int data : datas2){
			System.out.print(data+".");
		}
	}
}
