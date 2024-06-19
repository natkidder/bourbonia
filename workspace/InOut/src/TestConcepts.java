import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;

public class TestConcepts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String str = "20.6";
			DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
			Date testDt = df.parse("20/2209"); 			
			System.out.println(df.format(testDt));			
		} catch (ParseException e)  {
			e.printStackTrace();
		}

	}

}
