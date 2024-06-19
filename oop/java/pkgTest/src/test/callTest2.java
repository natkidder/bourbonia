import pkgTest.*;

public class callTest2  {

	public static void main( String[] args )  {
		test testTemp = new test( 30 );
		testTemp.setTemperature( 45 );
		System.out.println( testTemp.getTemperature() );
	}
}
