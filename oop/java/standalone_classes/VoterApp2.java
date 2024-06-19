// LB 194, book 2, chapter 6
import java.util.Scanner;

public class VoterApp2  {

	static Scanner scIn = new Scanner(System.in);

	public static void main(String[] args)  {
		System.out.println("Welecom to the voting maching error code decoder\n\n." +
			"If your voting machin generates and error code,\n" +
			"you can use this program to determine the exact\n" +
			"cause of the error\n");
		System.out.print("Enter the error code: ");
		int iErr = scIn.nextInt();

		String sMsg;

		switch (iErr)  {
		case 1:
			sMsg = "Voter marked more than one candidate.\nBallot rejected";
			break;
		case 2:
			sMsg = "Box checked and write-in candidate entered.\n";
			break;
		case 3:
			sMsg = "Entire ballot was blank.\nBallot filled in according to secret plan.";
			break;
		case 4:
			sMsg = "Nothing usual about the ballot.\nVoter randomly selected for tax audit.";
			break;
		case 5:
			sMsg = "Voter filled in every box.\nBallot counted twice.";
			break;
		case 6:
			sMsg = "Voter drooled in voting machine.\nBeginning spin cycle.";
			break;
		case 7:
			sMsg = "Voter lied to pollster after voting.\nVoter's ballot changed to match polling data.";
			break;
		default:
			sMsg = "Voter filled out ballot correctly\n.  Ballot discarded anyway.";
			break;
		}
		System.out.println(sMsg);
	}
}
