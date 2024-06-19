// LB 387, book 4, chapter 2
import utilities.*;
import java.text.NumberFormat;

public class MultiDimensionalArray  {

	static PrtObj p = new PrtObj();

	public static void main(String args[])  {

		NumberFormat nfCurrency = NumberFormat.getCurrencyInstance();
		Integer[][] iSales = new Integer[5][4];
        iSales[0][0] = 10001;
        iSales[0][1] = 10002;
        iSales[0][2] = 10003;
        iSales[0][3] = 10004;
        iSales[1][0] = 20001;
        iSales[1][1] = 20002;
        iSales[1][2] = 20003;
        iSales[1][3] = 20004;
        iSales[2][0] = 30001;
        iSales[2][1] = 30002;
        iSales[2][2] = 30003;
        iSales[2][3] = 30004;
        iSales[3][0] = 40001;
        iSales[3][1] = 40002;
        iSales[3][2] = 40003;
        iSales[3][3] = 40004;
        iSales[4][0] = 50001;
        iSales[4][1] = 50002;
        iSales[4][2] = 50003;
        iSales[4][3] = 50004;

		p.prtln("\t    North\t    South\t    East\t    West");
		int iYear = 2001;

		for (int iY = 0; iY < 5; iY++)  {
			p.prt(iYear + "\t");

			for (int iRegion = 0; iRegion < 4; iRegion++)  {
				p.prt( nfCurrency.format( iSales[iY][iRegion] ) );
				p.prt("\t");
			}
			iYear++;
			p.prtln("");
		}
	}
}
