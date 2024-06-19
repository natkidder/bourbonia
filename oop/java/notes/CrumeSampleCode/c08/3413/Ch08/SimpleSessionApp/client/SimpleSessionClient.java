package client;

import beans.SimpleSession;
import beans.SimpleSessionHome;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

public class SimpleSessionClient { 
  public static void main(String[] args) {
    try {
      // Get a naming context
      InitialContext jndiContext = new InitialContext();

      // Get a reference to the SimpleSession JNDI entry
      Object ref  = jndiContext.lookup("ejb/beans.SimpleSession");

      // Get a reference from this to the Bean's Home interface
      SimpleSessionHome home = (SimpleSessionHome)
       PortableRemoteObject.narrow(ref, SimpleSessionHome.class);

      // Create a SimpleSession object from the Home interface
      SimpleSession simpleSession = home.create();
      
      // loop through the words
      for (int i = 0; i < args.length; i++) {
        String returnedString = simpleSession.getEchoString(args[i]);
        System.out.println("sent string: " + args[i] +
						   ", received string: " + returnedString);
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
  }
}