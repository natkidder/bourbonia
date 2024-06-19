import clientEJB.FibEJBService;
import clientEJB.Fib;

class ClientEJB {
    public static void main(String args[ ]) {
	FibEJBService service = new FibEJBService();
	Fib port = service.getFibEJBPort();
    
	// Invoke service methods.
	System.out.println(port.fib(1));
	System.out.println(port.fib(11));
	System.out.println(port.getFibs());
    }
}


