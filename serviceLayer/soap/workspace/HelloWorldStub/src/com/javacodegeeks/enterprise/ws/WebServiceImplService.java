
package com.javacodegeeks.enterprise.ws;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "WebServiceImplService", targetNamespace = "http://ws.enterprise.javacodegeeks.com/", wsdlLocation = "http://localhost:8080/webserive/helloworld?wsdl")
public class WebServiceImplService
    extends Service
{

    private final static URL WEBSERVICEIMPLSERVICE_WSDL_LOCATION;
    private final static WebServiceException WEBSERVICEIMPLSERVICE_EXCEPTION;
    private final static QName WEBSERVICEIMPLSERVICE_QNAME = new QName("http://ws.enterprise.javacodegeeks.com/", "WebServiceImplService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/webserive/helloworld?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        WEBSERVICEIMPLSERVICE_WSDL_LOCATION = url;
        WEBSERVICEIMPLSERVICE_EXCEPTION = e;
    }

    public WebServiceImplService() {
        super(__getWsdlLocation(), WEBSERVICEIMPLSERVICE_QNAME);
    }

    public WebServiceImplService(WebServiceFeature... features) {
        super(__getWsdlLocation(), WEBSERVICEIMPLSERVICE_QNAME, features);
    }

    public WebServiceImplService(URL wsdlLocation) {
        super(wsdlLocation, WEBSERVICEIMPLSERVICE_QNAME);
    }

    public WebServiceImplService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, WEBSERVICEIMPLSERVICE_QNAME, features);
    }

    public WebServiceImplService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public WebServiceImplService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns WebServiceInterface
     */
    @WebEndpoint(name = "WebServiceImplPort")
    public WebServiceInterface getWebServiceImplPort() {
        return super.getPort(new QName("http://ws.enterprise.javacodegeeks.com/", "WebServiceImplPort"), WebServiceInterface.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns WebServiceInterface
     */
    @WebEndpoint(name = "WebServiceImplPort")
    public WebServiceInterface getWebServiceImplPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.enterprise.javacodegeeks.com/", "WebServiceImplPort"), WebServiceInterface.class, features);
    }

    private static URL __getWsdlLocation() {
        if (WEBSERVICEIMPLSERVICE_EXCEPTION!= null) {
            throw WEBSERVICEIMPLSERVICE_EXCEPTION;
        }
        return WEBSERVICEIMPLSERVICE_WSDL_LOCATION;
    }

}