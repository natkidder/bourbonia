/**
 * TerminalLocation.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.csapi.www.wsdl.parlayx.terminal_location.v3_0.service;

public interface TerminalLocation extends java.rmi.Remote {
    public org.csapi.www.schema.parlayx.terminal_location.v2_2.LocationInfo getLocation(org.apache.axis.types.URI requester, org.apache.axis.types.URI address, int requestedAccuracy, int acceptableAccuracy, org.csapi.www.schema.parlayx.common.v2_1.TimeMetric maximumAge, org.csapi.www.schema.parlayx.common.v2_1.TimeMetric responseTime, org.csapi.www.schema.parlayx.terminal_location.v2_2.DelayTolerance tolerance) throws java.rmi.RemoteException, org.csapi.www.schema.parlayx.common.v2_1.PolicyException, org.csapi.www.schema.parlayx.common.v2_1.ServiceException;
    public int getTerminalDistance(org.apache.axis.types.URI requester, org.apache.axis.types.URI address, float latitude, float longitude) throws java.rmi.RemoteException, org.csapi.www.schema.parlayx.common.v2_1.PolicyException, org.csapi.www.schema.parlayx.common.v2_1.ServiceException;
    public org.csapi.www.schema.parlayx.terminal_location.v2_2.LocationData[] getLocationForGroup(org.apache.axis.types.URI requester, org.apache.axis.types.URI[] addresses, int requestedAccuracy, int acceptableAccuracy, org.csapi.www.schema.parlayx.common.v2_1.TimeMetric maximumAge, org.csapi.www.schema.parlayx.common.v2_1.TimeMetric responseTime, org.csapi.www.schema.parlayx.terminal_location.v2_2.DelayTolerance tolerance) throws java.rmi.RemoteException, org.csapi.www.schema.parlayx.common.v2_1.PolicyException, org.csapi.www.schema.parlayx.common.v2_1.ServiceException;
}
