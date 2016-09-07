package algorithm.sort;


/**
 * 冒泡排序(交换)：
 * 1、比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 2、对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。在这一点，最后的元素应该会是最大的数。
 * 3、针对所有的元素重复以上的步骤，除了最后一个。
 * 4、持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 * @author Administrator
 *
 */
public class Bubble {
	
	public static void sort(int[] datas){
		int n = datas.length;
		int times = 0;
		for(int i=0;i<n-1;i++){//遍历n-1次,n为数组长度
			for(int j=0;j<n-1-i;j++){//遍历n-1-i次
				if(datas[j]>datas[j+1]){//元素互换
					times++;//交换次数+1
					int temp = datas[j];
					datas[j] = datas[j+1];
					datas[j+1] = temp;
				}
			}
		}
		System.out.println("元素互换次数："+times);
	}
	public static void main(String[] args) {
		int[] datas = {10,9,8,7,6,5,4,3,2,1};
		System.out.print("排序前：");
		for(int data : datas){
			System.out.print(data+".");
		}
		System.out.println("");
		sort(datas);
		System.out.print("排序后：");
		for(int data : datas){
			System.out.print(data+".");
		}
		
		System.out.println("");
		int[] datas2 = {1,2,3,7,6,5,4,8,9,10};
		System.out.print("排序前：");
		for(int data : datas2){
			System.out.print(data+".");
		}
		System.out.println("");
		sort(datas2);
		System.out.print("排序后：");
		for(int data : datas2){
			System.out.print(data+".");
		}
	}
	
}
