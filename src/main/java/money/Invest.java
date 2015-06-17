package money;

import org.junit.Test;

/**
 * 投资计算
 * 
 * @author Administrator
 * 
 */
public class Invest {
	private int years = 1;
	private double rate = 0.1;

	/**
	 * P2P每月定投的累计，完美收益，实际达不到
	 */
	@Test
	public void p2p() {
		int month_money = 1000;// 每月定投
		double month_sum = 12000;// 初始金额
		for (int i = 1; i <= 12 * years; i++) {
			if (month_sum == 0) {
				month_sum = month_money;// 第一个月不算利息
			} else {
				month_sum += (double) month_sum * 0.1 / 12 + month_money;
			}
			System.out.println(String.format("第%s结束时的资产为:%s", i, month_sum));
		}
	}

	/**
	 * 投资理财，每年固定金额，假设累计10%， 按月计息和按年计息的区别
	 * 
	 */
	@Test
	public void bankByMonth() {
		int years = 10;
		double month_num = 12000;// 初始化金额为12000
		double year_num = 12000;
		for (int i = 1; i <= 12 * years; i++) {
			month_num += (double) month_num * 0.1 / 12;
		}
		System.out.println(String.format("按年计息，资产：%s",month_num));

		for (int i = 1; i <=years; i++) {
			year_num += (double) year_num * 0.1;
		}
		System.out.println(String.format("按年计息，资产：%s",year_num));
//		按年计息，资产：32484.497890347062
//		按年计息，资产：31124.90952120001
	}

	/**
	 * 投资理财，每年固定金额，假设累计10%
	 */
	@Test
	public void bank() {
		int year_money = 12000;// 每年定投
		double year_sum = 12000;// 初始金额12000
		for (int i = 1; i <= years; i++) {
			year_sum += (double) year_sum * 0.1 + year_money;
			System.out.println(String.format("第%s年结束时的资产为:%s", i, year_sum));
		}
	}

}
