package web;

import java.io.*;
import java.util.*;

public class Test  {

	public static void main(String[] args)  {
		try  {
			List acqs = RunQuery.getAddresses();
			Acquantance acq;
			Iterator iter = acqs.iterator();
			while (iter.hasNext()) {
				acq = (Acquantance)iter.next();
				System.out.println(acq.getFname() + " " + acq.getLname());
			}
			RunInsert.doInsert("Andy");
			RunInsert.doInsert("Butch");
			RunInsert.doInsert("Carl");
			RunInsert.doInsert("Dave");
			RunInsert.doInsert("Earl");
			RunInsert.doInsert("Fred");
			RunInsert.doInsert("Gomer");
			RunInsert.doInsert("Harry");
			RunInsert.doInsert("Ike");
			RunInsert.doInsert("Andy");
		} catch (Exception e)  {
			e.printStackTrace();
		}
	}
}
