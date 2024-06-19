package net.webservicex.www;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;

import net.webservicex.www.*;
import net.webservicex.www.SunSetRiseServiceStub.*;

public class sunRiseSetMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try {
            LatLonDate lld = new LatLonDate();
            lld.setDay(21);
            lld.setLatitude(35.1F);
            lld.setLongitude(80.7F);
            lld.setMonth(6);
            lld.setYear(2013);
            lld.setTimeZone(7);
            //lld.setSunRiseTime(6.30F);
            //lld.setSunSetTime(8.50F);
            SunSetRiseServiceStub stub = new SunSetRiseServiceStub();
            GetSunSetRiseTime gssrt = new GetSunSetRiseTime();
            gssrt.setL(lld);
            GetSunSetRiseTimeResponse gssrtr = stub.GetSunSetRiseTime(gssrt);
            System.out.println("TimeZone = " + gssrtr.getGetSunSetRiseTimeResult().getTimeZone());
            System.out.println("SunRiseTime = " + gssrtr.getGetSunSetRiseTimeResult().getSunRiseTime());
            System.out.println("SunSetTime = " + gssrtr.getGetSunSetRiseTimeResult().getSunSetTime());
        } catch (AxisFault e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
	}

}
