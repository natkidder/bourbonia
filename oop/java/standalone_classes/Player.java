// LB 261, book 3, chapter 2
/* Illustrates class variables (AKA fields or properties) */

public class Player  {

	private int iHealth;

	public int getHealth()  {
		return iHealth;
	}

	public void setHealth(int iH)  {

		if (iH < 0)
			iHealth = 0;
		else if ( iH > 100 )
			iHealth = 100;
		else
			iHealth = iH;
	}
}
