/**
 * TerminalLocationSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.csapi.www.wsdl.parlayx.terminal_location.v3_0.service;

public class TerminalLocationSoapBindingStub extends org.apache.axis.client.Stub implements org.csapi.www.wsdl.parlayx.terminal_location.v3_0.service.TerminalLocation {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[3];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getLocation");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/terminal_location/v3_0/local", "requester"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyURI"), org.apache.axis.types.URI.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/terminal_location/v3_0/local", "address"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyURI"), org.apache.axis.types.URI.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/terminal_location/v3_0/local", "requestedAccuracy"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/terminal_location/v3_0/local", "acceptableAccuracy"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/terminal_location/v3_0/local", "maximumAge"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/common/v2_1", "TimeMetric"), org.csapi.www.schema.parlayx.common.v2_1.TimeMetric.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/terminal_location/v3_0/local", "responseTime"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/common/v2_1", "TimeMetric"), org.csapi.www.schema.parlayx.common.v2_1.TimeMetric.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/terminal_location/v3_0/local", "tolerance"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/terminal_location/v2_2", "DelayTolerance"), org.csapi.www.schema.parlayx.terminal_location.v2_2.DelayTolerance.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/terminal_location/v2_2", "LocationInfo"));
        oper.setReturnClass(org.csapi.www.schema.parlayx.terminal_location.v2_2.LocationInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/terminal_location/v3_0/local", "result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/common/v2_1", "PolicyException"),
                      "org.csapi.www.schema.parlayx.common.v2_1.PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/common/v2_1", "PolicyException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/common/v2_1", "ServiceException"),
                      "org.csapi.www.schema.parlayx.common.v2_1.ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/common/v2_1", "ServiceException"), 
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getTerminalDistance");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/terminal_location/v3_0/local", "requester"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyURI"), org.apache.axis.types.URI.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/terminal_location/v3_0/local", "address"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyURI"), org.apache.axis.types.URI.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/terminal_location/v3_0/local", "latitude"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"), float.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/terminal_location/v3_0/local", "longitude"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"), float.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        oper.setReturnClass(int.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/terminal_location/v3_0/local", "result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/common/v2_1", "PolicyException"),
                      "org.csapi.www.schema.parlayx.common.v2_1.PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/common/v2_1", "PolicyException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/common/v2_1", "ServiceException"),
                      "org.csapi.www.schema.parlayx.common.v2_1.ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/common/v2_1", "ServiceException"), 
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getLocationForGroup");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/terminal_location/v3_0/local", "requester"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyURI"), org.apache.axis.types.URI.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/terminal_location/v3_0/local", "addresses"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyURI"), org.apache.axis.types.URI[].class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/terminal_location/v3_0/local", "requestedAccuracy"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/terminal_location/v3_0/local", "acceptableAccuracy"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"), int.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/terminal_location/v3_0/local", "maximumAge"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/common/v2_1", "TimeMetric"), org.csapi.www.schema.parlayx.common.v2_1.TimeMetric.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/terminal_location/v3_0/local", "responseTime"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/common/v2_1", "TimeMetric"), org.csapi.www.schema.parlayx.common.v2_1.TimeMetric.class, false, false);
        oper.addParameter(param);
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/terminal_location/v3_0/local", "tolerance"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/terminal_location/v2_2", "DelayTolerance"), org.csapi.www.schema.parlayx.terminal_location.v2_2.DelayTolerance.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/terminal_location/v2_2", "LocationData"));
        oper.setReturnClass(org.csapi.www.schema.parlayx.terminal_location.v2_2.LocationData[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/terminal_location/v3_0/local", "result"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/common/v2_1", "PolicyException"),
                      "org.csapi.www.schema.parlayx.common.v2_1.PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/common/v2_1", "PolicyException"), 
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/common/v2_1", "ServiceException"),
                      "org.csapi.www.schema.parlayx.common.v2_1.ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/common/v2_1", "ServiceException"), 
                      true
                     ));
        _operations[2] = oper;

    }

    public TerminalLocationSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public TerminalLocationSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public TerminalLocationSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            java.lang.Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            java.lang.Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/common/v2_1", "PolicyException");
            cachedSerQNames.add(qName);
            cls = org.csapi.www.schema.parlayx.common.v2_1.PolicyException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/common/v2_1", "ServiceError");
            cachedSerQNames.add(qName);
            cls = org.csapi.www.schema.parlayx.common.v2_1.ServiceError.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/common/v2_1", "ServiceException");
            cachedSerQNames.add(qName);
            cls = org.csapi.www.schema.parlayx.common.v2_1.ServiceException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/common/v2_1", "TimeMetric");
            cachedSerQNames.add(qName);
            cls = org.csapi.www.schema.parlayx.common.v2_1.TimeMetric.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/common/v3_0", "TimeMetrics");
            cachedSerQNames.add(qName);
            cls = org.csapi.www.schema.parlayx.common.v3_0.TimeMetrics.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/terminal_location/v2_2", "DelayTolerance");
            cachedSerQNames.add(qName);
            cls = org.csapi.www.schema.parlayx.terminal_location.v2_2.DelayTolerance.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/terminal_location/v2_2", "LocationData");
            cachedSerQNames.add(qName);
            cls = org.csapi.www.schema.parlayx.terminal_location.v2_2.LocationData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/terminal_location/v2_2", "LocationInfo");
            cachedSerQNames.add(qName);
            cls = org.csapi.www.schema.parlayx.terminal_location.v2_2.LocationInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/terminal_location/v2_2", "RetrievalStatus");
            cachedSerQNames.add(qName);
            cls = org.csapi.www.schema.parlayx.terminal_location.v2_2.RetrievalStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                            java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public org.csapi.www.schema.parlayx.terminal_location.v2_2.LocationInfo getLocation(org.apache.axis.types.URI requester, org.apache.axis.types.URI address, int requestedAccuracy, int acceptableAccuracy, org.csapi.www.schema.parlayx.common.v2_1.TimeMetric maximumAge, org.csapi.www.schema.parlayx.common.v2_1.TimeMetric responseTime, org.csapi.www.schema.parlayx.terminal_location.v2_2.DelayTolerance tolerance) throws java.rmi.RemoteException, org.csapi.www.schema.parlayx.common.v2_1.PolicyException, org.csapi.www.schema.parlayx.common.v2_1.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/terminal_location/v3_0/local", "getLocation"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {requester, address, new java.lang.Integer(requestedAccuracy), new java.lang.Integer(acceptableAccuracy), maximumAge, responseTime, tolerance});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.csapi.www.schema.parlayx.terminal_location.v2_2.LocationInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.csapi.www.schema.parlayx.terminal_location.v2_2.LocationInfo) org.apache.axis.utils.JavaUtils.convert(_resp, org.csapi.www.schema.parlayx.terminal_location.v2_2.LocationInfo.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof org.csapi.www.schema.parlayx.common.v2_1.PolicyException) {
              throw (org.csapi.www.schema.parlayx.common.v2_1.PolicyException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof org.csapi.www.schema.parlayx.common.v2_1.ServiceException) {
              throw (org.csapi.www.schema.parlayx.common.v2_1.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public int getTerminalDistance(org.apache.axis.types.URI requester, org.apache.axis.types.URI address, float latitude, float longitude) throws java.rmi.RemoteException, org.csapi.www.schema.parlayx.common.v2_1.PolicyException, org.csapi.www.schema.parlayx.common.v2_1.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/terminal_location/v3_0/local", "getTerminalDistance"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {requester, address, new java.lang.Float(latitude), new java.lang.Float(longitude)});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return ((java.lang.Integer) _resp).intValue();
            } catch (java.lang.Exception _exception) {
                return ((java.lang.Integer) org.apache.axis.utils.JavaUtils.convert(_resp, int.class)).intValue();
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof org.csapi.www.schema.parlayx.common.v2_1.PolicyException) {
              throw (org.csapi.www.schema.parlayx.common.v2_1.PolicyException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof org.csapi.www.schema.parlayx.common.v2_1.ServiceException) {
              throw (org.csapi.www.schema.parlayx.common.v2_1.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public org.csapi.www.schema.parlayx.terminal_location.v2_2.LocationData[] getLocationForGroup(org.apache.axis.types.URI requester, org.apache.axis.types.URI[] addresses, int requestedAccuracy, int acceptableAccuracy, org.csapi.www.schema.parlayx.common.v2_1.TimeMetric maximumAge, org.csapi.www.schema.parlayx.common.v2_1.TimeMetric responseTime, org.csapi.www.schema.parlayx.terminal_location.v2_2.DelayTolerance tolerance) throws java.rmi.RemoteException, org.csapi.www.schema.parlayx.common.v2_1.PolicyException, org.csapi.www.schema.parlayx.common.v2_1.ServiceException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.csapi.org/schema/parlayx/terminal_location/v3_0/local", "getLocationForGroup"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {requester, addresses, new java.lang.Integer(requestedAccuracy), new java.lang.Integer(acceptableAccuracy), maximumAge, responseTime, tolerance});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (org.csapi.www.schema.parlayx.terminal_location.v2_2.LocationData[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (org.csapi.www.schema.parlayx.terminal_location.v2_2.LocationData[]) org.apache.axis.utils.JavaUtils.convert(_resp, org.csapi.www.schema.parlayx.terminal_location.v2_2.LocationData[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof org.csapi.www.schema.parlayx.common.v2_1.PolicyException) {
              throw (org.csapi.www.schema.parlayx.common.v2_1.PolicyException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof org.csapi.www.schema.parlayx.common.v2_1.ServiceException) {
              throw (org.csapi.www.schema.parlayx.common.v2_1.ServiceException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
