package ch02.tsd;  // 'd' for 'document' style

import java.util.Date;
import javax.jws.WebService;
import javax.jws.WebMethod;
@WebService
public class TimeServer {
    @WebMethod
    public String getTimeAsString() { return new Date().toString(); }

    @WebMethod
    public long getTimeAsElapsed() { return new Date().getTime(); }
}
