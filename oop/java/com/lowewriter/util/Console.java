// LB 349, book 3, chapter 8
package com.lowewriter.util;

import java.util.Scanner;

public class Console  {
	static Scanner sc = new Scanner(System.in);

	public static boolean askYorN( String prompt )  {
		while(true)  {
			String answer;
			System.out.print("\n" + prompt + " (Y or N) ");
			answer = sc.next();
			if (answer.equalsIgnoreCase("Y"))
				return true;
			else
				return false;
			}
		}
	}
