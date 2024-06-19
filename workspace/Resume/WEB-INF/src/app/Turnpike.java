package app;

import java.security.*;

public class Turnpike {

	private static String toHexString(byte [] ab) {
		StringBuffer sb = new StringBuffer(ab.length * 2) ;

		for(int i=0; i<ab.length; ++i) {
			String sTemp = Integer.toHexString(0xFF & ab[i]) ;
			if(1==sTemp.length()) {
				sb.append("0") ;
			}
			sb.append(sTemp) ;
		}

		return sb.toString() ;
	}

	static String genHash(String s) {
		String failed = "Password Encryption Unsuccessful";
		System.out.println("turnpike 2"); ////
		if (s != null)  {
			try  {
				MessageDigest md =	MessageDigest.getInstance("MD5") ;

				md.update(s.getBytes()) ;

				return toHexString(md.digest()) ;
			} catch (NoSuchAlgorithmException e)  {
				e.printStackTrace();
				return failed;
			}
		} else {
			return failed;
		}

	}
}
