import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FileWrite {
    public static void main(String[] args) {

//  create stream to read from keyboard
        InputStreamReader convert = new InputStreamReader(System.in);
        BufferedReader stdin = new BufferedReader(convert);
        String instr;
        String empty = "";

        try {

//  use command line argument for output file name
            FileWriter fout = new FileWriter(args[0]);
            PrintWriter fileout = new PrintWriter(fout,true);

//  read lines from keyboard and write them to output file
//  user enters an empty line to stop input
            System.out.println("Type your data, press Enter at the end of each 
line.");
            System.out.println("Press Enter twice when done.");
            instr = stdin.readLine();
            while (!instr.equals(empty)) {
                fileout.println(instr);
                instr = stdin.readLine();
            }
            fileout.close();
        }
        catch(IOException e) {}
    }
}
