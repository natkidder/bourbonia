package regex.main;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMain {

	public static void main(String[] args) {
		splitCsvString(-1);

	}

	private static void splitCsvString(int fieldIdx) {
		//String s = "a1, a2, a3, \"a4,a5\", a6";
		String s = "UNITED STATES,Sony Pictures,b725ca95-0126-46d7-9f5d-3da3e631b93b,Lockout,1/1/2012 12:00:00 AM,Movie,,,,,,PPV HD,3.99,1/1/2015 5:00:00 AM,1/1/2016 4:59:00 AM,\"Guy Pearce, Maggie Grace\",Stephen St. Leger,https://video.xbox.com/movie/b725ca95-0126-46d7-9f5d-3da3e631b93b";
		String csvPattern = "\\s*(\"[^\"]*\"|[^,]*)\\s*";
		Pattern pattern = Pattern.compile(csvPattern);
		Matcher matcher = pattern.matcher(s);
		int i = 0;
		while (matcher.find()) {
			if (!matcher.group(1).toString().equals("")) {
				System.out.println("i==" + i);
				if (i>fieldIdx) {
					System.out.println(matcher.group(1).toString());
				}
				i++;
			}
		}
		List<String> fields = Arrays.asList(s.split(csvPattern));
		System.out.println("After split, 4th field: "+fields.get(3));
	}

}
