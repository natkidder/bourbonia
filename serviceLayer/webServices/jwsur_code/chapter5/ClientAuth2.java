import tcauthClient.TempConvertAuthImplService;
import tcauthClient.TempConvertAuth;
import javax.xml.ws.BindingProvider;
import org.apache.catalina.realm.RealmBase;

// Revised to send a digested password.
class ClientAuth {
    public static void main(String args[ ]) {
        TempConvertAuthImplService service = new TempConvertAuthImplService();
        TempConvertAuth port = service.getTempConvertAuthImplPort();
        BindingProvider prov = (BindingProvider) port;

        String digest = RealmBase.Digest("rockbed", // password
                                         "SHA",     // digest algorithm
                                         null);     // default char. encoding

        prov.getRequestContext().put(BindingProvider.USERNAME_PROPERTY, "fred");
        prov.getRequestContext().put(BindingProvider.PASSWORD_PROPERTY, digest);

        System.out.println("f2c(-40.1) ==> " + port.f2C(-40.1f));
        System.out.println("c2f(-40.1) ==> " + port.c2F(-40.1f));
        System.out.println("f2c(+98.7) ==> " + port.f2C(+98.7f));
    }
}
