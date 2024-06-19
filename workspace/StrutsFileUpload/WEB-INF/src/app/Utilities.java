package app;

public class Utilities {
	private Utilities()  {
	}

	public static String rtnExtension(String filename)  {
		String extension = "";
		for (int i = filename.length(); !filename.substring(i-1,i).equals("."); i--)  {
			extension = filename.substring(i-1,i) + extension;
		}
		return extension;
	}
}