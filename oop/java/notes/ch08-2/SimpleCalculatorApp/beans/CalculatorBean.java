package beans;

import java.rmi.RemoteException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class CalculatorBean implements SessionBean  {
	// holds the calculator value
	private int _value = 0;

	// the public business methods.  These must be coded in the remote interface also

	// clear the calculator
	public void clearIt()  {
		_value = 0;
	}

	// add or subtract
	public void calculate(String operation, int value) throws RemoteException  {
		// if "+", add it
		if (operation.equals("+"))  {
			_value += value;
			return;
		}

		// if "-", subtract it
		if (operation.equals("-"))   {
			_value -= value;
			return;
		}

		// if neither "+" or "-", it is an invalid operation
		throw new RemoteException("Invalid Operation");
	}

	// return the value
	public int getValue() throws RemoteException  {
		return _value;
	}

	// standatd ejb methods, at the end of every business logic bean
	public void ejbActivate()  {}
	public void ejbPassivate()  {}
	public void ejbRemove()  {}
	public void ejbCreate()  {}
	public void setSessionContext(SessionContext context)  {}
}
