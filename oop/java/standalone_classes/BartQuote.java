// LB 483, book 5, chapter 2
// originated at work
import java.util.ArrayList;
import java.net.*;
import utilities.*;

public class BartQuote   {

    ArrayList<String> alQuote = new ArrayList<String>();

    public BartQuote()   {
        alQuote.add("I will not waste chalk.");
        alQuote.add("I will not skateboard in the halls.");
        alQuote.add("I will not burp in class.");
        alQuote.add("I will not instigate a revolution.");
        alQuote.add("It's potato, not potatoe.");
        alQuote.add("I will not encourage others to fly.");
        alQuote.add("Tar is not a plaything.");
        alQuote.add("I will not sell school property.");
        alQuote.add("I will not get very far with this attitude.");
        alQuote.add("I will not sell land in Florida.");
        alQuote.add("I will not grease the monkey bars.");
        alQuote.add("I will not hide behind the Fifth Amendment.");
        alQuote.add("I am not a dentist.");
        alQuote.add("I will finish what I sta");
        alQuote.add("Hamsters cannot fly.");
        alQuote.add("I will not aim for the head.");
        alQuote.add("I will not expose the ignorance of the faculty.");
        alQuote.add("I will not conduct my own fire drills.");
        alQuote.add("I will not fake seizures.");
        alQuote.add("This punishment is not boring or meaningless.");
    }

    public String getQuote()  {
        int iElem = (int)(Math.random() * alQuote.size());
        return alQuote.get( iElem );
    }
}
