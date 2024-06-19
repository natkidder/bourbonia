import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.axis.AxisFault;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.ServiceFactory;
import org.apache.axis.message.MessageElement;
import org.apache.axis.description.TypeDesc;
import javax.xml.namespace.QName;

import NET.webserviceX.www.GetInfoByCity;
import NET.webserviceX.www.GetInfoByCityResponse;
import NET.webserviceX.www.GetInfoByCityResponseGetInfoByCityResult;
import NET.webserviceX.www.GetInfoByZIPResponseGetInfoByZIPResult;
import NET.webserviceX.www.USZipSoap;
import NET.webserviceX.www.USZipSoap12Stub;
import NET.webserviceX.www.USZipSoapProxy;
import NET.webserviceX.www.USZipSoapStub;

import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.*;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class MyCity {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		try {
			URL url = new URL("http://www.webservicex.net/uszip.asmx?WSDL");
			ServiceFactory serviceFactory = new ServiceFactory();
			String targetNamespace = "http://www.webserviceX.NET";
			QName serviceName = new QName(targetNamespace, "USZip");
			Service service = serviceFactory.createService(url, serviceName);
			USZipSoap12Stub uzss = new USZipSoap12Stub(url, service);
			GetInfoByCityResponseGetInfoByCityResult result = uzss.getInfoByCity("Potomac");
			System.out.println(uzss.toString());
			MessageElement[] messageElements = result.get_any();
			System.out.println("messageElements.length = "+messageElements.length); ////
			for (int i = 0; i < messageElements.length; i++)  {
				Element e = messageElements[i].getAsDOM();
				Utilities.printZips(e);
			}
			
		} catch (AxisFault e)  {
			e.printStackTrace();
		} catch (RemoteException e)  {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (ServiceException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	

}
