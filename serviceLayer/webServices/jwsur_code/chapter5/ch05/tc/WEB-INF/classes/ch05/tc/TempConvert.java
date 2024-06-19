package ch05.tc;
import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService
public interface TempConvert {
    @WebMethod float c2f(float c);
    @WebMethod float f2c(float f);
}
