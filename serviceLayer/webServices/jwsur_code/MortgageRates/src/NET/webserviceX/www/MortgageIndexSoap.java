/**
 * MortgageIndexSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package NET.webserviceX.www;

public interface MortgageIndexSoap extends java.rmi.Remote {

    /**
     * Get Current month ARM indexes
     */
    public NET.webserviceX.www.MonthlyIndex getCurrentMortgageIndexMonthly() throws java.rmi.RemoteException;

    /**
     * Get Current week ARM indexes
     */
    public NET.webserviceX.www.WeeklyIndex getCurrentMortgageIndexByWeekly() throws java.rmi.RemoteException;

    /**
     * Get ARM indexes by Month
     */
    public NET.webserviceX.www.MonthlyIndex getMortgageIndexByMonth(int month, int year) throws java.rmi.RemoteException;

    /**
     * Get ARM indexes by Week
     */
    public NET.webserviceX.www.WeeklyIndex getMortgageIndexByWeek(int day, int month, int year) throws java.rmi.RemoteException;
}
