package interview;

import org.junit.Test;

public class RunTest   {
	/**
	 * œ‡µ»≈–∂œ
	 */
	@Test
	public void equals1() {
		
		Integer i01 = 59;
		int i02 = 59;
		Integer i03 = Integer.valueOf(59);
		Integer i04 = new Integer(59);
		System.out.println(i01 == i02);
		System.out.println(i01 == i03);
		System.out.println(i01 == i04);// false
		System.out.println(i02 == i03);
		System.out.println(i02 == i04);
		System.out.println(i03 == i04);// false
	}

	@Test
	public void equals2() {
		String a = "1234";
		String b = "1234";
		String c = new String("1234");
		System.out.println(a == b);
		System.out.println(a == c);
		System.out.println(a.equals(c));
	}

	@Test
	public void testString() {
		String str0 = "0123456789";
		String str1 = "0123456789";
		String str2 = str1.substring(5);
		System.out.println(str2);
		String str3 = new String(str2);
		String str4 = new String(str3.toCharArray());
		str0 = null;
	}

}
