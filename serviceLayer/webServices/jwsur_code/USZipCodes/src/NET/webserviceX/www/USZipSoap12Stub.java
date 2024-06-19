/**
 * USZipSoap12Stub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package NET.webserviceX.www;

public class USZipSoap12Stub extends org.apache.axis.client.Stub implements NET.webserviceX.www.USZipSoap {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[4];
        _initOperationDesc1();
    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetInfoByZIP");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.webserviceX.NET", "USZip"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.webserviceX.NET", ">>GetInfoByZIPResponse>GetInfoByZIPResult"));
        oper.setReturnClass(NET.webserviceX.www.GetInfoByZIPResponseGetInfoByZIPResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.webserviceX.NET", "GetInfoByZIPResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetInfoByCity");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.webserviceX.NET", "USCity"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.webserviceX.NET", ">>GetInfoByCityResponse>GetInfoByCityResult"));
        oper.setReturnClass(NET.webserviceX.www.GetInfoByCityResponseGetInfoByCityResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.webserviceX.NET", "GetInfoByCityResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetInfoByState");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.webserviceX.NET", "USState"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.webserviceX.NET", ">>GetInfoByStateResponse>GetInfoByStateResult"));
        oper.setReturnClass(NET.webserviceX.www.GetInfoByStateResponseGetInfoByStateResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.webserviceX.NET", "GetInfoByStateResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetInfoByAreaCode");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.webserviceX.NET", "USAreaCode"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false);
        param.setOmittable(true);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.webserviceX.NET", ">>GetInfoByAreaCodeResponse>GetInfoByAreaCodeResult"));
        oper.setReturnClass(NET.webserviceX.www.GetInfoByAreaCodeResponseGetInfoByAreaCodeResult.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.webserviceX.NET", "GetInfoByAreaCodeResult"));
        oper.setStyle(org.apache.axis.constants.Style.WRAPPED);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        _operations[3] = oper;

    }

    public USZipSoap12Stub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public USZipSoap12Stub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public USZipSoap12Stub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
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
            qName = new javax.xml.namespace.QName("http://www.webserviceX.NET", ">>GetInfoByAreaCodeResponse>GetInfoByAreaCodeResult");
            cachedSerQNames.add(qName);
            cls = NET.webserviceX.www.GetInfoByAreaCodeResponseGetInfoByAreaCodeResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.webserviceX.NET", ">>GetInfoByCityResponse>GetInfoByCityResult");
            cachedSerQNames.add(qName);
            cls = NET.webserviceX.www.GetInfoByCityResponseGetInfoByCityResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.webserviceX.NET", ">>GetInfoByStateResponse>GetInfoByStateResult");
            cachedSerQNames.add(qName);
            cls = NET.webserviceX.www.GetInfoByStateResponseGetInfoByStateResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.webserviceX.NET", ">>GetInfoByZIPResponse>GetInfoByZIPResult");
            cachedSerQNames.add(qName);
            cls = NET.webserviceX.www.GetInfoByZIPResponseGetInfoByZIPResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.webserviceX.NET", ">GetInfoByAreaCode");
            cachedSerQNames.add(qName);
            cls = NET.webserviceX.www.GetInfoByAreaCode.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.webserviceX.NET", ">GetInfoByAreaCodeResponse");
            cachedSerQNames.add(qName);
            cls = NET.webserviceX.www.GetInfoByAreaCodeResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.webserviceX.NET", ">GetInfoByCity");
            cachedSerQNames.add(qName);
            cls = NET.webserviceX.www.GetInfoByCity.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.webserviceX.NET", ">GetInfoByCityResponse");
            cachedSerQNames.add(qName);
            cls = NET.webserviceX.www.GetInfoByCityResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.webserviceX.NET", ">GetInfoByState");
            cachedSerQNames.add(qName);
            cls = NET.webserviceX.www.GetInfoByState.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.webserviceX.NET", ">GetInfoByStateResponse");
            cachedSerQNames.add(qName);
            cls = NET.webserviceX.www.GetInfoByStateResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

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

    public NET.webserviceX.www.GetInfoByZIPResponseGetInfoByZIPResult getInfoByZIP(java.lang.String USZip) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.webserviceX.NET/GetInfoByZIP");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.webserviceX.NET", "GetInfoByZIP"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {USZip});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (NET.webserviceX.www.GetInfoByZIPResponseGetInfoByZIPResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (NET.webserviceX.www.GetInfoByZIPResponseGetInfoByZIPResult) org.apache.axis.utils.JavaUtils.convert(_resp, NET.webserviceX.www.GetInfoByZIPResponseGetInfoByZIPResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public NET.webserviceX.www.GetInfoByCityResponseGetInfoByCityResult getInfoByCity(java.lang.String USCity) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.webserviceX.NET/GetInfoByCity");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.webserviceX.NET", "GetInfoByCity"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {USCity});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (NET.webserviceX.www.GetInfoByCityResponseGetInfoByCityResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (NET.webserviceX.www.GetInfoByCityResponseGetInfoByCityResult) org.apache.axis.utils.JavaUtils.convert(_resp, NET.webserviceX.www.GetInfoByCityResponseGetInfoByCityResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public NET.webserviceX.www.GetInfoByStateResponseGetInfoByStateResult getInfoByState(java.lang.String USState) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.webserviceX.NET/GetInfoByState");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.webserviceX.NET", "GetInfoByState"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {USState});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (NET.webserviceX.www.GetInfoByStateResponseGetInfoByStateResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (NET.webserviceX.www.GetInfoByStateResponseGetInfoByStateResult) org.apache.axis.utils.JavaUtils.convert(_resp, NET.webserviceX.www.GetInfoByStateResponseGetInfoByStateResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

    public NET.webserviceX.www.GetInfoByAreaCodeResponseGetInfoByAreaCodeResult getInfoByAreaCode(java.lang.String USAreaCode) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.webserviceX.NET/GetInfoByAreaCode");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP12_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://www.webserviceX.NET", "GetInfoByAreaCode"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {USAreaCode});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (NET.webserviceX.www.GetInfoByAreaCodeResponseGetInfoByAreaCodeResult) _resp;
            } catch (java.lang.Exception _exception) {
                return (NET.webserviceX.www.GetInfoByAreaCodeResponseGetInfoByAreaCodeResult) org.apache.axis.utils.JavaUtils.convert(_resp, NET.webserviceX.www.GetInfoByAreaCodeResponseGetInfoByAreaCodeResult.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
  throw axisFaultException;
}
    }

}
