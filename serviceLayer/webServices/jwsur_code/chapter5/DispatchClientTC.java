import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.Dispatch;
import javax.xml.ws.http.HTTPBinding;
import org.xml.sax.InputSource;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.BindingProvider;
import org.apache.catalina.realm.RealmBase;

class DispatchClientTC {
    public static void main(String[ ] args) throws Exception {
        QName service_name = new QName("TempConvert");
        QName port_name = new QName("TempConvertPort");
        String endpoint = "https://localhost:8443/tempcR/authrest";

        // Now create a service proxy or dispatcher.
        Service service = Service.create(service_name);
        service.addPort(port_name, HTTPBinding.HTTP_BINDING, endpoint);
        Dispatch<Source> dispatch =
            service.createDispatch(port_name, Source.class, Service.Mode.PAYLOAD);

        String digest = RealmBase.Digest("rockbed", // password
                                         "SHA",     // digest algorithm
                                         null);     // default encoding

        dispatch.getRequestContext().put(BindingProvider.USERNAME_PROPERTY,
                                     "fred");
        dispatch.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY,
                                     digest);
        dispatch.getRequestContext().put(MessageContext.HTTP_REQUEST_METHOD, "GET");
        dispatch.getRequestContext().put(MessageContext.QUERY_STRING, "temp=-40.1");

        StreamSource result = (StreamSource) dispatch.invoke(null);
        InputSource source = new InputSource(result.getInputStream());
        String expression = "//object";
        XPath xpath = XPathFactory.newInstance().newXPath();
        String list = xpath.evaluate(expression, source);
        System.out.println(list);
    }
}