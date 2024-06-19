package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class EmailReverseOrder {

	static final String FIRST_LINE = "^From:\\s.*$";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("usage: EmailReverseOrder <flat file path>");
			System.exit(1);
		}
	

		File file = null;
		Writer output = null;
		String text = null;
		int i = 0;
		
		try {
			FileInputStream fstream = new FileInputStream(args[0]);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine = "";
			StringBuilder reply = new StringBuilder();
			List<String> replies = new ArrayList();
			while ((strLine = br.readLine()) != null)  {
				i++;
				if (strLine.matches(FIRST_LINE)) {
					if (i==1)  {  System.out.println(reply.toString());  }
					if (reply.toString().matches("^*----------$"))   {
						reply.append("==================================\n");
					}
					replies.add(reply.toString());
					reply = new StringBuilder();
				} else if (i == 1)   {
					reply = new StringBuilder();
				} 
				if (!strLine.matches("^$"))   {
					if (strLine.matches("^\\w+:\\s.*$"))   {
						reply.append("    ");
					}
					reply.append(strLine+"\n");
				}
			}
			replies.add(reply.toString());
			if (output != null)   {  output.close(); }
			in.close();
			
			file = new File(args[0]+".out");
			if (output != null)  { output.close(); }
			output = new BufferedWriter(new FileWriter(file));
			ListIterator<String> iter = replies.listIterator(replies.size());
			String newReply = "";
			while (iter.hasNext())  { newReply = iter.next();  }
			while (iter.hasPrevious())   {
				newReply = iter.previous();
				output.write(newReply+"\n");
			}
			output.close();
			System.out.println("output in:     "+args[0]+".out");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
