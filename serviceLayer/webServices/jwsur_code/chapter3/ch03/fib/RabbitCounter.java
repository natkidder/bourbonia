package ch03.fib;  

import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.xml.ws.BindingType;

@WebService(targetNamespace = "http://ch03.fib")
@SOAPBinding(style          = SOAPBinding.Style.DOCUMENT,
             use            = SOAPBinding.Use.LITERAL,
             parameterStyle = SOAPBinding.ParameterStyle.WRAPPED)
// The value given is a "non-standard" binding for SOAP 1.2.
// The standard value is
//
//      http://www.w3.org/2003/05/soap/bindings/HTTP/
//
// which is the value of the constant 
//
//      javax.xml.ws.soap.SOAPBinding.SOAP12HTTP_BINDING
// 
// problem is that the Endpoint publisher cannot generate a WSDL on the fly
// if the standard binding value is used. The BindingType value 
// given here is a workaround to allow the WSDL to be generated at run time
// and to satisfy SOAP 1.2.
@BindingType(value = "http://java.sun.com/xml/ns/jaxws/2003/05/soap/bindings/HTTP/")
public class RabbitCounter {
    // stores previously computed values
    private Map<Integer, Integer> cache = 
	Collections.synchronizedMap(new HashMap<Integer, Integer>());

    @WebMethod
    public int countRabbits(int n) throws FibException {
	// Throw a fault if n is negative.
	if (n < 0) 
	    throw new FibException("Negative args not allowed.",
				   n + " < 0");
	
	// Easy cases.
	if (n < 2) return n;

	// Return cached values if present.
	if (cache.containsKey(n)) return cache.get(n);
	if (cache.containsKey(n - 1) &&
	    cache.containsKey(n - 2)) {
	    cache.put(n, cache.get(n - 1) + cache.get(n - 2));
	    return cache.get(n);
	}
	
	// Otherwise, compute from scratch, cache, and return.
	int fib = 1, prev = 0;
	for (int i = 2; i <= n; i++) {
	    int temp = fib;
	    fib += prev;
	    prev = temp;
	}
	cache.put(n, fib);
	return fib;
    }
}
