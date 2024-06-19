// LB 289, book 3, chapter 4
// illustrates final methods, which cannot be inherited

public class SpaceShip  {

	static int iVelocity;

	public final int getVelocity()  {

		return this.iVelocity;
	}
}

class StarCruiser extends SpaceShip   {

	public int getVelocity()  {

// will not compile as super.iVelocity is final
		return super.iVelocity;
	}
}
