package beans;

import java.rmi.RemoteException;
import javax.ejb.EJBObject;

public interface Calculator extends EJBObject {
  // the public business methods on the Calculator bean
  public void clearIt() throws RemoteException;
  public void calculate(String operation, int value)
    throws RemoteException;
  public int getValue() throws RemoteException;
}