import java.rmi.RemoteException;
import java.util.Calendar;
import javax.xml.rpc.ServiceException;
import org.apache.axis.types.URI.MalformedURIException;
import org.csapi.www.schema.parlayx.common.v2_1.PolicyException;
import org.csapi.www.schema.parlayx.terminal_location.v2_2.LocationInfo;
import org.csapi.www.wsdl.parlayx.terminal_location.v3_0.service.TerminalLocation;
import org.csapi.www.wsdl.parlayx.terminal_location.v3_0.service.TerminalLocationServiceLocator;

public class MyLocation {
	MyLocation(){
		try {
			TerminalLocation tls = new TerminalLocationServiceLocator().getTerminalLocation();
			// Set username and password
			String userName = "RandFan";
			String passWord = userName;
			org.apache.axis.client.Stub stub = (org.apache.axis.client.Stub)tls; 
			stub.setUsername(userName);
			stub.setPassword(passWord);
			// Invoke service
			org.apache.axis.types.URI address = new org.apache.axis.types.URI("tel", "yyyyyyyy");
			org.apache.axis.types.URI requester = new org.apache.axis.types.URI("tel", "2034");
			LocationInfo li = tls.getLocation(requester,address,1,1,null,null,null); 
			if(li != null){
				float lat = li.getLatitude();
				float lon = li.getLongitude();
				Calendar when = li.getTimestamp();
				System.out.println("Terminal: " + address.getSchemeSpecificPart() + " is at: (lat)" + lat + " (lon)" + lon + " " + when.getTime());
			}	
			else System.out.println("Could not obtain location");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PolicyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MalformedURIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyLocation();
	}
}