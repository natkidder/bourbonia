package ch05.rc2;

import java.net.InetSocketAddress;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.security.cert.X509Certificate;
import java.security.SecureRandom;
import java.security.KeyStore;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import javax.xml.ws.http.HTTPException;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;
import java.util.List;
import java.util.ArrayList;
import javax.xml.ws.BindingProvider;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpsServer;
import com.sun.net.httpserver.HttpsConfigurator;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpsExchange;
import com.sun.net.httpserver.HttpsParameters;
import com.sun.net.httpserver.Headers;

public class RabbitCounterPublisher {
    private Map<Integer, Integer> fibs;

    public RabbitCounterPublisher() { 
	fibs = new HashMap<Integer, Integer>(); 
    }

    public static void main(String[ ] args) {
	new RabbitCounterPublisher().publish();
    }

    public Map<Integer, Integer> getMap() { return fibs; }

    private void publish() {
	int port = 9876;
	String ip = "https://localhost:";
	String path = "/fib";
	String url_string = ip + port + path;

	HttpsServer server = get_https_server(ip, port, path);
	HttpContext http_ctx = server.createContext(path);

	System.out.println("Publishing RabbitCounter at " + url_string);
	if (server != null) server.start();
	else System.err.println("Failed to start server. Exiting.");
    }

    private HttpsServer get_https_server(String ip, int port, String path) {
	HttpsServer server = null;
	try {
	    InetSocketAddress inet = new InetSocketAddress(port);

	    // 2nd arg = max number of client requests to queue
	    server = HttpsServer.create(inet, 5); 
	    SSLContext ssl_ctx = SSLContext.getInstance("TLS");

	    // password for keystore
	    char[ ] password = "qubits".toCharArray();
	    KeyStore ks = KeyStore.getInstance("JKS");
	    FileInputStream fis = new FileInputStream("rc.keystore");
	    ks.load(fis, password);

	    KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
	    kmf.init(ks, password);
	    TrustManagerFactory tmf = TrustManagerFactory.getInstance("SunX509");
	    tmf.init(ks);
	    ssl_ctx.init(kmf.getKeyManagers(), tmf.getTrustManagers(), null);

	    // Create SSL engine and configure HTTPS to use it.
	    final SSLEngine eng = ssl_ctx.createSSLEngine();
	    server.setHttpsConfigurator(new HttpsConfigurator(ssl_ctx) {
		    public void configure(HttpsParameters parms) {
			parms.setCipherSuites(eng.getEnabledCipherSuites());
			parms.setProtocols(eng.getEnabledProtocols());
		    }
		});
	    server.setExecutor(null); // use default
           
            HttpContext http_context = 
		server.createContext(path, new MyHttpHandler(this));
	}
	catch(Exception e) { System.err.println(e); }
	return server;
    }

    private TrustManager[ ] get_trust_mgr() {
	// No exceptions thrown in any of the overridden methods.
	TrustManager[ ] certs = new TrustManager[ ] {
	    new X509TrustManager() {
		public X509Certificate[ ] getAcceptedIssuers() { return null; }
		public void checkClientTrusted(X509Certificate[ ] certs, String t) { } 
		public void checkServerTrusted(X509Certificate[ ] certs, String t) { }
	    }
	};
	return certs;
    }
}

// The handle method is called on a particular request context,
// in this case on any request to the server that ends with /fib.
class MyHttpHandler implements HttpHandler {
    private final String xml_start = "<fib:response xmlns:fib = 'urn:fib'>";
    private final String xml_stop = "</fib:response>";
    private final String uri = "urn:fib";

    private RabbitCounterPublisher pub;

    public MyHttpHandler(RabbitCounterPublisher pub) { this.pub = pub; }

    public void handle(HttpExchange ex) {
	authenticate(ex);
        String verb = ex.getRequestMethod().toUpperCase();
	if (verb.equals("GET"))         doGet(ex);
	else if (verb.equals("POST"))   doPost(ex);
	else if (verb.equals("DELETE")) doDelete(ex);
	else throw new HTTPException(405);
    }

    private void authenticate(HttpExchange ex) {
	// Extract the header entries.
	Headers headers = ex.getRequestHeaders();
	List<String> ulist = headers.get(BindingProvider.USERNAME_PROPERTY);
	List<String> plist = headers.get(BindingProvider.PASSWORD_PROPERTY);
	
	// Extract username/password from the two singleton lists.
	String username = ulist.get(0);
	String password = plist.get(0);
	if (!username.equals("fred") || !password.equals("rockbed"))
	    throw new HTTPException(401); // authentication error
    }
    
    private void respond_to_client(HttpExchange ex, String res) {
	try {
	    ex.sendResponseHeaders(200, 0); // 0 means: arbitrarily many bytes
      	    OutputStream out = ex.getResponseBody();
	    out.write(res.getBytes());
	    out.flush();
	    ex.close(); // closes all streams
	}
	catch(IOException e) { }
    }

    private void doGet(HttpExchange ex) {
	Map<Integer, Integer> fibs = pub.getMap();
	Collection<Integer> list = fibs.values();
	respond_to_client(ex, list.toString());
    }
    
    private void doPost(HttpExchange ex) {
	Map<Integer, Integer> fibs = pub.getMap();
	fibs.clear(); // clear to create a new map
	try {
	    InputStream in = ex.getRequestBody();
	    byte[ ] raw_bytes = new byte[4096];
	    in.read(raw_bytes);
	    String nums = new String(raw_bytes);
	    nums = nums.replace('[', '\0');
	    nums = nums.replace(']', '\0');
	    String[ ] parts = nums.split(",");
	    List<Integer> list = new ArrayList<Integer>();
	    for (String next : parts) {
		int n = Integer.parseInt(next.trim());
		fibs.put(n, countRabbits(n));
		list.add(fibs.get(n));
	    }
	    Collection<Integer> coll = fibs.values();
	    String res = "POSTed: " + coll.toString();
	    respond_to_client(ex, res);
	}
	catch(IOException e) { }
    }

    private void doDelete(HttpExchange ex) {
	Map<Integer, Integer> fibs = pub.getMap();
	fibs.clear();
	respond_to_client(ex, "All entries deleted.");
    }

    private int countRabbits(int n) {
	n = Math.abs(n);

        // Easy cases.
        if (n < 2) return n;
	
	Map<Integer, Integer> fibs = pub.getMap();

        // Return cached values if present.
        if (fibs.containsKey(n)) return fibs.get(n);
        if (fibs.containsKey(n - 1) &&
            fibs.containsKey(n - 2)) {
           fibs.put(n, fibs.get(n - 1) + fibs.get(n - 2));
           return fibs.get(n);
        }

        // Otherwise, compute from scratch, cache, and return.
        int fib = 1, prev = 0;
        for (int i = 2; i <= n; i++) {
            int temp = fib;
            fib += prev;
            prev = temp;
        }
        fibs.put(n, fib);
        return fib;
    }
}
