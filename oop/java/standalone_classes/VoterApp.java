// LB 194, book 2, chapter 6
import java.util.Scanner;

public class VoterApp  {

	static Scanner scIn = new Scanner(System.in);

	public static void main(String[] args)  {
		System.out.println("Welecom to the voting maching error code decoder\n\n." +
			"If your voting machin generates and error code,\n" +
			"you can use this program to determin the exact\n" +
			"cause of the error\n");
		System.out.print("Enter the error code: ");
		int iErr = scIn.nextInt();

		String sMsg;
		if (iErr == 1)
			sMsg = "Voter marked more than one candidate.\nBallot rejected";
		else if (iErr == 2)
			sMsg = "Box checked and write-in candidate entered.\n";
		else if (iErr == 3)
			sMsg = "Entire ballot was blank.\nBallot filled in according to secret plan.";
		else if (iErr ==4)
			sMsg = "Nothing usual about the ballot.\nVoter randomly selected for tax audit.";
		else if (iErr == 5)
			sMsg = "Voter filled in every box.\nBallot counted twice.";
		else if (iErr == 6)
			sMsg = "Voter drooled in voting machine.\nBeginning spin cycle.";
		else if (iErr == 7)
			sMsg = "Voter lied to pollster after voting.\nVoter's ballot changed to match polling data.";
		else
			sMsg = "Voter filled out ballot correctely\n.  Ballot discarded anyway.";
		System.out.println(sMsg);
	}
}
