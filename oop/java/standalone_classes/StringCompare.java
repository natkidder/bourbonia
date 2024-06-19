public class StringCompare  {
	public static void main(String[] args)  {
		float f1 = 3.3F;
		String s1 = "billy dog";
		String s2 = s1 + "gie";
		if (s1 == s1)  {
			System.out.println("s1 and s2 point to the same memory location");
		}
		if (s1.equals(s2))  {
			System.out.println("s1 and s2 have equal value");
		}
	}
}
