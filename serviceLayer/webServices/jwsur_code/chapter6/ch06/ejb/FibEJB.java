package ch06.ejb;

import java.util.Collection;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

@Stateless 
@WebService(endpointInterface = "ch06.ejb.Fib")
public class FibEJB implements Fib {
    @PersistenceContext(unitName = "FibServicePU")
    private EntityManager em;

    public int fib(int n) {
	int f = compute_fib(Math.abs(n));
	final FibNum fn = new FibNum();
	fn.setN(f);
	fn.setFib(f);
	em.persist(fn);

	return f;
    }

    public Collection<Integer> getFibs() {
	return null;
    }

    private int compute_fib(int n) {
        int f = 1, prev = 0;
        for (int i = 2; i <= n; i++) {
            int temp = f;
            f += prev;
            prev = temp;
        }
	return f;
    }
}



