package ch06.ejb;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

// A FibNum is a pair: an integer N and its Fibonacci value.
@Entity
public class FibNum implements Serializable {
    private int n;
    private int fib;

    public FibNum() { }

    @Id
    public int getN() { return this.n; }
    public void setN(int n) { this.n = n; }

    public int getFib() { return this.fib; }
    public void setFib(int n) { this.fib = fib; }
}
