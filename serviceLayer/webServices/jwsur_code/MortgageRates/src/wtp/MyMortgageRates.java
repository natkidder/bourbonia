package wtp;

import xmlUtils.Utilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;
import javax.xml.soap.Detail;

import org.apache.axis.AxisFault;
import org.apache.axis.client.ServiceFactory;
import org.apache.axis.message.MessageElement;
import org.w3c.dom.Element;

import NET.webserviceX.www.MortgageIndexSoap12Stub;
import NET.webserviceX.www.WeeklyIndex;


public class MyMortgageRates {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			URL url = new URL("http://www.webservicex.net/MortgageIndex.asmx?WSDL");
			ServiceFactory serviceFactory = new ServiceFactory();
			String targetNamespace = "http://www.webserviceX.NET/";
			QName serviceName = new QName(targetNamespace, "MortgageIndex");
			Service service = serviceFactory.createService(url, serviceName);
			MortgageIndexSoap12Stub miStub = new MortgageIndexSoap12Stub(url, service);
			WeeklyIndex result = miStub.getCurrentMortgageIndexByWeekly();
			String threeMthTBill = result.getThreeMonthTreasuryBill();
			String a = result.getFiveYearConstantMaturityTreasury();
			System.out.println("3mth T Bill = "+threeMthTBill); ////
			System.out.println("5Y CMT="+a); 
/*			for (int i = 0; i < messageElements.length; i++)  {
				Element e = messageElements[i].getAsDOM();
				Utilities.printZips(e);
			}*/
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
