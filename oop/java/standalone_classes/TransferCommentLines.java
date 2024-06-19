import java.io.*;

public class TransferCommentLines  {

	private static void prtln( String s ) { System.out.println( s ); }

	public static void main( String args[] )  {
		try {
			if ( args.length < 2 ) {
				prtln( "arg1: source file to draw comment lines from, arg2: destination file " );
				System.exit( 0 );
			}
			File infile = new File( args[0] );
			if ( ! infile.exists() )  {
				prtln( "source file " + args[0] + " does not exist" );
				System.exit( 0 );
			}
			BufferedReader br = new BufferedReader( new FileReader( infile ) );
			File fileOut = new File( args[1] );
			FileWriter fw = new FileWriter( fileOut, false );  // will append
			BufferedWriter bw = new BufferedWriter( fw );
			PrintWriter pw = new PrintWriter( bw, true );  // will flush

			boolean inComment = false;
			boolean prevInComment = false;
			String line = br.readLine();
			String trimLine = line.trim();
			if ( canPrint( trimLine, inComment, prevInComment ) )
				pw.println( line );
			while( line != null )  {
				if ( canPrint( trimLine, inComment, prevInComment ) )
					pw.println( line );
				trimLine = line.trim();
				if ( prevInComment && ! inComment )
					break;
				prevInComment = inComment;
				line = br.readLine();
			}
		}
		catch ( FileNotFoundException fnfe )  {
			prtln( fnfe.toString() );
			System.exit( 1 );
		}
		catch ( IOException ioe )  {
			prtln( ioe.toString() );
			System.exit( 2 );
		}
	}

	private static boolean canPrint( String trimLine, boolean inComment, boolean prevInComment ) {
		if ( trimLine.matches("^/\\*") || trimLine.matches("^//") )  {
			inComment = true;
		} else if ( inComment && trimLine.matches("\\*/$")  ) {
			inComment = false;
		}
		if ( inComment )
			return true;
		else
			return false;
	}
}
