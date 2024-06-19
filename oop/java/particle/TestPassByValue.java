// TG 17

public class TestPassByValue
{
	public static void main(String[] args)
	{
		// instantiate a TestPassByValue object
		TestPassByValue t = new TestPassByValue();
		int i = 1;
		System.out.println("value of i before increment = " + i);
		// pass value of local variable
		System.out.println("int j = t.increment(i);");
		int j = t.increment(i);
		System.out.println("value of i after increment = " + i);
		System.out.println("value of j = " + j);
		System.out.println("j = t.increment2(j);");
		j = t.increment2(j);
		System.out.println("value of i after increment2 = " + i);
		System.out.println("value of j after increment2 = " + j);
	}

	public int increment (int i)
	{
		i = ++i;  // or just say ++i or i = i + 1
		System.out.println("value of i (increment arg) in increment = " + i);
		return i;
	}

	public int increment2 (int k)
	{
		int i = k;   // i referes to instance variable
		System.out.println("value of k (increment2 arg) in increment2 = " + k);
		i = ++i;
		System.out.println("value of i in increment2 = " + i);
		return i;
	}
}
