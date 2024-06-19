package ch06.ejb;

import java.util.Collection;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.jws.WebMethod;

@Stateless
@WebService
public interface Fib {
    @WebMethod int fib(int n);
    @WebMethod Collection<Integer> getFibs();
}
