package generics.main;

import generics.bean.Test;

/*
 * https://www.geeksforgeeks.org/generics-in-java/?ref=ml_lbp
 */
public class GenericsMain {

	public static void main(String[] args) {
		// instance of Integer type
        Test<Integer> iObj = new Test<Integer>(15);
        System.out.println(iObj.getObject());
 
        // instance of String type
        Test<String> sObj
            = new Test<String>("GeeksForGeeks");
        System.out.println(sObj.getObject());	}

}
