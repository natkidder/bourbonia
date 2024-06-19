// LB 289, book 3, chapter 4
// illustrates a final class, which cannot be inherited

public final class StarShip  {

	public static int iWarp;
}

// will not compile as super class is declare as final
class EnterpriseClass extends StarShip  {

	public EnterpriseClass()  {

		iWarp = super.iWarp;
	}
}
