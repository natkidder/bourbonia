import java.util.*;
import java.text.*;

public class TestCalendar {
       public static void main(String args[])  {
               String allowedFYs = getCurFiscalYear()+",";
               Calendar now = Calendar.getInstance();
               if (now.get(Calendar.MONTH) == Calendar.OCTOBER)  {
                       allowedFYs += now.get(Calendar.YEAR) + ",";
               }
               System.out.println(allowedFYs);
       }

       public static String getCurFiscalYear() {
               String fy="";

               DateFormat mdf = new SimpleDateFormat("MM");
               DateFormat ydf = new SimpleDateFormat("yyyy");

               Date today = new Date();

               String month = mdf.format(today);
               String year = ydf.format(today);

               if( month.equals("10") || month.equals("11") || month.equals("12")) {
                       fy = String.valueOf(Integer.valueOf(year).intValue()+1);
               } else {
                       fy = year;
               }

               //System.out.println("FY:" + fy);

               //if( selFY.equals("")) {
                       return fy;
               //} else {
                       //return selFY;
               //}
       }

}
