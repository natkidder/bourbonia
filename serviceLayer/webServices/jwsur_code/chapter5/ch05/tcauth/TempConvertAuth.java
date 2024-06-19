package ch05.tcauth;

import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService
public interface TempConvertAuth {
    @WebMethod float c2f(float c);
    @WebMethod float f2c(float f);
}
