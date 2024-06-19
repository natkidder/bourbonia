// LB 276, book 3, chapter 2
// illustrates a singleton class, which allows only one instance
import utilities.*;
import java.util.Scanner;

public class CntSingletonClasses  {
	public static void main(String args[])  {
		SingletonClass sc1 = SingletonClass.getInstance();
		SingletonClass sc2 = SingletonClass.getInstance();
		if ( sc1 == sc2 )  {
			Prt.prtln("The 2 SingletonClass objects are really the same");
		} else {
			Prt.prtln("The 2 SingletonClass objects are, in fact, different");
		}
	}
}

class SingletonClass  {
	private static SingletonClass scInstance;  // note we can declare an instance of a class inside the class

	private SingletonClass()  {   // prevents any constructor from being used outside the class, if this is the only one
	}

	public static SingletonClass getInstance()  {
		if (scInstance == null)
			scInstance = new SingletonClass();
		return scInstance;
	}
}
