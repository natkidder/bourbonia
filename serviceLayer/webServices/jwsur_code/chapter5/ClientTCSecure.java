import tcClient.TempConvertImplService;
import tcClient.TempConvert;
import javax.xml.ws.BindingProvider;
import java.util.Map;

class ClientTCSecure {
    private static final String endpoint = "https://localhost:8443/tempc/tc";
    public static void main(String args[ ]) {
        TempConvertImplService service = new TempConvertImplService();
        TempConvert port = service.getTempConvertImplPort();

        Map<String, Object> req_ctx = ((BindingProvider) port).getRequestContext();
        req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);

        System.out.println("f2c(-40.1) ==> " + port.f2C(-40.1f));
        System.out.println("c2f(-40.1) ==> " + port.c2F(-40.1f));
        System.out.println("f2c(+98.7) ==> " + port.f2C(+98.7f));
    }
}
