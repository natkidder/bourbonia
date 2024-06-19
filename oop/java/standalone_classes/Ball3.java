// LB 287, book 3, chapter 4
import utilities.*;

public class Ball3   {

	public void hit()   {

		Prt.prtln("You hit it a mile!");
	}
}

// same file, so no boundary

class Baseball3 extends Ball3   {

	public void hit()   {

		Prt.prtln("You tore the cover off!");

// invoke Ball3.hit
		super.hit();
	}
}
