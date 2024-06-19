package client;

import beans.SimpleSession;
import beans.SimpleSessionHome;
import javax.naming.InitialContext; // the starting point for finding a resource, which has a "name" property
import javax.rmi.PortableRemoteObject;
//import javax.ejb.EJBHome;
//import javax.ejb.EJBObject;

public class SimpleSessionClient {
	public static void main(String[] args)  {
		try  {
			// instantiate a starting point for getting a JNDI resource, located by name
			InitialContext jndiContext = new InitialContext();

			// Get a reference to the SimpleSession JNDI entry
			Object ref = jndiContext.lookup("ejb/beans.SimpleSession");

			// Get a reference from this to the Bean's Home interface
			SimpleSessionHome ssHome = (SimpleSessionHome) PortableRemoteObject.narrow(ref, SimpleSessionHome.class);

			// Create a SimpleSession object from the Home interface
			SimpleSession simpleSession = ssHome.create();

			// Loop through the entry point's arguments
			for (int i = 0; i < args.length; i++)  {
				String returnedString = simpleSession.getEchoString(args[i]);
				System.out.println("sent string: " + args[i] + ", received string: " + returnedString);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

