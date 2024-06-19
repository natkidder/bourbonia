import tcClient2.TempConvertImplService;
import tcClient2.TempConvert;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.List;

class ClientTC2 {
    private static final String endpoint = "https://localhost:8443/tempc/tc";

    public static void main(String args[ ]) {
        TempConvertImplService service = new TempConvertImplService();
        TempConvert port = service.getTempConvertImplPort();

        Map<String, Object> req_ctx = ((BindingProvider) port).getRequestContext();
        req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);

        // Place the username/password in the HTTP request headers,
        // which a non-Java client can do as well.
        Map<String, List<String>> hdr = new HashMap<String, List<String>>();
        hdr.put("Username", Collections.singletonList("fred"));
        hdr.put("Password", Collections.singletonList("rockbed"));
        req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, hdr);

        // Invoke service methods.
        System.out.println("f2c(-40.1) ==> " + port.f2C(-40.1f));
        System.out.println("c2f(-40.1) ==> " + port.c2F(-40.1f));
        System.out.println("f2c(+98.7) ==> " + port.f2C(+98.7f));
    }
}
