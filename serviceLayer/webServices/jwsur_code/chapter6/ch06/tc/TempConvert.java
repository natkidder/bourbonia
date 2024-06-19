package ch06.tc;
import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService
public class TempConvert {
    @WebMethod
    public float c2f(float t) { return 32.0F + (t * 9.0F / 5.0F); }
    @WebMethod
    public float f2c(float t) { return (5.0F / 9.0F) * (t - 32.0F); }
}
