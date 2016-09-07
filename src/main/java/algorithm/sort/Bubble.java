package algorithm.sort;


/**
 * ð������(����)��
 * 1���Ƚ����ڵ�Ԫ�ء������һ���ȵڶ����󣬾ͽ�������������
 * 2����ÿһ������Ԫ����ͬ���Ĺ������ӿ�ʼ��һ�Ե���β�����һ�ԡ�����һ�㣬����Ԫ��Ӧ�û�����������
 * 3��������е�Ԫ���ظ����ϵĲ��裬�������һ����
 * 4������ÿ�ζ�Խ��Խ�ٵ�Ԫ���ظ�����Ĳ��裬ֱ��û���κ�һ��������Ҫ�Ƚϡ�
 * @author Administrator
 *
 */
public class Bubble {
	
	public static void sort(int[] datas){
		int n = datas.length;
		int times = 0;
		for(int i=0;i<n-1;i++){//����n-1��,nΪ���鳤��
			for(int j=0;j<n-1-i;j++){//����n-1-i��
				if(datas[j]>datas[j+1]){//Ԫ�ػ���
					times++;//��������+1
					int temp = datas[j];
					datas[j] = datas[j+1];
					datas[j+1] = temp;
				}
			}
		}
		System.out.println("Ԫ�ػ���������"+times);
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
