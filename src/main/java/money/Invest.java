package money;

import org.junit.Test;

/**
 * Ͷ�ʼ���
 * 
 * @author Administrator
 * 
 */
public class Invest {
	private int years = 1;
	private double rate = 0.1;

	/**
	 * P2Pÿ�¶�Ͷ���ۼƣ��������棬ʵ�ʴﲻ��
	 */
	@Test
	public void p2p() {
		int month_money = 1000;// ÿ�¶�Ͷ
		double month_sum = 12000;// ��ʼ���
		for (int i = 1; i <= 12 * years; i++) {
			if (month_sum == 0) {
				month_sum = month_money;// ��һ���²�����Ϣ
			} else {
				month_sum += (double) month_sum * 0.1 / 12 + month_money;
			}
			System.out.println(String.format("��%s����ʱ���ʲ�Ϊ:%s", i, month_sum));
		}
	}

	/**
	 * Ͷ����ƣ�ÿ��̶��������ۼ�10%�� ���¼�Ϣ�Ͱ����Ϣ������
	 * 
	 */
	@Test
	public void bankByMonth() {
		int years = 10;
		double month_num = 12000;// ��ʼ�����Ϊ12000
		double year_num = 12000;
		for (int i = 1; i <= 12 * years; i++) {
			month_num += (double) month_num * 0.1 / 12;
		}
		System.out.println(String.format("�����Ϣ���ʲ���%s",month_num));

		for (int i = 1; i <=years; i++) {
			year_num += (double) year_num * 0.1;
		}
		System.out.println(String.format("�����Ϣ���ʲ���%s",year_num));
//		�����Ϣ���ʲ���32484.497890347062
//		�����Ϣ���ʲ���31124.90952120001
	}

	/**
	 * Ͷ����ƣ�ÿ��̶��������ۼ�10%
	 */
	@Test
	public void bank() {
		int year_money = 12000;// ÿ�궨Ͷ
		double year_sum = 12000;// ��ʼ���12000
		for (int i = 1; i <= years; i++) {
			year_sum += (double) year_sum * 0.1 + year_money;
			System.out.println(String.format("��%s�����ʱ���ʲ�Ϊ:%s", i, year_sum));
		}
	}

}
