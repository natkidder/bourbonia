import javax.xml.ws.Service;
import clientTC.TempConvertService;
import clientTC.TempConvert;

class ClientTC {
    public static void main(String args[ ]) throws Exception {
        TempConvertService service = new TempConvertService();
        TempConvert port = service.getTempConvertPort();
        double d1 = -40.1, d2 = -39.4;
        System.out.printf("f2C(%f) = %f\n", d1, port.f2C(d1));
        System.out.printf("c2F(%f) = %f\n", d2, port.c2F(d2));
   }
}
